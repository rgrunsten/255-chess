package Pieces;
import Meta.*;

public class Queen extends Piece {

    public Queen(int x, int y, Player player, boolean alive) {
        super(x, y, player, alive);
    }

    /**
	* Queen legal move: essentially rook + bishop combined
    * @param finalX the final x coordinate
    * @param finalY the final Y coordinate
	* @param player	player who owns the piece
    */
    public boolean isLegalMovement(int finalX, int finalY) {
        int xDiff = Math.abs(finalX - this.x);
        int yDiff = Math.abs(finalY - this.y);
        if (xDiff > 0 && yDiff == 0) {
            return true;
        }
        else if (xDiff == 0 && yDiff > 0) {
            return true;
        }
        return xDiff == yDiff;
    }
}