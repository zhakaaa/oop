package Interface.example1;

public class Moon implements IMoveable{
    @Override
    public void move() {
        System.out.println("The moon can move");
    }
}

//public class Moon extends BaseClass {
//    @Override
//    public void move() {
//        System.out.println("The moon can move");
//    }
//}
