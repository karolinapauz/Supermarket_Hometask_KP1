//import enitity.UserType;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class MenuDialog extends JDialog {
//    public MenuDialog(JFrame parent, UserType userType, SupermarketApplication app) {
//        super(parent, "Supermarket Menu", true);
//
//        setSize(300, 200);
//        setLocationRelativeTo(parent);
//
//        setLayout(new BorderLayout());
//
//        // Menu options panel
//        JPanel menuPanel = new JPanel();
//        menuPanel.setLayout(new GridLayout(0, 1));
//
//        // Add menu options based on user type
//        if (userType == UserType.BUYER) {
//            JButton buyProductButton = new JButton("Buy Product");
//            buyProductButton.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    app.buyProduct(app.getLoggedInUser());
//                }
//            });
//            menuPanel.add(buyProductButton);
//        } else if (userType == UserType.SALES_REPRESENTATIVE || userType == UserType.OWNER) {
//            JButton addProductButton = new JButton("Add Product");
//            addProductButton.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    app.addProduct(app.getLoggedInUser());
//                }
//            });
//            menuPanel.add(addProductButton);
//
//            // Add more menu options for different user types as needed
//        }
//
//        add(menuPanel, BorderLayout.CENTER);
//
//        // Close button
//        JPanel closeButtonPanel = new JPanel();
//        JButton closeButton = new JButton("Close");
//        closeButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                setVisible(false);
//            }
//        });
//        closeButtonPanel.add(closeButton);
//
//        add(closeButtonPanel, BorderLayout.SOUTH);
//    }
//}
