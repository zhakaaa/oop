package Interface.example2;

//public class Eagle extends Animal implements IAerialAnimals{
//    @Override
//    void eat() {
//        System.out.println("Eagle can eat");
//    }
//
//    @Override
//    void sleep() {
//        System.out.println("Eagle can sleep");
//    }
//
//    @Override
//    public void fly() {
//        System.out.println("Eagle can fly");
//    }
//}
//
 public class Eagle extends Animal{

    @Override
    void eat() {
        System.out.println("Eagle can eat");
    }

    @Override
    void sleep() {
        System.out.println("Eagle can sleep");
    }

    @Override
    public void fly() {
        System.out.println("eagle can fly");
    }

    @Override
    void jump() {
        // заглушка абстрактных методов, так как они этому классу не нужны.
    }

    @Override
    void swim() {
        // заглушка абстрактных методов, так как они этому классу не нужны.
    }

    @Override
    void walk() {
        System.out.println("eagle can walk");
    }
}
