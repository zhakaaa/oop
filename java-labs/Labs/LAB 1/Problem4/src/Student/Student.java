package Student;

public class Student {
    private int id;
    private char name;
    private int yearOfStudy;

    public Student(int id, char name, int yearOfStudy) {
        this.id = id;
        this.name= name;
        this.yearOfStudy = yearOfStudy;
    }

    public int getId() {return id;}
    public char getName() {return name;}
    public int getYearOfStudy() {return yearOfStudy;}

}
