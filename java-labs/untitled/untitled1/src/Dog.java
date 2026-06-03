public class Dog extends Animal  implements CanWalk{
    Dog(String name, int age) {
        super(name, age);
    }

    Fish fish;

    @Override
    void makeSound() {
        System.out.println("Dog is barking");
    }

    @Override
    public void walk() {
        System.out.println("Dog can walk");
    }
}
