package day2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class senddemo {
	public static void main(String[]ags) throws IOException {
		DatagramSocket ds=new DatagramSocket();
		
		byte[]bys="hello,udp,我来了".getBytes();
		int length=bys.length;
		InetAddress address=InetAddress.getByName("168.192.12.12");
		int port=10086;
		DatagramPacket dp=new DatagramPacket(bys,length,address,port);
		ds.send(dp);
		
		ds.close();
		
	}
}
