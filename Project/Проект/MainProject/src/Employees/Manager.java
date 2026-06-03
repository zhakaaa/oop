package Employees;

import Database.Database;
import Enums.*;
import Material.*;
import NotEmployees.Admin;
import NotEmployees.Student;
import NotEmployees.User;


import java.util.*;
import java.util.stream.Collectors;

public class Manager extends Employee {
    private ManagerType type;
    private List<News> newsList = new ArrayList<>(); // список новостей

    public Manager(){};

    public Manager(String login, String username, String password, int age,int id) {
        super(login,username,password,age,id);
    }
    public Manager(String username,int id){
        super(username,id);
    }

    public void approveStudentRegistration(){
        Scanner scanner = new Scanner(System.in);
        Student approvedStudent = null;
        viewAllStudents();
        System.out.print("Enter student id to approve: ");
        int studentId = scanner.nextInt();
        for (Student student : Database.allStudents) {
            if(student.getUserId() == studentId){
                approvedStudent = student;
                break;
            }
        }
        if (approvedStudent != null && !approvedStudent.enrolledCourses.isEmpty())
            System.out.println("Student " + approvedStudent.getUsername() + " approved for his courses ");

        Admin.logAction(super.getUsername(), "Manager approved Student's course registration");
    }

    public void viewAllCourses(){
        Database.allCourses.sort(Database.byCourseId());
        for(Course course : Database.allCourses){
            System.out.println(course.toString());
        }
    }

    public void addNewCourse() {
        Course newCourse = new Course();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the school of new Course: ");
        int count = 0;
        for(Enums.Schools school : Enums.Schools.values()){
            System.out.println( (count++) +  ": " + school.toString());
        }
        String schoolId = scanner.nextLine();

        System.out.print("Course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Course description: ");
        int courseID = Integer.parseInt(scanner.nextLine());
        System.out.print("Course credits: ");
        int credits = Integer.parseInt(scanner.nextLine());

        Database.allCourses.add(newCourse);
        Database.courseBySchool.put(schoolId, new ArrayList<>(List.of(newCourse)));
        System.out.println("Course " + newCourse.getCourseName() + " added successfully.");
        Admin.logAction(super.getUsername(), "Manager added new Courses");

    }

