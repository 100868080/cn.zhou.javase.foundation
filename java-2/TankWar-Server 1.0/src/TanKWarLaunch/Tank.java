package TanKWarLaunch;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Tank {

	int x;
	int y;
	static int width = 50;
	static int height = 50;
	private int SPEED = 10;
	double enemyX, enemyY;
	int enemyWidth, enemyHeight;

	Direction dir = Direction.stop;
	private Direction ptDir = Direction.d;

	TankLaunch tl;

	enemyTank et;

	boolean enemy = true;

	boolean live = true;

	private static Random r = new Random();

	private int oldX, oldY;

	private int blood = 100;

	BloodBar bb = new BloodBar();

	private int steep = r.nextInt(12) + 3;

	public int getBlood() {
		return blood;
	}

	public void setBlood(int breed) {
		this.blood = breed;
	}

	public Tank(int x, int y, boolean enemy, Direction dir) {
		this.x = x;
		this.y = y;
		this.enemy = enemy;
		this.dir = dir;

		this.oldX = oldX;
		this.oldY = oldY;

	}

	public Tank(int x, int y, boolean enemy, Direction dir, TankLaunch tl) {
		this(x, y, enemy, dir);
		this.tl = tl;

	}

	public Tank(int x, int y, boolean enemy, Direction dir, enemyTank et) {
		this(x, y, enemy, dir);
		this.et = et;

	}

	public void draw(Graphics g) {

		if (live == false) {
			if (enemy) {
				tl.enemyTankList.remove(this);
			}

			return;
		}
		Color c = g.getColor();
		if (enemy == true)
			g.setColor(Color.GRAY);
		else
			g.setColor(Color.blue);
		g.fillOval((int) x, (int) y, (int) width, (int) height);

		g.setColor(c);
		move();

		switch (ptDir) {
		case l:
			g.drawLine(x + width / 2, y + height / 2, x, y + height / 2);
			break;
		case lu:
			g.drawLine(x + width / 2, y + height / 2, x, y);
			break;
		case ld:
			g.drawLine(x + width / 2, y + height / 2, x, y + height);
			break;

		case r:
			g.drawLine(x + width / 2, y + Tank.height / 2, x + width, y + height / 2);
			break;
		case ru:
			g.drawLine(x + width / 2, y + height / 2, x + width, y);
			break;
		case rd:
			g.drawLine(x + width / 2, y + height / 2, x + width, y + Tank.height);
			break;
		case u:
			g.drawLine(x + width / 2, y + height / 2, x + width / 2, y);
			break;
		case d:
			g.drawLine(x + width / 2, y + height / 2, x + Tank.width / 2, y + Tank.height);
			break;
		default:
			break;

		}

		if (!enemy)
			bb.draw(g);

	}

	public Rectangle getRect() {
		return new Rectangle(x, y, width, height);
	}

	boolean left, right, up, down, launch;

	public void addDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 65:
			left = true;
			break;

		case 87:
			up = true;
			break;

		case 68:
			right = true;
			break;
		case 83:
			down = true;
			break;

		case 37:
			left = true;
			break;

		case 38:
			up = true;
			break;

		case 39:
			right = true;
			break;
		case 40:
			down = true;
			break;
		case 32:
			fire();
			break;
		case 10:
			superFire();
			break;
		case 27:
			System.exit(0);
			break;
		case 112:
			if (!this.live) {
				this.live = true;
				this.blood = 100;
			}
			break;
		}

		if (this.dir != Direction.stop) {
			this.ptDir = this.dir;
		}
		MOVE();

	}

	public void minusDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 65:

			left = false;
			this.dir = Direction.stop;
			break;

		case 87:
			up = false;
			this.dir = Direction.stop;
			break;

		case 68:
			right = false;
			break;
		case 83:
			down = false;
			break;

		case 37:
			left = false;
			break;

		case 38:
			up = false;
			break;

		case 39:
			right = false;
			break;
		case 40:
			down = false;
			break;

		// case 32:
		// t.b=fire();
		// break;
		}

		MOVE();

	}

	public void MOVE() {

		if (left) {
			this.dir = Direction.l;
		}
		if (right) {
			this.dir = Direction.r;

		}
		if (up) {
			this.dir = Direction.u;
		}

		if (down) {
			this.dir = Direction.d;
		}

		if (left & up) {
			this.dir = Direction.lu;
		}

		if (left & down) {
			this.dir = Direction.ld;
		}

		if (right & up) {
			this.dir = Direction.ru;
		}

		if (right & down) {
			this.dir = Direction.rd;
		}
		if (!left & !right & !up & !down) {
			this.dir = Direction.stop;
		}
	}

	private void stay() {
		x = oldX;
		y = oldY;
	}

	private void move() {

		this.oldX = x;
		this.oldY = y;

		switch (dir) {
		case l:
			x -= SPEED;
			break;
		case r:
			x += SPEED;
			break;
		case u:
			y -= SPEED;
			break;
		case d:
			y += SPEED;
			break;
		case lu:
			x -= SPEED;
			y -= SPEED;
			break;
		case ld:
			x -= SPEED;
			y += 20;
			break;
		case ru:
			x += SPEED;
			y -= SPEED;
			break;
		case rd:
			x += SPEED;
			y += SPEED;
			break;
		default:
			break;

		}

		if (x < 0)
			x = 0;

		if (y < 30)
			y = 30;
		if (x > constant.WINDOW_WIDTH - 20)
			x = constant.WINDOW_WIDTH - Tank.width - 20;
		if (y > constant.WINDOW_HEIGHT - 20)
			y = constant.WINDOW_HEIGHT - Tank.height - 20;

		if (enemy) {
			Direction dirs[] = Direction.values();
			if (steep == 0) {
				steep = r.nextInt(12) + 3;
				int rn = r.nextInt(dirs.length);
				dir = dirs[rn];
			}

			steep--;
			if (r.nextInt(40) > 38)
				this.fire();
		}
	}

	Bullet b = null;

	public Bullet fire() {
		if (!live)
			return null;
		int x = this.x + Tank.width / 2 - b.width / 2;
		int y = this.y + Tank.height / 2 - b.height / 2;
		Bullet b = new Bullet(x, y, ptDir, tl, enemy);
		tl.bulletList.add(b);

		return b;

	}

	public Bullet fire(Direction dir) {
		if (!live)
			return null;
		int x = this.x + Tank.width / 2 - b.width / 2;
		int y = this.y + Tank.height / 2 - b.height / 2;
		Bullet b = new Bullet(x, y, dir, tl, enemy);
		tl.bulletList.add(b);

		return b;

	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public boolean isEnemy() {
		return enemy;

	}

	public boolean hitWall(Wall w) {

		if (this.live && this.getRect().intersects(w.getRect())) {
			this.dir = Direction.stop;
			this.stay();
			return true;
		}

		return false;

	}

	public void superFire() {
		Direction[] superDir = Direction.values();

		for (int i = 0; i < 8; i++) {
			fire(superDir[i]);
		}
	}

	public boolean hitTank(java.util.List<Tank> enemyTankList) {
		for (int i = 0; i < enemyTankList.size(); i++) {

			Tank et = enemyTankList.get(i);
			if (this != et) {
				if (this.live && et.isLive() && this.getRect().intersects(et.getRect())) {
					this.stay();
					et.stay();
					return true;

				}
			}
		}

		return false;

	}

	// public void getBreed() {
	//
	// this.breed = breed;
	// }

	private class BloodBar {

		public void draw(Graphics g) {
			Color c = g.getColor();
			g.setColor(Color.PINK);
			g.drawRect(x, y - 15, width, 10);
			int w = width * blood / 100;
			g.fillRect(x, y - 15, w, 10);
			g.setColor(c);

		}
	}

	public boolean eatBlood(Blood b) {
		if (this.live && this.getRect().intersects(b.getRec())) {
			if (b.getLive()) {
				blood += 20;

			}
			b.setLive(false);
			return true;
		}

		return false;

	}

}
