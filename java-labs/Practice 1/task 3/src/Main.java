import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        if(number <= 100 && number >= 95){
            System.out.println("A");
        } else if(number < 95 && number >= 90){
            System.out.println("A-");
        } else if(number < 90 && number >= 85){
            System.out.println("B+");
        } else if(number < 85 && number >= 80){
            System.out.println("B");
        } else if(number < 80 && number >= 75){
            System.out.println("B-");
        }else if(number < 75 && number >= 70){
            System.out.println("C+");
        }else if(number < 70 && number >= 65){
            System.out.println("C");
        }
        else if(number < 65 && number >= 60){
            System.out.println("C-");
        }
        else if(number < 60 && number >= 55){
            System.out.println("D+");
        }
        else if(number < 55 && number >= 50){
            System.out.println("D");
        }
        else{
            System.out.println("Invalid");
        }

    }
}