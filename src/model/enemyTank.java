package model;

import util.finalData;

public class enemyTank extends tank{
	public enemyTank(int x,int y){
		super(x,y);
		this.x=x;
		this.y=y;
		this.direct=2;
		this.speed=finalData.speedLevel_2;
		this.tankType=2;
	}
	/*
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
	}
	public int getSpeed() {
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
	}//*/
}
