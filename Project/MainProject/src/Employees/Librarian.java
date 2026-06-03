package Employees;
import Database.Database;
import Material.*;
import NotEmployees.Admin;
import NotEmployees.User;

import java.util.*;

public class Librarian extends Employee {
    private List<Book> issuedBooks = new ArrayList<>();

    public Librarian(String login, String username, String password, int age,int id) {
        super(login,username,password,age,id);
    }
    public Librarian(String username,int id){
        super(username,id);
    }

    public Librarian(){}

    private void addNewBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter title: ");
        String title = sc.nextLine();
        System.out.println("Enter author: ");
        String author = sc.nextLine();
        System.out.println("Enter quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());
        System.out.println("Enter book id: ");
        int id = Integer.parseInt(sc.nextLine());

        Book book = new Book(title,author,quantity,id);
        Database.allBooks.add(book);
        System.out.println("Book added: " + book);

        Admin.logAction(getUsername(), "Librarian added new Book ot Database ");
    }

    public void removeBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter book id: ");
        int bookID = sc.nextInt();
        Database.allBooks.removeIf(book -> book.getId() == bookID);
        System.out.println("Book with ID " + bookID + " removed.");

        Admin.logAction(getUsername(), "Librarian removed new Book ot Database ");
    }

    public void updateBook() {
        for(Book book : Database.allBooks) {
            System.out.println(book.toString());
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter book id: ");
        int bookID = sc.nextInt();
        for (Book book : Database.allBooks) {
            if (book.getId() == bookID) {
                int newQuantity = sc.nextInt();
                book.setQuantity(newQuantity);
                System.out.println("Book with ID " + bookID + " updated.");
                return;
            }
        }
        System.out.println("Book with ID " + bookID + " not found.");

        Admin.logAction(getUsername(), "Librarian updated Book");

    }

    public void issueBook(int bookID, int userID) {
        User userBorrowed = null;
        for (Book book : Database.allBooks) {
            if (book.getId() == bookID && book.getQuantity() > 0) {
                issuedBooks.add(book);
                book.setQuantity(book.getQuantity() - 1);
                System.out.println("Book with ID " + bookID + " issued to user " + userID);
                for (User user: Database.userDatabase){
                    if(user.getUserId() == userID){
                        userBorrowed = user;
                        break;
                    }
                }
                if (userBorrowed != null) {
                    userBorrowed.books.add(book);
                }
                book.setBorrowedBy(userBorrowed);
                book.setBorrowed(true);
                return;
            }
        }
        System.out.println("Book with ID " + bookID + " is not available for issuing.");

        Admin.logAction(getUsername(), "Librarian borrowed Book");

    }

    public void returnBook(int bookID) {
        User userBorrowed = null;
        if (issuedBooks.contains(issuedBooks.stream().filter(b -> b.getId() == bookID))) {
            issuedBooks.remove(bookID);
            for (Book book : Database.allBooks) {
                if (book.getId() == bookID) {
                    book.setQuantity(book.getQuantity() + 1);
                    System.out.println("Book with ID " + bookID + " returned.");

                    for (User user: Database.userDatabase){
                        if(user.getUserId() == book.getBorrowedBy().getUserId()){
                            userBorrowed = user;
                            break;
                        }
                    }
                    if (userBorrowed != null) {
                        userBorrowed.books.remove(book);
                    }
                    book.setBorrowedBy(null);
                    book.setBorrowed(false);
                    return;

                }
            }
        } else {
            System.out.println("Book with ID " + bookID + " was not issued.");
        }

        Admin.logAction(getUsername(), "Librarian returned Book to library");

    }

    @Override public String toString() {
        return "Id: " + super.getUserId() +  ", Login: " + super.getLogin() + ", Username: " + super.getUsername() + ", Age: " + super.getAge();
    }

    public void manageBooks() {
        Book book = new Book();
        Scanner scanner = new Scanner(System.in);
        while(true){
            int choice = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.println("1. View all books\n2. View issued books\n3. Add new book\n4. Remove book\n5. Update book\n6. Quit");
                    choice = scanner.nextInt();
                    validInput = true;

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine();
                }
            }

            if(choice == 1){
                book.viewBooks();
            }
            else if(choice == 2) {
                viewIssuedBooks();
            }
            else if(choice == 3) {
                addNewBook();
            }
            else if(choice == 4) {
                removeBook();
            }
            else if(choice == 5){
                updateBook();
            }
            else if(choice == 6){
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
        Admin.logAction(getUsername(), "Librarian sent message");
    }

    private void viewIssuedBooks() {
        issuedBooks.forEach(book -> System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Quantity: " + book.getQuantity()));

        Admin.logAction(getUsername(), "Librarian view all Books");

    }
}