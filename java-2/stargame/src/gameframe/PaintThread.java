package gameframe;

public class PaintThread extends Thread{
public void run() {
	while(true) {
		repaint();
		
		try {
			Thread.sleep(40);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

private void repaint() {
	// TODO Auto-generated method stub
	
}
}
