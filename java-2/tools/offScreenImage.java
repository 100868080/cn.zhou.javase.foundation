package plane;

import java.awt.Graphics;
import java.awt.Image;

public class offScreenImage {

	private Image offScreenImage=null;  //利用双缓冲技术消除闪烁
	public void update(Graphics g) {
		if(offScreenImage==null) {
			offScreenImage=this.createImage(Constant.WINDOW_WIDTH,Constant.WINDOW_HEIGHT);
			
			Graphics gOff=offScreenImage.getGraphics();
			paint(gOff);
			g.drawImage(offScreenImage,0,0,null);
		}
	}
	
}
