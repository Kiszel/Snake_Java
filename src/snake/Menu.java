package snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Menu extends MouseAdapter implements IMenu{
	
	private Game game;
	private IHandlrer handler;
	private ISnake snake;
	private IApple a;
	public Menu(Game game,IHandlrer handler) {
		this.game=game;
		this.handler=handler;
	}
	@Override
	/** check if mousepressed and if its pressed where if on a block where is action for example if click on the new game its start a new game */
	public void mousePressed(MouseEvent e) {
		int mx=e.getX();
		int my=e.getY();
		
		if(game.gamestate==STATE.MENU) {
			if(mouseOver(mx,my, 300,250,200,64)) {
				game.gamestate=STATE.GAME;
				snake=Factory.createSnake(game.size,ID.Snake,game.getDirection());
				a=Factory.createApple(15,new Random().nextInt(40),new Random().nextInt(40),ID.Apple);
				handler.addEntity(a);
				handler.addEntity(snake);

			}
			if(mouseOver(mx,my, 300,450,200,64)) {
				System.exit(1);
			}
			if(mouseOver(mx,my, 300,350,200,64)) {
				game.gamestate=STATE.SCOREBOARD;
			}
		}else if(game.gamestate==STATE.SCOREBOARD) {
			if(mouseOver(mx,my, 50,50,200,64)) {
				game.gamestate=STATE.MENU;
			}
		}else if(game.gamestate==STATE.END) {
			if(mouseOver(mx,my,100,600,200,64)) {
				game.gamestate=STATE.GAME;
				game.getDirection().setGoingdown(false);
				game.getDirection().setGoingleft(false);
				game.getDirection().setGoingright(false);
				game.getDirection().setGoingup(false);
				game.getDirection().setMovemed(false);
				game.setSnake(null);
				game.setA(null);
				game.cleartheTimer();
				snake=Factory.createSnake(game.size,ID.Snake,game.getDirection());
				a=Factory.createApple(15,new Random().nextInt(40),new Random().nextInt(40),ID.Apple);
				handler.clearEntitys();
				handler.addEntity(a);
				handler.addEntity(snake);
			}
			if(mouseOver(mx,my, 400,600,200,64)) {
				System.exit(1);
			}
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}
	/**
	 *read from a file a sort the file content */
	@Override
	public void fileReader(Graphics g) {
		Font f2=new Font("arial",1,15);
		g.setColor(Color.WHITE);
		g.setFont(f2);
		int y =130;
		File f = new File("dicsoseglista.txt");
		ArrayList<Integer> appleQuantity=new ArrayList<Integer>();
		ArrayList<String> highScore=new ArrayList<String>();
		try {
			FileReader fir = new FileReader(f);
			BufferedReader bir = new BufferedReader(fir);
			while (true) {
				String line = bir.readLine();
				if(line==null) {
					break;
				}
				if(line.isEmpty()){
					break;
				}
				System.out.println(line);
				String[] splittedLine=line.split("  ");
				System.out.println(splittedLine);
				appleQuantity.add(Integer.parseInt(splittedLine[1].split(" ")[0]));
				highScore.add(line);		
				
			}
			for (int i = 0; i < appleQuantity.size()-1; i++) {
	            for (int j = 0; j < appleQuantity.size()-i-1; j++) 
	                if (appleQuantity.get(j) < appleQuantity.get(j+1)) 
	                { 
	                    // swap arr[j+1] and arr[i] 
	                	int temp = appleQuantity.get(j);
		                appleQuantity.set(j,appleQuantity.get(j+1));
		                appleQuantity.set(j+1, temp);
		                String temp2 = highScore.get(j);
		                highScore.set(j,highScore.get(j+1));
		                highScore.set(j+1, temp2);
	                } 
			}
			
			for (int i = 0; i < 10; i++) {
				y+=20;
				if(highScore.size()>i) {
					g.drawString(highScore.get(i),100,y);
				}
			}
			y=100;
			fir.close();
			bir.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/** check if the mouse is over one of the block*/
	private boolean mouseOver(int mx,int my,int x, int y,int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height){
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	@Override
	/** its paint the block of the state*/
	public void paint(Graphics g) {
		if(game.gamestate==STATE.MENU) {
		Font f=new Font("arial",1,50);
		Font f2=new Font("arial",1,30);
		g.setFont(f);
		
		g.setColor(Color.WHITE);
		g.drawString("Menu",320,200);
		
		g.setFont(f2);
		
		g.drawString("Play",320,300);
		g.drawRect(300,250,200,64);
		
		g.drawString("ScoreBoard",320,400);
		g.drawRect(300,350,200,64);
		
		g.drawString("Quit",320,500);		
		g.drawRect(300,450,200,64);
		} else if(game.gamestate==STATE.SCOREBOARD) {
			Font f=new Font("arial",1,50);
			Font f2=new Font("arial",1,30);
			g.setFont(f);
			g.setColor(Color.WHITE);
			g.drawString("ScoreBoard",320,100);
			g.setFont(f2);
			g.setColor(Color.WHITE);
			g.drawRect(0,50,200,64);
			g.drawString("Back",70,100);
			fileReader(g);
			
		}else if(game.gamestate==STATE.END) {
			Font f=new Font("arial",1,50);
			Font f2=new Font("arial",1,30);
			g.setFont(f);
			g.setColor(Color.WHITE);
			g.drawString("Game Over",280,200);
			g.setFont(f2);
			g.drawRect(100,600,200,64);
			g.drawString("Try agian",120,650);
			g.drawRect(400,600,200,64);
			g.drawString("Quit",450,650);
		}
	}
	@Override
	public void tick() {
		
	}
}
