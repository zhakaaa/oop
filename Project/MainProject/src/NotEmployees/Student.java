package NotEmployees;
import java.util.*;

import Database.Database;
import Employees.Librarian;
import Enums.QuizNumber;
import Enums.Schools;
import Material.Book;
import Material.Course;
import Material.Mark;
import Material.Message;

public class Student extends User {

    public List<Course> enrolledCourses = new ArrayList<>();
    public List<Course> completedCourses = new ArrayList<>();
    private Map<String, List<Date>> schedule = new HashMap<>();
    private Map<Course, Mark> marks = new HashMap<>();
    private List<Book> books = new ArrayList<>();

    private int numberOfCredits;
    private double gpa;
    private Schools school = Schools.IT;


    public Student(String login, String username, String password, int age, int id) {
        super(login,username,password,age,id);
    }

    public Student(String login, String username, String password, int age, int id, Schools school) {
        super(login,username,password,age,id);
        this.school = school;
    }

    public Student(String login, String username, String password, int age,int id, double gpa) {
        super(login,username,password,age,id);
        this.gpa = gpa;
    }
    public Student(String username,int id){
        super(username, id);
    }

    public Student() {}

    public List<Course> getEnrolledCourses() {
        return  enrolledCourses;
    }

    public void registrateCourse() {
        showCourseForSchool(school);
        Scanner sc = new Scanner(System.in);
        System.out.print("Select course order to registrate: ");
        int courseOrder = sc.nextInt();

        // Select the course from the list
        Course course = getCoursesForSchool(school).get(--courseOrder);


        // Check if student do not have the course already
        if (enrolledCourses != null && !enrolledCourses.contains(course)) {
            // Check if student pass all prerequisites
            boolean isAll = true;
            if(!course.prerequisites.isEmpty()){
                if(!completedCourses.isEmpty()){
                    for(Course item2 : completedCourses){
                        if(!course.prerequisites.contains(item2)){
                            isAll = false;
                            System.out.println("Student didn't close the prerequisites of this course: " + course.getCourseName());
                            return;
                        }
                    }
                }
                else{
                    isAll = false;
                    System.out.println("Student didn't close the prerequisites of this course: " + course.getCourseName());
                    return;
                }
            }


            if(numberOfCredits + course.getCredits() <= 21){
                enrolledCourses.add(course);
                System.out.println("Successfully enrolled in course: " + (course != null ? course.getCourseId() : 0) + " " + (course != null ? course.getCourseName() : null));
                numberOfCredits += course != null ? course.getCredits() : 0;
                Student student = new Student();
                for(Student item : Database.allStudents){
                    if(item.getUserId() == this.getUserId()){
                        student = item;
                    }
                }
                course.students.add(student);
                completedCourses.add(course);
            }
            else{
                System.out.println("Student have more than available number of credits!\nRegistration course cancelled");
            }

        }
        else {
            System.out.println("Already enrolled in course : " + (course != null ? course.getCourseId() : 0) + " " + course.getCourseName());
        }

        Admin.logAction(super.getUsername(), "Student registrated for Course");

    }

    private void showCourseForSchool(Enums.Schools school) {
        List<Course> courses = Database.courseBySchool.get(school.name());
        if (courses != null) {
            System.out.println("Courses for " + school + ":");
            for (Course course : courses) {
                System.out.println( (courses.indexOf(course) + 1) +  ". " + course.toString());
            }
        } else {
            System.out.println("No courses found for " + school.toString());
        }

        Admin.logAction(super.getUsername(), "Student view Courses of Each School");

    }

    private List<Course> getCoursesForSchool(Enums.Schools school) {
        List<Course> courses = Database.courseBySchool.get(school.name());
        return courses == null ? new ArrayList<>() : courses;
    }


    private void dropCourse() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter course's id to remove: ");
        int courseId = in.nextInt();
        if (enrolledCourses.remove(
                Database.allCourses.stream()
                        .filter(course -> course.getCourseId() == courseId)
                        .findFirst()
                        .orElse(null)))
        {
            System.out.println("Successfully dropped course: ");
        }
        else {
            System.out.println("Course ID " + courseId + " not found in enrolled courses.");
        }

