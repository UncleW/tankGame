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
 * @author 
 *
 */
public class tankPanel extends JPanel implements Runnable{
	private int direct=0;
	private tank ht1;
	Vector<enemyTank> ets=new Vector<enemyTank>();
	public tankPanel(){
		ht1=new heroTank(finalData.heroT_x,finalData.heroT_y);
		for (int i=0;i<finalData.enemyTanknum;i++){
			ets.add(new enemyTank((i+1)*50,0));
			
		}
	}
	public void paint(Graphics g){
		
		super.paint(g);
		g.fillRect(0, 0, finalData.tankPanWidth, finalData.tankPanHeight);
		ht1.tankDraw(g);
		
		/*
		if(ht1.isAlive()){
			ht1.tankDraw(g);
			System.out.println("alive");
		}else {
			switch(ht1.getIsAli()){
			case 1:
				ht1.tankBlowStep1(g);
				break;
			case 2:
				ht1.tankBlowStep2(g);
				break;
			case 3:
				break;
			}
			
			/*
			//ht1.tankBlowStep1(g);
			System.out.println("dead");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ht1.tankBlowStep2(g);
			System.out.println("dead2");
		}	//*/
		
		for (int i=0;i<ets.size();i++){
			ets.get(i).tankDraw(g);
			//generateTank(ets.get(i),g);
		}
		//»­³ö×Óµ¯
		if (ht1.getBu()!=null&&(ht1.getBu().isAlive()==0)){
			g.draw3DRect(ht1.getBu().getX(), ht1.getBu().getY(), 1, 1, false);
		}
		else if(ht1.getBu()!=null&&(ht1.getBu().isAlive()==1)){
			ht1.getBu().blow(g);
			ht1.getBu().setAlive(ht1.getBu().isAlive()+1);
		}
		if(ets.get(0).getBu()!=null&&(ets.get(0).getBu().isAlive()==0)){
			g.draw3DRect(ets.get(0).getBu().getX(), ets.get(0).getBu().getY(), 1, 1, false);
		}
	}

	public void generateTank(tank t,Graphics g){
		int x=t.getX();
		int y=t.getY();
		int type=t.getTankType();
		int direct=t.getDirect();
		switch(type){
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
	
	/*
	 * 
	 * 
	 * //*/
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
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.repaint();
			
			
			
			
		}
	}
	public void bulletOnEnemy(){
		if(true){
			//this.ets.get(0)
		}
	}
	
	
	
}
