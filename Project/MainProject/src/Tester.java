import Database.Database;
import Employees.Manager;
import Employees.Teacher;
import Enums.Schools;
import NotEmployees.Admin;
import NotEmployees.Student;
import Material.Course;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Tester {
    public static void changeUserData(){

    }
    public static void courseRegistration(){
        // Test case for Course registration

        // Create course and prerequisites of this course.
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
        Database.courseBySchool.put(Schools.IT.name(), itCourses); // Add the courses to database

        Student zhaksylyk = new Student("z_torekhan@kbtu.kz","Zhaksylyk", "abcd1234", 18, 1);
        zhaksylyk.setSchool(Schools.IT);
        zhaksylyk.completedCourses.add(calculus); // Let imagine that Student completed some courses
        zhaksylyk.completedCourses.add(pp);

        zhaksylyk.registrateCourse();
    }

    public static void putMarks(){
        // Create users
        Teacher teacher = new Teacher("n_zhumadir@kbtu.kz", "Nadira Zhumadir", "1234bafa",20,123);
        Manager manager = new Manager("a_azat@kbtu.kz", "Azat Oralgazin", "45dsfdsa", 25,541);

        Student student1 = new Student("a_aruzhan@kbtu.kz", "Aruzhan Eraly", "123af++)cS",18,423);
        Student student2 = new Student("s_aslan@kbtu.kz", "Aslan Tukenov", "t351gas",18,424);
        Student student3 = new Student("t_omar@kbtu.kz", "Talgat Omar", "1g35asvS",18,425);

        Admin admin = new Admin("s_sakeadmin@kbtu.kz", "Saken Omarov","23rfac4",23,234);


        // Create courses
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
        Database.courseBySchool.put(Schools.IT.name(), itCourses); // Add the courses to database

        student1.setSchool(Schools.IT);
        student2.setSchool(Schools.IT);
        student3.setSchool(Schools.IT);

        student1.completedCourses.add(calculus); // Let imagine that Student completed some courses
        student1.completedCourses.add(pp);
        student1.registrateCourse();
        // Assign course to teacher
        manager.assignCourseToTeacher();
        teacher.putMarks();
        student1.viewMarks();



    }
    public static void main(String[] args) {

        // Course Registration case
//        courseRegistration();
        // Put Marks case
        putMarks();

    }


}
