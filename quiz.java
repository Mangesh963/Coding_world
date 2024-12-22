import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class qq {
    String question;
    String[] options;
    String right_ans;

    public qq(String question, String[] options, String right_ans) {
        this.question = question;
        this.options = options;
        this.right_ans = right_ans;
    }
}

public class quiz {
    private static int score = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        qq[] questions = new qq[] {
                new qq("What is the capital of India?", new String[] { "Delhi", "Maharashtra", "Kashmir", "Goa" },
                        "Delhi"),
                new qq(" How many peoples are allowed to seat on two wheeler bike?",
                        new String[] { "1", "2", "4", "5" }, "2"),
                new qq("Who is current prime minister of india?",
                        new String[] { "Arijit singh", "Dont Know", "Ajit Pawar", "Narendra Modi" }, "Narendra Modi")
        };
        for (qq question : questions) {
            q(question, scanner);
        }
        System.out.println("Your final score is: " + score + "/" + questions.length);
    }

    private static void q(qq question, Scanner scanner) {
        System.out.println("\nQuestion: " + question.question);
        for (int i = 0; i < question.options.length; i++) {
            System.out.println((i + 1) + ". " + question.options[i]);
        }
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("\nTime's up! Moving to next question.");
            }
        };
        timer.schedule(task, 10000);
        System.out.print("Enter your answer (1-4): ");
        String answer = scanner.nextLine();
        timer.cancel();
        String selected_ans = question.options[Integer.parseInt(answer) - 1];
        if (selected_ans.equals(question.right_ans)) {
            score++;
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect! The correct answer was: " + question.right_ans);
        }
    }
}
