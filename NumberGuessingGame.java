import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int min = 1;
            int max = 100;
            int numberToGuess = random.nextInt(max - min + 1) + min;
            int attempts = 0;
            int maxAttempts = 10;
            boolean hasGuessedCorrectly = false;

            System.out.println("\nI've generated a number between " + min + " and " + max + ". Can you guess it?");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    hasGuessedCorrectly = true;
                }

                if (!hasGuessedCorrectly && attempts == maxAttempts) {
                    System.out.println("Sorry, you've used all your attempts. The number was " + numberToGuess);
                }
            }

            totalScore += (maxAttempts - attempts) > 0 ? (maxAttempts - attempts) : 0;

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Thank you for playing! Your total score is: " + totalScore);
        scanner.close();
    }
}