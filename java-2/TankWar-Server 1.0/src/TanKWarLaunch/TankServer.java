package TanKWarLaunch;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TankServer {

	public static final int TankServer_port = 6666;

	public static void main(String[] args) {

		try {
			ServerSocket ss=new ServerSocket(TankServer_port);
			Socket s=ss.accept();
			System.out.println("A Tank is coming!! "+"   "+"New Tank IP:"+s.getInetAddress()+"New Tank Port:"+s.getPort());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
