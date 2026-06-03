public class Fish extends  Animal  implements CanSwim{
    Fish(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println("Fish is silent.");
    }

    @Override
    public void swim() {
        System.out.println("Fish can swim");
    }
}
