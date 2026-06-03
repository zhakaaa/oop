public class Airplane implements IAirMoveable {

    @Override
    public void fly() {
        System.out.println("Airplane can fly very high");
    }

    @Override
    public void move() {
        System.out.println("Airplane can move");
    }
}
