package gameframe;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class frame2  extends Frame{
	Image img=GameUtil.getImage("stars/sun.jpg");
	
	public void launchFrame() {
		setSize(400,400);
		setLocation(900,150);
		setVisible(true);
		
		new PaintThread().start();
		
		addWindowListener(new WindowAdapter () {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		
	}
	
	private double x=100,y=100;
	
	private double degree=0;
	private double speed=0;
	public void paint(Graphics g) {
		
		g.drawImage(img,(int)x,(int)y,null);
		
		if(speed>0) {
			speed-=5;
		}else {
			speed=0;
		}
		
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		
		if(y>400-30||y<30) {
			degree=-degree;
		}
		if(x<30||x>400-30) {
			degree=Math.PI-degree;
		}
		
		
	}
	
	public class PaintThread extends Thread{
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(40);
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

