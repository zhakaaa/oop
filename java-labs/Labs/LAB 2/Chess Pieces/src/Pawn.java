import java.util.Random;

public class Pawn extends Piece {
    Random rand = new Random();
    int row = rand.nextInt(8)+1;
    char col = (char)(rand.nextInt(8) + 'a');
    Position a = new Position(col, row);

//    public String color;
//    public Pawn(String color) {
//        this.color = color;
//    }

    @Override public boolean isLegalMove(Position b) {
        if(a.getRow() <= 4){
            if(a.getCol() == b.getCol() && b.getRow() - 1  == a.getRow())return true;
            else if(a.getCol() == b.getCol()) return true;
        }
        else{if(a.getCol() == b.getCol() && b.getRow() - 1  == a.getRow())return true;}
        return false;
    }

    public String toString() {
        return col + "" + row;
    }

//    public String toString(String color) {
//        String pos = "";
//        for (int i = 0; i < board.squares.length; i++) {
//            for (int j = 0; j < board.squares[i].length; j++) {
//                if(board.squares[i][j] instanceof Pawn && ((Pawn) board.squares[i][j]).color.equals(color) ){
//                    pos += (i + " " + (char) j);
//                }
//            }
//        }
//        return pos;
//    }
}
