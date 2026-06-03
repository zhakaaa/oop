import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        List<Person> people = new ArrayList<Person>();
//        people.add(new Student("Azat" ,15,7000));
//        people.add(new Student("Maks" ,20,0));
//        people.add(new Student("Kairat" ,10,5000));
//
//        Collections.sort(people);
//
//        for (Person person : people) {
//            System.out.println(person.toString());
//        }

        CanHavePizza cat1 = new Cat("Bob",11);
        Animal cat2 = new Cat("Jack", 10);
        Cat cat3 = new Cat("Moris",5);
        Student zhaka = new Student("Zhaka", 18, 5000);
        Restaraunt delpapa = new Restaraunt();

        cat1.eatPizza();
        cat2.eatPizza();
        cat3.eatPizza();
        zhaka.eatPizza();

        while(true){
            System.out.println("Do you take retake for OOP?\n1:Yes\n2:No");
            Scanner scanner = new Scanner(System.in);
            int choice1 = scanner.nextInt();

            if(choice1 == 1){
                zhaka.takeRetake();
                System.out.println("You are loser!!!");
                break;
            }

            else if(choice1 == 2){
                System.out.println("Ooh, Let's dance and go eat pizza!!!");
                zhaka.dance();
                zhaka.move();
                System.out.println("Welcome to our pizzaria! What you want?\n1:Serve Pizza\n2:Goodbye");
                Scanner input = new Scanner(System.in);
                int choice = input.nextInt();

                if(choice == 1) delpapa.servePizza(zhaka);
                else if (choice == 2) break;
                else System.out.println("Invalid input");
            }
        }
    }
}
