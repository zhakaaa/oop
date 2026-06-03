import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Vector<Shape> shapes = new Vector<Shape>();

        while (true){
            System.out.println("1:Exit\n2:Choose shape and color\n3:Show shapes\n");
            Scanner in = new Scanner(System.in);
            int input = in.nextInt();
            if (input == 1) {
                break;
            }
            else if(input == 2) {
                String color = "red";

                System.out.println("1:Red\n2:Blue\n3:Yellow\n4:Green");
                Scanner in3 = new Scanner(System.in);
                int input3 = in3.nextInt();
                if(input3 == 1) color = "red";
                else if(input3 == 2) color = "blue";
                else if(input3 == 3) color = "yellow";
                else if(input3 == 4) color = "green";

                System.out.println("1:Circle\n2:Rectangle\n3:Triangle");
                Scanner in2 = new Scanner(System.in);
                int input2 = in2.nextInt();
                if (input2 == 1) {
                    Shape circle = new Circle(color);
                    shapes.add(circle);
                }
                else if (input2 == 2) {
                    Shape rect = new Rectangle(color);
                    shapes.add(rect);
                }
                else if (input2 == 3) {
                    Shape triangle = new Triangle(color);
                    shapes.add(triangle);
                }
                else{
                    System.out.println("Invalid choice");
                }
            }

            else if(input == 3) {
                    for (Shape s : shapes) {
                        s.draw();
                    }
            }
        }
    }
}