package TanKWarLaunch;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 这个类是坦克游戏的启动类
 * 
 * @author zhou
 *
 */

public class TankLaunch extends GameFrame {

	Tank t = new Tank(constant.WINDOW_WIDTH / 2, constant.WINDOW_HEIGHT / 2, false, Direction.stop, this);
	List<Tank> enemyTankList = new ArrayList<Tank>();
	List<Bullet> bulletList = new ArrayList<Bullet>();
	List<Explode> explodeList = new ArrayList<Explode>();

	NetClient nc = new NetClient();

	public void paint(Graphics g) {

		g.drawString("Bullet Count:" + bulletList.size(), 650, 40);
		g.drawString("Explode Count:" + explodeList.size(), 650, 55);
		// g.drawString("EnemyTankCount:" + enemyTankList.size(), 650, 75);
		// g.drawString("My Blood:" + t.getBlood(), 5, 45);
		g.drawString("按F1复活", 5, 60);

		t.draw(g);
		for (int i = 0; i < explodeList.size(); i++) {
			Explode e = explodeList.get(i);
			e.draw(g);
		}

		for (int i = 0; i < bulletList.size(); i++) {
			Bullet b = bulletList.get(i);
			if (b.isLive() == false)
				bulletList.remove(b);
			else
				b.draw(g);
		}

	}

	public void launchFrame() {
		super.launchFrame();
		this.setBackground(Color.gray);
		addKeyListener(new KeyMonitor());
		nc.connect("127.0.0.1", TankServer.TankServer_port);
	}

	public class KeyMonitor extends KeyAdapter {
		public void keyPressed(KeyEvent e) {

			System.out.println("按键:" + e.getKeyCode());
			t.addDirection(e);
		}

		public void keyReleased(KeyEvent e) {
			System.out.println("释放：" + e.getKeyCode());
			t.minusDirection(e);
		}

	}

	public static void main(String[] args) {
		TankLaunch tl = new TankLaunch();
		tl.launchFrame();
	}

}
