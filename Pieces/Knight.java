package Pieces;
import Meta.*;

public class Knight extends Piece {

    public Knight(int x, int y, Player player, boolean alive) {
        super(x, y, player, alive);
    }

    /**
	* Knight legal move: must move in L shape
    * @param destX  the destination x coordinate
    * @param destY  the destination y coordinate
    * @return       boolean whether move is legal
    */
    public boolean isLegalMovement(int destX, int destY) {
        int xDiff = Math.abs(destX - this.x); 
        int yDiff = Math.abs(destY - this.y); 
        return xDiff * yDiff == 2;
    }
}