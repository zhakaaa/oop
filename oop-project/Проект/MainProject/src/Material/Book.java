package Material;
import Database.Database;
import NotEmployees.User;

import java.util.*;

public class Book {
    private String title;
    private String author;

    // new changes
    private int quantity;
    private int id;

    private boolean isBorrowed;
    private User borrowedBy;
    private Date dueDate;

    public Book(String title, String author, int id, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.id = id;

        this.isBorrowed = false;
        this.borrowedBy = null;
        this.dueDate = null;
    }

    public Book(){};

    public boolean isAvailable() {
        return !isBorrowed;
    }

    public long checkOverdue() {
        if (isBorrowed && dueDate != null) {
            Date currentDate = new Date();
            if (currentDate.after(dueDate)) {
                long overdueMillis = currentDate.getTime() - dueDate.getTime();
                long overdueDays = overdueMillis / (1000 * 60 * 60 * 24);
                System.out.println("Material.Book '" + title + "' is overdue by " + overdueDays + " days.");
                return overdueDays;
            }
        }
        System.out.println("Material.Book '" + title + "' is not overdue.");
        return 0;
    }

    public double calculateFine() {
        long overdueDays = checkOverdue();
        if (overdueDays > 0) {
            double fine = overdueDays * 0.2;
            System.out.println("Fine for'" + title + "': $" + fine);
            return fine;
        }
        return 0.0;
    }

    public void viewBooks() {
        for (Book book : Database.allBooks) {
            System.out.println(book.toString());
        }
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public User getBorrowedBy() {
        return borrowedBy;
    }
    public void setBorrowedBy(User borrowedBy) {this.borrowedBy = borrowedBy;}

    public Date getDuedate() {
        return dueDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



    public String toString() {
        return "Title: " + title + ", author: " + author + ", quantity: " + quantity +
                ", isBorrowed: " + (borrowedBy != null ? ", borrowedBy=" + borrowedBy.getUsername() : "None") +
                ", dueDate: " + (dueDate!=null ? dueDate : "None");
    }
}