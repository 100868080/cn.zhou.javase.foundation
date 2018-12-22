package day1;

import java.awt.Component;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class j4 {
	public static void main(String[] ads) {
		Frame f=new Frame("menu");
		f.setBounds(990,200,300,300);
		
		MenuBar mb=new MenuBar();
		Menu me=new Menu("gg");
		MenuItem mi=new MenuItem("ggr");
		
		Menu me2=new Menu("seh");
		MenuItem mi2=new MenuItem("dsasda");
		
		mb.add(me);
		f.setMenuBar(mb);
		me.add(mi);
		me.add(mi2);

		mb.add(me2);
		me2.add(mi2);
		me2.add(mi);
		me2.add(me);
		mi2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}

//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
		});
	f.setVisible(true);
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}
		});
	
	}
}
