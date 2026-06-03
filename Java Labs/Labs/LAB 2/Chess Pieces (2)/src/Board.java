import java.util.Vector;

public class Board {
    public static Piece[][] squares = new Piece[8][8];;

    public Board(){
        initialPosition();
    }

    private void initialPosition(){
        Rook rookBlack = new Rook("black");
        rookBlack.setNewPos(new Position((char) 0 ,0));
        squares[0][0] = new Rook("white");
        squares[0][1] = new Knight("white");
        squares[0][2] = new Bishop("white");
        squares[0][3] = new Queen("white");
        squares[0][4] = new King("white");
        squares[0][5] = new Bishop("white");
        squares[0][6] = new Knight("white");
        squares[0][7] = new Rook("white");
        for (int i = 0; i < 8; i++) {
            squares[1][i] = new Pawn("white");
            squares[6][i] = new Pawn("black");
        }
        squares[7][0] = new Rook("black");
        squares[7][1] = new Knight("black");
        squares[7][2] = new Bishop("black");
        squares[7][3] = new Queen("black");
        squares[7][4] = new King("black");
        squares[7][5] = new Bishop("black");
        squares[7][6] = new Knight("black");
        squares[7][7] = new Rook("black");
    }



    class White{
        Vector<Piece> blackPieces = new Vector<>();

        public void moveKnight(int row, int col){
            if(legalmove(row, col)){
                char row2 = (char) row;
                Position b = new Position(row2,col);
                Piece knight = new Knight("white");
                if(knight.isLegalMove(b)){
                    if (squares[row][col] != null) {
                        blackPieces.add(squares[row][col]);
                    }
                    squares[row][col] = knight;
                }
            }
        }
        public void moveRook(int row, int col){
            if(legalmove(row, col)){
                char row2 = (char) row;
                Position b = new Position(row2,col);
                Piece rook = new Rook("white");
                if(rook.isLegalMove(b)){
                    if (squares[row][col] != null) {
                        blackPieces.add(squares[row][col]);
                    }
                    squares[row][col] = rook;

                }
            }
        }
        public void moveBishop(int row, int col){
            if(legalmove(row, col)){
                char row2 = (char) row;
                Position b = new Position(row2,col);
                Piece bishop = new Bishop("white");
                if(bishop.isLegalMove(b)){
                    if (squares[row][col] != null) {
                        blackPieces.add(squares[row][col]);
                    }
                    squares[row][col] = bishop;
                }
            }
        }
        public void moveQueen(int row, int col){
            if(legalmove(row, col)){
                char row2 = (char) row;
                Position b = new Position(row2,col);
                Piece queen = new Queen("white");
                if(queen.isLegalMove(b)){
                    if (squares[row][col] != null) {
                        blackPieces.add(squares[row][col]);
                    }
                    squares[row][col] = queen;
                }
            }
        }
        public void moveKing(int row, int col){
            if(legalmove(row, col)){
                char row2 = (char) row;
                Position b = new Position(row2,col);
                Piece king = new King("white");
                if(king.isLegalMove(b)){
                    if (squares[row][col] != null) {
                        blackPieces.add(squares[row][col]);
                    }
                    squares[row][col] = king;
                }
            }
        }
        public void movePawn(char row, int col){
            int row2 = Character.toLowerCase(row) - 'a' + 1;
            if(legalmove(row, col)){
                Position b = new Position(row,col);
                Piece pawn = new Rook("white");
                if(pawn.isLegalMove(b)){
                    if (squares[row2][col] != null) {
                        blackPieces.add(squares[row2][col]);
                    }
                    squares[row2][col] = pawn;
                }
            }
        }
    }

    class Black{
        Vector<Piece> whitePieces = new Vector<>();
        public void moveKnight(char row, int col){
            if(legalmove(row, col)){
                int row2 = Character.toLowerCase(row) - 'a' + 1;
                Position b = new Position(row,col);
                Piece knight = new Knight("black");
                if(knight.isLegalMove(b)){
                    if (squares[row2][col] != null) {
                        whitePieces.add(squares[row2][col]);
                    }
                    squares[row2][col] = knight;
                }
            }
        }
        public void moveRook(char row, int col){
            if(legalmove(row, col)){
                int row2 = Character.toLowerCase(row) - 'a' + 1;
                Position b = new Position(row,col);
                Piece rook = new Rook("black");
                if(rook.isLegalMove(b)){
                    if (squares[row2][col] != null) {
                        whitePieces.add(squares[row2][col]);
                    }
                    squares[row2][col] = rook;
                }
            }
        }
        public void moveBishop(char row, int col){
            int row2 = Character.toLowerCase(row) - 'a' + 1;
            if(legalmove(row2, col)){
                Position b = new Position(row,col);
                Piece bishop = new Bishop("black");
                if(bishop.isLegalMove(b)){
                    if (squares[row2][col] != null) {
                        whitePieces.add(squares[row2][col]);
                    }
                    squares[row2][col] = bishop;
                }
            }
        }
        public void moveQueen(char row, int col){
            int row2 = Character.toLowerCase(row) - 'a' + 1;
            if(legalmove(row2, col)){
                Position b = new Position(row,col);
                Piece queen = new Queen("black");
                if(queen.isLegalMove(b)){
                    if (squares[row2][col] != null) {
                        whitePieces.add(squares[row2][col]);
                    }
                    squares[row2][col] = queen;
                }
            }
        }
        public void moveKing(char row, int col){
            int row2 = Character.toLowerCase(row) - 'a' + 1;
            if(legalmove(row2, col)){
                Position b = new Position(row,col);
                Piece king = new King("black");
                if(king.isLegalMove(b)){
                    if (squares[row2][col] != null) {
                        whitePieces.add(squares[row2][col]);
                    }
                    squares[row2][col] = king;
                }
            }
        }
        public void movePawn(char row, int col){
            int row2 = Character.toLowerCase(row) - 'a' + 1;
            if(legalmove(row2, col)){
                Position b = new Position(row,col);
                Piece pawn = new Rook("black");
                if(pawn.isLegalMove(b)){
                    if (squares[row2][col] != null) {
                        whitePieces.add(squares[row2][col]);
                    }
                    squares[row2][col] = pawn;
                }
                else{
                    System.out.println("You cannot move to this position");
                }
            }
            else{
                System.out.println("You cannot move to this position");
            }
        }
    }


    private boolean legalmove(int row, int col){
        return (row >= 0 && row < 8 && col >= 0 && col < 8);
    }

    public void showPosition(String color){
        Piece king = new King(color);
        Piece queen = new Queen(color);
        Piece rook = new Rook(color);
        Piece bishop = new Bishop(color);
        Piece knight = new Knight(color);
        Piece pawn = new Pawn(color);

        System.out.println("The position of King: " + king.showPos(color));
        System.out.println("The position of Queen: "+queen.showPos(color));
        System.out.println("The position of Rook: "+rook.showPos(color));
        System.out.println("The position of Bishop: "+bishop.showPos(color));
        System.out.println("The position of Knight: "+knight.showPos(color));
        System.out.println("The position of Pawn: "+pawn.showPos(color));
    }

    public void eatenFigures(String color) {
        if(color.equals("white")){
            White white = new White();
            for(Piece pieces : white.blackPieces){
                System.out.print(pieces.getClass().getName());
            }
        }
        else{
            Black black = new Black();
            for(Piece pieces : black.whitePieces){
                System.out.print(pieces.getClass().getName());
            }
        }
    }


}
