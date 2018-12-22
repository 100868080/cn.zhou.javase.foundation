package day2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class udp_send {
	public static void main(String[]args) throws IOException {
		
		DatagramSocket ds=new DatagramSocket();
				
		BufferedReader br=new BufferedReader
				(new InputStreamReader(System.in));
		String line=null;
		
		while((line=br.readLine())!=null) {
			
			if("886".equals(line)) {
				break;
			}
			byte []bys=line.getBytes();
//"hello,I'm coming!!"
		int length=bys.length;
		
		InetAddress address=InetAddress.getByName("127.168.12.13");

		int port=10086;
		DatagramPacket dp=new DatagramPacket(bys,length,address,port);
		ds.send(dp);
		}
		ds.close();

	}
}
