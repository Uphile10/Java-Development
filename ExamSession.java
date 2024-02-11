import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExamSession {
    private Exam exam;
    private Map<Question, String> studentResponses = new HashMap<>();

    public ExamSession(Exam exam) {
        this.exam = exam;
    }

    public void takeExam(Scanner scanner) {
        // Code for taking the exam, recording student responses, and auto-submitting when the time expires

        // Sample code to record student responses (this would be based on your actual implementation)
        for (Question question : exam.getQuestions()) {
            System.out.print("Enter your answer for question: " + question.getQuestionText() + ": ");
            String response = scanner.nextLine();
            studentResponses.put(question, response);
        }

        // Auto-submit or manual submission based on the timer

        // Grade the exam
        gradeExam();
    }

    private void gradeExam() {
        int totalQuestions = exam.getQuestions().size();
        int correctAnswers = 0;

        for (Question question : exam.getQuestions()) {
            String studentResponse = studentResponses.get(question);
            if (studentResponse != null && studentResponse.equalsIgnoreCase(question.getCorrectAnswer())) {
                correctAnswers++;
            }
        }

        double score = ((double) correctAnswers / totalQuestions) * 100;

        // Provide feedback and scores to students upon exam completio
    }
}
