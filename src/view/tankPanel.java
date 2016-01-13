/**
 * 
 */
package view;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import model.*;
import util.finalData;

/**
 * @author donutgames@126.com
 *
 */
public class tankPanel extends JPanel implements Runnable{
	/**
	 * 1，坦克在范围内自由移动
	 * 2，坦克子弹可以打死对方
	 * 3，我的坦克死亡后自动归位
	 * 
	 * TODO 坦克死亡后其所发射的子弹不应该消失
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
		g.fillRect(0, 0, finalData.tankPanWidth, finalData.tankPanHeight);
		//显示本方坦克与子弹
		ht1.drawTank(g);
		ht1.drawBullet(g);
		//显示敌方坦克与对应的子弹
		for (int i=0;i<ets.size();i++){
			if(ets.get(i)!=null&&ets.get(i).isAlive()){
				ets.get(i).drawTank(g);
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
		while(true){
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.repaint();
			bulletsOnEnemy();
			bulletsOnMe();
		}
	}
	//判断子弹是否击中敌人
	public void bulletsOnEnemy(){
		for (int i=0;i<ht1.getBullets().size();i++){
			for (int j=0;j<ets.size();j++){
				judgeBul(ets.get(j),ht1.getBullets().get(i));
				if(!ets.get(j).isAlive()){
					ets.remove(j);
				}
			}
		}
	}
	//判断子弹是否击中我
	public void bulletsOnMe(){
		for (int i=0;i<ets.size();i++){
			for (int j=0;j<ets.get(i).getBullets().size();j++){
				judgeBul(ht1,ets.get(i).getBullets().get(j));
				if(!ht1.isAlive()){
					this.ht1=new heroTank(finalData.heroT_x,finalData.heroT_y);
				}
			}
		}
	}
	//判断方法，通过坐标与方向判断
	public void judgeBul(tank t,Bullet bu){
		int bu_x=bu.getX();
		int bu_y=bu.getY();
		int t_x=t.getX();
		int t_y=t.getY();
		int dire=t.getDirect();
		switch (dire){
		case 0:
			if (bu_x<=(t_x+finalData.tankwidth)&&
			bu_y<=(t_y+finalData.tankHeight)&&
			bu_x>=(t_x)&&
			bu_y>=(t_y)){
				t.setAlive(false);
				bu.setInTank(true);
			}
			break;
		case 1:
			if (bu_x<=(t_x+finalData.tankHeight)&&
			bu_y<=(t_y+finalData.tankwidth)&&
			bu_x>=(t_x)&&
			bu_y>=(t_y)){
				t.setAlive(false);
				bu.setInTank(true);
			}
			break;
		case 2:
			if (bu_x<=(t_x+finalData.tankwidth)&&
			bu_y<=(t_y+finalData.tankHeight)&&
			bu_x>=(t_x)&&
			bu_y>=(t_y)){
				t.setAlive(false);
				bu.setInTank(true);
			}
			break;
		case 3:
			if (bu_x<=(t_x+finalData.tankHeight)&&
			bu_y<=(t_y+finalData.tankwidth)&&
			bu_x>=(t_x)&&
			bu_y>=(t_y)){
				t.setAlive(false);
				bu.setInTank(true);
			}
			break;			
		}
	}
}
