import java.util.Random;

public class Bishop extends Piece {
    Random rand = new Random();
    int row = rand.nextInt(8)+1;
    char col = (char)(rand.nextInt(8) + 'a');
    Position a = new Position(col, row);

//    String color;
//    public Bishop(String color) {
//        this.color = color;
//    }

    @Override public boolean isLegalMove(Position b) {
        // Check diagonal moves
        if(Math.abs(a.getCol() - b.getCol()) ==  Math.abs(a.getRow() - b.getRow())) return true;

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
//                if(board.squares[i][j] instanceof Bishop && ((Bishop) board.squares[i][j]).color.equals(color) ){
//                    pos += (i + " " + (char) j);
//                }
//            }
//        }
//        return pos;
//    }
}
