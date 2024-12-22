import java.util.Scanner;

public class grade_cal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int Sub = scanner.nextInt();

        int totalMarks = 0;
        for (int i = 1; i <= Sub; i++) {
            System.out.print("Enter marks for subject " + i + ": ");
            int marks = scanner.nextInt();
            totalMarks += marks;
        }
        double avg = (double) totalMarks / Sub;
        char grade;
        if (avg >= 90) {
            grade = 'A';
        } else if (avg >= 75) {
            grade = 'B';
        } else if (avg >= 60) {
            grade = 'C';
        } else if (avg >= 50) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Percentage: " + avg + "%");
        System.out.println("Grade: " + grade);
    }
}