package snake;

import java.awt.Color;
import java.awt.Graphics;

public interface IApple extends IEntity {

	int getXcord();

	void setXcord(int xcord);

	int getYcord();

	void setYcord(int ycord);

	void draw(Graphics g, Color c);

	void paint(Graphics g);

	void tick();

}