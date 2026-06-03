import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();

        while(true){
            Scanner input2 = new Scanner(System.in);
            System.out.print("1: Start/Continue \n2: Exit \nYour choice: ");
            int choice2 = input2.nextInt();

            if(choice2 == 1){
                int a = 0;
                while(true){
                    if(a % 2 == 0) {                     // White order
                        Scanner input = new Scanner(System.in);
                        System.out.print("You are white\n1: Move piece\n2: Show positions of my pieces\n3: Show my eaten figures\n4: Game over\nYour choice: ");
                        int choice = input.nextInt();

                        if(choice == 1){
                            Board.White whites = board.new White();
                            System.out.println("Which piece you want to move?\n1: King\n2: Queen\n3: Rook\n4: Bishop\n5: Knight\n6: Pawn\nYour choice: ");
                            Scanner input3 = new Scanner(System.in);
                            int choice3 = input3.nextInt();
                            if(choice3 == 1){
                                System.out.println("New position: ");
                                Scanner input4 = new Scanner(System.in);
                                System.out.print("Row: ");
                                char char4 = input4.next().charAt(0);
                                System.out.print("Column: ");
                                int choice4 = input4.nextInt();
                                whites.moveKing(char4, choice4);
                            }else if(choice3 == 2){
                                System.out.println("New position: ");
                                Scanner input4 = new Scanner(System.in);
                                System.out.print("Row: ");
                                char char4 = input4.next().charAt(0);
                                System.out.print("Column: ");
                                int choice4 = input4.nextInt();
                                whites.moveQueen(char4, choice4);
                            }else if(choice3 == 3){
                                System.out.println("New position: ");
                                Scanner input4 = new Scanner(System.in);
                                System.out.print("Row: ");
                                char char4 = input4.next().charAt(0);
                                System.out.print("Column: ");
                                int choice4 = input4.nextInt();
                                whites.moveRook(char4, choice4);
                            }else if(choice3 == 4){
                                System.out.println("New position: ");
                                Scanner input4 = new Scanner(System.in);
                                System.out.print("Row: ");
                                char char4 = input4.next().charAt(0);
                                System.out.print("Column: ");
                                int choice4 = input4.nextInt();
                                whites.moveBishop(char4, choice4);
                            }else if(choice3 == 5){
                                System.out.println("New position: ");
                                Scanner input4 = new Scanner(System.in);
                                System.out.print("Row: ");
                                char char4 = input4.next().charAt(0);
                                System.out.print("Column: ");
                                int choice4 = input4.nextInt();
                                whites.moveKnight(char4, choice4);
                            }else if(choice3 == 6){
                                System.out.println("New position: ");
                                Scanner input4 = new Scanner(System.in);
                                System.out.print("Row: ");
                                char char4 = input4.next().charAt(0);
                                System.out.print("Column: ");
                                int choice4 = input4.nextInt();
                                whites.movePawn(char4, choice4);
                            }
                        }
                        else if(choice == 2){
                            board.showPosition("white");
                        }
                        else if(choice == 3){
                            board.eatenFigures("white");
                        }
                        else if(choice == 4){break;}

                    }
                    else{ // Black order
                        Scanner input = new Scanner(System.in);
                        System.out.print("You are black\n1: Move piece\n2: Show positions of my pieces\n3: Show my eaten figures\n4: Game over\nYour choice: ");
                        int choice = input.nextInt();

                        if(choice == 1){
                            Board.Black blacks = board.new Black();
                            System.out.println("Which piece you want to move?\n1: King\n2: Queen\n3: Rook\n4: Bishop\n5: Knight\n6: Pawn\nYour choice: ");
                            Scanner input3 = new Scanner(System.in);
                            int choice3 = input3.nextInt();
                            if(choice3 == 1){
                                System.out.println("New position: ");
                                Scanner input4 = new Scanner(System.in);
                                System.out.print("Row: ");
                                char char4 = input4.next().charAt(0);
                                System.out.print("Column: ");
                                int choice4 = input4.nextInt();
                                blacks.moveKing(char4, choice4);
                            }else if(choice3 == 2){
                                System.out.println("New position: ");
                                Scanner input4 = new Scanner(System.in);
                                System.out.print("Row: ");
                                char char4 = input4.next().charAt(0);
                                System.out.print("Column: ");
                                int choice4 = input4.nextInt();
                                blacks.moveQueen(char4, choice4);
                            }else if(choice3 == 3){
                                System.out.println("New position: ");
                                Scanner input4 = new Scanner(System.in);
                                System.out.print("Row: ");
                                char char4 = input4.next().charAt(0);
                                System.out.print("Column: ");
                                int choice4 = input4.nextInt();
                                blacks.moveRook(char4, choice4);
                            }else if(choice3 == 4){
                                System.out.println("New position: ");
                                Scanner input4 = new Scanner(System.in);
                                System.out.print("Row: ");
                                char char4 = input4.next().charAt(0);
                                System.out.print("Column: ");
                                int choice4 = input4.nextInt();
                                blacks.moveBishop(char4, choice4);
                            }else if(choice3 == 5){
                                System.out.println("New position: ");
                                Scanner input4 = new Scanner(System.in);
                                System.out.print("Row: ");
                                char char4 = input4.next().charAt(0);
                                System.out.print("Column: ");
                                int choice4 = input4.nextInt();
                                blacks.moveKnight(char4, choice4);
                            }else if(choice3 == 6){
                                System.out.println("New position: ");
                                Scanner input4 = new Scanner(System.in);
                                System.out.print("Row: ");
                                char char4 = input4.next().charAt(0);
                                System.out.print("Column: ");
                                int choice4 = input4.nextInt();
                                blacks.movePawn(char4, choice4);
                            }
                        }
                        else if(choice == 2){
                            board.showPosition("black");
                        }
                        else if(choice == 3){
                            board.eatenFigures("black");
                        }
                        else if(choice == 4){break;}
                    }

                    a++;
                }
            }
            else{
                break;
            }
        }
//        show();
    }

//    public static void show() {
//        Random rand = new Random();
//        int row = rand.nextInt(8)+1;
//        char col = (char)(rand.nextInt(8) + 'a');
//
//        Position a = new Position(col,row);
//        System.out.println("New Position: " + a.toString());
//
//        Piece king =  new King();
//        System.out.println("Old position: " + king.toString() + " King: " + king.isLegalMove(a));
//
//        Piece queen =  new Queen();
//        System.out.println("Old position: " + queen.toString()+ " Queen: " + queen.isLegalMove(a));
//
//        Piece rook =  new Rook();
//        System.out.println("Old position: " + rook.toString()+ " Rook: " + rook.isLegalMove(a));
//
//        Piece bishop =  new Bishop();
//        System.out.println("Old position: " + bishop.toString()+ " Bishop: " + bishop.isLegalMove(a));
//
//        Piece knight =  new Knight();
//        System.out.println("Old position: " + knight.toString()+ " Knight: " + knight.isLegalMove(a));
//
//        Piece pawn =  new Pawn();
//        System.out.println("Old position: " + pawn.toString()+ " Pawn: " + pawn.isLegalMove(a));
//
//    }
}