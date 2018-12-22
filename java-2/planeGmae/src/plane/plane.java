package plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class plane extends gameObject{

	
	
	public void addDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 65:
			left=true;
			break;
		case 68:
			right=true;
			break;
		case 87:
			up=true;
			break;
		case 83:
			down=true;
			break;
	
			
		case 37:
			left=true;
			break;
			
		case 39:
			right=true;
			break;
		case 38:
			up=true;
			break;
		case 40:
			down=true;
			break;
			
		case 32:
			bullet=true;
			break;
		}
		
	}
	
	public void minusDirection(KeyEvent e) {
		switch(e.getKeyCode()){
		case 65:
			left=false;
			break;
		case 68:
			right=false;
			break;
		case 87:
			up=false;
			break;
		case 83:
			down=false;
			break;
			
		case 37:
			left=false;
			break;
			
		case 39:
			right=false;
			break;
			
		case 38:
			up=false;
			break;
		case 40:
			down=false;
			break;
			
		case 32:
			bullet=false;
		}
	}

	boolean left, right, up, down,bullet;

	public void move() {
		// switch(e.getKeyCode()) {
		// case 37:
		// x-=10;
		// break;
		//
		// case 38:
		// y-=10;
		// break;
		// case 39:
		// x+=10;
		// break;
		// case 40:
		// y+=10;
		// break;
		//
		// case 65:
		// x-=10;
		// break;
		//
		// case 87:
		// y-=10;
		// break;
		// case 68:
		// x+=10;
		// break;
		// case 83:
		// y+=10;
		// break;
		// }

		if (left) {
			x -= speed;
		}
		if (right) {
			x += speed;
		}
		if (up) {
			y -= speed;
		}
		if (down) {
			y += speed;
		}
		
		
		
		
	}

	boolean live=true;
	
	int score;
	
	bullet b=new bullet(x,y-10,false);
	
	public void draw(Graphics g) {
		if(live) {
		g.drawImage(img, (int) x, (int) y, null);
		
		
		

		

		move();
		
		if(bullet) {
			b.draw(g);

		}
		 
		
		}
		
	}

	public plane(String imgpath, double x, double y) {
		this.img = gameUtil.getImage(imgpath);
		this.x = x;
		this.y = y;
		
		this.width=img.getWidth(null);
		this.height=img.getHeight(null);
		
		this.speed=speed*3;
		
		
	}

}
