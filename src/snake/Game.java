package snake;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;



public class Game extends Canvas implements Runnable, IGame {
	private static final long  serialVersionUID =5L;
	public static final int WIDTH = 800, HEIGHT = 800;
	private Thread thread;
	private boolean running;
    private long start;

	
	private IHandlrer handler;
	private IKey key;
	private IDirection direction;
	
	public int size=5;
	private Menu menu;
	public STATE gamestate = STATE.MENU;
	


	public void setSnake(ISnake snake) {
		this.snake = snake;
	}

	public void setA(IApple a) {
		this.a = a;
	}
	private ISnake snake;

	private IApple a;
	
	
	@Override
	/** Direction getter @return direction*/
	public IDirection getDirection() {
		return direction;
	}

	public Game() {
		start = System.currentTimeMillis();
		Factory.createScreen(WIDTH,HEIGHT,this);
		direction=Factory.createDirection();
		key=Factory.createKey(direction);
		addKeyListener(key);
		handler=Factory.createHandlrer();
		this.menu=Factory.createMenu(this,handler);
		addMouseListener(this.menu);
	}
    @Override
	/** @return the elapsedTime from the game started*/
	public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
    @Override
    /** set the timer 0*/
	public void cleartheTimer() {
    	start = System.currentTimeMillis();
    }
    @Override
    /** write to the file after end the game */
	public void fileWritter() {
    	File f = new File("dicsoseglista.txt");
    	BufferedWriter bw = null;
    	FileWriter fiw;
			try {
				if (!f.exists()) {
					f.createNewFile();
				}
				fiw = new FileWriter(f,true);
				bw = new BufferedWriter(fiw);
				bw.newLine();
				bw.write("Ennyi almát tudtál fel venni:  "+snake.getPoints()+" "+"Ennyi idő alatt :"+elapsedTime());
				
				System.out.println("File written Successfully");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{ 
				   try{
				      if(bw!=null)
					 bw.close();
				   }catch(Exception ex){
				       System.out.println("Error in closing the BufferedWriter"+ex);
				    }
				}
		}
 
	@Override
	/** run every tick here is the Snake game logic its check if the player is get the apple or if the player collide to the wall or himself  */
	public void tick() {		
		if(gamestate==STATE.GAME){
			if(snake==null) {
				for (int i = 0; i < handler.sizeOfEntitysList(); i++) {
					if(handler.getEntity(i).getId()==ID.Snake) {
						snake=(ISnake) handler.getEntity(i);
					}
					if(handler.getEntity(i).getId()==ID.Apple) {
						a=(IApple)handler.getEntity(i);
					}
				}
			};
		if(snake!=null || a!=null) {
			
			if(snake.getHeadXCord()==51||snake.getHeadYCord()==0||snake.getHeadXCord()==0||snake.getHeadYCord()==50) {
				fileWritter();
				gamestate=STATE.END;
			}
			if(a.getXcord()==snake.getHeadXCord()&& a.getYcord()==snake.getHeadYCord()) {
				a.setXcord(new Random().nextInt(49));
				a.setYcord(new Random().nextInt(49));
				snake.addBodyPart(new BodyPart(15,snake.getHeadXCord(), snake.getHeadYCord()));
				snake.increasePoints();
			}
			handler.tick();
			if(direction.isMovemed() ) {
				for (int i = 0; i < snake.sizeBodyParts()-1; i++) {
					if(snake.getHeadXCord()==snake.getBodyPart(i).getXcord() && snake.getHeadYCord()==snake.getBodyPart(i).getYcord() ){
						System.out.println(i);
						fileWritter();
						gamestate=STATE.END;
					}
				}
			}
		}
		this.key.Clear();
		}else if(gamestate==STATE.MENU || gamestate==STATE.END) {
			if(this.menu!=null) {
				this.menu.tick();
			}
		}
		
	}
	@Override
	/** draw to the canvas */
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs==null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
	
		
		
		g.setColor(Color.WHITE);
		if(gamestate==STATE.GAME){
			if(snake !=null) {
				handler.paint(g);
			g.drawString("Score: " + snake.getPoints(), 10, 86);
			}
		}else if(gamestate==STATE.MENU || gamestate==STATE.SCOREBOARD || gamestate==STATE.END) {
			if(this.menu != null) {
				this.menu.paint(g);
			}
		}
	
		g.dispose();
		bs.show();
		
	}
	@Override
	/** create a new thread and start the game*/
	public synchronized void start() {
		running=true;
		thread=new Thread(this);
		thread.start();
		
	}
	@Override
	/** stop the thread and the game*/
	public synchronized void stop() {
		try {
			thread.join();
			running=false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	/** calculate the frame*/
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks=60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta>=1) {
				tick();
				delta-=1.5;
			}
			if(running) {
				render();
			}
			frames++;
			if(frames>60) {
				frames=0;
			}
			if(System.currentTimeMillis() - timer > 1000) {
				timer +=1000;
				System.out.println("FPS: "+ frames);
			}
		}
	}
	

}
