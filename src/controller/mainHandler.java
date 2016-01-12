package controller;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import model.Bullet;
import util.finalData;
import view.tankPanel;

public class mainHandler implements KeyListener{
	private tankPanel tp;
	public mainHandler(){
		
	}
	public mainHandler(tankPanel tp){
		this.tp=tp;
		
	}
	public void keyPressed(KeyEvent e){
		if (e.getKeyCode()==KeyEvent.VK_UP || e.getKeyCode()==KeyEvent.VK_W){
			tp.getHt1().tankMove(finalData.direction_up);
		}
		else if (e.getKeyCode()==KeyEvent.VK_DOWN || e.getKeyCode()==KeyEvent.VK_S){
			tp.getHt1().tankMove(finalData.direction_down);
		}
		else if (e.getKeyCode()==KeyEvent.VK_LEFT || e.getKeyCode()==KeyEvent.VK_A){
			tp.getHt1().tankMove(finalData.direction_left);
		}
		else if (e.getKeyCode()==KeyEvent.VK_RIGHT || e.getKeyCode()==KeyEvent.VK_D){
			tp.getHt1().tankMove(finalData.direction_right);
		}
		if (e.getKeyCode()==KeyEvent.VK_SPACE){
			tp.getHt1().ShotBullet();
			//tp.getHt1().setAlive(false);
			//System.out.println(tp.getHt1().getBullets().size());
		}
		
		
		
		
		
		
		
		
		
		//TODO !!最后要删的东西!!
		//按下J键子弹爆炸，按下K键显示所有子弹位置的X值；；仅测试用    @TestOnly
		if(e.getKeyCode()==KeyEvent.VK_J){
			if(tp.getHt1().getBullets().get(0)!=null){
				//tp.getHt1().getBullets().get(0).setInTank(true);
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_K){
			for (int i=0;i<tp.getHt1().getBullets().size();i++){
				//System.out.println(tp.getHt1().getBullets().get(i).getX());
			}
		}
		if (e.getKeyCode()==KeyEvent.VK_R){
			tp.getHt1().setBullets(new Vector<Bullet>());
			for(int i=0;i<3;i++){
				tp.getEts().get(i).setBullets(new Vector<Bullet>());
			}
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
