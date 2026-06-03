package Person;

public class Employee extends Person {
    private String name;
    private int age;
    private String profession;
    public boolean flag = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Employee(String name, int age, String profession) {
        super(name, age);
        this.name=name;
        this.age=age;
        this.profession = profession;
    }

    @Override public void getOccupation(){
        System.out.println(super.name + "'s the status is: Person.Employee" );
    }
    @Override public String toString(){
        return "Name: " + name + " Age: " + age + " Profession: " + profession;
    }

    @Override public boolean equals(Object object){
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        Employee employee = (Employee) object;
        return age == employee.age && name.equals(employee.name) && profession.equals(employee.profession);
    }

    @Override public int hashCode(){
        int hash = 7;
        hash = 31 * hash +  age;
        hash = 31 * hash + (name != null ? name.hashCode() : 0);
        hash = 31 * hash + (profession != null ? profession.hashCode() : 0);
        return hash;
    }


    @Override
    public int compareTo(Person employee) {
        return Integer.compare(this.getAge(), employee.age);
    }
}
