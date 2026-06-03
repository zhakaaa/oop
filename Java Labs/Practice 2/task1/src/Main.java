class Student {
    private int id;
    private String name;
    private int yearOfStudy;

    public Student(int id, String name, int yearOfStudy) {
        this.id = id;
        this.name= name;
        this.yearOfStudy = yearOfStudy;

    }

    public Student() {

    }

    public int getId() {return id;}
    public String getName() {return name;}
    public int getYearOfStudy() {return yearOfStudy;}

    public void setId(int id) {this.id = id;}
    public void setName(String name) {this.name = name;}
}

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Student student1 = new Student();
        student1.setName("alex");
        System.out.println(student1.getName());


    }
}