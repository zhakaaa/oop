package Interface.example3;

import Interface.example2.ILandAnimals;

public class Elephant extends Animal implements ILandAnimals {

    @Override
    void eat() {
        System.out.println("Elephant can eat");
    }

    @Override
    void sleep() {
        System.out.println("Elephant can sleep");
    }

    @Override
    public void walk() {
        System.out.println("Elephant can jump");
    }

}
