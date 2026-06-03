import java.util.Random;

public class Knight extends Piece {
    Random rand = new Random();
    int row = rand.nextInt(8) + 1;
    char col = (char)(rand.nextInt(8) + 'a');
    Position a = new Position(col, row); //Old position


    @Override public boolean isLegalMove(Position b) {
        // Check moves forward, back, right and left
        if((char)(a.getCol() + 1) == b.getCol() && a.getRow() + 2 == b.getRow()) return true;
        else if((char)(a.getCol() - 1) == b.getCol() && a.getRow() + 2 == b.getRow()) return true;
        else if((char)(a.getCol() + 2) == b.getCol() && a.getRow() + 1 == b.getRow()) return true;
        else if((char)(a.getCol() - 2) == b.getCol() && a.getRow() + 1 == b.getRow()) return true;
        else if((char)(a.getCol() + 1) == b.getCol() && a.getRow() - 2 == b.getRow()) return true;
        else if((char)(a.getCol() - 1) == b.getCol() && a.getRow() - 2 == b.getRow()) return true;
        else if((char)(a.getCol() - 2) == b.getCol() && a.getRow() - 1 == b.getRow()) return true;
        else if((char)(a.getCol() + 2) == b.getCol() && a.getRow() - 1 == b.getRow()) return true;
        return false;
    }

    public String toString() {
        return col + "" + row;
    }
}