        Admin.logAction(super.getUsername(), "Student removed Course from enrolled Courses");
    }

    private void viewEnrolledCourses() {
        if (enrolledCourses.isEmpty()) {
            System.out.println("No courses currently enrolled.");
        } else {
            System.out.println("Enrolled courses: " + enrolledCourses);
        }

        Admin.logAction(super.getUsername(), "Student view his enrolled Courses");

    }

    private void viewTranscript() { // 1 - english, 2 - russian, 3 - kazakh
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose the language to get transcipt\n1. English\n2. Русский\n3. Қаза\n4. Quit");
        int language = sc.nextInt();
        switch (language) {
            case 1:
                for(Map.Entry<Course, Mark> entry : marks.entrySet()) {
                    System.out.println("The course: " + entry.getKey().getCourseName()
                            + ", Credits: " + entry.getKey().getCredits()
                            + ", Digit grade: " + entry.getValue().calculateTotal()
                            + ", Letter grade: " + entry.getValue().getLetterGrade()
                            + ", GPA: " + entry.getValue().getGPA()
                            + ", Traditional grade: " + entry.getValue().getTraditionalGrade(1));

                }
                break;
            case 2:
                for(Map.Entry<Course, Mark> entry : marks.entrySet()) {
                    System.out.println("Наименование: " + entry.getKey().getCourseName()
                            + ", Кредитность: " + entry.getKey().getCredits()
                            + ", Цифр.оценка: " + entry.getValue().calculateTotal()
                            + ", Букв.оценка" + entry.getValue().getLetterGrade()
                            + ", GPA: " + entry.getValue().getGPA()
                            + ", Традиц.оценка: " + entry.getValue().getTraditionalGrade(2));
                }
                break;
            case 3:
                for(Map.Entry<Course, Mark> entry : marks.entrySet()) {
                    System.out.println("Атауы: " + entry.getKey().getCourseName()
                            + ", Кредиттілігі: " + entry.getKey().getCredits()
                            + ", Цифр.оценка: " + entry.getValue().calculateTotal()
                            + ", Букв.оценка" + entry.getValue().getLetterGrade()
                            + ", GPA: " + entry.getValue().getGPA()
                            + ", Традиц.оценка: " + entry.getValue().getTraditionalGrade(3));
                }
                break;
            case 4:
                return;

            default:
                System.out.println("Invalid language");
        }

        Admin.logAction(super.getUsername(), "Student view Transcript");


    }

    public void manageCourses() {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("1. Enroll course\n2. Drop course\n3. View courses\n4. Quit");
            int choice = scanner.nextInt();

            if(choice == 1){
                registrateCourse();
            }
            else if(choice == 2) {
                dropCourse();
            }
            else if(choice == 3) {
                viewEnrolledCourses();
            }
            else if(choice == 4) {
                break;
            }
            else System.out.println("Invalid input. Please try again.");
        }
    }


    @Override
    public void changePassword(String newPassword) {
        super.setPassword(newPassword);
    }

    public int getAge() {
        return super.getAge();
    }

    public void setAge(int age) {
        super.setAge(age);
    }

    public String getUsername() {
        return super.getUsername() ;
    }

    public void setUsername(String username) {
        super.setUsername(username);
    }

    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public Map<Course, Mark> getTranscript() {
        return marks;
    }

    public Map<String, List<Date>> getSchedule() {
        return schedule;
    }
    public void setSchedule(Map<String, List<Date>> schedule) {
        this.schedule = schedule;
    }

    public Map<Course, Mark> getMarks() {
        return marks;
    }

    public void setMarks(Course course, Mark mark) {
        marks.put(course,mark);
    }

    private void showMarksForCourse(){
        Scanner sc = new Scanner(System.in);
        viewEnrolledCourses();
        System.out.println("Enter the course Id to view the marks: ");
        int courseId = sc.nextInt();
        Course course = enrolledCourses.stream()
                .filter(item -> item.getCourseId() == courseId)
                .findFirst()
                .orElse(null);

        if(course == null){
            System.out.println("The course with given Id was not found.");
            return;
        }

        for(Map.Entry<Course, Mark> entry : marks.entrySet()) {
            if(entry.getKey().getCourseId() == courseId) {
                System.out.println("The course: " + entry.getKey().getCourseName()
                        + "\nFirst Quiz:  " + entry.getValue().getQuizScore(QuizNumber.quiz1)
                        + "\nSecond quiz: " + entry.getValue().getQuizScore(QuizNumber.quiz2)
                        + "\nThe first attestation: " + entry.getValue().getFirstAttestation()
                        + "\nThird quiz: " + entry.getValue().getQuizScore(QuizNumber.quiz3)
                        + "\nFourth quiz: " + entry.getValue().getQuizScore(QuizNumber.quiz4)
                        + "\nThe second attestation: " + entry.getValue().getSecondAttestation()
                        + "\nThe Final exam: " + entry.getValue().getFinalExam()
                        + "\nThe total: " + entry.getValue().calculateTotal()
                        + "\nThe total grade: " + entry.getValue().getLetterGrade());
            }
        }

        Admin.logAction(super.getUsername(), "Student view marks for specific Course");

    }

    public void viewMarks() {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("1. View transcript\n2. View mark for Course\n3. Quit");
            int choice = scanner.nextInt();

            if(choice == 1){
                viewTranscript();
            }
            else if(choice == 2) {
                showMarksForCourse();
            }
            else if(choice == 3) {
                break;
            }
            else System.out.println("Invalid input. Please try again.");
        }
    }

    public void manageBooks() {
        Librarian librarian = new Librarian();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("1. Request book\n2. Return book\n3. Quit");
            int choice = scanner.nextInt();

            if(choice == 1){
                for(Book book : Database.allBooks){
                    System.out.println(book.toString());
                }

                Scanner sc = new Scanner(System.in);
                System.out.println("Enter book's id: ");
                int id = sc.nextInt();
                librarian.issueBook(id,getUserId());
                Admin.logAction(getUsername(), "Student requested Book from library");

            }
            else if(choice == 2) {
                for(Book book : books){
                    System.out.println(book.toString());
                }

                Scanner sc = new Scanner(System.in);
                System.out.println("Enter book's id: ");
                int id = sc.nextInt();
                librarian.returnBook(id);
                Admin.logAction(getUsername(), "Student returned book to library");

            }
            else if(choice == 3) {
                break;
            }
            else System.out.println("Invalid input. Please try again.");
        }
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

    public Schools getSchool() {
        return school;
    }

    public void setSchool(Schools school) {
        this.school = school;
    }

    @Override public String toString() {
        return "Id: " + super.getUserId() + ", Login: " + super.getLogin() + ", Username: " + super.getUsername() + ", Age: " + super.getAge() + ", GPA: " + gpa;
    }
}
