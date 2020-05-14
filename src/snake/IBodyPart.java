package snake;

import java.awt.Color;
import java.awt.Graphics;

public interface IBodyPart {

	void draw(Graphics g, Color c);

	int getXcord();


	int getYcord();

}