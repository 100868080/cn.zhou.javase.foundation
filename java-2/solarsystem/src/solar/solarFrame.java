package solar;

import java.awt.Graphics;
import java.awt.Image;

public class solarFrame extends myframe {

	
	Image bg = GameUtil.getImage("stars/bg.jpg");
	
	star sun=new star("stars/sun.jpg",Constant.WINDOW_WIDTH/2,Constant.WINDOW_HEIGHT/2);
	
     planet earth=new planet(sun, "stars/Earth.jpg",80,60,0.1);
     planet moon=new planet(earth,"stars/moon.jpg",30,20,0.3,false);

  
     planet jupiter=new planet(sun, "stars/Jupiter.jpg",130,90,0.2,false);
     
      planet mars=new planet(sun,"stars/Mars.jpg",160,120,0.3);
      
      planet mercury=new planet(sun,"stars/Mercury.jpg",190,150,0.13);
      planet neptune=new planet(sun,"stars/Neptune.jpg",220,180,0.24);
      planet saturn=new planet(sun,"stars/Saturn.jpg",250,210,0.246);
      planet uranus=new planet(sun,"stars/Uranus.jpg",280,240,0.235);
      planet venus=new planet(sun,"stars/Venus.jpg",310,280,0.137);


	public void paint(Graphics g) {

		g.drawImage(bg, 0, 0, null);
		
		sun.draw(g);
		
		earth.draw(g);
		moon.draw(g);
		
		jupiter.draw(g);
		mars.draw(g);
		mercury.draw(g);
		neptune.draw(g);
		saturn.draw(g);
		uranus.draw(g);
		venus.draw(g);
		
		
	}

	
	public static void main(String[]args) {
		
		
		solarFrame sf=new solarFrame();
		
		sf.launch();
	}
}
