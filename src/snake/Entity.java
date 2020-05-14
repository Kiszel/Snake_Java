package snake;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Entity implements IEntity {
	protected int xcord=10;
	protected int ycord=10;
	protected int widthsize;
	protected int heightsize;
	public ID getId() {
		return id;
	}
	/** Id setter  @param the id enum boolean type*/
	public void setId(ID id) {
		this.id = id;
	}
	protected ID id;
	public Entity(ID id) {
		this.id=id;
		
	}
	@Override
	/** draw the Entity @param Graphics object   @param Color object color of the Entity*/
	public void draw(Graphics g,Color c) {
		g.setColor(Color.black);
		g.fillRect(xcord * widthsize, ycord * heightsize, widthsize, heightsize);
		g.setColor(c);
		g.fillRect(xcord * widthsize + 2 , ycord * heightsize +2, widthsize, heightsize);
	}
	@Override
	public abstract void paint(Graphics g); 
	@Override
	public abstract void tick();
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

}
