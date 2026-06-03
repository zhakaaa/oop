package Animals;

public class Bird extends Animal {
    private String name;
    private int age;

    public Bird(String name, int age) {
        super(name, age);

    }
    @Override public void getSound(){
        System.out.println("chirik-chirik-chirik");
    }
    @Override public String toString() {
        return "Animals.Bird: " + name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
