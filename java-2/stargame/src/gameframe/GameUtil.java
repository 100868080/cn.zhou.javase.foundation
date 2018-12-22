package gameframe;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
/*
 * 游戏开发的常用类
 * 工具类
 */
public class GameUtil {
	private GameUtil() {}
	public static  Image getImage(String path) {		
		URL u= GameUtil.class.getClassLoader().getResource(path);
		BufferedImage img=null;
		
		try {
			img=ImageIO.read(u);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}

	private static Object GameClassLoader() {
		// TODO Auto-generated method stub
		return null;
	}

}
