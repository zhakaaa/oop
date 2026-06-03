package Animals;

public abstract class Animal {
    public String name;
    public int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void getSound();
    public abstract String toString();
}
