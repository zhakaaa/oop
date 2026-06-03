package Interface.example3;

import Interface.example2.ILandAnimals;

public class Eagle extends Animal implements IAerialAnimals, ILandAnimals {
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
        System.out.println("Eagle can fly");
    }

    @Override
    public void walk() {
        System.out.println("Eagle can walk");
    }
}
