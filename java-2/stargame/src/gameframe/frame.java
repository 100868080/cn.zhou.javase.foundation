package gameframe;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class frame {
public static void main(String[]args) {
	Frame f=new Frame();
	f.setBounds(300,300,300,300);
	f.setVisible(true);
	f.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	});
}
}
