package Material;

import NotEmployees.Student;
import Employees.Teacher;
import Enums.LessonType;
import Enums.QuizNumber;

import java.util.*;

public class Lesson {
    private String topic;
    private LessonType type;
    private Teacher instructor;
    private Date schedule;
    private Map<Student, Integer> quizScores;


    public Lesson(String topic, LessonType type, Teacher instructor, Date schedule) {
        this.topic = topic;
        this.type = type;
        this.instructor = instructor;
        this.schedule = schedule;
    }

    public void assignQuizScore(Student student, int score) {
        if (score < 0 || score > 15) {
            throw new IllegalArgumentException("Quiz score must be between 0 and 15.");
        }
        quizScores.put(student, score);
        System.out.println("Assigned " + score + " points to " + student.getUsername());
    }


    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }

    public LessonType getType() {
        return type;
    }
    public void setType(LessonType type) {
        this.type = type;
    }

    public Teacher getInstructor() {
        return instructor;
    }
    public void setInstructor(Teacher instructor) {
        this.instructor = instructor;
    }

    public Date getSchedule() {
        return schedule;
    }
    public void setSchedule(Date schedule) {
        this.schedule = schedule;
    }

    public int getQuizScore(Student student) {
        return quizScores.getOrDefault(student, 0);
    }


    public String toString() {
        return "Material.Lesson{" +
                "topic='" + topic + '\'' +
                ", type=" + type +
                ", instructor=" + instructor.getUsername() +
                ", schedule=" + schedule +
                '}';
    }
}