package Meta;
import Pieces.*;

public class Board {
    private Square[][] squares;
    private boolean gameOver;

    public Board(){
        gameOver = false;
        squares = new Square[8][8];
    }

    public Square getSquare(int x, int y) { return squares[x][y] ;} 
    public boolean setGameOver() { return gameOver;}

    public void initialize(Player pla){
        
        // Assign player their starting pieces
        pla.initializePieces();
        
        // Grabs each piece a player owns, gets the piece's x and y coordinates, 
        // and places the piece on that square
        for(int i = 0; i < pla.getPlayerPieces().size(); i++){
            squares[pla.getPlayerPieces().get(i).getX()]
            [pla.getPlayerPieces().get(i).getY()]
            .takeSquare(pla.getPlayerPieces().get(i));
        }
    }

    public boolean makeMove(Player pla) {
        Move sourceMove = pla.getMove(0);
        Piece piece = sourceMove.getPiece();
        Move destMove = pla.getMove(1);
        
        // If move is illegal, cancel it and return false
        if (!piece.isLegalMovement(destMove.destX, destMove.destY)) {
            pla.removeMove(1);
            return false;
        }
        // If move bumps into own piece, cancel it and return false
        if (squares[destMove.destX][destMove.destY].getPiece().getPlayer().getColor() == pla.getColor()) {
            pla.removeMove(1);
            return false;
        } else {
            // Move the Piece and return true
            squares[destMove.destX][destMove.destY].takeSquare(piece);
            return true;
        }
    }
}