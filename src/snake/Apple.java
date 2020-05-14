package snake;

import java.awt.Color;
import java.awt.Graphics;

public class Apple extends Entity implements IApple {

	@Override
	/** Xcordinate getter @return the xCordinate integer type*/
	public int getXcord() {
		return xcord;
	}
	@Override
	/** Xcordinate setter @param the xCordinate integer type*/
	public void setXcord(int xcord) {
		this.xcord = xcord;
	}
	@Override
	/** Ycordinate getter @return the YCordinate integer type*/
	public int getYcord() {
		return ycord;
	}
	@Override
	/** Ycordinate setter @param the YCordinate integer type*/
	public void setYcord(int ycord) {
		this.ycord = ycord;
	}
	public Apple(int size, int xcord, int ycord,ID id) {
		super(id);
		this.heightsize=size;
		this.widthsize=size;
		this.xcord=xcord;
		this.ycord=ycord;
	}
	@Override
	/** draw the apple @param Graphics object   @param Color object color of the apple*/
	public void draw(Graphics g,Color c) {
		g.setColor(c);
		g.fillRect(xcord * widthsize + 2 , ycord * heightsize +2, widthsize, heightsize);
	}
	@Override
	/** its call the draw*/
	public void paint(Graphics g) {
		draw(g,Color.RED);
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	

}
