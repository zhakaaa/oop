public class Employee extends Person {
    private String name;
    private int age;
    private String profession;
    public boolean flag = false;

    public Employee(String name, int age, String profession) {
        super(name, age);
//        this.name=name;
//        this.age=age;
        this.profession = profession;
    }

    @Override public void getOccupation(){
        System.out.println(super.name + "'s the status is: Employee" );
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

}
