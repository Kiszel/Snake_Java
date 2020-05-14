package snake;

import java.awt.Color;
import java.awt.Graphics;

public interface IEntity {

	ID getId();

	void setId(ID id);

	void draw(Graphics g, Color c);

	void paint(Graphics g);

	void tick();

	int getXcord();

	void setXcord(int xcord);

	int getYcord();

	void setYcord(int ycord);

}