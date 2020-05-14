package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Snake extends Entity implements ISnake {
	private IBodyPart b;
	public ArrayList<IBodyPart> bodyparts;
	private IDirection direction; 
	private int size;
	private int points;

	public Snake(int size,ID id,IDirection direction) {
		super(id);
		points=0;
		bodyparts=new ArrayList<IBodyPart>();
		if(bodyparts.size()==0) {
			b=new BodyPart(15,10,10);
			bodyparts.add(b);
		}
		this.direction=direction;
		this.size=size;
	}
	@Override
	public int getPoints() {
		return points;
	}
	@Override
	public void increasePoints() {
		this.points++;
	}
	@Override
	/** Xcordinate getter @return the xCordinate integer type*/
	public int getHeadXCord() {
		return xcord;
	}
	@Override
	/** Xcordinate setter @param the xCordinate integer type*/
	public void setHeadXCord(int headXCord) {
		this.xcord = headXCord;
	}
	@Override
	/** ycordinate getter @return the yCordinate integer type*/
	public int getHeadYCord() {
		return ycord;
	}
	@Override
	/** add to the snake body a bodypart obejct @param a bodypart object*/
	public void addBodyPart(BodyPart b) {
		bodyparts.add(b);
	}
	@Override
	/** get a snake bodypart from the bodyparts arraylist @param a index integer */
	public IBodyPart getBodyPart(int i) {
		return bodyparts.get(i);
	}
	@Override
	/** get size of the Arraylist @return integer size */
	public int sizeBodyParts() {
		return bodyparts.size();
	}
	@Override
	/** ycordinate setter @param the yCordinate integer type*/
	public void setHeadYCord(int headYCord) {
		this.ycord = headYCord;
	}
	@Override
	/** run every tick set the right cordinate and add a bodypart to the bodyparts and if its bigger than its possible remove one of the bodyparts */
	public void tick() {
		if(direction.isGoingup()) ycord--;
		if(direction.isGoingdown()) ycord++;
		if(direction.isGoingleft()) xcord--;
		if(direction.isGoingright()) xcord++;
		b=Factory.createBodyPart(15, xcord, ycord);
		bodyparts.add(b);
		if(bodyparts.size()>=size) {
			bodyparts.remove(0);
		}
		
	}
	@Override
	/** paint the bodyparts @param Graphics object*/
	public void paint(Graphics g) {
		for (int i = 0; i < bodyparts.size(); i++) {
			if(i==bodyparts.size()-1) {
				bodyparts.get(i).draw(g,Color.YELLOW);
			} else {
				bodyparts.get(i).draw(g,Color.GREEN);
			}
		}
	}

}
