package TanKWarLaunch;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
public class NetClient {

	public void connect(String IP,int port) {
		try {
			Socket s=new Socket(IP,port);
			System.out.println("A Tank connect to server!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}