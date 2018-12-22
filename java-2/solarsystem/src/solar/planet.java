package solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class planet extends star {

	star center;
	double longAxis;
	double shortAxis;
	double speed;
	double degree;

	boolean satellite = true;

	public void draw(Graphics g) {
		// g.drawImage(img,(int)x,(int)y,null);
		super.draw(g);
		if (satellite) {
			drawTrace(g);
		}

		move();
	}

	public void move() {

		x = (center.x + center.width / 2) + longAxis * Math.cos(degree);
		y = (center.y + center.height / 2) + shortAxis * Math.sin(degree);
		degree += speed;
	}

	public void drawTrace(Graphics g) {

		double ovalx, ovaly, ovalwidth, ovalheight;

		ovalx = (center.x + center.width / 2) - longAxis;
		ovaly = (center.y + center.height / 2) - shortAxis;
		ovalwidth = longAxis * 2;
		ovalheight = shortAxis * 2;

		Color c = g.getColor();
		g.setColor(Color.blue);
		g.drawOval((int) ovalx, (int) ovaly, (int) ovalwidth, (int) ovalheight);

		g.setColor(c);

	}

	public planet(star center, String imgpath, double longAxis, double shortAxis, double speed) {

		super(GameUtil.getImage(imgpath));
		this.center = center;
		// this.img=GameUtil.getImage(imgpath);
		this.x = center.x + longAxis;
		this.y = center.y;

		this.speed = speed;
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;

	}

	public  planet(star center, String imgpath, double longAxis, 
			double shortAxis, double speed,boolean satellite) {
       this(center, imgpath, longAxis, shortAxis, speed);
		this.satellite = satellite;

	}

	public planet(Image img, double x, double y) {
		super(img, x, y);
	}

	public planet(String imgpath, double x, double y) {
		super(imgpath, x, y);
	}
}
