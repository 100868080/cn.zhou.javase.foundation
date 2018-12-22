package TanKWarLaunch;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class TankLaunch extends GameFrame {

	Tank t = new Tank(constant.WINDOW_WIDTH / 2, constant.WINDOW_HEIGHT / 2, this, false,Direction.stop);
	//Tank enemy = new Tank(50, 50, this, true);

	List<Tank> enemyTankList=new ArrayList<Tank>();
	// Bullet b=null;	
	List<Bullet> bulletList = new ArrayList<Bullet>();

	//Explode e=new Explode(200,325,this );
	List<Explode>explodeList=new ArrayList<Explode>();
	
	public void paint(Graphics g) {

		g.drawString("Bullet Count:" + bulletList.size(), 650, 40);
		g.drawString("Explode  Count:"+explodeList.size(),650, 55);
		g.drawString("EnemyTankCount:"+enemyTankList.size(), 650,75);
		t.draw(g);
		//enemy.draw(g);
		for(int i=0;i<enemyTankList.size();i++) {
			Tank enemy=enemyTankList.get(i);
			enemy.draw(g);
		}
		
	
		
		for(int i=0;i<explodeList.size();i++) {
			Explode e=explodeList.get(i);
			e.draw(g);
		}
		//e.draw(g);

		for (int i = 0; i < bulletList.size(); i++) {
			Bullet b = bulletList.get(i);
			// if(b.isLive()==false) bulletList.remove(b);
			// else b.draw(g);
			b.draw(g);
			b.hitEnemyTankList(enemyTankList);
			
			b.hitTank(t);
			//b.hitTank(enemy);
			
			
		}
		
	}


	public void launchFrame() {
		super.launchFrame();

		addKeyListener(new KeyMonitor());

		for(int i=0;i<50;i++) {
			Tank enemyTank=new Tank(10*(i+1)*5,45,this,true,Direction.d);
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
