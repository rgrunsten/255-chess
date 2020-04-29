package Pieces;
import Meta.*;

public class Queen extends Piece {

    public Queen(int x, int y, Player player, boolean alive) {
        super(x, y, player, alive);
    }

    /**
	* Queen legal move: essentially rook + bishop combined
    * @param destX  the destination x coordinate
    * @param destY  the destination y coordinate
    * @return       boolean whether move is legal
    */
    public boolean isLegalMovement(int destX, int destY) {
        int xDiff = Math.abs(destX - this.x);
        int yDiff = Math.abs(destY - this.y);
        if (xDiff > 0 && yDiff == 0) {
            return true;
        }
        else if (xDiff == 0 && yDiff > 0) {
            return true;
        }
        return xDiff == yDiff;
    }
}