    public void assignCourseToTeacher() {
        List<Course> tempCourses = new ArrayList<>();
        Teacher tempTeacher = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("The available teachers: ");
        viewAllTeachers();
        System.out.print("Enter teacher id to assign the course: ");
        int teacherID = Integer.parseInt(scanner.nextLine());

        try{
            for(Teacher teacher : Database.allTeachers){
                if(teacher.getUserId() == teacherID){
                    tempTeacher = teacher;
                    break;
                }
            }
        }catch (Exception e){
            System.out.println("No teacher found with the given ID: " + teacherID);
            return;
        }

        while(true){
            int choice = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.println("1. Assign course to teacher\n2. Quit");
                    choice = scanner.nextInt();
                    validInput = true;

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine();
                }
            }
            if(choice == 1){
                System.out.println("All available courses");
                for(Course course : Database.allCourses){
                    if(course.teachers.isEmpty())System.out.println(course.toString());

                }
                System.out.println("Enter course id to be assigned: ");
                int courseId = scanner.nextInt();
                for(Course course : Database.allCourses){
                    if(course.getCourseId() == courseId){
                        tempCourses.add(course);
                        course.teachers.add(tempTeacher);
                    }
                }
            }
            else if(choice == 2){
                System.out.println("You quit.");
                break;
            }
            else{
                System.out.println("Invalid choice. Try again.");
            }

        }
        if (tempTeacher != null) {
            for(Course course : tempCourses){
                tempTeacher.assignedCourses.add(course);
            }
        }
        assignStudentToTeacher(teacherID,tempCourses);

        String courses = tempCourses.stream()
                .map(Course::getCourseName)
                .collect(Collectors.joining(", "));

        System.out.println("Course " + courses + " assigned to teacher " + (tempTeacher != null ? tempTeacher.getUsername() : null));

        Admin.logAction(super.getUsername(), "Manager assign Course to Teacher ");

    }

    private void assignStudentToTeacher(int teacherId, List<Course> courses) {
        Teacher tempTeacher;
        try {
            tempTeacher = Database.allTeachers.stream()
                    .filter(teacher -> teacher.getUserId() == teacherId)
                    .findFirst()
                    .get();
        } catch (NoSuchElementException e) {
            System.out.println("No teacher found with the given ID: " + teacherId);
            return;
        }

        for(Course item : courses){
            for(Student student : item.students){
                tempTeacher.students.add(student);
            }
        }

        Admin.logAction(super.getUsername(), "Manager assign Students to Teacher ");
    }


    public void viewAllStudents() {
        for(Student student : Database.allStudents){
            System.out.println(student.toString());
        }

        Admin.logAction(getUsername(), "Manager view all Students ");

    }

    public void viewAllTeachers() {
        for(Teacher teacher : Database.allTeachers ){
            System.out.println(teacher.toString());
        }
        Admin.logAction(super.getUsername(), "Manager view all Teachers ");

    }


    public void makeReport() {
        if (Database.allStudents.isEmpty()) {
            System.out.println("No students available to generate a report.");
            return;
        }

        for (Course course : Database.allCourses) {
            int studentCount = 0;
            double totalGpa = 0.0;

            for (Student student : Database.allStudents) {
                if (student.getEnrolledCourses().contains(course)) {
                    studentCount++;
                    totalGpa += student.getGpa();
                }
            }
            double averageGpa = studentCount > 0 ? totalGpa / studentCount : 0.0;
            System.out.println("Course: " + course.getCourseName() + ", Students: " + studentCount + ", GPA: " + averageGpa);
        }

        Admin.logAction(super.getUsername(), "Manager make report ");

    }

    public void changeEmployeeData() {
        Scanner scanner = new Scanner(System.in);
        for(User user : Database.userDatabase){
            System.out.println(user.toString());
        }

        System.out.print("Which user's data change?\nEnter the user's id: ");
        int id = scanner.nextInt();


        while(true){
            int choice = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.println("Change:\n1. Login\n2. Password\n3. Username\n4. Age\n5. Quit");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    validInput = true;

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine();
                }
            }

            if(choice == 1){
                System.out.print("New login: ");
                String newLogin = scanner.nextLine();
                for(User user : Database.userDatabase){
                    if(user.getUserId() == id){
                        user.setLogin(newLogin);
                        break;
                    }
                }

            }
            else if(choice == 2){
                System.out.print("New password: ");
                String newPassword = scanner.nextLine();
                Database.userDatabase.stream()
                        .filter(user -> user.getUserId() == id)
                        .findFirst()
                        .ifPresent(user -> user.setPassword(newPassword));
            }
            else if(choice == 3){
                System.out.print("New username: ");
                String newUsername = scanner.nextLine();
                Database.userDatabase.stream()
                        .filter(user -> user.getUserId() == id)
                        .findFirst()
                        .ifPresent(user -> user.setUsername(newUsername));
            }
            else if(choice == 4){
                System.out.print("New age: ");
                int newAge = scanner.nextInt();
                Database.userDatabase.stream()
                        .filter(user -> user.getUserId() == id)
                        .findFirst()
                        .ifPresent(user -> user.setAge(newAge));
            }
            else if(choice == 5){
                System.out.println("Quit");
                break;
            }
            else{
                System.out.println("Invalid choice. Try again.");
            }
        }

        System.out.println("Employee's data updated");

        Admin.logAction(super.getUsername(), "Manager changed Employee Data ");

    }

    public void manageCoursesPanel(){
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while(isRunning) {
            int roleChoice = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.println("1. View courses.\n2. Add new courses.\n3. Approve Student registration.\n4. Assign course to teacher.\n5. Quit");
                    roleChoice = scanner.nextInt();
                    validInput = true;

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine();
                }
            }
            switch (roleChoice) {
                case 1:
                    viewAllCourses();
                    break;
                case 2:
                    addNewCourse();
                    break;
                case 3:
                    approveStudentRegistration();
                    break;
                case 4:
                    assignCourseToTeacher();
                case 5:
                    isRunning = false;
                    return;


                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public ManagerType getType() {
        return type;
    }

    public void setType(ManagerType type) {
        this.type = type;
    }

    @Override public String toString() {
        return "Id: " + super.getUserId() +  ", Login: " + super.getLogin() + ", Username: " + super.getUsername()  + ", Age: " + super.getAge();
    }

    public void viewInfo() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while(isRunning) {
            int choice = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.println("1. View info about Students.\n2. View info about Teachers.\n3. Send message.\n4. Quit");
                    choice = scanner.nextInt();
                    validInput = true;

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine();
                }
            }
            switch (choice) {
                case 1:
                    viewAllStudents();
                    break;
                case 2:
                    viewAllTeachers();
                    break;
                case 3:
                    sendMessage();
                    break;
                case 4:
                    isRunning = false;
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public void reportNews(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the title of news: ");
        String titleOfNews = scanner.nextLine();

        System.out.println("Enter the content of news: ");
        String contentOfNews = scanner.nextLine();

        News news = new News();
        news.setTitle(titleOfNews);
        news.setContent(contentOfNews);
        news.setAuthor(this.getUsername());
        news.setPublicationDate(new Date());
        newsList.add(news); // save news

        for (User user: Database.userDatabase){
            user.newsList.add(news);
        }

        Admin.logAction(super.getUsername(), "Manager reported News ");
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

}
