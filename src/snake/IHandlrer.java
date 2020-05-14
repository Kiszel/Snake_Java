package snake;

import java.awt.Graphics;

public interface IHandlrer {

	int sizeOfEntitysList();

	void tick();

	void paint(Graphics g);

	void addEntity(IEntity e);

	void removeEntity(IEntity e);

	void clearEntitys();

	IEntity getEntity(int i);

}