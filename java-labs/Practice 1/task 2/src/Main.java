import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();

        PrintMyName(name);
    }

    private static void PrintMyName(String name) {
        System.out.print("+");
        for(int i = 0; i < name.length(); i++) {
            System.out.print("-");
        }
        System.out.print("+");

        System.out.print("\n|" + name + "|\n+");
        for(int i = 0; i < name.length(); i++) {
            System.out.print("-");
        }
        System.out.print("+");
    }
}