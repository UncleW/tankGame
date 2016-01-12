package model;

import java.awt.Color;
import java.awt.Graphics;

import util.finalData;

public class Bullet implements Runnable{
	private int x;
	private int y;
	private int direct;
	private boolean isInTank,isAlive;
	public Bullet(int x,int y,int direct){
		this.x=x;
		this.y=y;
		this.direct=direct;
		this.isInTank=false;//是否碰到坦克（引出爆炸效果）
		this.isAlive=true;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	@Override
	public void run() {
		while(isAlive&&!isInTank){
			
			switch (direct){
			case 0:
				//move up
				y-=finalData.bulletSpeed;
				break;
			case 1:
				//move right
				x+=finalData.bulletSpeed;
				break;
			case 2:
				//move down 
				y+=finalData.bulletSpeed;
				break;
			case 3:
				//move left
				x-=finalData.bulletSpeed;
				break;
			}
			
			if (x<0||x>400||y<0||y>300){
				this.isAlive=false;
				break;
			}
			delayMs(50);
		}
		delayMs(500);
		this.isInTank=false;
		this.isAlive=false;
		
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
		this.isInTank=true;
	}
	
	public boolean isInTank() {
		return isInTank;
	}
	public void setInTank(boolean isInTank) {
		this.isInTank = isInTank;
	}
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAli) {
		this.isAlive = isAli;
	}
	public void delayMs(int i){
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
