package model;

import java.util.*;
import util.finalData;

public class enemyTank extends tank implements Runnable{
	public enemyTank(int x,int y){
		super(x,y);
		this.x=x;
		this.y=y;
		this.direct=2;
		this.speed=finalData.speedLevel_2;
		this.tankType=2;
		this.isAlive=true;
		this.isAli=0;
		this.bullets=new Vector<Bullet>();
		this.tankBullets=new Vector<Thread>();
	}

	@Override
	public void run() {
		while(isAlive){
			//随机运动
			if(getChance(finalData.moveChance)){
				this.move();
			}
			//随机发射子弹
			if(getChance(finalData.shootChance)){
				this.ShotBullet();
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean getChance(int j){
		Random rd=new Random();
		int rdNum=Math.abs(rd.nextInt()%100);
		if(rdNum<j){
			return true;
		}
		else return false;
	}
	public void move(){
		if(getChance(20)){
			if(getChance(50)){
				this.direct=(this.direct+1)%4;
			}
			else this.direct=Math.abs((this.direct-1)%4);
		}
		this.tankMove(direct);
	}
}
