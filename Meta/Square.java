package Meta;
import Pieces.*;

public class Square {
    private int x;
    private int y;
    private Piece piece;
    
    public Square(int x, int y, Piece piece){
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    public int getX(){ return x ;}
    public void setX(int x){ this.x = x ;}
    
    public int getY(){ return y ;}
    public void setY(int y){ this.y = y ;}

    public Piece getPiece(){ return piece ;}
    public void setPiece(Piece piece){ this.piece = piece ;}

    public void takeSquare(Piece pPiece){
        // If another piece is present on this square already, kill it
        // then move the passed piece objcet to this square
        if (this.piece != null) {
            this.piece.setAlive(false);
        }
        // Place the passed piece on this square
        pPiece.setX(x);
        pPiece.setY(y);
        this.piece = pPiece;
    }

}