package Meta;
import Pieces.*;

public class Board {
    public Square[][] squares;
    public boolean gameOver;

    public Board(){
        gameOver = false;
        squares = new Square[8][8];
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                Square curSquare = new Square(i, j, null);
                squares[i][j] = curSquare;
            }
        }
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

            .setPiece(pla.getPlayerPieces().get(i));

        }

    }

    public boolean makeMove(Player pla) {
        Move sourceMove = pla.getMove(0);
        Piece piece = sourceMove.getPiece();
        Move destMove = pla.getMove(1);
    
        System.out.println(sourceMove.destX + ", " + sourceMove.destY);
        System.out.println(destMove.destX + ", " + destMove.destY);

        // If move is illegal, cancel it and return false
        if (!piece.isLegalMovement(destMove.destX, destMove.destY)) {
            System.out.println("Illegal move!");
            pla.clearMove();
            return false;
        }
        // If move bumps into own piece, cancel it and return false
        else if (squares[destMove.destX][destMove.destY].getPiece() != null) {
            if (squares[destMove.destX][destMove.destY].getPiece().getPlayer().getColor() == pla.getColor()) {
                System.out.println("Bumping move!");
                pla.clearMove();
                return false;
            }
            squares[destMove.destX][destMove.destY].takeSquare(piece);
            System.out.println("Successful capture.");
            pla.clearMove();
            return true;
        } else {
            // Move the Piece and return true
            squares[destMove.destX][destMove.destY].takeSquare(piece);
            squares[sourceMove.destX][sourceMove.destY].setPiece(null);
            System.out.println("Successful move to empty square.");
            pla.clearMove();
            return true;
        }
    }
}