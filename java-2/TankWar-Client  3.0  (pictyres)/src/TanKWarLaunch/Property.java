package TanKWarLaunch;

import java.io.IOException;
import java.util.Properties;

public class Property {
	  static Properties properties=new Properties();
	 static {
		 try {
			properties.load(Property.class.getClassLoader().getResourceAsStream("config/tank.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

	public static String getProperties(String key) {
		return properties.getProperty(key);
	}
}
