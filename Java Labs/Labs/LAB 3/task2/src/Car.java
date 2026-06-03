public class Car implements ILandMoveable {

    @Override
    public void drive() {
        System.out.println("BMW drive on land");
    }

    @Override
    public void move() {
        System.out.println("BMW can move");
    }
}
