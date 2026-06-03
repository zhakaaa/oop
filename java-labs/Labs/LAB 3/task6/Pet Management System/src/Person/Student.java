package Person;

public class Student extends Person {
    private String name;
    private int age;
    private int course;
    private String subject;

    public Student(String name, int age, String subject, int course) {
        super(name, age);
        this.name = name;
        this.age = age;
        this.subject = subject;
        this.course = course;
    }

    @Override public void getOccupation(){
        System.out.println(super.name + "'s status is: Person.Student" );
    }
    @Override public String toString(){
        return "Name: " + name + " Age: " + age + " Subject: " + subject + " Course: " + course;
    }

    @Override public boolean equals(Object object){
        if(this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Student student = (Student) object;
        return age == student.age && name.equals(student.name) && subject.equals(student.subject);
    }

    @Override public int hashCode(){
        int hash = 7;
        hash = 31 * hash + age;
        hash = 31 * hash + course;
        hash = 31 * hash + (name != null ? name.hashCode() : 0);
        hash = 31 * hash + (subject != null ? subject.hashCode() : 0);
        return hash;
    }

    @Override public int compareTo(Person person){
        return Integer.compare(age, person.age);
    }

}
