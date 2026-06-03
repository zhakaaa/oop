package Interface.example2;

public class Elephant extends Animal{

    @Override
    void eat() {
        System.out.println("Elephant can eat");
    }

    @Override
    void sleep() {
        System.out.println("Elephant can sleep");
    }

    @Override
    void walk(){
        System.out.println("Elephant can walk");
    }
}

//public class Elephant extends Animal{
//
//    @Override
//    void eat() {
//        System.out.println("Elephant can eat");
//    }
//
//    @Override
//    void sleep() {
//        System.out.println("Elephant can sleep");
//    }
//
//    @Override
//    void walk() {
//        System.out.println("Elephant can walk");
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
//        // заглушка абстрактных методов, так как они этому классу не нужны.
//    }
//}
