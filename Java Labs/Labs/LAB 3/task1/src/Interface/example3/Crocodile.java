package Interface.example3;

import Interface.example2.IAquaticAnimals;
import Interface.example2.ILandAnimals;

public class Crocodile extends Animal implements ILandAnimals, IAquaticAnimals {
    @Override
    public void swim() {
        System.out.println("Crocodile swimming");
    }

    @Override
    public void walk() {
        System.out.println("Crocodile walking");
    }

    @Override
    void eat() {
        System.out.println("crocodile eat");
    }

    @Override
    void sleep() {
        System.out.println("crocodile sleeping");
    }
}
