import enitity.UserType;

import java.util.Scanner;

public class Menu {
    private final UserType userType;
    private final SupermarketApplication app;
    private final Scanner scanner;

    public Menu(UserType userType, SupermarketApplication app, Scanner scanner) {
        this.userType = userType;
        this.app = app;
        this.scanner = scanner;
    }

    public void display() {
        while (true) {
            System.out.println("---- Supermarket Menu ----");
            System.out.println("1. Exit");

            if (userType == UserType.BUYER) {
                System.out.println("2. Buy Product");
            } else if (userType == UserType.SALES_REPRESENTATIVE || userType == UserType.OWNER) {
                System.out.println("2. Add Product");
            }

            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                break;
            } else if (option == 2) {
                if (userType == UserType.BUYER) {
                    // Implement buy product functionality
                    app.buyProduct();
                } else if (userType == UserType.SALES_REPRESENTATIVE || userType == UserType.OWNER) {
                    // Implement add product functionality
                    app.addProduct();
                }
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
