import enitity.Product;
import enitity.Sale;
import enitity.User;
import enitity.UserType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.swing.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class SupermarketApplication {

    private List<User> users = new GetDataFromJson().getDataFromJsonToList();

    public User selectedUser = new User();

    public SupermarketApplication() throws IOException {
    }

    public UserType login(Scanner scanner) {
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                selectedUser = user;
                return user.getUserType();
            } else {
                return UserType.OWNER;
            }
        }

        return null;
    }

    public void buyProduct() {
        String productName = JOptionPane.showInputDialog("Enter the product name:");
        if (productName == null || productName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid product name.");
            return;
        }

        try {
            Session session = HibernateUtil.sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Product product = session.createQuery("FROM Product WHERE name = :productName", Product.class)
                    .setParameter("productName", productName)
                    .uniqueResult();

            if (product == null) {
                JOptionPane.showMessageDialog(null, "Product not found.");
                return;
            }

            if (product.getTotalAvailable() <= 0) {
                JOptionPane.showMessageDialog(null, "Item is sold out.");
                return;
            }

            int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity you want to buy:"));
            if (quantity <= 0 || quantity > product.getTotalAvailable()) {
                JOptionPane.showMessageDialog(null, "Invalid quantity.");
                return;
            }

            BigDecimal totalCost = product.getPrice().multiply(BigDecimal.valueOf(quantity));
            if (selectedUser.getBalance().compareTo(totalCost) < 0) {
                JOptionPane.showMessageDialog(null, "Not enough money to buy the product.");
                return;
            }

            // Update product and user data
            product.setTotalAvailable(product.getTotalAvailable() - quantity);
            selectedUser.setBalance(selectedUser.getBalance().subtract(totalCost));
            session.save(new Sale(product, selectedUser, quantity, LocalDateTime.now()));
            transaction.commit();
            JOptionPane.showMessageDialog(null, "Product purchased successfully.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid quantity.");
        }
    }

    public void addProduct() {
        if (selectedUser.getUserType() != UserType.SALES_REPRESENTATIVE || selectedUser.getUserType() != UserType.OWNER) {
            JOptionPane.showMessageDialog(null, "You are not authorized to add products.");
            return;
        }

        String productName = JOptionPane.showInputDialog("Enter the product name:");
        if (productName == null || productName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid product name.");
            return;
        }

        int totalAvailable;
        BigDecimal price, weight, cost;
        try {
            totalAvailable = Integer.parseInt(JOptionPane.showInputDialog("Enter the total number of products available:"));
            price = new BigDecimal(JOptionPane.showInputDialog("Enter the price of the product:"));
            weight = new BigDecimal(JOptionPane.showInputDialog("Enter the weight of the product:"));
            cost = new BigDecimal(JOptionPane.showInputDialog("Enter the cost of the product:"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input.");
            return;
        }

        Product product = new Product(productName, totalAvailable, price, weight, cost);
        try (Session session = HibernateUtil.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
            JOptionPane.showMessageDialog(null, "Product added successfully.");
        }
    }

    public User getLoggedInUser() {


        return null;
    }

}
