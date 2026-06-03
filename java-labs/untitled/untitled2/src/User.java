import java.util.Scanner;

public class User {
    String login, password;
    public void run(){
        System.out.println("1: login/password\n2: catalog\n3: order");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        switch(choice) {
            case 1:
                enterLoginPassword();

            case 2:
                viewCatalog();

            case 3:
                orderItem();
        }
    }

    private void orderItem() {
    }

    private void viewCatalog() {

    }

    private void enterLoginPassword() {
        Scanner in = new Scanner(System.in);
        String login = in.nextLine();
        String password = in.nextLine();
    }
}
