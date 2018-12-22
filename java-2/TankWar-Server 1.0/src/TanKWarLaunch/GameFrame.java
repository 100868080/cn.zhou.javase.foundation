package TanKWarLaunch;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class GameFrame extends Frame {

	public void launchFrame() {
		setSize(constant.WINDOW_WIDTH,constant.WINDOW_HEIGHT);
		setLocation(constant.WINDOW_X,constant.WINDOW_Y);
		
		setTitle("TankWar");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
		setBackground(Color.GREEN);
		
		setBackground(Color.green);
//		PaintThread pt=new PaintThread();
//		Thread t=new Thread(pt);
//		t.start();
		PaintThread t=new PaintThread();
		t.start();
		setName("TankWar");
		setResizable(false);
		setVisible(true);
	}
	
//	int y=300;
//	double degree=3;
//	public void paint(Graphics g) {
//		Color c=g.getColor();
//		g.setColor(Color.red);
//		g.fillOval(200,y,50,50);
//		
//		g.setColor(c);
//		
//		y+=0.3*Math.cos(degree);
//		if(y>constant.WINDOW_HEIGHT |y<30) {
//			degree=-degree;
//		}
//	}
	
	
	
	
	
//	private class PaintThread implements Runnable{
//
//		@Override
//		public void run() {
//
//			while(true) {
//				repaint();
//				try {
//					Thread.sleep(0);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		
//	}
	
	private class PaintThread extends Thread{
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
	
	
//	public static void main(String[]args) {
//		GameFrame gf=new GameFrame();
//		gf.launchFrame();
//	}
	
}
