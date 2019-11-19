package TrivialMaze;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	//protected means it can only be accessed by which object inherits the GameObject 
	protected int x,y; 	// location
	protected ID id;
	protected int velX, velY;
	
	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick(); 				// Update 
	public abstract void render(Graphics g); 	// draw window
	public abstract Rectangle getBounds();		// handle collision (Rectangle has intersect method to handle if two rectangles intersect each other)
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setID(ID id) {
		this.id = id;
	}
	public ID getID() {
		return id;
	}
	public void setVelX(int velX) {
		this.velX = velX;
	}
	public void setVelY(int velY) {
		this.velY = velY;
	}
	public int getVelX() {
		return velX;
	}
	public int getVelY() {
		return velY;
	}
}
