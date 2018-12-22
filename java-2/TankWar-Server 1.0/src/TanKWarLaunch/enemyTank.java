package TanKWarLaunch;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class enemyTank extends GameFrame {

	NetClient nc = new NetClient();
	Tank t = new Tank(100,100,false,Direction.stop,this);
	List<Bullet> bulletList = new ArrayList<Bullet>();

	public void paint(Graphics g) {
		t.draw(g);

		for (int i = 0; i < bulletList.size(); i++) {
			Bullet b = bulletList.get(i);
			if (!b.isLive())
				bulletList.remove(b);
			else
				b.draw(g);
		}
	}

	public void launchFrame() {
		super.launchFrame();
		this.setBackground(Color.gray);
		setTitle("Enemy Tank");

		addKeyListener(new KeyMonitor());
		nc.connect("127.0.0.1", TankServer.TankServer_port);

	}

	public class KeyMonitor extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			System.out.println("按键：" + e.getKeyCode());
			t.addDirection(e);

		}

		public void keyReleased(KeyEvent e) {
			System.out.println("释放：" + e.getKeyCode());
			t.minusDirection(e);
		}
	}

	public static void main(String[] args) {

		enemyTank et = new enemyTank();
		et.launchFrame();
	}
}
