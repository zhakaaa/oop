public abstract class Person implements CanHavePizza, Comparable<Person> {
    String name;
    int age;
    double money;

    public Person(String name, int age, double money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

    protected abstract void pay(double payment);

    @Override public int compareTo(Person other) {
        return Integer.compare(this.age, other.age); // Compare by age
    }

    @Override public String toString() {
        return "Name: " + name + ", Age: " + age + ", Money: " + money;
    }
}
