//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Fish fish = new Fish("jonh",10);
        Dog dog = new Dog("jake",20);
        Bird bird = new Bird("alice",30);


        fish.swim();
        dog.walk();
        bird.fly();

    }
}