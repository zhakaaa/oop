public class Knight extends Piece {

    Position oldPosition; //Old position

    String color;
    public Knight(String color) {
        this.color = color;
    }

    @Override public boolean isLegalMove(Position newPosition) {
        // Check moves forward, back, right and left
        if((char)(oldPosition.getCol() + 1) == newPosition.getCol() && oldPosition.getRow() + 2 == newPosition.getRow()) return true;
        else if((char)(oldPosition.getCol() - 1) == newPosition.getCol() && oldPosition.getRow() + 2 == newPosition.getRow()) return true;
        else if((char)(oldPosition.getCol() + 2) == newPosition.getCol() && oldPosition.getRow() + 1 == newPosition.getRow()) return true;
        else if((char)(oldPosition.getCol() - 2) == newPosition.getCol() && oldPosition.getRow() + 1 == newPosition.getRow()) return true;
        else if((char)(oldPosition.getCol() + 1) == newPosition.getCol() && oldPosition.getRow() - 2 == newPosition.getRow()) return true;
        else if((char)(oldPosition.getCol() - 1) == newPosition.getCol() && oldPosition.getRow() - 2 == newPosition.getRow()) return true;
        else if((char)(oldPosition.getCol() - 2) == newPosition.getCol() && oldPosition.getRow() - 1 == newPosition.getRow()) return true;
        else if((char)(oldPosition.getCol() + 2) == newPosition.getCol() && oldPosition.getRow() - 1 == newPosition.getRow()) return true;
        return false;
    }

    public String toString() {
        return oldPosition.getCol() + "" + oldPosition.getRow();
    }
    @Override public void setNewPos(Position newPos){
        oldPosition = newPos;
    }

    @Override public String showPos(String color) {
        StringBuilder pos = new StringBuilder();
        for (int i = 0; i < Board.squares.length; i++) {
            for (int j = 0; j < Board.squares[i].length; j++) {
                if(Board.squares[i][j] instanceof Knight && ((Knight) Board.squares[i][j]).color.equals(color) ){
                    pos.append(i+1).append((char)(j + 97)).append(" ");
                }
            }
        }
        return pos.toString();
    }
}
