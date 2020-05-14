package snake;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

public interface IMenu  {

	void mousePressed(MouseEvent e);

	void mouseReleased(MouseEvent e);

	void fileReader(Graphics g);

	void paint(Graphics g);

	void tick();

}