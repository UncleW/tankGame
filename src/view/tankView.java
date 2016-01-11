/**
 * 
 */
package view;

import java.awt.event.KeyListener;

import javax.swing.*;

import controller.mainHandler;

/**
 * @author Administrator
 *
 */
public class tankView extends JFrame{
	tankPanel tp;
	public tankView(){
		tp=new tankPanel();
		this.add(tp);
		this.addKeyListener(new mainHandler(tp));
		this.setSize(400,300);
		this.setVisible(true);
		new Thread(tp).start();
	}
}
