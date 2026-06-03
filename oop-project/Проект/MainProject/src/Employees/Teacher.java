package Employees;

import Database.Database;
import Enums.ComplaintLevel;
import Enums.TeacherType;
import Enums.QuizNumber;
import Material.Course;
import Material.Mark;
import Material.Message;
import NotEmployees.Admin;
import NotEmployees.Student;
import NotEmployees.User;

import java.util.*;

public class Teacher extends Employee {

    public List<Course> assignedCourses = new ArrayList<>();
    public List<Student> students = new ArrayList<>();;
    public HashMap<Course, Student> ratingLogs = new HashMap<>();

    private TeacherType teacherType;
    private ComplaintLevel ComplaintLevel;

    public Teacher(){};

    public Teacher(String login, String username, String password, int age, int id) {
        super(login,username,password,age,id);
    }

    public Teacher(String username,int id){
        super(username, id);
    }

    public void viewCourses() {
        if (assignedCourses.isEmpty()) {
            System.out.println("No courses assigned.");
            return;
        }

        System.out.println("Courses of teacher: " + this.getUserId() + " " + this.getUsername());
        for (Course course : assignedCourses) {
            System.out.println("- Course Id: " + course.getCourseId() +", Course Name: " + course.getCourseName());
        }


        Admin.logAction(super.getUsername(), "Teacher view enrolled courses");

    }

    public void manageCourse() {  // нужно подумать
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while(isRunning) {
            int choice = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.println("1. View courses\n2. Delete courses\n3. Quit");
                    choice = scanner.nextInt();
                    validInput = true;

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine();
                }
            }

            switch (choice) {
                case 1:
                    viewCourses();
                    break;
                case 2:
                    deleteCourses();
                    break;
                case 3:
                    isRunning = false;
                    return;


                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public void deleteCourses() {
        if (assignedCourses.isEmpty()) {
            System.out.println("No courses to delete.");
            return;
        }

        System.out.println("Assigned Courses:");
        for (Course course : assignedCourses) {
            System.out.println("- " + course.toString());
        }

        System.out.println("Which course you want to delete?");
        Scanner scanner = new Scanner(System.in);
        int courseId = scanner.nextInt();

        for(Course course : assignedCourses) {
            if(course.getCourseId() == courseId) {
                assignedCourses.remove(course);
            }
        }

        Admin.logAction(super.getUsername(), "Teacher deleted course from enrolled courses");


    }

    public void viewInfoStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("Students of teacher: " + this.getUserId() + " " + this.getUsername());
        for (Student student : students) {
            System.out.println("Name: " + student.getUsername() + ", ID: " + student.getUserId() + ", GPA: " + student.getGpa());
        }

        Admin.logAction(super.getUsername(), "Teacher view information about his Students");

    }

    public void sendComplaint() {
        viewStudents();
        System.out.println("To which student you (teacher) want to send complaint");
        Scanner scanner = new Scanner(System.in);
        int studentId = scanner.nextInt();
        Student student = students.stream().filter(s -> s.getUserId() == studentId).findFirst().get();
        String complaintMessage = "Complaint about student: " + student.getUsername() + " with level (low,medium,high): " + ComplaintLevel ;
        Message message = new Message(complaintMessage, this, student, new Date());
        this.messagesSend.add(message);

        // В зависимости от уровня жалобы отправляем её к декану или студенту
        switch (ComplaintLevel) {
            case high:
                System.out.println("High-level complaint sent to the Dean: " + complaintMessage);
                student.messagesReceived.add(message);
                break;
            case medium:
                System.out.println("Medium-level complaint sent to the Dean: " + complaintMessage);
                student.messagesReceived.add(message);
                break;
            case low:
                System.out.println("Low-level complaint sent to the Dean: " + complaintMessage);
                student.messagesReceived.add(message);
                break;
        }

        Admin.logAction(super.getUsername(), "Teacher send complaint to Student");

    }

    public void putMarks(){
        viewCourses();
        viewStudents();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter course Id to put mark: ");
        int courseId = scanner.nextInt();


        Student student = new Student();
        Course course = new Course();

        try {
            for(Course itemCourse : assignedCourses){
                if(itemCourse.getCourseId() == courseId){
                    course = itemCourse;
                }
            }
        }catch (NoSuchElementException | NullPointerException e) {
            System.out.println("The course with given id was not found. You (teacher) is not enrolled in this course.");
            return;
        }

        viewStudentsForCourse(courseId);
        System.out.println("Enter Student id: ");
        int studentId = scanner.nextInt();

        for(Student itemStudent : course.students){
            if(itemStudent.getUserId() == studentId){
                student = itemStudent;
            }
        }

        Mark mark = new Mark();

        System.out.println("Mark for first quiz (out of 15) for student with id: " + student.getUserId());
        int score1 = scanner.nextInt();
        mark.setQuizScore(QuizNumber.quiz1, score1);

        System.out.println("Mark for second quiz (out of 15) for student with id: " + student.getUserId());
        int score2 = scanner.nextInt();
        mark.setQuizScore(QuizNumber.quiz2, score2);

        System.out.println("Mark for third quiz (out of 15) for student with id: " + student.getUserId());
        int score3 = scanner.nextInt();
        mark.setQuizScore(QuizNumber.quiz3, score3);

        System.out.println("Mark for fourth quiz (out of 15) for student with id: " + student.getUserId());
        int score4 = scanner.nextInt();
        mark.setQuizScore(QuizNumber.quiz4, score4);

        System.out.println("Mark for final quiz (out of 40) for student with id: " + student.getUserId());
        int finalMark = scanner.nextInt();
        mark.setFinalExam(finalMark);

        mark.setFirstAttestation(score1 + score2);
        mark.setSecondAttestation(score3 + score4);

        student.setMarks(course, mark);

        System.out.println("Mark added for student " + student.getUsername() + " for course " + course.getCourseName());

        Admin.logAction(super.getUsername(), "Teacher put mark for Student");

    }

    private void viewStudentsForCourse(int courseId) {
        Course course = null;
        for(Course item : assignedCourses){
            if(item.getCourseId() == courseId){
                course = item;
            }
        }
        if(course == null) {
            System.out.println("The course with given Id was not found");
            return;
        }

        for(Student item: course.students){
            System.out.println(item.toString());
        }

        Admin.logAction(super.getUsername(), "Teacher view Students of each Course");

    }

    private void viewStudents() {
        System.out.println("Students of teacher: " + this.getUserId() + " " + this.getUsername());
        for (Student student : students) {
            System.out.println("Username: " + student.getUsername() + ", ID: " + student.getUserId() + ", GPA: " + student.getGpa());
        }

        Admin.logAction(super.getUsername(), "Teacher view all Students");

    }

    @Override public void sendMessage() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("To whom do you want to send messages?\nEnter the user id: ");
        int userId = scanner.nextInt();

        User user = Database.userDatabase.stream()
                .filter(user1 -> user1.getUserId() == userId)
                .findFirst()
                .orElse(null);

        scanner.nextLine();
        System.out.println("Please, write your message: ");
        String messageContent = scanner.nextLine();

        Message message = new Message() ;
        message.setContent(messageContent);
        message.setSender(this);
        message.setReceiver(user);
        message.setSentDate(new Date());


        if (user != null) {
            user.messagesReceived.add(message);
        }
        messagesSend.add(message);
        System.out.println("Message sent to: " + (user != null ? user.getUsername() : null));
    }

    @Override public String toString() {
        return "Id: " + super.getUserId() +  ", Login: " + super.getLogin() + ", Username: " + super.getUsername()  + ", Age: " + super.getAge();
    }
}
