package TanKWarLaunch;

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

	Tank t = new Tank(constant.WINDOW_WIDTH / 2, constant.WINDOW_HEIGHT / 2, this, false, Direction.stop);
	// Tank enemy = new Tank(50, 50, this, true);

	List<Tank> enemyTankList = new ArrayList<Tank>();
	// Bullet b=null;
	List<Bullet> bulletList = new ArrayList<Bullet>();

	// Explode e=new Explode(200,325,this );
	List<Explode> explodeList = new ArrayList<Explode>();

	Wall w1 = new Wall(100, 230, 30, 250, this);
	Wall w2 = new Wall(300, 200, 250, 30, this);

	Blood b = new Blood();

	offScreen off = new offScreen();

	Toolkit tk = Toolkit.getDefaultToolkit();

	public void paint(Graphics g) {

		g.drawString("Bullet Count:" + bulletList.size(), 650, 40);
		g.drawString("Explode  Count:" + explodeList.size(), 650, 55);
		g.drawString("EnemyTankCount:" + enemyTankList.size(), 650, 75);
		g.drawString("My Blood:" + t.getBlood(), 5, 45);
		g.drawString("按F1复活", 5, 60);

		if (enemyTankList.size() <= 0 && t.live) {
			for (int i = 0; i < 10; i++) {
				Tank enemyTank = new Tank(1* (i + 1) , 50, this, true, Direction.d);
				enemyTankList.add(enemyTank);
			}
		}

		t.draw(g);
		t.eatBlood(b);
		for (int i = 0; i < enemyTankList.size(); i++) {
			Tank enemy = enemyTankList.get(i);
			enemy.draw(g);

			enemy.hitWall(w1);
			enemy.hitWall(w2);

			enemy.hitTank(enemyTankList);
		}

		for (int i = 0; i < explodeList.size(); i++) {
			Explode e = explodeList.get(i);
			e.draw(g);
		}

		for (int i = 0; i < bulletList.size(); i++) {
			Bullet b = bulletList.get(i);
			// if(b.isLive()==false) bulletList.remove(b);
			// else b.draw(g);
			b.draw(g);
			b.hitEnemyTankList(enemyTankList);

			b.hitTank(t);
			// b.hitTank(enemy);
			b.hitWall(w1);
			b.hitWall(w2);

		}

		w1.draw(g);
		w2.draw(g);

		b.draw(g);

		////////// off.update(g);

	}

	public void launchFrame() {
		super.launchFrame();

		
		addKeyListener(new KeyMonitor());

		

		Properties properties = new Properties();   //使用property集合 调用文件
		try {
			properties.load(this.getClass().getClassLoader().
					getResourceAsStream("config/tank.properties"));
			
			//properties实例化对象调用配置文件      
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//定义一个变量 获取配置文件的 坦克的数量
		 int tankNum=Integer.parseInt(properties.getProperty("tankCount"));

		for (int i = 0; i < tankNum; i++) { // 添加十辆坦克ss
			Tank enemyTank = new Tank(10 * (i + 1) * 10, 50, this, true, Direction.d);
			enemyTankList.add(enemyTank);
		}

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
