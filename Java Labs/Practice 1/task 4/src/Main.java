import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner sc = new Scanner(System.in);
        int a  = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        try{
            double D = Math.sqrt(b*b - 4*a*c );
            double solution1 = (-b + D) / (2 * a);
            double solution2 = (-b - D) / (2 * a);

            System.out.println(solution1);
            System.out.println(solution2);
        }
        catch(ArithmeticException e){
            System.out.println("An exception happened!");
        }
    }
}