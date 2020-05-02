package Pieces;
import Meta.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public abstract class Piece implements moveLogic {
	public int x, y;
	public Player player;
	public boolean alive = true;
	public String imgString;
	public BufferedImage img;
	

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

	public BufferedImage getImage() { return img ;}
	public String getImageString() { return imgString ;}
	public void setImage(String imgString) {
		try {
            if (this.img == null) {
				this.img = ImageIO.read(getClass().getResource(imgString));
            }
        } catch (IOException e) {
            System.err.println("File missing: " + e.getMessage());
        }
	}

	/**
	* Abstract, implemented function for retrieving a piece's move logic
	* @param destX	the destination x coordinate
	* @param destY	the destination y coordinate
	* @return		boolean whether move is legal
	*/
	public abstract boolean isLogical(int destX, int destY);

	/**
	* Function for whether a piece can move to a destination legally
	* @param destX	the destination x coordinate
	* @param destY	the destination y coordinate
	* @return		boolean whether move is legal
	*/
	public boolean isLegalMovement(int destX, int destY) {
		return isLogical(destX, destY);
	}
	
}
