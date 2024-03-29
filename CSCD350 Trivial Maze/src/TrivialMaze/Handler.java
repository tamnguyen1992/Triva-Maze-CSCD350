package TrivialMaze;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	LinkedList<GameObject> gameObjects = new LinkedList<GameObject>();
	public void tick() {
		// for (GameObject gameObject : gameObjects) {
		//		gameObject.tick();
		// }
		// To avoid the ConcurrentModificationException, we use normal for loop, not foreach
		// before finishing our iteration we are removing/modification an element. 
		// That's what triggers the exception
		for(int i = 0; i < gameObjects.size(); i++) {
			GameObject temp = gameObjects.get(i);
			temp.tick();
		}
	}
	public void render(Graphics g) {
		for (GameObject gameObject : gameObjects) {
			gameObject.render(g);
		}
		
	}
	public void addObject(GameObject object) {
		this.gameObjects.add(object);
	}
	public void removeObject(GameObject object) {
		this.gameObjects.remove(object);
	}
}
