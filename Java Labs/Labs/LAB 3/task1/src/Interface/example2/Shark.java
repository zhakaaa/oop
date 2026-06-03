package Interface.example2;

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


//public class Shark extends Animal{
//
//    @Override
//    void eat() {
//        System.out.println("Shark can eat");
//    }
//
//    @Override
//    void sleep() {
//        System.out.println("Shark can sleep");
//    }
//
//    @Override
//    void walk() {
//        // заглушка абстрактных методов, так как они этому классу не нужны.
//    }
//
//    @Override
//    public void fly() {
//        // заглушка абстрактных методов, так как они этому классу не нужны.
//    }
//
//    @Override
//    void jump() {
//        // заглушка абстрактных методов, так как они этому классу не нужны.
//    }
//
//    @Override
//    void swim() {
//        System.out.println("Shark can swim");
//    }
//}
