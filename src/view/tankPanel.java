/**
 * 
 */
package view;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import controller.*;
import model.*;
import util.finalData;

/**
 * @author donutgames@126.com
 *
 */
public class tankPanel extends JPanel implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 868647902951996246L;
	private int direct=0;
	private tank ht1;
	Vector<enemyTank> ets=new Vector<enemyTank>();
	public tankPanel(){
		ht1=new heroTank(finalData.heroT_x,finalData.heroT_y);
		for (int i=0;i<finalData.enemyTanknum;i++){
			enemyTank et=new enemyTank((i+1)*50,100);
			new Thread(et).start();
			ets.add(et);
			
		}
	}
	public void paint(Graphics g){
		super.paint(g);
		//显示本方坦克
		g.fillRect(0, 0, finalData.tankPanWidth, finalData.tankPanHeight);
		ht1.tankDraw(g);
		//显示子弹
		ht1.drawBullet(g);
		
		//显示敌方坦克与对应的子弹
		for (int i=0;i<ets.size();i++){
			if(ets.get(i)!=null&&ets.get(i).isAlive()){
				ets.get(i).tankDraw(g);
				ets.get(i).drawBullet(g);
			}
		}
	}
	
	
	
	public int getDirect() {
		return direct;
	}
	public void setDirect(int direct) {
		this.direct = direct;
	}
	public tank getHt1() {
		return ht1;
	}
	public void setHt1(heroTank ht1) {
		this.ht1 = ht1;
	}
	
	public Vector<enemyTank> getEts() {
		return ets;
	}
	public void setEts(Vector<enemyTank> ets) {
		this.ets = ets;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.repaint();
			bulletOnEnemy();
		}
	}
	public void bulletOnEnemy(){
		int bu_x;
		int bu_y;
		for (int i=0;i<ht1.getBullets().size();i++){
			bu_x=ht1.getBullets().get(i).getX();
			bu_y=ht1.getBullets().get(i).getY();
			for (int j=0;j<ets.size();j++){
				if (ets.get(j)!=null&&
						bu_x<=(ets.get(j).getX()+finalData.tankwidth)&&
						bu_y<=(ets.get(j).getY()+finalData.tankHeight)&&
						bu_x>=(ets.get(j).getX())&&
						bu_y>=(ets.get(j).getY())){
					ets.get(j).setAlive(false);
					ht1.getBullets().get(i).setInTank(true);
					ets.remove(j);
				}
			}
		}
	}
	
	
	
}
