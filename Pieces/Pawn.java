package Pieces;
import Meta.*;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Pawn extends Piece {

    public Pawn(int x, int y, Player player, boolean alive) {
        super(x, y, player, alive);
        if (this.player.getColor() == 1) {
            imgString = "/Assets/wPawn.png";
        } else {
            imgString = "/Assets/bPawn.png";
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
	* Pawn legal move: must move forward one space, can be two spaces at start
	* @param destX	the destination x coordinate
	* @param destY	the destination y coordinate
	* @return	    boolean whether move is legal
	*/
    public boolean isLogical(int destX, int destY) {
        int xDiff = Math.abs(destX - this.x);
        int yDiff = Math.abs(destY - this.y);
        System.err.println("DIFF: " + xDiff + ", " + yDiff);

        // Pawn's capture rules
        if (xDiff == 1 && yDiff == 1) {
            return true;
        }
        // If Pawn is in the player's second row, can move two spaces
        if ((this.y == 1 && this.player.getColor() == 1) 
        || (this.y == 6 && this.player.getColor() == 2)) {
            yDiff--;
        }
        if (yDiff <= 1 && xDiff == 0){
            return true;
        }
        return false;
    }

    
}