package TanKWarLaunch;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Blood {

	int x, y;
	int width;
	int height;
	int[][] position = { { 300, 360 }, { 305, 370 }, { 400, 412 }, { 60, 23 }, { 123, 60 }, { 465, 321 }, { 46, 300 } };

	int step = 0;

	private boolean live = true;

	public Blood() {
		this.x = position[0][0];
		this.y = position[0][1];
		this.width = 20;
		this.height = 20;
	}

	public void draw(Graphics g) {
		if (!live)
			return;

		Color c = g.getColor();
		g.setColor(Color.MAGENTA);
		g.fillRect(x, y, width, height);
		g.setColor(c);

		move();

	}

	public void move() {
		step++;
		if (step == position.length) {
			step = 0;
		}

		x = position[step][0];
		y = position[step][1];

	}

	public Rectangle getRec() {
		return new Rectangle(x, y, width, height);
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public boolean getLive() {
		return live;
	}

}
