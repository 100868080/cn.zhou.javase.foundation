package day2;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class udp_send2 {
public static void main(String[]args) throws IOException {
	DatagramSocket ds=new DatagramSocket();
	
	byte []bys="hello,world".getBytes();
	DatagramPacket dp=new DatagramPacket(bys,
			bys.length,InetAddress.getByName("127.168.12.13"),12345);
	
	ds.send(dp);
	
	ds.close();
	
	
	
}
}
