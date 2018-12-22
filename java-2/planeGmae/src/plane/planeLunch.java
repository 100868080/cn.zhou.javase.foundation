package plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

public class planeLunch extends myFrame {

	Image bg = gameUtil.getImage("stars/bg.jpg");

	// Image plane=gameUtil.getImage("images/plane.png");
	int score;
	double x, y ;

	plane p = new plane("images/plane.png", 100, 50);

	explode bao=new explode(p.x, p.y);
	
	private  Date startTime=new Date();
	Date endTime=new Date();
	//bullet b = new bullet();

	ArrayList<bullet> bulletList = new ArrayList<bullet>();

	public void paint(Graphics g) {

		g.drawImage(bg, 0, 0, null);

		// g.drawImage(plane, Constant.WINDOW_WIDTH/2, Constant.WINDOW_HEIGHT/2, null);
		p.draw(g);

		for (int i = 0; i < bulletList.size(); i++) {
               
		bullet b= bulletList.get(i);
			b.draw(g);

			
			//检测碰撞：
			
			boolean peng=b.getRectangle().intersects(p.getRectangle());
			
			if(peng) {
				System.out.print("********peng!!!!!");
				p.live=false;
				
                 endTime=new Date();
                 
     			int score=(int) (endTime.getTime()-startTime.getTime());
     			if(bao==null) {
     				   bao=new explode(p.x,p.y);
     			}
     			bao.draw(g);

     			break;
			}
			
			if(!p.live) {
				
				String string="GAME OVER ! ! !";
				int size=50;
				printInfo(g,string,size,230,100);
				printInfo(g,"时间:"+score+"秒",50,230,150);
				
			
			}
			printInfo(g,"时间:"+((startTime.getTime())/10000)+"秒",20,600,50);

		}

	}

	
	public void printInfo(Graphics g,String string,int size,double x,double y) {
		  Font f=new Font("宋体",Font.BOLD,size);
		  Color c=g.getColor();
		  g.setColor(Color.red);
		  g.setFont(f);
		  g.drawString(string,(int) x,(int) y);
		  g.setColor(c);
		

			
	}
	class keyMonitor extends KeyAdapter {
		public void keyPressed(KeyEvent e) {

			System.out.println("按键：" + e.getKeyCode());
			// p.move(e);

			p.addDirection(e);
		}

		public void keyReleased(KeyEvent e) {

			System.out.println("释放：" + e.getKeyCode());

			p.minusDirection(e);
		}
	}

	public void launchFrame() {
		super.launchFrame();

		addKeyListener(new keyMonitor());
		// p.addkeyMonitor();

		 for(int i=0;i<50;i++) {
		 bullet b=new bullet(Constant.WINDOW_WIDTH/2,Constant.WINDOW_HEIGHT/2);
		 bulletList.add(b);
		 }
			startTime=new Date();

	}

	public static void main(String[] args) {
		planeLunch pf = new planeLunch();
		pf.launchFrame();
		
		
	}

}
