package gameframe;

import java.awt.Graphics;
import java.awt.Image;

public class solarframe extends myframe {
	
	Image bg=GameUtil.getImage("stars/bg.jpg");
	
	Image sun=GameUtil.getImage("stars/sun.jpg");
	
	public void paint(Graphics g) {
		
		g.drawImage(bg, 0,0,null);
		
		g.drawImage(sun, Constant.WINDOW_WIDTH/2,Constant.WINDOW_HEIGHT/2,null);
		
	}
	
	public static void main(String[] args) {
//		solarframe sol=new solarframe();
//		sol.launchFrame();
		
		new solarframe().launchFrame();
	}

}
