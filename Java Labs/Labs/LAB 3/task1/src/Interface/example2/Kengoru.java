package Interface.example2;

public class Kengoru extends Animal implements ILandAnimals{

    @Override
    void eat() {
        System.out.println("Kengoru can eat");
    }

    @Override
    void sleep() {
        System.out.println("Kengoru can sleep");
    }

    @Override
    public void walk() {
        System.out.println("Kengoru can walk");
    }
}

//public class Kengoru extends Animal{
//
//    @Override
//    void eat() {
//        System.out.println("Kengoru can eat");
//    }
//
//    @Override
//    void sleep() {
//        System.out.println("Kengoru can sleep");
//    }
//
//    @Override
//    void walk() {
//        System.out.println("Kengoru can walk");
//    }
//
//    @Override
//    public void fly() {
//        // заглушка абстрактных методов, так как он этому классу не нужны.
//    }
//
//    @Override
//    void jump() {
//        System.out.println("Kengoru can jump");
//    }
//
//    @Override
//    void swim() {
//        // заглушка абстрактных методов, так как он этому классу не нужны.
//    }
//}
