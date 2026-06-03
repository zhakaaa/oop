public class Queen extends Piece {

    Position oldPosition;

    String color;
    public Queen (String color) {
        this.color = color;
    }

    @Override public boolean isLegalMove(Position newPosition) {
        // Check moves forward, back, right and left
        if(oldPosition.getCol() == newPosition.getCol() && oldPosition.getRow() != newPosition.getRow())return true;
        else if(oldPosition.getCol() != newPosition.getCol() && oldPosition.getRow() == newPosition.getRow()) return true;

        // Check diagonal moves
        else if(Math.abs(oldPosition.getCol() - newPosition.getCol()) ==  Math.abs(oldPosition.getRow() - newPosition.getRow())) return true;

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
                if(Board.squares[i][j] instanceof Queen && ((Queen) Board.squares[i][j]).color.equals(color) ){
                    pos.append(i+1).append((char)(j + 97)).append(" ");
                }
            }
        }
        return pos.toString();
    }
}
