package TrivialMaze;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class GameManager extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 640, HEIGHT = 480;  // Center: WIDTH/2 -32, HEIGHT/2 -32
	private static final int XPLAYER = 228; // Initialize location x of player
	private static final int YPLAYER = 148; // Initialize location y of player
	private static final int DISTROOM = 60; // Distance of 2 room
	private static int x = 210, y = 130; // Initialize location of first room.
	
	private Thread threadGame;
	private boolean running = false;
	
	private Handler handler;
	public GameManager() {
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		new Window(WIDTH, HEIGHT, "Trivial Maze", this);
		buildRoom(3, 3, x, y);
		buildDoor(3, 3, x, y);

		
		//handler.addObject(new Player(118, 118, ID.Player));
		handler.addObject(new Player(XPLAYER, YPLAYER, ID.Player, handler));
		handler.addObject(new Target(XPLAYER + DISTROOM * 2, YPLAYER +DISTROOM * 2 , ID.Target));
	}
	
	private void buildRoom(int row, int col, int x, int y) {
		int temp = x;
		int horDist = 60; //distance from 2 room
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				handler.addObject(new Room(x, y, ID.Room, handler));
				x +=horDist;
			}
			x = temp;
			y += horDist;
		}
	}
	private void buildDoor(int row, int col, int x, int y) {
		int temp = x;
		int horDist = 60; //distance from 2 room
		int verDist = 14; //distance from top room to top door
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(j < col-1 )
					handler.addObject(new Door(x+horDist, y+verDist, ID.DoorVertical));
				if (i < row-1)
					handler.addObject(new Door(x+verDist, y+horDist, ID.DoorHorizontal));
				x +=horDist;
			}
			x = temp;
			y += horDist;
		}
	}

	/*  the game loop
	 *  it checks whether enough time has passed (1/60 sec) to refresh the game, and checks whether enough time has passed (1 sec) to refresh the FPS counter;
	 *  while 'running' it adds the time it took to go through one iteration of the loop it self 
	 *  and adds it to delta (which is simplified to 1)
	 *  so once it reaches 1 delta it means enough time has passed to go forward one tick.
	 */
	@Override
	public void run()
    {
		this.requestFocus(); //focus on this game window when start the application
        long lastTime = System.nanoTime(); 		// get current time to the nanosecond
        double amountOfTicks = 60.0;			// set the number of ticks
        double ns = 1000000000 / amountOfTicks; // this determines how many times we can divide 60 into 1e9 of nanoseconds or about 1 second
        double delta = 0;						
        long timer = System.currentTimeMillis();// get current time
        int frames = 0;
        while(running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            // whenever delta >= 1, we call tick()
            // if game's running, call render()
            while(delta >=1)
                {
                    tick();
                    delta--;
                }
            	//if game's running, call render()
                if(running)
                    render();
                
                frames++;
                if(System.currentTimeMillis() - timer > 1000) // if one second has passed
                {
                    timer += 1000;
                    //System.out.println("FPS: "+ frames); // print out how many frames have happened in the last second
                    frames = 0;
                }
        }
        stop();
    }
	
	private void tick() {
		handler.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.gray);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		//hud.render(g);
		
		g.dispose();
		bs.show();
	}

	public synchronized void start() {
		threadGame = new Thread(this,"TrivialMaze");
		threadGame.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			threadGame.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int clamp(int var, int min, int max) {
		if(var <= min)
			return var = min;
		else if (var >= max)
			return var = max;
		else
			return var;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GameManager();
	}
}
