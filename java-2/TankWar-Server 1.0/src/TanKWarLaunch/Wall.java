package TanKWarLaunch;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Wall {

	int x,y;
	int width,height;
	TankLaunch tl;
	
	
	public Wall(int x,int y,int width,int height,TankLaunch tl) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.tl=tl;
	}
	
	
	public void draw(Graphics g) {
		
		
		g.fillRect(x, y, width, height);
	}
	
	
	public Rectangle getRect() {
		return new Rectangle(x,y,width,height);
	}
	
}
