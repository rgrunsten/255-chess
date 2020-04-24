package Pieces;
import Meta.*;

public abstract class Piece {
	private boolean captured = false;
	public int x, y;
	public Player player;

	/**
	* Constructor for an abstract piece.
	* @param x	piece's x location
	* @param y	piece's y location
	* @param player	player who owns the piece
	*/
	public Piece(int x, int y, Player player) {
		this.x = x;
		this.y = y;
		this.player = player;
	}

	/**
	* Function for whether a piece can move to a destination legally
	* @param destX	the destination x coordinate
	* @param destY	the destination y coordinate
	* @return	boolean whether movement is legal
	*/
	public abstract boolean isLegalMovement(int destX, int destY);

	/**
	* Function for piece's "coverage"
	* @param startX the starting x coordinate
	* @param startY the starting y coordinate
	* @param destX	the destination x coordinate
	* @param destY	the destination y coordinate
	* @return	array of coordinates the piece is covering
	*/
	public abstract int[][] pieceCoverage(int startX, int startY, int destX, int destY);


}
