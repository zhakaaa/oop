public class Cat extends Animal implements CanHavePizza, Movable{
    public Cat(String name, int age) {
        super(name, age);
    }
    @Override
    public void eatPizza() {
        System.out.println("The Cat can eat pizza!!!");
    }

    @Override public void move(){
        System.out.println("The cat can move");
    }

}
