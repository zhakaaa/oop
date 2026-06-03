import java.util.Random;

public class Rook extends Piece {
    Random rand = new Random();
    int row = rand.nextInt(8)+1;
    char col = (char)(rand.nextInt(8) + 'a');
    Position oldPosition = new Position(col, row);

//    String color;
//    public Rook(String color) {
//        this.color = color;
//    }

    @Override public boolean isLegalMove(Position newPosition) {
        if(oldPosition.getCol() == newPosition.getCol() && oldPosition.getRow() != newPosition.getRow())return true;
        else if(oldPosition.getCol() != newPosition.getCol() && oldPosition.getRow() == newPosition.getRow()) return true;
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
//                if(board.squares[i][j] instanceof Rook && ((Rook) board.squares[i][j]).color.equals(color) ){
//                    pos += (i + " " + (char) j);
//                }
//            }
//        }
//        return pos;
//    }
}
