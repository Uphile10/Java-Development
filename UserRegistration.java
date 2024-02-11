import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserRegistration {
    static Map<String, String> userAccounts = new HashMap<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("User Registration System");
                System.out.println("1. Register as Student");
                System.out.println("2. Register as Teacher");
                System.out.println("3. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        registerUser("student");
                        break;
                    case 2:
                        registerUser("teacher");
                        break;
                    case 3:
                        System.out.println("Exiting User Registration System. Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
        }
    }

    private static void registerUser(String role) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            userAccounts.put(username, password + ":" + role);
        }

        System.out.println("Registration successful as " + role + ".\n");
    }
}
