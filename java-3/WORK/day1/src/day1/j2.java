package day1;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class j1 {
	public static void main(String[]args) {
		Frame f=new Frame();
		f.setBounds(300,500,200,200);
		
		Menu m=new Menu();
//		f.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e) {
//				System.exit(0);
//			}
//		});
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}
		});
		
		f.setVisible(true);
	}
}
