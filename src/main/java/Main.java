import enitity.UserType;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        SupermarketApplication app = new SupermarketApplication();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the supermarket!");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                UserType userType = app.login(scanner);
                if (userType != null) {
                    Menu menu = new Menu(userType, app, scanner);
                    menu.display();
                } else {
                    System.out.println("Invalid email or password. Please try again.");
                }
            } else if (option == 2) {
                // Register a new user
            } else if (option == 3) {
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
