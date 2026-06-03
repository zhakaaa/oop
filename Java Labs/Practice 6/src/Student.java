public class Student extends Person  implements CanHavePizza, CanHaveRetake, CanHaveParty{
    public Student(String firstName, int age, double money) {
        super(firstName, age, money);
    }

    @Override
    public void dance() {
        System.out.println("Student is dancing");
    }

    @Override
    public void eatPizza() {
        System.out.println("Student can eat pizza");
    }

    @Override
    public void takeRetake() {
        System.out.println("Student took retake");
    }

    @Override
    public void move() {
        System.out.println("Student can move");
    }

    @Override protected void pay(double payment){
        if(payment <= money){
            money-=payment;
            System.out.println(this.name + " paid for pizza");
        }
    }

    @Override public String toString() {
        return "Name: " + name + ", Age: " + age + ", Money: " + money;
    }
}
