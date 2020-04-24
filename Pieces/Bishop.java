package Pieces;

public class Bishop extends Piece {

    /**
	* Constructor for a Bishop.
	* @param x	bishop's x location
	* @param y	bishop's y location
	* @param player	player who owns the piece
    */
    public Bishop(int x, int y, Player player) {
        super(x, y, player);
    }

    /**
	* Bishop coverage: diagonal squares
	* @param startX the starting x coordinate
	* @param startY the starting y coordinate
	* @param destX	the destination x coordinate
	* @param destY	the destination y coordinate
	* @param player	player who owns the piece
    */
    //public int [][] pieceCoverage(int startX, int startY, int finalX, int finalY) {

    //}

    /**
	* Bishop legal move: must move diagonally
    * @param finalX the final x coordinate
    * @param finalY the final Y coordinate
	* @param player	player who owns the piece
    */
    public boolean isLegalMovement(int finalX, int finalY) {
        int xDiff = Math.abs(finalX - this.x);
        int yDiff = Math.abs(finalY - this.y);
        return xDiff == yDiff;
    } 
}