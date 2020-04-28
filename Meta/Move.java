package Meta;
import Pieces.*;

public class Move {
    int destX;
    int destY;
    Piece piece;

    public Move(Piece piece, int destX, int destY) {
        this.piece = piece;
        this.destX = destX;
        this.destY = destY;
    }

    public int getDestX() { return this.destX ;}
    public int getDestY() { return this.destY ;}
    public Piece getPiece() { return this.piece ;}
}