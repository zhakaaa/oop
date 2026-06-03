public class Position {
    private int col;
    private int row;

    char[] cols = {'a','b','c','d','e','f','g','h'};
    int[] rows = {1,2,3,4,5,6,7,8};

    public Position(int row, int col) {
        this.col = col;
        this.row = row;
    }

    public char getCol() {return (char) (col + 97);}
    public int getRow() {return this.row;}

    public String toString() {
        return col + "" + row;
    }

}
