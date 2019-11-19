package TrivialMaze;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Door extends GameObject{

	public Door(int x, int y, ID id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		if (this.id == ID.DoorVertical) {
			g.setColor(Color.orange);
			g.fillRect(x, y, 8, 40);
		}else if (this.id == ID.DoorHorizontal) {
			g.setColor(Color.orange);
			g.fillRect(x, y, 40, 8);
		}
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		if (this.id == ID.DoorVertical) {
			return new Rectangle(x, y, 8, 40);
		}else if (this.id == ID.DoorHorizontal) {
			return new Rectangle(x, y, 40, 8);
		}else
			return null;
	}

}
