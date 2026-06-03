import java.util.Scanner;

enum Menu {
    Latte(700),
    Cappuchino  (800),
    Ice_Latte(900),
    Mocco(1000),
    Americano(700);

    int price;

    Menu(int price) {
        this.price = price;
    }

}

class Coffee{
    public static final String password = "123abc";
    public static final String account = "admin";

    private String order;
    private int amount;

    public Coffee(String order, int amount) {
        this.order = order;
        this.amount = amount;
    };

    public void orderCoffee(Menu menu) {

        System.out.println("Price: " + amount * menu.price + "tg");
    }

    public void orderCoffee() {
        System.out.println("Coffee: " + order);
    }

}
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the account name: ");
        String account = scan.nextLine();

        System.out.print("Enter the password: ");
        String password = scan.nextLine();

        if(account.equals(Coffee.account) && password.equals(Coffee.password)) {
            System.out.println("You are our client and you can successfully order Coffee.");
            while (true) {

                System.out.println("1: Exit\n2: Order coffee\n");
                System.out.print("Enter your choice: ");

                int answer = scan.nextInt();

                if (answer == 1) {
                    System.out.println("Thank you! Goodbye!");
                    break;
                }
                else if (answer == 2) {
                    System.out.println("Menu: ");
                    for (Menu menu : Menu.values()) {
                        System.out.println(menu);
                    }

                    System.out.println("Choose coffee: ");
                    String order = scan.next();

                    System.out.println("Amount: ");
                    int amount = scan.nextInt();

                    Coffee coffee = new Coffee(order,amount);
                    boolean flag = false;
                    for (Menu menu : Menu.values()) {
                        if (order.equals(menu.toString())) {
                            coffee.orderCoffee();
                            coffee.orderCoffee(menu);
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println("Coffee order failed");
                    }
                }
            }
        }
        else{
            System.out.println("You are not our client and you cannot order Coffee");
        }

        // static field (статическое поле) - поле объекта, НЕ экземпляра. Это значит, что все экземпляры
        // данного объекта могут получить доступ этому поле. Это экономит память так как, не создается экземпляр на куче.

        // final field (поле только для чтения) - поле которое инициализируется только при создании. Это значит, в дальнейшим невозможно
        // изменить значение поле.

        // methods overloading (перегрузка метода) - повторное использование одноименного метода. Отличается лишь количеством и типом аргументов.
    }
}