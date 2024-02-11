import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExamCreation {
    static List<Exam> exams = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Exam Creation System");
                System.out.println("1. Create Exam");
                System.out.println("2. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        createExam();
                        break;
                    case 2:
                        System.out.println("Exiting Exam Creation System. Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
        }
    }

    private static void createExam() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the exam title: ");
            String title = scanner.nextLine();
            System.out.print("Enter the exam duration (in minutes): ");
            int duration = scanner.nextInt();

            Exam exam = new Exam(title, duration);
            addQuestions(exam);

            exams.add(exam);
        }

        System.out.println("Exam creation successful.\n");
    }

    private static void addQuestions(Exam exam) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of questions: ");
            int numQuestions = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            for (int i = 1; i <= numQuestions; i++) {
                System.out.print("Enter question " + i + ": ");
                String question = scanner.nextLine();
                System.out.print("Enter correct answer for question " + i + ": ");
                String correctAnswer = scanner.nextLine();

                exam.addQuestion(new Question(question, correctAnswer));
            }
        }
    }
}
