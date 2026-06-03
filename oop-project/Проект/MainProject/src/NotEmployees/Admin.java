package NotEmployees;

import Database.Database;
import Employees.*;
import Material.Book;
import Material.Course;
import Material.Message;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Admin extends User {
    private static List<String> logs = new ArrayList<>();

    public Admin(){};

    public Admin(String login, String username, String password, int age,int id) {
        super(login,username,password,age,id);
    }
    public Admin(String username,int id){
        super(username,id);
    }

    public static void initializeDatabase(User user) {
        Database.userDatabase.add(user);
        if(user instanceof Teacher){
            Database.allTeachers.add((Teacher)user);
            Database.allEmployees.add((Employee)user);
        }
        if(user instanceof Student){
            Database.allStudents.add((Student)user);
        }
        if(user instanceof Employee){
            Database.allEmployees.add((Employee)user);
        }
        if(user instanceof Manager){
            Database.allManagers.add((Manager)user);
            Database.allEmployees.add((Employee)user);
        }
        if(user instanceof  Librarian){
            Database.allLibrarians.add((Librarian)user);
            Database.allEmployees.add((Employee)user);
        }

    }

    public static void viewAllUsers(){
        Database.userDatabase.sort(Database.byUserId());
        for(User user : Database.userDatabase){
            System.out.println(toString(user));
        }
    }

    public static void viewAllCourses(){
        Database.allCourses.sort(Database.byCourseId());
        for(Course course : Database.allCourses){
            System.out.println(course.toString());
        }
    }

    public static void viewAllBooks(){
        for(Book book : Database.allBooks){
            System.out.println(book.toString());
        }

    }

    public static void initializeCourseDatabase(Course course) {
        Database.allCourses.add(course);
    }

    private static void addUser(User user) {
        Database.userDatabase.add(user);
    }

    private void removeUser(int userID) {
        Database.userDatabase.removeIf(user -> user.getUserId() == userID);
        System.out.println("NotEmployees.User with ID " + userID + " removed.");
    }

    private void updateUser(int userID) {
        User user = Database.userDatabase.stream()
                .filter(user1 -> user1.getUserId() == userID)
                .findFirst()
                .orElse(null);

        Scanner scanner = new Scanner(System.in);
        while(true){
            int choice2 = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.println("Change:\n1. Login\n2. Password\n3. Quit");
                    choice2 = scanner.nextInt();
                    validInput = true;

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine();
                }
            }

            if(choice2 == 1){
                System.out.println("New login: ");
                String newLogin = scanner.nextLine();
                if (user != null) {
                    user.setLogin(newLogin);
                }
                for(User item : Database.userDatabase){
                    if(item.getUserId() == userID){
                        item.setLogin(newLogin);
                        break;
                    }
                }
            }
            else if(choice2 == 2){
                System.out.println("New password: ");
                String newPassword = scanner.nextLine();
                if (user != null) {
                    user.setPassword(newPassword);
                }
                for(User item : Database.userDatabase){
                    if(item.getUserId() == userID){
                        item.setLogin(newPassword);
                        break;
                    }
                }
            }
            else if(choice2 == 3){
                break;
            }
            else{
                System.out.println("Invalid choice. Try again.");
            }
        }

    }

    public void manageUsers() {
        Scanner scanner = new Scanner(System.in);

        while(true){
            int choice = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.println("1. View users\n2. Remove user\n3. Update user\n4. Quit");
                    choice = scanner.nextInt();
                    validInput = true;

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine();
                }
            }

            if(choice == 1){
                viewUsers();
            }

            else if(choice == 2){
                System.out.println("Which user will be removed?\nEnter the user's id:");
                int id = scanner.nextInt();
                removeUser(id);
                System.out.println("The user has been removed.");
            }
            else if(choice == 3) {
                System.out.println("Which user will be removed?\nEnter the user's id:");
                int id = scanner.nextInt();
                updateUser(id);

            }
            else if(choice == 4){
                break;
            }
            else{
                System.out.println("Invalid input. Please, try again");
            }
        }
    }

    private void viewUsers(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            int choice = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.println("1. View users\n2. View Managers\n3. View Teachers\n4. View Students\n5. View Librarians\n6. Quit");
                    choice = scanner.nextInt();
                    validInput = true;

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine();
                }
            }

            if(choice == 1){
                viewAllUsers();
            }
            else if(choice == 2){
                Database.userDatabase.sort(Database.byUserId());
                for(Manager manager : Database.allManagers){
                    System.out.println(toString(manager));
                }
            }
            else if(choice == 3){
                Database.userDatabase.sort(Database.byUserId());
                for(Teacher teacher : Database.allTeachers){
                    System.out.println(toString(teacher));
                }
            }
            else if(choice == 4){
                Database.userDatabase.sort(Database.byUsername());
                for(Student student : Database.allStudents){
                    System.out.println(toString(student));
                }
            }
            else if(choice == 5){
                Database.userDatabase.sort(Database.byUserId());
                for(Librarian librarian : Database.allLibrarians){
                    System.out.println(toString(librarian));
                }
            }
            else if(choice == 6){
                break;
            }
            else System.out.println("Invalid choice. Try again.");
        }
    }

    public static void logAction(String username, String action) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = now.format(formatter);

        String logMessage = date + " ,Username: " + username + " Action: " + action;
        Admin.logs.add(logMessage);
    }

    public static void viewLogs(){
        for (String item : Admin.logs) {
            System.out.println(item);
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

    private static String toString(User user) {
        return "Id: " + user.getUserId() +  ", Login: " + user.getLogin() + ", Password: " + user.getPassword() +  ", Username: " + user.getUsername()  + ", Age: " + user.getAge();
    }
}