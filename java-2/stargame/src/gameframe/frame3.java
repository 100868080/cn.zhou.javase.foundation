package gameframe;

import java.awt.Graphics;
import java.awt.Image;

public class frame3 extends myframe {
	public void run() {}
  Image img=GameUtil.getImage("stars/Earth.jpg");
  
  Image bg=GameUtil.getImage("stars/bg.jpg");
  
  private double x=200;
  private double y=200;
  private double degree=3.14;
  private double speed=12; 
  
  public void paint(Graphics g) {
	  

	  g.drawImage(img, (int)x,(int)y, null);
	  
	  x+=speed*Math.cos(degree);
	  y+=speed*Math.sin(degree);
	  
	  degree+=speed;
	  
	  
	  
	  
  }
  public static void main(String[]args) {
//	  frame3 f=new frame3();
//     	///f.paint(null);
//	  
//	  f.launchFrame();
	  
	  new frame3().launchFrame();
  }
  
}
