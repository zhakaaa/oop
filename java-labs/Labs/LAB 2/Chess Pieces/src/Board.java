//import java.util.Vector;
//
//public class Board {
//    public  Piece[][] squares;
//
//    public Board(){
//        squares = new Piece[8][8];
//        initialPosition();
//    }
//
//    private void initialPosition(){
//        squares[0][0] = new Rook("black");
//        squares[0][1] = new Knight("black");
//        squares[0][2] = new Bishop("black");
//        squares[0][3] = new Queen("black");
//        squares[0][4] = new King("black");
//        squares[0][5] = new Bishop("black");
//        squares[0][6] = new Knight("black");
//        squares[0][7] = new Rook("black");
//        for (int i = 0; i < 8; i++) {
//            squares[1][i] = new Pawn("black");
//            squares[6][i] = new Pawn("white");
//        }
//        squares[7][0] = new Rook("white");
//        squares[7][1] = new Knight("white");
//        squares[7][2] = new Bishop("white");
//        squares[7][3] = new Queen("white");
//        squares[7][4] = new King("white");
//        squares[7][5] = new Bishop("white");
//        squares[7][6] = new Knight("white");
//        squares[7][7] = new Rook("white");
//    }
//
//    class White{
//        Vector<Piece> blackPieces = new Vector<>();
//
//        public void moveKnight(int row, int col){
//            if(legalmove(row, col)){
//                char row2 = (char) row;
//                Position b = new Position(row2,col);
//                Piece knight = new Knight("white");
//                if(knight.isLegalMove(b)){
//                    if (squares[row][col] != null) {
//                        blackPieces.add(squares[row][col]);
//                    }
//                    squares[row][col] = knight;
//                }
//            }
//        }
//        public void moveRook(int row, int col){
//            if(legalmove(row, col)){
//                char row2 = (char) row;
//                Position b = new Position(row2,col);
//                Piece rook = new Rook("white");
//                if(rook.isLegalMove(b)){
//                    if (squares[row][col] != null) {
//                        blackPieces.add(squares[row][col]);
//                    }
//                    squares[row][col] = rook;
//                }
//            }
//        }
//        public void moveBishop(int row, int col){
//            if(legalmove(row, col)){
//                char row2 = (char) row;
//                Position b = new Position(row2,col);
//                Piece bishop = new Bishop("white");
//                if(bishop.isLegalMove(b)){
//                    if (squares[row][col] != null) {
//                        blackPieces.add(squares[row][col]);
//                    }
//                    squares[row][col] = bishop;
//                }
//            }
//        }
//        public void moveQueen(int row, int col){
//            if(legalmove(row, col)){
//                char row2 = (char) row;
//                Position b = new Position(row2,col);
//                Piece queen = new Queen("white");
//                if(queen.isLegalMove(b)){
//                    if (squares[row][col] != null) {
//                        blackPieces.add(squares[row][col]);
//                    }
//                    squares[row][col] = queen;
//                }
//            }
//        }
//        public void moveKing(int row, int col){
//            if(legalmove(row, col)){
//                char row2 = (char) row;
//                Position b = new Position(row2,col);
//                Piece king = new King("white");
//                if(king.isLegalMove(b)){
//                    if (squares[row][col] != null) {
//                        blackPieces.add(squares[row][col]);
//                    }
//                    squares[row][col] = king;
//                }
//            }
//        }
//        public void movePawn(int row, int col){
//            if(legalmove(row, col)){
//                char row2 = (char) row;
//                Position b = new Position(row2,col);
//                Piece pawn = new Rook("white");
//                if(pawn.isLegalMove(b)){
//                    if (squares[row][col] != null) {
//                        blackPieces.add(squares[row][col]);
//                    }
//                    squares[row][col] = pawn;
//                }
//            }
//        }
//    }
//
//    class Black{
//        Vector<Piece> whitePieces = new Vector<>();
//        public void moveKnight(int row, int col){
//            if(legalmove(row, col)){
//                char row2 = (char) row;
//                Position b = new Position(row2,col);
//                Piece knight = new Knight("black");
//                if(knight.isLegalMove(b)){
//                    if (squares[row][col] != null) {
//                        whitePieces.add(squares[row][col]);
//                    }
//                    squares[row][col] = knight;
//                }
//            }
//        }
//        public void moveRook(int row, int col){
//            if(legalmove(row, col)){
//                char row2 = (char) row;
//                Position b = new Position(row2,col);
//                Piece rook = new Rook("black");
//                if(rook.isLegalMove(b)){
//                    if (squares[row][col] != null) {
//                        whitePieces.add(squares[row][col]);
//                    }
//                    squares[row][col] = rook;
//                }
//            }
//        }
//        public void moveBishop(int row, int col){
//            if(legalmove(row, col)){
//                char row2 = (char) row;
//                Position b = new Position(row2,col);
//                Piece bishop = new Bishop("black");
//                if(bishop.isLegalMove(b)){
//                    if (squares[row][col] != null) {
//                        whitePieces.add(squares[row][col]);
//                    }
//                    squares[row][col] = bishop;
//                }
//            }
//        }
//        public void moveQueen(int row, int col){
//            if(legalmove(row, col)){
//                char row2 = (char) row;
//                Position b = new Position(row2,col);
//                Piece queen = new Queen("black");
//                if(queen.isLegalMove(b)){
//                    if (squares[row][col] != null) {
//                        whitePieces.add(squares[row][col]);
//                    }
//                    squares[row][col] = queen;
//                }
//            }
//        }
//        public void moveKing(int row, int col){
//            if(legalmove(row, col)){
//                char row2 = (char) row;
//                Position b = new Position(row2,col);
//                Piece king = new King("black");
//                if(king.isLegalMove(b)){
//                    if (squares[row][col] != null) {
//                        whitePieces.add(squares[row][col]);
//                    }
//                    squares[row][col] = king;
//                }
//            }
//        }
//        public void movePawn(int row, int col){
//            if(legalmove(row, col)){
//                char row2 = (char) row;
//                Position b = new Position(row2,col);
//                Piece pawn = new Rook("black");
//                if(pawn.isLegalMove(b)){
//                    if (squares[row][col] != null) {
//                        whitePieces.add(squares[row][col]);
//                    }
//                    squares[row][col] = pawn;
//                }
//            }
//        }
//    }
//
//
//    private boolean legalmove(int row, int col){
//        return (row >= 0 && row < 8 && col >= 0 && col < 8);
//    }
//
//
//}
