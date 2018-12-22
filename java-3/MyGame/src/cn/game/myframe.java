package cn.game;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class myframe extends Frame {
	
	public void launchFrame() {
		setBounds(900,100,300,300);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	
	public static void main(String[] dsa) {
		
		myframe l=new myframe();
		l.launchFrame();
	}
}
