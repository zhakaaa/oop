package Interface.example1;

public class Car implements IMoveable{
    @Override
    public void move() {
        System.out.println("The car can move");
    }
}

//public class Car extends BaseClass {
//    @Override
//    public void move() {
//        System.out.println("The car can move");
//    }
//}
