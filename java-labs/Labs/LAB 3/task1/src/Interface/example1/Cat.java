package Interface.example1;

public class Cat implements IMoveable{
    @Override
    public void move() {
        System.out.println("The cat can move");
    }
}

//public class Cat extends BaseClass {
//    @Override
//    public void move() {
//        System.out.println("The cat can move");
//    }
//}
