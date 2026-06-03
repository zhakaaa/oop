import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter side length of square: ");

        int side = myObj.nextInt();

        int length = side * 4;
        int area = side * side;
        double diagonal = side * Math.sqrt(2);

        System.out.println("The area of the square is: " + area);
        System.out.println("The diagonal of the square is: " + diagonal);
        System.out.println("The perimeter of the square is: " + length);


    }
}
