package day1;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.Collator;

public class j2 {
	public static void main(String[]aefds) {
		Frame f=new Frame();
		f.setLayout(new FlowLayout());
		f.setBounds(990,300,350,350);
		
		Button bt1=new Button("redbutton");
		Button bt2=new Button("bluebutton");
		bt1.addMouseListener(new MouseListener() {

			
//		    TextField tf=new TextField(32);
//			TextArea ta=new TextArea(10,15);
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				f.setBackground(Color.RED);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				f.setBackground(Color.WHITE);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		bt2.addMouseListener( new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				System.out.println("god");
				f.setBackground(Color.BLUE);
			}
			public void mouseClicked(MouseEvent e) {
				f.setBackground(Color.GRAY);
			}
			public void mouseReleased(MouseEvent e) {
				System.out.println("back");
			}
			public void mousePressed(MouseEvent e) {
				f.setBackground(Color.CYAN);
			}
			public void mouseExited(MouseEvent e) {
				f.setBackground(Color.GREEN);
			}
		});
//		
//		f.add(tf);
//		f.add(ta);

		f.add(bt1);
		f.add(bt2);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
			       System.exit(0);
			}
		});
		f.setVisible(true);
	}
}
