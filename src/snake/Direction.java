package snake;


public class Direction implements IDirection {
	
	private boolean goingright;
	private boolean goingleft;
	private boolean goingup;
	private boolean goingdown;
	private boolean movemed;
	public Direction() {
		  goingright =false;
		  goingleft =false;
		  goingup =false;
		  goingdown =false;
		  movemed =false;
	}
	@Override
	/** goingright getter @return the goingright boolean type*/
	public boolean isGoingright() {
		return goingright;
	}
	@Override
	/** goingright setter @param the goingright boolean type*/
	public void setGoingright(boolean goingright) {
		this.goingright = goingright;
		  goingleft =false;
		  goingup =false;
		  goingdown =false;
	}
	@Override
	/** goingleft getter @return the goingright boolean type*/
	public boolean isGoingleft() {
		return goingleft;
	}
	@Override
	/** goingleft setter @param the goingleft boolean type*/
	public void setGoingleft(boolean goingleft) {
		this.goingleft = goingleft;
		 goingright =false;
		  goingup =false;
		  goingdown =false;
	}
	@Override
	/** goingup getter @return the goingup boolean type*/
	public boolean isGoingup() {
		return goingup;
		
	}
	@Override
	/** goingup setter @param the goingup boolean type*/
	public void setGoingup(boolean goingup) {
		this.goingup = goingup;
		 goingright =false;
		  goingleft =false;
		  goingdown =false;
	}
	@Override
	/** goingdown getter @return the goingdown boolean type*/
	public boolean isGoingdown() {
		return goingdown;
	}
	@Override
	/** goingdown setter @param the goingdown boolean type*/
	public void setGoingdown(boolean goingdown) {
		this.goingdown = goingdown;
		 goingright =false;
		  goingleft =false;
		  goingup =false;
	}
	@Override
	/** ismovemed getter @return the ismovemed boolean type*/
	public boolean isMovemed() {
		return movemed;
	}
	@Override
	/** ismovemed setter its check if the moved @param the ismovemed boolean type*/
	public void setMovemed(boolean movemed) {
		this.movemed = movemed;
	}


}
