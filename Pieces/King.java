package Pieces;
import Meta.*;
import javax.imageio.ImageIO;
import java.io.IOException;

public class King extends Piece {

    public King(int x, int y, Player player, boolean alive) {
        super(x, y, player, alive);
        if (this.player.getColor() == 1) {
            imgString = "/Assets/wKing.png";
        } else {
            imgString = "/Assets/bKing.png";
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
	* King legal move: one square in any direction
	* @param destX  the destination x coordinate
	* @param destY	the destination y coordinate
	* @return	    boolean whether move is legal
	*/
    public boolean isLogical(int destX, int destY) {
        int xDiff = Math.abs(destX - this.x); 
        int yDiff = Math.abs(destY - this.y); 
        return xDiff + yDiff <= 2;
    }
}