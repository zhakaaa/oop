public class Bird extends Animal implements CanFly {
    Bird(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println("Bird is chirping");
    }

    @Override
    public void fly() {
        System.out.println("Bird can fly");
    }
}
