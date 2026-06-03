public class King extends Piece {

    Position oldPosition;

    String color;
    public King(String color) {
        this.color = color;
    }

    @Override public boolean isLegalMove(Position newPosition) {
        // Check moves forward and back
        if(newPosition.getCol() == oldPosition.getCol() && ((char)(newPosition.getRow()-1) == oldPosition.getRow() || (char)(newPosition.getRow()+1) == oldPosition.getRow())) return true;

        // Check moves right and left
        else if(newPosition.getRow() == oldPosition.getRow() && (newPosition.getCol()-1  == oldPosition.getCol() || newPosition.getCol() + 1  == oldPosition.getCol())) return true;

        // Check diagonal moves
        else if (oldPosition.getRow() + 1 == newPosition.getRow() && (char)(oldPosition.getCol() + 1) == newPosition.getCol()) return true; // top right
        else if (oldPosition.getRow() + 1 == newPosition.getRow() && (char)(oldPosition.getCol() - 1) == newPosition.getCol()) return true; // top left
        else if (oldPosition.getRow() - 1 == newPosition.getRow() && (char)(oldPosition.getCol() + 1) == newPosition.getCol()) return true; // bottom right
        else if (oldPosition.getRow() - 1 == newPosition.getRow() && (char)(oldPosition.getCol() - 1) == newPosition.getCol()) return true; // bottom left

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
                if(Board.squares[i][j] instanceof King && ((King) Board.squares[i][j]).color.equals(color) ){
                    pos.append(i+1).append((char)(j + 97)).append(" ");
                }
            }
        }
        return pos.toString();
    }
}
