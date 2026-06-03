package Animals;

public class Dog  extends Animal{
    private String name;
    private int age;

    public Dog(String name, int age) {
        super(name, age);
        this.age = age;
        this.name = name;
    }

    @Override public void getSound(){
        System.out.println("woof-woof-woof");
    }
    @Override public String toString() {
        return "Animals.Cat: " + name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
