package Employees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import Database.Database;
import Material.*;
import NotEmployees.Admin;
import NotEmployees.User;

public abstract class Employee extends User {
//    private double salary;

//    protected List<Message> messages = new ArrayList<>();;

    public Employee(){};

    public Employee(String login, String username, String password, int age, int id) {
        super(login,username,password,age,id);
    }
    public Employee(String username, int id){
        super(username,id);
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
            }
            else if(choice == 2) {
                for(Book book : books){
                    System.out.println(book.toString());
                }

                Scanner sc = new Scanner(System.in);
                System.out.println("Enter book's id: ");
                int id = sc.nextInt();
                librarian.returnBook(id);
            }
            else if(choice == 3) {
                break;
            }
            else System.out.println("Invalid input. Please try again.");
        }
    }

//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }


//    public String getUsername(){
//        return firstName + " " + surname;
//    }
}
