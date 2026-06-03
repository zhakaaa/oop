package Database;

import Employees.*;
import Material.Book;
import Material.Course;
import NotEmployees.Student;
import NotEmployees.User;

import java.util.*;

public class Database{
    public static List<User> userDatabase = new ArrayList<>();

    public static List<Teacher> allTeachers = new ArrayList<>();
    public static List<Student> allStudents  = new ArrayList<>();
    public static List<Manager> allManagers = new ArrayList<>();
    public static List<Librarian> allLibrarians = new ArrayList<>();
    public static List<Employee> allEmployees =  new ArrayList<>();

    public static List<Book> allBooks = new ArrayList<>();
    public static List<Course> allCourses = new ArrayList<>();
//    public static List<Course> allNotAssignedCourses = allCourses;
    public static HashMap<String, List<Course>> courseBySchool = new HashMap<>();


    public static Comparator<User> byUserId() {
        return (u1, u2) -> Integer.compare(u1.getUserId(), u2.getUserId());
    }
    public static Comparator<User> byUsername() {
        return (u1, u2) -> u1.getUsername().compareTo(u2.getUsername());
    }
    public static Comparator<Course> byCourseId() {
        return (u1, u2) -> Integer.compare(u1.getCourseId(), u2.getCourseId());
    }
}
