import java.util.Random;

public class King extends Piece {
    Random rand = new Random();
    int row = rand.nextInt(8)+1;
    char col = (char)(rand.nextInt(8) + 'a');
    Position a = new Position(col, row);

//    String color;
//    public King(String color) {
//        this.color = color;
//    }

    @Override public boolean isLegalMove(Position b) {
        // Check moves forward and back
        if(b.getCol() == a.getCol() && ((char)(b.getRow()-1) == a.getRow() || (char)(b.getRow()+1) == a.getRow())) return true;

        // Check moves right and left
        else if(b.getRow() == a.getRow() && (b.getCol()-1  == a.getCol() || b.getCol() + 1  == a.getCol())) return true;

        // Check diagonal moves
        else if (a.getRow() + 1 == b.getRow() && (char)(a.getCol() + 1) == b.getCol()) return true; // top right
        else if (a.getRow() + 1 == b.getRow() && (char)(a.getCol() - 1) == b.getCol()) return true; // top left
        else if (a.getRow() - 1 == b.getRow() && (char)(a.getCol() + 1) == b.getCol()) return true; // bottom right
        else if (a.getRow() - 1 == b.getRow() && (char)(a.getCol() - 1) == b.getCol()) return true; // bottom left

        return false;
    }

    public String toString() {
        return col + "" + row;
    }

//    Board board;
//    public String toString(String color) {
//        String pos = "";
//        for (int i = 0; i < board.squares.length; i++) {
//            for (int j = 0; j < board.squares[i].length; j++) {
//                if(board.squares[i][j] instanceof King && ((King) board.squares[i][j]).color.equals(color) ){
//                    pos += (i + " " + (char) j);
//                }
//            }
//        }
//        return pos;
//    }
}
