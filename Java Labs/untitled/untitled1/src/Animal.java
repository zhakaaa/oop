public abstract class Animal {
    String name;
    int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    abstract void makeSound();
    void sleep(){
        System.out.println(name + " is sleeping");
    }
}
