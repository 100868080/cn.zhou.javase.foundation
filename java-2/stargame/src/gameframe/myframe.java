package gameframe;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class myframe extends Frame {
	
	public void launchFrame() {
		 new Frame("Star Frame");
		setSize(Constant.WINDOW_WIDTH, Constant.WINDOW_HEIGHT);
		setLocation(900, 100);

		new PaintThread().start();

		addWindowListener(new windowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setVisible(true);

	}


	public class PaintThread extends  Thread{
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
		myframe mf = new myframe();
		mf.launchFrame();
	}
}
