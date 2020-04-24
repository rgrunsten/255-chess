package Pieces;
import Meta.*;

public abstract class Piece {

	public int x, y;
	public Player player;

	/**
	* Constructor for an abstract piece.
	* @param x	piece's x location
	* @param y	piece's y location
	* @param player	player who own's the piece
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
	public abstract boolean legalMovement(int destX, int destY);


}
