package TanKWarLaunch;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class TankClient {

	private Direction dir=Direction.stop;
	
	private final int width=50,height=50;
	
	private int x,y;
	
	Bullet b=null;
	private int SPEED=10;
	TankClient tc;
	
	
	
	public TankClient(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	
	public TankClient(int x,int y,TankClient tc) {
		this(x,y);
		this.tc=tc;
	}
	
	public void draw(Graphics g) {
		
		if(b!=null) {
			b.draw(g);
		}
		
		
		Color c = g.getColor();
		g.setColor(Color.red);
		g.fillOval((int) x, (int) y, (int) width, (int) height);

		g.setColor(c);
		
		move();

	}
	
	boolean left,right,up,down;
	
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
			tc.b = fire();

	}

		locateDirection();

	}

	public void minusDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 65:

			left = false;
			break;

		case 87:
			up = false;
			break;

		case 68:
			right = false;
			break;
		case 83:
			down = false;
			break;

		case 37:
			left = false;
			this.dir = dir.stop;
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

	
		}

		locateDirection();

	}

	public void locateDirection() {

		if(left&&!right&&!up&&!down) this.dir=Direction.l;
		else if(!left&&right&&!up&&!down)  this.dir=Direction.r;
		else if(!left&&!right&&up&&!down)  this.dir=Direction.u;
		else if(!left&&!right&&!up&&down)  this.dir=Direction.d;
		else if(left&&!right&&up&&!down)  this.dir=Direction.lu;
		else if(left&&!right&&!up&&down)  this.dir=Direction.ld;
		else if(!left&&right&&up&&!down)  this.dir=Direction.ru;
		else if(!left&&right&&!up&&down)  this.dir=Direction.rd;
		else if(!right&&!left&&!up&&!down)  this.dir=Direction.stop;

		
 
	}

	private void move() {

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
			y += SPEED;
			break;
			
		case ru:
			x += SPEED;
			y -= SPEED;
			break;
		case rd:
			x += SPEED;
			y += SPEED;
			break;
		case stop:
			break;

		}
	}

	public Bullet fire() {
		int x = this.x + Tank.width/2-b.width/2;
		int y= this.y+Tank.height/2-b.height/2;
		Bullet b = new Bullet(x,  y, dir);

		return b;

	}
	
}
