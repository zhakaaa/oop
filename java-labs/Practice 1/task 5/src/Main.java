import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial balance: ");
        double initialBalance = sc.nextInt();

        System.out.print("Enter percent: ");
        int percent = sc.nextInt();

        System.out.print("Enter period (in years): ");
        int periodYear = sc.nextInt();


        for (int i = 0; i < periodYear; i++){
            initialBalance += ((initialBalance * percent / 100));
        }

        System.out.println(String.format("Your new balance is %.2ftg",initialBalance));


    }
}