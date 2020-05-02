package Pieces;
import Meta.*;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Bishop extends Piece {

    public Bishop(int x, int y, Player player, boolean alive) {
        super(x, y, player, alive);
        if (this.player.getColor() == 1) {
            imgString = "/Assets/wBishop.png";
        } else {
            imgString = "/Assets/bBishop.png";
        }
        try {
            if (this.img == null) {
                this.img = ImageIO.read(getClass().getResource(imgString));
            }
        } catch (IOException e) {
            System.err.println("File missing: " + e.getMessage());
        }
    }

    /**
	* Bishop legal move: must move diagonally
	* @param destX	the destination x coordinate
	* @param destY	the destination y coordinate
	* @return	    boolean whether move is legal
	*/
    public boolean isLegalMovement(int destX, int destY) {
        return isLogical(destX, destY);
    }

    public boolean isLogical(int destX, int destY) {
        int xDiff = Math.abs(destX - this.x); 
        int yDiff = Math.abs(destY - this.y); 
        return xDiff == yDiff;
    }
}