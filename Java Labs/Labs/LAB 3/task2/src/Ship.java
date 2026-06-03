public class Ship implements ISeaMoveable{
    @Override
    public void swim() {
        System.out.println("War Ship can swim on water");
    }

    @Override
    public void move() {
        System.out.println("War Ship can move");
    }
}
