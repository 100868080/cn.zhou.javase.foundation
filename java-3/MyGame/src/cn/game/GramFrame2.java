package cn.game;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
 * 测试各种物体运动轨迹
 */
public class GramFrame2 extends Frame {
Image img=GameUtil.getImage("star/Mars.jpg");
	public void launchFrame() {
		setSize(300,300);
		setLocation(900,100);
		setVisible(true);
		new PaintThread().start();
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	private double x=100,y=150;
	
	private boolean left;
	public void paint(Graphics g) {
		g.drawImage(img,(int)x,(int)y,null);
		if(left) {
			x-=3;
		}else {
			x+=3;
		}
		if(x>500-30) {
			left=true;
		}
		if(x<0){
			left=false;
		}
		//y+=3; 
	}
	
	class PaintThread extends Thread{
		public void run() {
			while(true) {
				repaint();
				
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[]dsa) {
		GameFrame gf=new GameFrame();
		gf.launchFrame();
	}
}
