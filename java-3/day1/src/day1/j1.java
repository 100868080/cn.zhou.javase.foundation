package day1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class j1 {
	public static void main(String[]asd) {
		Frame f=new Frame("color");
		f.setBounds(300,300,100,200);
		Button b1=new Button("BU1");
		Button b2=new Button("BU2");
		
		b1.setSize(32,332);

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		     System.out.println("red");
			}
			
		});
		
         b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		       System.out.println("green");
			}
			
		});
		 
         
		b1.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				//System.exit(0);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
			       System.out.println("clicked");

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
			       System.out.println("exited");
			       System.exit(0);

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
			       System.out.println("pressed");

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
			       System.out.println("released");

			}
			
		});
		
		f.add(b1);
		f.add(b2);
		
		f.addWindowListener(new WindowAdapter() {
			@SuppressWarnings("unused")
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		f.setVisible(true);
	}
}
