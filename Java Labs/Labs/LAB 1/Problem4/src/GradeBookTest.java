import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;

public class GradeBookTest{

    private final GradeBook gradeBook = new GradeBook();
    private GradeBook.Course course = gradeBook.new Course("CSCI2106 Object-Oriented Programming and Design","Based on classes and objects","Calculus", 3 );

    private final Vector<Integer> grades = new Vector<>();

    public void Go(){
        Arrays.fill(gradeBook.frequency, "");

        gradeBook.displayMessage(course);

        Scanner input = new Scanner(System.in);
        System.out.println("Please, enter grades for students: ");

        // Fill list students
        for (int i = 0; i < gradeBook.students.length;i++){
            System.out.print("Student " + gradeBook.students[i].getName() + ": ");
            int grade = input.nextInt();

            if(grade >= 0 && grade < 10){
                grades.add(grade);
                gradeBook.frequency[0] += "*";}

            else if(grade >= 10 && grade < 20){
                grades.add(grade);
                gradeBook.frequency[1] += "*";}

            else if (grade >= 20 && grade < 30){
                grades.add(grade);
                gradeBook.frequency[2] += "*";}

            else if (grade >= 30 && grade < 40){
                grades.add(grade);
                gradeBook.frequency[3] += "*";}

            else if (grade >= 40 && grade < 50){
                grades.add(grade);
                gradeBook.frequency[4] += "*";}

            else if (grade >= 50 && grade < 60){
                grades.add(grade);
                gradeBook.frequency[5] += "*";}

            else if (grade >= 60 && grade < 70){
                grades.add(grade);
                gradeBook.frequency[6] += "*";}

            else if (grade >= 70 && grade < 80){
                grades.add(grade);
                gradeBook.frequency[7] += "*";}

            else if (grade >= 80 && grade < 90){
                grades.add(grade);
                gradeBook.frequency[8] += "*";}

            else if (grade >= 90 && grade < 100){
                grades.add(grade);
                gradeBook.frequency[9] += "*";}

            else if (grade == 100){
                grades.add(grade);
                gradeBook.frequency[10] += "*";}

            else{
                System.out.println("Invalid grade");
                break;}
        }

        for (int i = 0; i < grades.size(); i++){
            if(grades.get(i) > gradeBook.max){
                gradeBook.max = grades.get(i);
                gradeBook.highestName = gradeBook.students[i].getName();
                gradeBook.idHighestStudent = gradeBook.students[i].getId();
            }
            if(grades.get(i) <= gradeBook.min){
                gradeBook.min = grades.get(i);
                gradeBook.lowestName = gradeBook.students[i].getName();
                gradeBook.idLowestStudent = gradeBook.students[i].getId();
            }

            gradeBook.counter++;
            gradeBook.sum += grades.get(i);
        }

        gradeBook.displayGreatReport();
    }
}
