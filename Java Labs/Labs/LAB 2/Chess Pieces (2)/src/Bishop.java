public class Bishop extends Piece {

    Position oldPosition;

    String color;
    public Bishop(String color) {
        this.color = color;
    }

    @Override public boolean isLegalMove(Position newPosition) {
        // Check diagonal moves
        if(Math.abs(oldPosition.getCol() - newPosition.getCol()) ==  Math.abs(oldPosition.getRow() - newPosition.getRow())) return true;

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
                if(Board.squares[i][j] instanceof Bishop && ((Bishop) Board.squares[i][j]).color.equals(color) ){
                    pos.append(i+1).append((char)(j + 97)).append(" ");
                }
            }
        }
        return pos.toString();
    }
}
