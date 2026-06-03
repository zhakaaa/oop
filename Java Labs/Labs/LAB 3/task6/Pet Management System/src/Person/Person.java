package Person;
import Animals.Animal;
import Animals.Dog;

public abstract class Person implements Comparable<Person>  {
    public String name;
    public int age;
    Animal pet;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void assignPet(Animal pet){
        if(this instanceof PhDStudent && pet instanceof Dog){
                System.out.println(this.name + " is PhD student.He cannot own a Animals.Dog");
        }
        else{
            this.pet = pet;
        }
    };

    public void removePet(){
        pet = null;
    };

    public void hasPet(){
        if(pet != null) System.out.println(this.name + " has " + pet.getClass().getSimpleName() + " " + pet.name);
        else System.out.println(this.name + " has not any pet ");
    };

    public abstract void getOccupation();

    public abstract String toString();
    public abstract boolean equals(Object obj);
    public abstract int hashCode();

    public  void leavePetWith(Person person){
        if(this.pet instanceof Dog && person instanceof PhDStudent){
            System.out.println("You cannot leave a dog to PhD student");
        }

        else if(this.pet != null) {
            person.pet = this.pet;
            this.pet = null;
        }
        else{
            System.out.println(this.name + " don`t have a pet. Please, assign pet.");
        }
    };

    public void retrievePetFrom(Person person){
        if(person.pet != null){
            this.pet = person.pet;
            person.pet = null;
        }
        else{System.out.println(person.name +  " don`t have a pet.");}
    };


    @Override public int compareTo(Person o) {
        return Integer.compare(this.age, o.age);
    }

}
