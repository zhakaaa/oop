package NotEmployees;


import Database.Database;
import Material.Book;
import Material.Message;
import Material.News;

import java.util.*;
import java.util.regex.Pattern;

public abstract class User implements Comparable<User> {
    private String login;
    private String username;
    private String password;
    private int age;
    private int userId;


    public List<Book> books;
    public List<Message> messagesSend = new ArrayList<>();
    public List<Message> messagesReceived = new ArrayList<>();
    public List<News> newsList = new ArrayList<>();

    public User(String login, String username, String password, int age, int userId) {
        this.login = login;
        this.password = password;
        this.username = username;
        this.age = age;
        this.userId = userId;
        Admin.initializeDatabase(this);
    }

    public User(String username, int id){
        this.username = username;
        this.userId = id;
        Admin.initializeDatabase(this);
    }

    public User(){};


    public void changePassword(String newPassword) {
        if(newPassword == null || newPassword.isEmpty()){
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        if(!newPassword.equals(this.password)){
            throw new IllegalArgumentException("New password cannot be the same as the current password.");
        }

        boolean isMatch = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")
                .matcher(newPassword)
                .find();

        if (newPassword.length() < 8 || isMatch) {
            throw new IllegalArgumentException("Password must be at least 8 characters long, contain letters, and include at least one special symbol.");
        }

        this.password = newPassword;
        System.out.println("Password changed successfully");
    }


    public void setLogin(String login) {
        if(login == null || login.isEmpty()){
            throw new IllegalArgumentException("Login cannot be null or empty");
        }
        if(isValidLogin(login)){
            this.login = login;
        }
        else{
            throw new IllegalArgumentException("Invalid login");
        }
    }

    private boolean isValidLogin(String login) {

        return login.contains("@") && login.endsWith("kbtu.kz");
    }

    public void setPassword(String password) {
        if(password == null || password.isEmpty()){
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        boolean isMatch = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")
                .matcher(password)
                .find();

        if (password.length() < 8 || isMatch) {
            throw new IllegalArgumentException("Password must be at least 8 characters long, contain letters, and include at least one special symbol.");
        }

        this.password = password;
        System.out.println("Password changed successfully");

    }

    protected void receiveMessage(Message message, User user) {
        messagesReceived.add(message);}

    public void sendMessage() {
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

    private void viewMessagesSend() {
        for (Message message : messagesSend) {
            System.out.println("The message send to: " + message.getSender().getUsername() + "\nThe content of message: " + message.getContent());
        }
    }

    private void viewMessagesReceived() {
        for (Message message : messagesReceived) {
            System.out.println("The message came from: " + message.getReceiver().getUsername() + "\nThe content of message: " + message.getContent());
        }
    }

    public void viewNews(){
        for(News news: newsList){
            System.out.println(news.toString());
        }
    }

    public void openMail(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            int choice = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.println("1. View received messages\n2. View sended messages\n3. View news\n4. Exit ");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    validInput = true;

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine();
                }
            }

            if(choice == 1){
                viewMessagesReceived();
            }
            else if(choice == 2){
                viewMessagesSend();
            }
            else if(choice == 3){
                viewNews();
            }
            else if(choice == 4){
                System.out.println("Quit");
                break;
            }
            else{
                System.out.println("Invalid choice. Try again.");
            }
        }

        Admin.logAction(getUsername(), "User open mail");
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override public String toString() {
        return "Id: " + userId +  ", Login: " + login + ", Username: " + username + ", Age: " + age;
    }

    @Override
    public int compareTo(User o) {
        return Integer.compare(this.userId, o.getUserId());
    }
}
