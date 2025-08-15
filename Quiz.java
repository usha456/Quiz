public class Question {
    private String questionText;
    private String[] options;
    private int correctOptionIndex;

    public Question(String questionText, String[] options, int correctOptionIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public void displayQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    public boolean isCorrect(int userAnswer) {
        return userAnswer - 1 == correctOptionIndex;
    }
}
import java.util.Scanner;

public class QuizApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample questions
        Question[] questions = new Question[] {
            new Question("What is the capital of France?",
                new String[] { "Berlin", "Paris", "London", "Madrid" }, 1),
            new Question("Which planet is known as the Red Planet?",
                new String[] { "Earth", "Venus", "Mars", "Jupiter" }, 2),
            new Question("What is 5 + 7?",
                new String[] { "10", "11", "12", "13" }, 2)
        };

        int score = 0;

        System.out.println("Welcome to the Quiz!\n");

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ":");
            questions[i].displayQuestion();

            System.out.print("Your answer (1-4): ");
            int userAnswer = scanner.nextInt();

            if (questions[i].isCorrect(userAnswer)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong!\n");
            }
        }

        System.out.println("Quiz completed.");
        System.out.println("Your score: " + score + " out of " + questions.length);

        scanner.close();
    }
}
