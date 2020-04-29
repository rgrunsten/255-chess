package Meta;
import Pieces.*;

public class Board {
    private Square[][] squares;
    private boolean gameOver;

    public Board(){
        gameOver = false;
        squares = new Square[8][8];
    }

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
        Move mv = pla.getCurrentMove();
        Piece piece = mv.getPiece();

        // If move is illegal, cancel it and return false
        if (!piece.isLegalMovement(mv.destX, mv.destY)) {
            pla.removeCurrentMove();
            return false;
        }
        // If move bumps into own piece, cancel it and return false
        if (squares[mv.destX][mv.destY].getPiece().getPlayer().getColor() == pla.getColor()) {
            pla.removeCurrentMove();
            return false;
        } else {
            // Move the Piece and return true
            squares[mv.destX][mv.destY].takeSquare(piece);
            return true;
        }
    }
}