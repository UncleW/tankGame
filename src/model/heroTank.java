/**
 * 
 */
package model;

import java.util.Vector;

import util.finalData;

/**
 * @author Administrator
 *
 */
public class heroTank extends tank {
	public heroTank(int x,int y){
		super(x,y);
		this.x=x;
		this.y=y;
		this.direct=0;
		this.speed=finalData.speedLevel_1;
		this.tankType=finalData.heroTankType;
		this.isAlive=true;
		this.isAli=0;
		this.bullets=new Vector<Bullet>();
		this.tankBullets=new Vector<Thread>();
	}
}
