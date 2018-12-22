package sokoban;

import java.awt.Color;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

	private final int width = 500;
	private final int height = 560;

	private final int x = 450;
	private final int y = 100;

	public void launch() {
		
		setSize(width, height);
		setLocation(x, y);

		getContentPane().setBackground(Color.magenta);

		
		setVisible(true);
	}
}
