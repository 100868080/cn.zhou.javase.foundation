package plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class bullet extends gameObject{
	double degree;
	boolean d;
	public bullet(double x,double y) {
//		this.x=Constant.WINDOW_WIDTH/2 ;
//		this.y=Constant.WINDOW_HEIGHT/2  ;
		degree+=speed*Math.random()*Math.PI*2;

		this.x=x;
		this.y=y;
		
		this. width=10;
		this.height=10;

	}
	
	public bullet(double x,double y,boolean d) {
	  this(x, y);
	  
	  this.d=d;
	}
	
	
	public void draw(Graphics g) {
		
		Color c=g.getColor();
		g.setColor(Color.yellow);
		
		g.fillOval((int)x,(int) y, (int)width, (int)height);
		
		g.setColor(c);
		
		if( d=true) {
			
			
			x+=speed*Math.cos(degree);
		   y+=speed*Math.sin(degree);

		
		
		if(x<0|x>Constant.WINDOW_WIDTH) {
			degree=Math.PI-degree;
		}
		
		if(y<30|y>Constant.WINDOW_HEIGHT) {
			degree=-degree;
		}
		
		}
		
		
		if(d=false) {
			//x+=speed*Math.cos(degree);
			   y-=speed*Math.sin(degree);
			
			
			if(x<0|x>Constant.WINDOW_WIDTH) {
				degree=Math.PI-degree;
			}
			
			if(y<30|y>Constant.WINDOW_HEIGHT) {
				degree=-degree;
			}
		}
		
		
		
	}
	
}
