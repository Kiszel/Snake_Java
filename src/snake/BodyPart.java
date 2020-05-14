package snake;


import java.awt.Color;
import java.awt.Graphics;

public class BodyPart implements IBodyPart {
	private int xcord;
	private int ycord;
	private int widthsize;
	private int heightsize;

	public BodyPart(int size, int xcord, int ycord) {
		this.heightsize=size;
		this.widthsize=size;
		this.xcord=xcord;
		this.ycord=ycord;
	}
	@Override
	/** draw the Bodypart @param Graphics object   @param Color object color of the apple*/
	public void draw(Graphics g,Color c) {
		g.setColor(c);
		g.fillRect(xcord * widthsize + 1 , ycord * heightsize +1, widthsize, heightsize);
	}
	@Override
	/** Xcordinate getter @return the xCordinate integer type*/
	public int getXcord() {
		return xcord;
	}

	@Override
	/** Ycordinate getter @return the YCordinate integer type*/
	public int getYcord() {
		return ycord;
	}


}
