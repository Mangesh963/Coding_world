import java.util.Random;
import java.util.Scanner;

public class test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int totalScore = 0;
        int roundsPlayed = 0;

        while (true) {
            roundsPlayed++;
            int targetNumber = rand.nextInt(100) + 1;
            int maxAttempts = 10;
            int attempts = 0;
            boolean crt_guess = false;
            System.out.println("Round " + roundsPlayed);
            System.out.println("Guess the number between 1 and 100. You have " + maxAttempts + " attempts.");

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
                    crt_guess = true;
                    break;
                }
            }
            if (!crt_guess) {
                System.out.println("Sorry, you didn't guess the number. It was " + targetNumber + ".");
            }
            totalScore += Math.max(0, 10 - attempts);

            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine();
            String playAgain = scanner.nextLine();

            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }
        System.out.println("Game Over! You played " + roundsPlayed + " rounds.");
        System.out.println("Your total score is: " + totalScore);
    }
}
