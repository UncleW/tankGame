package controller;
import java.awt.Event.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import util.finalData;

import java.awt.*;

import view.tankPanel;
import view.tankView;
public class mainHandler implements KeyListener{
	private tankPanel tp;
	public mainHandler(){
		
	}
	public mainHandler(tankPanel tp){
		this.tp=tp;
		
	}
	public void keyPressed(KeyEvent e){
		if (e.getKeyCode()==KeyEvent.VK_UP || e.getKeyCode()==KeyEvent.VK_W){
			tp.getHt1().moveUp(finalData.speedLevel_1);
			tp.getHt1().setDirect(finalData.direction_up);
		}
		else if (e.getKeyCode()==KeyEvent.VK_DOWN || e.getKeyCode()==KeyEvent.VK_S){
			tp.getHt1().moveDown(finalData.speedLevel_1);
			tp.getHt1().setDirect(finalData.direction_down);
		}
		else if (e.getKeyCode()==KeyEvent.VK_LEFT || e.getKeyCode()==KeyEvent.VK_A){
			tp.getHt1().moveLeft(finalData.speedLevel_1);
			tp.getHt1().setDirect(finalData.direction_left);
		}
		else if (e.getKeyCode()==KeyEvent.VK_RIGHT || e.getKeyCode()==KeyEvent.VK_D){
			tp.getHt1().moveRight(finalData.speedLevel_1);
			tp.getHt1().setDirect(finalData.direction_right);
		}
		if (e.getKeyCode()==KeyEvent.VK_SPACE){
			tp.getHt1().ShotBullet();
			
			
			tp.getEts().get(0).ShotBullet();
			tp.getHt1().setAlive(false);
			/*
			tp.getHt1().setIsAli(1);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			tp.getHt1().setIsAli(2);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			tp.getHt1().setIsAli(3);//*/
			//System.out.println(tp.getHt1().getBu().getX());
			//System.out.println(tp.getHt1().getBu().getY());
		}
		if(e.getKeyCode()==KeyEvent.VK_J){
			tp.getHt1().getBu().setAlive(1);
		}
		
		tp.repaint();
		
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
