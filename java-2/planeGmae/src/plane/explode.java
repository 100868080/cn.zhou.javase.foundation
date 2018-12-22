package plane;
import java.awt.Graphics;
import java.awt.Image;

public class explode {

	
	double x,y;
	private int count;

	
	static Image imgs[]=new Image[16];
	static {
	
		for( int i=0;i<16;i++) {
			imgs[i]=gameUtil.getImage("images/e"+(i+1)+".gif");
			imgs[i].getWidth(null);
		}
	}
	
	
	public explode(double x,double y) {
		this.x=x;
		this.y=y;
	}
	
	
	public void draw(Graphics g) {
		
		if(count<16) {
		g.drawImage(imgs[count],(int)x,(int)y,null);
		count++;
		}
	}
	
}
