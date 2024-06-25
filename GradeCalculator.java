import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the number of subjects
        System.out.println("Enter the number of subjects:");
        int numSubjects = scanner.nextInt();

        // Initialize an array to store the marks for each subject
        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        // Loop to get the marks for each subject
        for (int i = 0; i < numSubjects; i++) {
            System.out.println("Enter the marks obtained in subject " + (i + 1) + " (out of 100):");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];
        }

        // Calculate the average percentage
        double averagePercentage = (double) totalMarks / numSubjects;

        // Determine the grade based on the average percentage
        char grade;
        if (averagePercentage >= 85) {
            grade = 'A';
        } else if (averagePercentage >= 70) {
            grade = 'B';
        } else if (averagePercentage >= 55) {
            grade = 'C';
        } else if (averagePercentage >= 40) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display the results to the user
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        // Close the scanner
        scanner.close();
    }
}
