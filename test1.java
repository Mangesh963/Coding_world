import java.util.Random;
import java.util.Scanner;

public class test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int totalScore = 0;
        int roundsPlayed = 0;

        // Loop for multiple rounds
        while (true) {
            roundsPlayed++;
            int targetNumber = rand.nextInt(100) + 1; // Random number between 1 and 100
            int maxAttempts = 10;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Round " + roundsPlayed);
            System.out.println("Guess the number between 1 and 100. You have " + maxAttempts + " attempts.");

            // Loop for attempts in the current round
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < targetNumber) {
                    System.out.println("Too low!");
                } else if (guess > targetNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct! The number was " + targetNumber + ".");
                    guessedCorrectly = true;
                    break;
                }
            }

            // If the player didn't guess correctly, reveal the number
            if (!guessedCorrectly) {
                System.out.println("Sorry, you didn't guess the number. It was " + targetNumber + ".");
            }

            // Score calculation: 10 points minus the number of attempts
            totalScore += Math.max(0, 10 - attempts);

            // Ask if the player wants to play again
            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine(); // Clear the buffer
            String playAgain = scanner.nextLine();

            if (!playAgain.equalsIgnoreCase("yes")) {
                break; // Exit the loop if the player doesn't want to play again
            }
        }

        // Final score and rounds played
        System.out.println("Game Over! You played " + roundsPlayed + " rounds.");
        System.out.println("Your total score is: " + totalScore);
    }
}
