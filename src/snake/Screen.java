package snake;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;


public class Screen extends Canvas implements IScreen  {
	private static final long  serialVersionUID =5L;
	public Screen(int width, int height,Game game) {
		JFrame frame= new JFrame("Snake Game");
	
		frame.setPreferredSize(new Dimension(width,height));
		frame.setMaximumSize(new Dimension(width,height));
		frame.setMinimumSize(new Dimension(width,height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}
}
