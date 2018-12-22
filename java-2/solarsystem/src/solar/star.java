package solar;

import java.awt.Graphics;
import java.awt.Image;

public class star  {

	
	Image img;
	
	double x,y;
	
	int width,height;
	
	public void draw(Graphics g) {
		g.drawImage(img, (int)x,(int)y,null);
	}
	
	
	public star() {
		
	}
	
	public star(Image img) {
		this.img=img;
		this.width=img.getWidth(null);
		this.height=img.getHeight(null);
	}
	public star(Image img,double x,double y) {
//		this.img=img;
		this(img);
		this.x=x;
		this.y=y;
				
	}
	
	
	public star(String imgpath,double x,double y) {
		//this.img=GameUtil.getImage(imgpath);
		this(GameUtil.getImage(imgpath));
		this.x=x;
		this.y=y;
	}
	
	
}
