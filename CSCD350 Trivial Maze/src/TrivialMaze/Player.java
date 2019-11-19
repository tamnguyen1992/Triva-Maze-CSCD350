package TrivialMaze;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject{
	private Handler handler;
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		//x += velX;
		//y += velY;

		//clamp player to stay in our screen
		//x = GameManager.clamp(x, 0, GameManager.WIDTH - 48);
		//y = GameManager.clamp(y, 0, GameManager.HEIGHT - 72);
		//collisionCheck();
	}
	private void collisionCheck() {
		for (GameObject gameObject : handler.gameObjects) {
			// check intersect of player and basic enemy
			if(gameObject.getID() == ID.DoorVertical || gameObject.getID() == ID.DoorHorizontal) {
				if(getBounds().intersects(gameObject.getBounds())) {
					// collision code in here
					System.out.println("Hit the door!");
				}
			}
			
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		g.fillRect(x, y, 32, 32);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,32,32);
	}

}
