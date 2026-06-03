import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Board board = new Board();
//
//
//        while(true){
//            Scanner input2 = new Scanner(System.in);
//            System.out.print("1: Start/Continue \n2: Exit");
//            int choice2 = input2.nextInt();
//
//            if(choice2 == 1){
//                while(true){
//                    int a = 0;
//                    if(a % 2 == 0) {                     // White move
//                        Scanner input = new Scanner(System.in);
//                        System.out.print("You white\n1: Move piece\n 2: Show positions of my pieces\n3: Show my eaten figures\n4: Game over");
//                        int choice = input.nextInt();
//
//                        if(choice == 1){
//
//                        }
//                        else if(choice == 2){
//
//                        }
//                        else if(choice == 3){
//
//                        }
//                        else if(choice == 4){break;}
//
//                    }
//                    else{
//                        Scanner input = new Scanner(System.in);
//                        System.out.print("You black\n1: Move piece\n 2: Show positions of my pieces\n3: Show my eaten figures\n4: Game over");
//                        int choice = input.nextInt();
//
//                        if(choice == 1){
//
//                        }
//                    }
//                    a++;
//                }
//            }
//        }
        show();
    }
    public static void show() {
        Random rand = new Random();
        int row = rand.nextInt(8)+1;
        char col = (char)(rand.nextInt(8) + 'a');

        Position a = new Position(col,row);
        System.out.println("New Position: " + a.toString());

        Piece king =  new King();
        System.out.println("Old position: " + king.toString() + " King: " + king.isLegalMove(a));

        Piece queen =  new Queen();
        System.out.println("Old position: " + queen.toString()+ " Queen: " + queen.isLegalMove(a));

        Piece rook =  new Rook();
        System.out.println("Old position: " + rook.toString()+ " Rook: " + rook.isLegalMove(a));

        Piece bishop =  new Bishop();
        System.out.println("Old position: " + bishop.toString()+ " Bishop: " + bishop.isLegalMove(a));

        Piece knight =  new Knight();
        System.out.println("Old position: " + knight.toString()+ " Knight: " + knight.isLegalMove(a));

        Piece pawn =  new Pawn();
        System.out.println("Old position: " + pawn.toString()+ " Pawn: " + pawn.isLegalMove(a));

    }
}