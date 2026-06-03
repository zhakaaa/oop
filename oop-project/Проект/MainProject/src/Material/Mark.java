package Material;
import Enums.QuizNumber;

import java.util.HashMap;
import java.util.Map;

public class Mark {
    private double firstAttestation;
    private double secondAttestation;
    private double finalExam;
    private Map<QuizNumber, Integer> quizScores = new HashMap<>();

    public Mark(){}

    public Mark(double firstAttestation, double secondAttestation, double finalExam) {
        this.firstAttestation = firstAttestation;
        this.secondAttestation = secondAttestation;
        this.finalExam = finalExam;
    }

    public void setQuizScore(QuizNumber QuizNumber, int score) {
        if (score < 0 || score > 15) {
            throw new IllegalArgumentException("Quiz score must be between 0 and 15.");
        }
        quizScores.put(QuizNumber, score);
//        validateAttestations();
    }

    public int getQuizScore(QuizNumber QuizNumber) {
        return quizScores.get(QuizNumber);
    }


    public double calculateTotal() {
        return firstAttestation  + secondAttestation  + finalExam;
    }

    public boolean isPass() {
        return calculateTotal() >= 50;
    }

    public String getLetterGrade() {
        double total = calculateTotal();
        if (total >= 95) return "A+";
        else if (total >= 90) return "A-";
        else if (total >= 85) return "B+";
        else if (total >= 80) return "B";
        else if (total >= 75) return "B-";
        else if (total >= 70) return "C+";
        else if (total >= 65) return "C-";
        else if (total >= 60) return "D";
        return "F";
    }

    public double getGPA(){
        double total = calculateTotal();
        if(total >= 90) return 4.00;
        else if(total >= 85) return 3.67;
        else if(total >= 80) return 3.33;
        else if(total >= 75) return 3.00;
        else if(total >= 70) return 2.67;
        else if(total >= 65) return 2.33;
        else if(total >= 60) return 2.00;
        else if(total >= 55) return 1.67;
        else if(total >= 50) return 1.00;
        else return 0.00;
    }
    public String getTraditionalGrade(int language){
        double total = calculateTotal();

        if(language == 1){
            if(total >= 90) return "Excellent";
            else if(total >= 75) return "Good";
            else if(total >= 60) return "Satisfactory";
            else if(total >= 50) return "Poor";
            else return "Academic fail";
        }
        else if(language == 2){
            if(total >= 90) return "Отлично";
            else if(total >= 75) return "Хорошо";
            else if(total >= 60) return "Удовлетворительно";
            else if(total >= 50) return "Плохо";
            else return "Академический провал";
        }
        else if(language == 3){
            if(total >= 90) return "Үздік";
            else if(total >= 75) return "Жақсы";
            else if(total >= 60) return "Қанағаттандырлық";
            else if(total >= 50) return "Нашар";
            else return "Академиялық сәтсіздік";
        }

        return "Invalid language selection";
    }



    public double getFirstAttestation() {
        return firstAttestation;
    }

    public void setFirstAttestation(double score) {
        if (score < 0 || score > 30) {
            throw new IllegalArgumentException("First Attestation score must be between 0 and 30.");
        }
        this.firstAttestation = score;
    }

    public double getSecondAttestation() {
        return secondAttestation;
    }

    public void setSecondAttestation(double score) {
        if (score < 0 || score > 30) {
            throw new IllegalArgumentException("Second Attestation score must be between 0 and 30.");
        }
        this.secondAttestation = score;
    }

    public double getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(double score) {
        if (score < 0 || score > 40) {
            throw new IllegalArgumentException("Final exam score must be between 0 and 40.");
        }
        this.finalExam = score;
    }

    public String toString() {
        return "Material.Mark{" +
                ", total=" + calculateTotal() +
                ", passed=" + (isPass() ? "Yes" : "No") +
                '}';
    }
}