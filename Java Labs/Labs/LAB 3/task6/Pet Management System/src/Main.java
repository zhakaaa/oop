import Animals.Animal;
import Animals.Cat;
import Animals.Dog;
import Person.Person;
import Person.Employee;
import Person.PersonRegistry;
import Person.PhDStudent;
import Person.Student;

public class Main {
    public static void main(String[] args) {

        Person john = new Employee("John", 30, "Engineer");
        Person alice = new PhDStudent("Alice", 26, "Comp. Science", "AI");
        Person mark = new Student("Mark", 26, "Comp. Science",3);
        Person jack = new PhDStudent("Jack", 26, "Comp. Science","AI");

        Animal murka = new Cat("Murka", 5);
        Animal aktos = new Dog("Aktos", 5);

        john.assignPet(murka); // John owns Rex
        jack.assignPet(aktos);

        PersonRegistry registry = new PersonRegistry();
        registry.addPerson(john);
        registry.addPerson(alice);
        registry.addPerson(mark);
        registry.addPerson(jack);

        john.leavePetWith(alice);
        System.out.println(registry.registry());

        john.retrievePetFrom(alice);
        System.out.println(registry.registry());

        System.out.println("\nAll information in regitsry: ");
        registry.showAllPeople();
    }
}