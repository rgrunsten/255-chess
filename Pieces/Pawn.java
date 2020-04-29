package Pieces;
import Meta.*;

public class Pawn extends Piece {

    public Pawn(int x, int y, Player player, boolean alive) {
        super(x, y, player, alive);
    }

    /**
	* Pawn legal move: must move forward one space, can be two spaces at start
	* @param destX	the destination x coordinate
	* @param destY	the destination y coordinate
	* @return	    boolean whether move is legal
	*/
	public boolean isLegalMovement(int destX, int destY) {
        int xDiff = Math.abs(destX - this.x);
        int yDiff = Math.abs(destY - this.y);

        // Pawn's capture rules
        if (xDiff == 1 && yDiff == 1) {
            return true;
        }
        // If Pawn is in the player's second row, can move two spaces
        if ((this.y == 1 && this.player.getColor() == 1) 
        || (this.y == 6 && this.player.getColor() == 2)) {
            yDiff--;
        }
        else if (yDiff <= 1 && xDiff == 0){
            return true;
        }
        return false;
    }
}