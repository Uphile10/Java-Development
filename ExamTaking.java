public

import java.util.Scanner;

public class ExamTaking {
    private static User currentUser;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Exam Taking System");
            System.out.println("1. Login");
            System.out.println("2. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    loginUser();
                    break;
                case 2:
                    System.out.println("Exiting Exam Taking System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void loginUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        String userCredentials = UserRegistration.userAccounts.get(username);

        if (userCredentials != null && userCredentials.startsWith(password)) {
            String[] credentials = userCredentials.split(":");
            String role = credentials[1];
            currentUser = new User(username, role);
            System.out.println("Login successful as " + role + ".\n");

            if (role.equals("student")) {
                takeExam();
            } else {
                System.out.println("Only students can take exams in this system.");
            }
        } else {
            System.out.println("Invalid username or password.\n");
        }
    }

    private static void takeExam() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Available Exams:");
        for (int i = 0; i < ExamCreation.exams.size(); i++) {
            System.out.println((i + 1) + ". " + ExamCreation.exams.get(i).getTitle());
        }

        System.out.print("Select an exam to take (enter the exam number): ");
        int examNumber = scanner.nextInt();

        if (examNumber > 0 && examNumber <= ExamCreation.exams.size()) {
            Exam selectedExam = ExamCreation.exams.get(examNumber - 1);
            ExamSession examSession = new ExamSession(selectedExam);
            examSession.takeExam();
        } else {
            System.out.println("Invalid exam number. Please enter a valid exam number.\n");
        }
    }
}
