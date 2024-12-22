import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizQuestion {
    String question;
    String[] options;
    String correctAnswer;

    public QuizQuestion(String question, String[] options, String correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

public class quiz {
    private static int score = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define the quiz questions
        QuizQuestion[] questions = new QuizQuestion[] {
                new QuizQuestion("What is the capital of France?", new String[] { "Paris", "London", "Rome", "Berlin" },
                        "Paris"),
                new QuizQuestion("Which planet is known as the Red Planet?",
                        new String[] { "Earth", "Mars", "Venus", "Jupiter" }, "Mars"),
                new QuizQuestion("What is the largest ocean on Earth?",
                        new String[] { "Atlantic", "Indian", "Arctic", "Pacific" }, "Pacific")
        };

        // Ask each question
        for (QuizQuestion question : questions) {
            askQuestion(question, scanner);
        }

        // Show final score
        System.out.println("Your final score is: " + score + "/" + questions.length);
    }

    private static void askQuestion(QuizQuestion question, Scanner scanner) {
        System.out.println("\nQuestion: " + question.question);
        for (int i = 0; i < question.options.length; i++) {
            System.out.println((i + 1) + ". " + question.options[i]);
        }

        // Start timer
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("\nTime's up! Moving to next question.");
            }
        };
        timer.schedule(task, 10000); // 10 seconds for each question

        // Get user input
        System.out.print("Enter your answer (1-4): ");
        String answer = scanner.nextLine();

        // Cancel timer if the user answers before time runs out
        timer.cancel();

        // Check the answer
        String chosenAnswer = question.options[Integer.parseInt(answer) - 1];
        if (chosenAnswer.equals(question.correctAnswer)) {
            score++;
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect! The correct answer was: " + question.correctAnswer);
        }
    }
}
