package Pieces;
import Meta.*;


public abstract class Piece {
	public int x, y;
	public Player player;
	public boolean alive = true;

	/**
	* Constructor for an abstract piece.
	* @param x	piece's x location
	* @param y	piece's y location
	* @param player	player who owns the piece
	* @param alive whether piece has been captured or not
	*/
	public Piece(int x, int y, Player player, boolean alive) {
		this.x = x;
		this.y = y;
		this.player = player;
		this.alive = alive;
	}

	public boolean isAlive() { return alive ;}
	public void setAlive(boolean alive){ this.alive = alive ;}

	public int getX() { return x ;}
	public void setX(int x) { this.x = x ;}

	public int getY() { return y ;}
	public void setY(int y) { this.y = y ;}

	public Player getPlayer() { return player ;}

	/**
	* Function for whether a piece can move to a destination legally
	* @param destX	the destination x coordinate
	* @param destY	the destination y coordinate
	* @return		boolean whether move is legal
	*/
	public abstract boolean isLegalMovement(int destX, int destY);
}
