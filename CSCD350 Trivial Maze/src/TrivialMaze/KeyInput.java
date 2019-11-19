package TrivialMaze;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	private Handler handler;
	private int XPLAYER = 228; // Initialize location x of player
	private int YPLAYER = 148; // Initialize location y of player
	private int DISTROOM = 60; // Distance of 2 room
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		for (GameObject gameObject : handler.gameObjects) {
			if(gameObject.getID() == ID.Player) {
				//System.out.println(key);
				if(key == KeyEvent.VK_UP && gameObject.getY() > YPLAYER) gameObject.setY(gameObject.getY() - DISTROOM);				
				if(key == KeyEvent.VK_DOWN && gameObject.getY() < YPLAYER + DISTROOM * 2 ) gameObject.setY(gameObject.getY() + DISTROOM);
				if(key == KeyEvent.VK_RIGHT && gameObject.getX() < XPLAYER + DISTROOM * 2) gameObject.setX(gameObject.getX() + DISTROOM);
				if(key == KeyEvent.VK_LEFT && gameObject.getX() > XPLAYER) gameObject.setX(gameObject.getX() - DISTROOM);
			}
		}

		if(key == KeyEvent.VK_ESCAPE)
			System.exit(1);
		
	}
}
