package snake;

import java.awt.event.KeyEvent;

public class Key implements IKey {
	private IDirection direction;
	private boolean canBePressed;
	public Key(IDirection direction) {
		this.direction=direction;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void Clear() {
		this.canBePressed=true;
	}
	@Override
	/** check wihich key pressed */
	public void keyPressed(KeyEvent e) {
		if(canBePressed) {
			this.canBePressed=false;
			if(e.getKeyCode()==KeyEvent.VK_UP && !direction.isGoingdown()) {
				direction.setGoingup(true);
				direction.setMovemed(true);
			} else if(e.getKeyCode()==KeyEvent.VK_DOWN && !direction.isGoingup()) {
				direction.setGoingdown(true);
				direction.setMovemed(true);
			} else if (e.getKeyCode()==KeyEvent.VK_RIGHT && !direction.isGoingleft()){
				direction.setGoingright(true);
				direction.setMovemed(true);
			} else if(e.getKeyCode()==KeyEvent.VK_LEFT &&  !direction.isGoingright()) {
				direction.setGoingleft(true);
				direction.setMovemed(true);
			}
			
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
