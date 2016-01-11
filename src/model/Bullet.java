package model;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet implements Runnable{
	private int x;
	private int y;
	private int direct;
	private int isAlive;
	public Bullet(int x,int y,int direct){
		this.x=x;
		this.y=y;
		this.direct=direct;
		this.isAlive=0;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			switch (direct){
			case 0:
				//move up
				y-=4;
				break;
			case 1:
				//move right
				x+=4;
				break;
			case 2:
				//move down 
				y+=4;
				break;
			case 3:
				//move left
				x-=4;
				break;
			}//TODO ×Óµ¯ºÎÊ±ËÀÍö£¿£¿
			
			if (x<0||x>400||y<0||y>300){
				this.isAlive=1;
				break;
			}
			
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public void blow(Graphics g){
		int x=this.x-10;
		int y=this.y-10;
		g.setColor(Color.red);
		g.drawArc(x+5, y, 10, 20, 60, 60);
		g.drawArc(x, y+5, 20, 10, 150, 60);
		g.drawArc(x+5, y, 10, 20, 240, 60);
		g.drawArc(x, y+5, 20, 10, 330, 60);
		g.drawLine(x+2,y+2,x+7,y+7);
		g.drawLine(x+13,y+13,x+18,y+18);
		g.drawLine(x+18,y+2,x+13,y+7);
		g.drawLine(x+2,y+18,x+7,y+13);
	}
	
	public int isAlive() {
		return isAlive;
	}
	public void setAlive(int isAlive) {
		this.isAlive = isAlive;
	}
	
}
