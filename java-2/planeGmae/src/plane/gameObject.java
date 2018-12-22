package plane;

import java.awt.Image;
import java.awt.Rectangle;

public class gameObject {

	Image img;
	double x,y;
	double width, height;
	double speed=Math.PI;
	
	public gameObject() {
		
	}
	public gameObject(double x,double y,double width,double height,Image img,double speed) {
		this.img=img;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.speed=speed;
	}
	
	public Rectangle getRectangle() {
		return new Rectangle((int) x,(int)y,(int)width,(int)height);
	}
	
}
