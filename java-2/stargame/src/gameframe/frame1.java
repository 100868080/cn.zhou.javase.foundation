package gameframe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class frame1  extends Frame{
	Image img=GameUtil.getImage("stars/sun.jpg");
	
	public void launchFrame() {
		setSize(400,400);
		setLocation(900,150);
		setVisible(true);
		
		new PaintThread().start();
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		
	}
	
	private double x=150,y=100;
	private boolean left;
	private boolean up;
	
	public void paint(Graphics g) {
		
		g.drawImage(img,(int)x,(int)y,null);
		if(left) {
		x-=3;
		//y+=3;
		}else {
			x+=3;
		}
		
		if(x>400-30) {
			left=true;
		}
		if(x<0) {
			left=false;
		}
		if(up) {
			y-=3;
		}else {
			y+=3;
		}
		
		if(y>400-30) {
			up=true;
		}
		if(y<0) {
			up=false;
		}
	}
	
	public class PaintThread extends Thread{
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		frame1 gf=new frame1();
		gf.launchFrame();
	}
}
