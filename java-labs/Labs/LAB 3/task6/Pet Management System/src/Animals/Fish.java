package Animals;

public class Fish extends Animal {
    private String name;
    private int age;

    public Fish(String name, int age) {
        super(name, age);
        this.age = age;
        this.name = name;
    }

    @Override public void getSound(){
        System.out.println("bulk-bulk-bulk");
    }

    @Override
    public String toString() {
        return "Animals.Fish: " + name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
