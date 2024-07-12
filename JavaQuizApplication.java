import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class JavaQuizApplication {
    
    static class QuizQuestion {
        String question;
        String[] options;
        int correctAnswerIndex;
        
        public QuizQuestion(String question, String[] options, int correctAnswerIndex) {
            this.question = question;
            this.options = options;
            this.correctAnswerIndex = correctAnswerIndex;
        }
    }
    
    static List<QuizQuestion> quizQuestions = new ArrayList<>();
    static int score = 0;
    static int currentQuestionIndex = 0;
    static Scanner scanner = new Scanner(System.in);
    static Timer timer; // Declare timer globally
    
    public static void main(String[] args) {
        initializeQuiz();
        startQuiz();
    }
    
    public static void initializeQuiz() {
        // Define your quiz questions here
        quizQuestions.add(new QuizQuestion("What is the output of the following Java code?\n\npublic class Main {\n    public static void main(String[] args) {\n        int x = 5;\n        System.out.println(x++);\n    }\n}", 
                                           new String[]{"5", "6", "Compilation Error", "Runtime Error"}, 
                                           0));
        
        quizQuestions.add(new QuizQuestion("Which of the following is not a Java keyword?", 
                                           new String[]{"class", "interface", "extends", "unsigned"}, 
                                           3));
        
        quizQuestions.add(new QuizQuestion("What is the correct way to declare a constant in Java?", 
                                           new String[]{"final int PI = 3.14;", "const double PI = 3.14;", "int PI = 3.14; //constant", "static int PI = 3.14;"}, 
                                           0));
    }
    
    public static void startQuiz() {
        score = 0;
        currentQuestionIndex = 0;
        
        System.out.println("Welcome to the Java Programming Quiz!");
        System.out.println("You will have 15 seconds to answer each question.");
        System.out.println("Let's begin!\n");
        
        askQuestion(currentQuestionIndex);
    }
    
    public static void askQuestion(int questionIndex) {
        QuizQuestion question = quizQuestions.get(questionIndex);
        
        System.out.println("Question " + (questionIndex + 1) + ": " + question.question);
        for (int i = 0; i < question.options.length; i++) {
            System.out.println((i+1) + ") " + question.options[i]);
        }
        
        System.out.print("Your answer (1-" + question.options.length + "): ");
        
        // Initialize a new Timer for each question
        timer = new Timer();
        
        // Start the timer for 15 seconds
        TimerTask task = new TimerTask() {
            int timeRemaining = 15;
            
            @Override
            public void run() {
                if (timeRemaining > 0) {
                    System.out.print("\rTime remaining: " + timeRemaining + " seconds");
                    System.out.flush(); // Flush the output to ensure it updates the line
                    timeRemaining--;
                } else {
                    System.out.println("\nTime's up!");
                    showCorrectAnswer(question);
                    timer.cancel();
                    nextQuestion();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000); // Schedule timer to run every second
        int userChoice = scanner.nextInt();
        timer.cancel(); // Cancel timer after user inputs
        
        if (userChoice == question.correctAnswerIndex + 1) {
            score++;
            System.out.println("\nCorrect!");
        } else {
            System.out.println("\nIncorrect!");
            showCorrectAnswer(question);
        }
        
        System.out.println();
        
        // Move to the next question if there are more questions
        if (questionIndex < quizQuestions.size() - 1) {
            currentQuestionIndex++;
            askQuestion(currentQuestionIndex);
        } else {
            displayResult();
        }
    }
    
    public static void showCorrectAnswer(QuizQuestion question) {
        System.out.println("The correct answer was: " + question.options[question.correctAnswerIndex]);
    }
    
    public static void displayResult() {
        System.out.println("Quiz complete!");
        System.out.println("Your score: " + score + "/" + quizQuestions.size());
    }
    
    public static void nextQuestion() {
        if (currentQuestionIndex < quizQuestions.size() - 1) {
            currentQuestionIndex++;
            askQuestion(currentQuestionIndex);
        } else {
            displayResult();
        }
    }
}