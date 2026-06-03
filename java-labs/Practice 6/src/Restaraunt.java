import java.util.Scanner;

public class Restaraunt extends Chef {
    double money = 0;
    boolean servePizza(CanHavePizza eater){

        double payment = 0;
        eater.eatPizza();

        if(eater instanceof Person) {
            System.out.println("1: Margarita (cheese, tomato) - 5000tg\n2: Pepperoni (pepperoni, cheese, tomato) - 7000tg");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            if (choice == 1) payment = 5000;
            else if (choice == 2) payment = 7000;
            else System.out.println("invalid choice");

            if(((Person) eater).money >= payment) {
                ((Person) eater).pay(payment);
                money += payment;
                if(choice == 1){
                    addCheese();
                    addTomato();
                    addSauce();
                }
                else if(choice == 2){
                    addPepperoni();
                    addCheese();
                    addTomato();
                    addTomato();

                }
            }
            else{
                System.out.println("Not enough money");
            }
            return true;
        }
        else{System.out.println("The cat cannot buy pizza, but we give him for free");}

        return false;
    }

}
