package Interface.example3;

public class Shark extends Animal implements IAquaticAnimals{
    @Override
    void eat() {
        System.out.println("Shark can eat");
    }

    @Override
    void sleep() {
        System.out.println("Shark can sleep");
    }

    @Override
    public void swim() {
        System.out.println("Shark can swim");
    }
}
