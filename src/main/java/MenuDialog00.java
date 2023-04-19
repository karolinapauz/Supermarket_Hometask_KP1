//import enitity.User;
//import enitity.UserType;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class MenuDialog00 extends JDialog {
//
//    SupermarketApplication supermarketApplication = new SupermarketApplication();
//
//    public MenuDialog00(JFrame parent, UserType userType) {
//        super(parent, "Supermarket Menu", true);
//
//        setSize(600, 500);
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
//                    supermarketApplication.buyProduct(new User());
//                }
//            });
//            menuPanel.add(buyProductButton);
//        } else if (userType == UserType.SALES_REPRESENTATIVE || userType == UserType.OWNER) {
//            JButton addProductButton = new JButton("Add Product");
//            addProductButton.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    supermarketApplication.addProduct(new User());
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
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                UserType userType = UserType.BUYER; // Set user type based on the user's choice
//                JFrame frame = new JFrame("Supermarket");
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.setSize(400, 300);
//                frame.setLocationRelativeTo(null);
//
//                JButton openMenuButton = new JButton("Open Menu");
//                openMenuButton.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        MenuDialog00 menuDialog = new MenuDialog00(frame, userType);
//                        menuDialog.setVisible(true);
//                    }
//                });
//
//                frame.add(openMenuButton, BorderLayout.CENTER);
//                frame.setVisible(true);
//            }
//        });
//    }
//}
