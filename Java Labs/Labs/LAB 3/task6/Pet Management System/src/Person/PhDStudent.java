package Person;

public class PhDStudent extends Person {
    private String name;
    private int age;
    private String subject;
    private String profession;

    public PhDStudent(String name, int age,String subject, String profession) {
        super(name, age);
        this.name=name;
        this.age=age;
        this.profession = profession;
    }

    @Override public void getOccupation(){
        System.out.println(super.name + "'s status is: PhD Person.Student" );
    }
    @Override public String toString(){
        return "Name: " + name + " Age: " + age + " Profession: " + profession;
    }

    @Override public boolean equals(Object object){
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        PhDStudent that = (PhDStudent) object;
        return age == that.age && name.equals(that.name) && profession.equals(that.profession) && subject.equals(that.subject);

    }

    @Override public int hashCode(){
        int hash = 7;
        hash = 31 * hash +  age;
        hash = 31 * hash + (name != null ? name.hashCode() : 0);
        hash = 31 * hash + (profession != null ? profession.hashCode() : 0);
        hash = 31 * hash + (subject != null ? subject.hashCode() : 0);
        return hash;
    }

    @Override
    public int compareTo(Person phdStudent) {
        return Integer.compare(age, phdStudent.age);
    }
}
