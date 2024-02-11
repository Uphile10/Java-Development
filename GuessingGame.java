
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();

            do {
                int lowerBound = 1;
                int upperBound = 100;
                int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
                int userGuess;
                int attempts = 0;

                // Welcome message and displaying the range of numbers
                System.out.println("Welcome to the Simple Guessing Game!");
                System.out.println("I have selected a number between " + lowerBound + " and " + upperBound);

                // Loop for each attempt
                do {
                    // Prompting the user to enter their guess
                    System.out.print("Enter your guess: ");
                    userGuess = scanner.nextInt();
                    attempts++;

                    // Providing feedback based on the user's guess
                    if (userGuess < randomNumber) {
                        System.out.println("Too low! Try again.");
                    } else if (userGuess > randomNumber) {
                        System.out.println("Too high! Try again.");
                    } else {
                        // Congratulating the user upon correct guess
                        System.out.println(
                                "Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    }
                } while (userGuess != randomNumber); // Continuing until the user guesses the correct number

                // Asking the user if they want to play again
                System.out.print("Do you want to play again? (yes/no): ");
            } while (scanner.next().equalsIgnoreCase("yes")); // Looping if the user wants to play again
        }
        // Farewell message when the game ends
        System.out.println("Thank you for playing the Guessing Game. Goodbye!");
    }
}
