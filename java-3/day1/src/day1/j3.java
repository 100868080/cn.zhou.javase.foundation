package day1;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class j3 {
	public static void main(String[] args) {
		Frame f=new Frame("text");
		f.setBounds(990,200,400,400);
		f.setLayout(new FlowLayout());
		TextField tf=new TextField(30);
		TextArea ta=new TextArea(20,45);
		Button bu=new Button("clicked");
		Button bt=new Button("exit");
		
		
		bu.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				String t=tf.getText();
				tf.setText("");
				ta.append(t+"\r\n");
				tf.requestFocus();
			}
			public void mouseClicked(MouseEvent e) {
				String text_str=tf.getText().trim();
				//清空数据
				tf.setText("");
//				ta.setText(text_str+"\n\r");
				ta.append(text_str+"\r\n");
				tf.requestFocus();
			}
		});
		bt.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			
		});
		f.add(tf);
		f.add(bu);
		f.add(bt);
		f.add(ta);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.setVisible(true);
		
	}
}
