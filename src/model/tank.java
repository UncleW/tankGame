/**
 * 
 */
package model;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Administrator
 *
 */
public class tank {
	int x;
	int y;//坦克初始位置xy值
	int direct;//定义坦克方向
	int speed;//坦克移动速度
	int tankType;//坦克类型，0玩家坦克，1~3电脑坦克
	Bullet bu;
	boolean isAlive;
	int isAli;
	public tank(int x,int y){
		this.x=x;
		this.y=y;
	}
	
	public void ShotBullet(){
		switch(direct){
			case 0:
				bu=new Bullet(this.x+10,this.y,direct);
				break;
			case 1:
				bu=new Bullet(this.x+30,this.y+10,direct);
				break;
			case 2:
				bu=new Bullet(x+10,y+30,direct);
				break;
			case 3:
				bu=new Bullet(x,y+10,direct);
				break;
		}
		Thread t=new Thread(bu);
		t.start();
	}
	public void tankDraw(Graphics g){
		switch(tankType){
			case 0:
				g.setColor(Color.yellow);
				break;
			case 1:
				g.setColor(Color.cyan);
				break;
			case 2:
				g.setColor(Color.green);
				break;
			case 3:
				g.setColor(Color.red);
				break;
		}
		switch(direct){
			case 0:
				g.fillRect(x, y+2, 5, 26);
				g.drawRect(x+5, y+5, 10, 20);
				g.fillRect(x+15, y+2, 5, 26);
				g.fillOval(x+5, y+10, 10, 10);
				g.drawLine(x+10, y, x+10, y+10);
				break;
			case 1:
				
				g.fillRect(x+2, y, 26, 5);
				g.drawRect(x+5, y+5, 20, 10);
				g.fillRect(x+2, y+15, 26, 5);
				g.fillOval(x+10, y+5, 10, 10);
				g.drawLine(x+20, y+10, x+30, y+10);
				break;
				//*/
			case 2:
				g.fillRect(x, y+2, 5, 26);
				g.drawRect(x+5, y+5, 10, 20);
				g.fillRect(x+15, y+2, 5, 26);
				g.fillOval(x+5, y+10, 10, 10);
				g.drawLine(x+10, y+20, x+10, y+30);
				break;
			case 3:
				g.fillRect(x+2, y, 26, 5);
				g.drawRect(x+5, y+5, 20, 10);
				g.fillRect(x+2, y+15, 26, 5);
				g.fillOval(x+10, y+5, 10, 10);
				g.drawLine(x, y+10, x+10, y+10);
				break;
				
			
		}
	}
	public void tankBlowStep1(Graphics g){
		g.fillRect(x, y+2, 5, 26);
		g.drawRect(x+5, y+5, 10, 20);
		g.fillRect(x+15, y+2, 5, 26);
		g.fillOval(x+5, y+10, 10, 10);
		g.drawLine(x+10, y, x+10, y+10);
		g.setColor(Color.red);
		g.drawArc(x+5, y+0, 5, 10, 0, 180);
		g.drawArc(x+10, y, 5, 10, 0, 180);
		g.drawArc(x, y+5, 10, 5, 90, 180);
		g.drawArc(x, y+10, 10, 5, 90, 180);
		g.drawArc(x, y+15, 10, 5, 90, 180);
		g.drawArc(x+10, y+5, 10, 5, 270, 180);
		g.drawArc(x+10, y+10, 10, 5, 270, 180);
		g.drawArc(x+10, y+15, 10, 5, 270, 180);
		g.drawArc(x+5, y+15, 5, 10, 180, 180);
		g.drawArc(x+10, y+15, 5, 10, 180, 180);
		
	}
	public void tankBlowStep2(Graphics g){
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
	
	
	
	
	
	public void moveUp(int speed){
		this.y-=speed;
	}
	public void moveDown(int speed){
		this.y+=speed;
	}
	public void moveLeft(int speed){
		this.x-=speed;
	}
	public void moveRight(int speed){
		this.x+=speed;
	}
	
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getDirect(){
		return direct;
	}
	public void setDirect(int direct){
		this.direct=direct;
	}
	public int getTankType(){
		return tankType;
	}
	public void setTankType(int tankType){
		this.tankType=tankType;
	}
	public Bullet getBu() {
		return bu;
	}
	public void setBu(Bullet bu) {
		this.bu = bu;
	}
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	public int getIsAli() {
		return isAli;
	}
	public void setIsAli(int isAli) {
		this.isAli = isAli;
	}
	
	
	
	
	
	
}
