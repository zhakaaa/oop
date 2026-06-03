import Database.Database;
import Employees.*;
import Enums.Schools;
import Material.Course;
import NotEmployees.Admin;
import NotEmployees.Student;
import NotEmployees.User;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Tester.main(args);
        Student student1 = new Student("z_torekhan@kbtu.kz", "Zhaksylyk", "a-z91f~ds", 18,5464, Schools.IT);
        student1.setSchool(Schools.IT);
        Student student2 = new Student("a_azat@kbtu.kz", "Arman", "goaf+1ssS", 18,1234,Schools.IT);
        Student student3 = new Student("a_ormanovich@kbtu.kz", "Aslan", "sdf+c2@Df", 18,4253,Schools.IT);
        Admin admin = new Admin("a_abdrahman@kbtu.kz", "Azat", "a-z91f~ds", 25,4531);
        Teacher teacher1 = new Teacher("a_azatovich@kbtu.kz", "Arman", "a-z91f~ds", 34, 4513);
        Manager manager1 = new Manager("s_talgatovich@kbtu.kz","Saken","cSDFSW4A",34,4765);
        Librarian librarian1 = new Librarian("r_abay@kbtu.kz","Roza","as4f2sd2",54,1223);

        Course oop = new Course("OOP", 1, 3);
        Course calculus = new Course("Calculus", 2, 4);
        Course pp = new Course("Principle of Programming", 3, 5);
        oop.prerequisites.add(calculus);
        oop.prerequisites.add(pp);

        Course ads  = new Course("Ads", 4, 5);
        Course statistics  = new Course("Statistics", 5, 3);
        Course linearAlgebra  = new Course("Linear Algebra", 6, 4);
        ads.prerequisites.add(statistics);
        ads.prerequisites.add(calculus);
        ads.prerequisites.add(linearAlgebra);
        List<Course> itCourses = new ArrayList<Course>();
        itCourses.add(oop);
        itCourses.add(ads);
        itCourses.add(calculus);
        itCourses.add(linearAlgebra);
        itCourses.add(pp);
        Database.courseBySchool.put(Schools.IT.name(), itCourses); // Add the courses to database
        student1.completedCourses.add(calculus); // Let imagine that Student completed some courses
        student1.completedCourses.add(pp);

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        int choice = 0;

        while(isRunning) {
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.println("Welcome to the system.\n1. Log in to the system\n2. Quit:");
                    choice = scanner.nextInt();
                    validInput = true;

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine();
                }
            }
            if(choice == 1) {
                System.out.print("Enter login: ");
                scanner.nextLine();
                String login = scanner.nextLine();

                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                if (authenticate(login, password)) {
                    for(User entry : Database.userDatabase){
                        if(entry.getLogin().equals(login)) {
                            if(entry instanceof Admin){
                                adminPanel();
                            }
                            else if(entry instanceof Employee){
                                employeePanel(login);
                            }
                            else if(entry instanceof Student){
                                studentPanel();
                            }
                        }
                    }
                }
                else {
                    System.out.println("Invalid data. Please try again.");
                }
            }
            else if(choice == 2) {
                isRunning = false;
            }
            else{
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }



    private static void employeePanel(String login) {
        for(User entry : Database.userDatabase){
            if(entry.getLogin().equals(login)){
                if(entry instanceof Manager){
                    managerPanel();
                }
                else if(entry instanceof Teacher){
                    teacherPanel();
                }
                else if(entry instanceof Librarian){
                    librarianPanel();
                }
            }
        }
    }

    private static void librarianPanel() {
        System.out.println("Hello, Dear Librarian");
        Scanner scanner = new Scanner(System.in);
        Librarian librarian = new Librarian();
        boolean isRunning = true;
        while(isRunning) {
            System.out.println("1. Manage books.\n2. Send message\n3. Open mail\n4. Quit");
            int roleChoice = Integer.parseInt(scanner.nextLine());
                switch (roleChoice) {
                    case 1:
                        librarian.manageBooks();
                        break;
                    case 2:
                        librarian.sendMessage();
                        break;
                    case 3:

                        librarian.openMail();
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

    private static void teacherPanel() {
        Teacher teacher = new Teacher();
        System.out.println("Hello, Dear Teacher");
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while(isRunning) {
            System.out.println("1. Manage courses\n2. Put marks\n3. View Students\n4. Send messages\n5. Send complaint to student\n6. Open mail\n7. Quit");
            int roleChoice = Integer.parseInt(scanner.nextLine());
            switch (roleChoice) {
                case 1:
                    teacher.manageCourse();
                    break;
                case 2:
                    teacher.putMarks();
                    break;
                case 3:
                    teacher.viewInfoStudents();
                    break;
                case 4:
                    teacher.sendMessage();
                    break;
                case 5:
                    teacher.sendComplaint();
                    break;
                case 6:
                    teacher.openMail();
                    break;
                case 7:
                    isRunning = false;
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void managerPanel() {
        System.out.println("Hello, Dear Manager");
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager();
        boolean isRunning = true;
        while(isRunning) {
            System.out.println("1. Manage Courses.\n2. Make report.\n3. Change date of Employee\n4. View info about\n5. Report news\n6. Open mail\n7. Quit");
            int roleChoice = Integer.parseInt(scanner.nextLine());
            switch (roleChoice) {
                case 1:
                    manager.manageCoursesPanel();
                    break;
                case 2:
                    manager.makeReport();
                    break;
                case 3:
                    manager.changeEmployeeData();
                    break;
                case 4:
                    manager.viewInfo();
                    break;
                case 5:
                    manager.reportNews();
                    break;
                case 6:
                    manager.openMail();
                    break;
                case 7:
                    isRunning = false;
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void adminPanel() {
        System.out.println("Hello, Dear Admin");
        Admin admin = new Admin();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while(isRunning) {
            System.out.println("1. Manage users.\n2. See logs.\n3. Send message\n4. Open mail\n5. Quit");
            int roleChoice = Integer.parseInt(scanner.nextLine());
            switch (roleChoice) {
                case 1:
                    admin.manageUsers();
                    break;
                case 2:
                    Admin.viewLogs();
                    break;
                case 3:
                    admin.sendMessage();
                    break;
                case 4:
                    admin.openMail();
                    break;
                case 5:
                    isRunning = false;
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

    }

    private static void studentPanel() {
        System.out.println("Hello, Dear Student");
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while(isRunning) {
            System.out.println("1. Manage courses.\n2. View marks.\n3. Manage books\n4. Send messages\n5. Open mail\n6. Quit");
            int roleChoice = Integer.parseInt(scanner.nextLine());
            switch (roleChoice) {
                case 1:
                    student.manageCourses();
                    break;
                case 2:
                    student.viewMarks();
                    break;
                case 3:
                    student.manageBooks();
                    break;
                case 4:
                    student.sendMessage();
                    break;
                case 5:
                    student.openMail();
                    break;
                case 6:
                    isRunning = false;
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static boolean authenticate(String login, String password) {
        return Database.userDatabase != null &&
                Database.userDatabase.stream()
                        .anyMatch(user -> user.getLogin().equals(login) && user.getPassword().equals(password));
    }
}