package snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public interface IKey extends KeyListener {

	void keyTyped(KeyEvent e);

	void keyPressed(KeyEvent e);

	void keyReleased(KeyEvent e);

	void Clear();

}