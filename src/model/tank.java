package model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

import util.finalData;

/**
 * @author Administrator
 * 各种坦克的父类，包含发射子弹，显示坦克，显示子弹，更新位置等方法
 */
public class tank {
	int x;
	int y;//̹坦克出现坐标
	int direct;//坦克炮口方向
	int speed;//̹坦克移动速度
	int tankType;//̹坦克类型，0~3分别表示玩家坦克、敌人坦克、敌人加强坦克、敌人特强坦克、敌人boss
	Bullet bu;
	boolean isAlive;
	int isAli;
	Thread tankBullet;
	Vector<Bullet> bullets;
	Vector<Thread> tankBullets;
	public tank(int x,int y){
		this.x=x;
		this.y=y;
	}
	
	public void ShotBullet(){
		switch(direct){
			case 0:
				this.bullets.add(new Bullet(this.x+10,this.y,direct));
				break;
			case 1:
				this.bullets.add(new Bullet(this.x+30,this.y+10,direct));
				break;
			case 2:
				this.bullets.add(new Bullet(x+10,y+30,direct));
				break;
			case 3:
				this.bullets.add(new Bullet(x,y+10,direct));
				break;
		}
		if(!bullets.isEmpty()){
			this.tankBullet=new Thread(bullets.get(bullets.size()-1));
		}
		this.tankBullet.start();
		this.tankBullets.add(tankBullet);
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
	public void drawBullet(Graphics g){
		for (int i=0;i<this.getBullets().size();i++){
			if (bullets.get(i)!=null&&(bullets.get(i).isAlive())&&!bullets.get(i).isInTank()){
				g.setColor(Color.yellow);
				g.draw3DRect(bullets.get(i).getX(), bullets.get(i).getY(), 1, 1, false);
			}
			else if(bullets.get(i)!=null&&(bullets.get(i).isInTank())){
				bullets.get(i).blow(g);
			}
			if(!bullets.get(i).isAlive()){
				bullets.remove(i);
			}
		}
	}
	
	public void tankMove(int direct){
		switch (direct){
		case 0:
			if(y>0){this.y-=speed;}
			this.direct=direct;
			break;
		case 1:
			if(x<finalData.tankPanWidth-40){this.x+=speed;}
			this.direct=direct;
			break;
		case 2:
			if(y<finalData.tankPanHeight-40){this.y+=speed;}
			this.direct=direct;
			break;
		case 3:
			if(x>0)this.x-=speed;
			this.direct=direct;
			break;
		}
	}
	
	
	
	//getters and setters
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
	public Thread getTankBullet() {
		return tankBullet;
	}
	public void setTankBullet(Thread tankBullet) {
		this.tankBullet = tankBullet;
	}
	public Vector<Bullet> getBullets() {
		return bullets;
	}
	public void setBullets(Vector<Bullet> bullets) {
		this.bullets = bullets;
	}
	public Vector<Thread> getTankBullets() {
		return tankBullets;
	}
	public void setTankBullets(Vector<Thread> tankBullets) {
		this.tankBullets = tankBullets;
	}
	
}
