public abstract class Piece {
    Position a;
    String color;
    public abstract boolean isLegalMove(Position b);
    public abstract String showPos(String color);
    public abstract void  setNewPos(Position a);
}
