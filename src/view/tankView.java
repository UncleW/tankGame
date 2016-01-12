/**
 * 
 */
package view;
import javax.swing.*;

import controller.mainHandler;
import util.finalData;

/**
 * @author Administrator
 *
 */
public class tankView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3642934607889655769L;
	tankPanel tp;
	public tankView(){
		tp=new tankPanel();
		this.add(tp);
		this.addKeyListener(new mainHandler(tp));
		this.setSize(finalData.tankPanWidth+16,finalData.tankPanHeight+38);
		this.setVisible(true);
		new Thread(tp).start();
	}
}
