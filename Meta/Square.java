package Meta;

public class Square {
    private int x;
    private int y;
    private Piece piece;
    
    public Spot(int x, int y, Piece piece){
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    public int getX(){
        return this.x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY(){
        return this.y;
    }

    public void setY(int y){
        this.y = y;
    }

    public Piece getPiece(){
        return this.piece();
    }

    public void setPiece(Piece inPiece){
        this.piece = inPiece;
    }

}