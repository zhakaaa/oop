//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Airplane airplane = new Airplane();
        airplane.fly();

        Ship ship = new Ship();
        ship.swim();

        Car car = new Car();
        car.drive();
    }
}