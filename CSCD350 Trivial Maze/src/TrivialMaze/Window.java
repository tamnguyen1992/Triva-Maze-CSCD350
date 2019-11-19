package TrivialMaze;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Window extends Canvas {

	private static final long serialVersionUID = 1L;
	public Window (int width, int height, String title, GameManager gameManager) {
		JFrame frame = new JFrame(title);
		Dimension dimension = new Dimension(width,height);
		frame.setPreferredSize(dimension);
		frame.setMinimumSize(dimension);
		frame.setMaximumSize(dimension);
		
		//Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("Admin");
        JMenu m3 = new JMenu("About");
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        JMenuItem m11 = new JMenuItem("New Game");
        JMenuItem m12 = new JMenuItem("Save as");
        JMenuItem m13 = new JMenuItem("Load Game");
        JMenuItem m14 = new JMenuItem("Exit");
        m1.add(m11);
        m1.add(m12);
        m1.add(m13);
        m1.add(m14);

        JMenuItem m21 = new JMenuItem("Log In");
        JMenuItem m22 = new JMenuItem("Add Question");
        m2.add(m21);
        m2.add(m22); 
        
        frame.getContentPane().add(BorderLayout.NORTH, mb);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	// get exit button on window
		frame.setResizable(false); 								// do not allow resize window
		frame.setLocationRelativeTo(null);						// to place window in the center of screen
		frame.add(gameManager);
		frame.setVisible(true);
		gameManager.start();
		
	}
}
