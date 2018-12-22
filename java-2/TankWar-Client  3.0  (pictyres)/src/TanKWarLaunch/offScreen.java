package TanKWarLaunch;

import java.awt.Graphics;
import java.awt.Image;

public class offScreen {

	private Image offScreenImage=null;  //利用双缓冲技术消除闪烁
	public void update(Graphics g) {
		if(offScreenImage==null) {
			offScreenImage=this.createImage(constant.WINDOW_WIDTH,constant.WINDOW_HEIGHT);
			
			Graphics gOff=offScreenImage.getGraphics();
			paint(gOff);
			g.drawImage(offScreenImage,0,0,null);
		}
	}
	private void paint(Graphics gOff) {
		// TODO Auto-generated method stub
		
	}
	private Image createImage(int wINDOW_WIDTH, int wINDOW_HEIGHT) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
