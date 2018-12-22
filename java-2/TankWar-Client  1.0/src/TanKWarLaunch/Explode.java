package TanKWarLaunch;


import java.awt.*;

public class Explode {

	int x,y;
	private boolean live=true;

	int diameter[]= {2,8,12,16,22,26,35,45,52,65,77,56,47,41,36,32,29,25,21,17,15,10,5};
	int step=0;
	
	TankLaunch tl;
	
	public Explode(int x,int y,TankLaunch tl) {
		
		this.x=x;
		this.y=y;
		this.tl=tl;
		
	}
	
	
	public void draw(Graphics g) {
		if(!live) {
			tl.explodeList.remove(this);
			
			return;
		
		}
		
		if(step==diameter.length) {
			live=false;
			step=0;
			return;
		}
		
		Color c=g.getColor();
		g.setColor(Color.red);
		g.fillOval(x, y, diameter[step], diameter[step]);
		step++;
		g.setColor(c);
		
		
	}
}
