package Meta;
import Pieces.*;

public class Square {
    private int x;
    private int y;
    private Piece piece;
    
    public Square(int x, int y, Piece piece){
        this.x = x;
        this.y = y;
        this.piece = null;
    }

    public int getX(){ return this.x ;}
    public void setX(int x){ this.x = x ;}
    
    public int getY(){return this.y ;}
    public void setY(int y){this.y = y ;}

    public Piece getPiece(){return this.piece ;}
    public void setPiece(Piece inPiece){ this.piece = inPiece ;}

}