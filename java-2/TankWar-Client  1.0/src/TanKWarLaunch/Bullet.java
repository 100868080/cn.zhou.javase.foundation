package TanKWarLaunch;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

public class Bullet{

	  int x,y;
	static  int width,height;
	private  Direction dir;
	private int speed=50;
	private boolean live=true;
	private TankLaunch tl;
	
	private boolean enemy;
	
	public Bullet(int x,int y,Direction dir) {
		this.x=x;
		this.y=y;
		this.width=20;
		this.height=20;
		this.dir=dir;
	}
	public Bullet(int x,int y,Direction dir,TankLaunch tl,boolean enemy) {
		this(x,y, dir);
		this.tl=tl;
		this.enemy=enemy;
	}
	

	public  void draw(Graphics g) {
		if(live ==false) {
			tl.bulletList.remove(this);
			return ;
		}
		Color c=g.getColor();
		g.setColor(Color.black);
		g.fillOval(x, y, width, height);
		g.setColor(c);

		move();
	
	}


	private void move() {

		switch(dir) {
		case l:
			x-=speed;
			break;
		case r:
			x+=speed;
			break;
		case u:
			y-=speed;
			break;
		case d:
			y+=speed;
		    break;
		case lu:
			x-=speed;
			y-=speed;
			break;
		case ld:
			x-=speed;
			y+=speed;
			break;
		case ru:
			x+=speed;
			y-=speed;
			break;
		case rd:
			x+=speed;
			y+=speed;
			break;
		}
		
		if(x<0||y<0||x>constant.WINDOW_WIDTH||y>constant.WINDOW_HEIGHT) {
			this.live=false;
		}
	}
	
	public boolean isLive() {
		
		return live;
	}
	
	
	public Rectangle getRect() {
		return new Rectangle(x,y,width,height);
		
	}
	
	public boolean hitTank(Tank t) {
		if(this.live&&this.getRect().intersects(t.getRect())&&t.isLive()&&this.enemy!=t.isEnemy()) {
			t.setLive(false);
			Explode e=new Explode(x,y,tl);
			tl.explodeList.add(e);
			return true;
		}
		return false;
		
	}
	
	public boolean hitEnemyTankList (List<Tank> enemyTankList) {
		
		for(int i=0;i<enemyTankList.size();i++) {
			if(hitTank(enemyTankList.get(i))) {
				return true;
			}
		}
		
		
		return false;
		
	}
	
}
