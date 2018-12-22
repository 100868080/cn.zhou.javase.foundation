package day1;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class j5 {
	public static void main(String[] ads) {
		Frame f=new JFrame("JFRAME");
		f.setBounds(990,150,300,300);
		f.setLayout(new FlowLayout());
		f.setVisible(true);
		//Dialog dia=new Dialog(f,"dia");
//		Panel p=new Panel();
//		p.setBackground(Color.red);
//		p.setSize(100,430);
//		f.add(p);
		JButton b=new JButton();
		b.setSize(100,100);
		f.add(b);
		//f.add(dia);
		
//		Toolkit t=Toolkit.getDefaultToolkit();
//		
//		Image i=t.getImage("/home/图片/e4.gif");
//		f.setIconImage(i);
//		
		
		b.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}
		});
	}
}
