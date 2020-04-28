package Pieces;
import Meta.*;

public class King extends Piece {

    public King(int x, int y, Player player, boolean alive) {
        super(x, y, player, alive);
    }

    /**
	* King legal move: one square in any direction
	* @param destX  the destination x coordinate
	* @param destY	the destination y coordinate
	* @return	    boolean whether move is legal
	*/
	public boolean isLegalMovement(int destX, int destY) {
        int xDiff = Math.abs(destX - this.x);
        int yDiff = Math.abs(destY - this.y);
        return xDiff + yDiff <= 2;
    } 
}