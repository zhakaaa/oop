package Material;

import Database.Database;
import Employees.Teacher;
import NotEmployees.Admin;
import NotEmployees.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Course {
    private String courseName;
    private int credits;
    private Enums.Schools school;
    public List<Course> prerequisites = new ArrayList<>();

    private List<Lesson> lessons = new ArrayList<>();
    public List<Teacher> teachers = new ArrayList<>();
    public  List<Student> students = new ArrayList<>();
    private int courdeId;

    public Course() {};
    public Course(String courseName, int courseId, int credits) {
        this.courseName = courseName;
        this.courdeId = courseId;
        this.credits = credits;
        Admin.initializeCourseDatabase(this);

    }

    public boolean addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            return true;
        }
        return false;
    }

    public boolean addTeacher(Teacher teacher) {
        if (!teachers.contains(teacher)) {
            teachers.add(teacher);
            return true;
        }
        return false;
    }

    public List<String> getStudentsNames(){
        return students.stream().map(Student::getUsername).collect(Collectors.toList());
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getCourseId() {
        return courdeId;
    }

    public void setCourdeId(int courdeId) {
        this.courdeId = courdeId;
    }

    public String getSchool() {
        return school.toString();
    }

    public void setSchool(Enums.Schools school) {
        this.school = school;
    }

    @Override public String toString() {
        return "Course Id: " + courdeId +  ", Course Name: " + courseName + ", Credits: " + credits;
    }

}