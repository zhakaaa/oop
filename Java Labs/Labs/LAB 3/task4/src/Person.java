public class Person {
    String name;

    public String toString(){
        return "Name: " + name;
    }

    public boolean equals(Object person){
        if(this == person) return true;
        if(person == null || getClass() != person.getClass()) return false;
        Person p = (Person)person;
        return this.name.equals(p.name);
    }
}
