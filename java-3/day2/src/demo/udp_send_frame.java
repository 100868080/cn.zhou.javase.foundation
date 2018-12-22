package demo;

import java.net.DatagramSocket;
import java.net.SocketException;

public class udp_send_frame {
	public static void main(String[] args) throws SocketException {
		
		DatagramSocket dssend=new DatagramSocket();
		DatagramSocket dsreceive=new DatagramSocket(12306);
		
		sendThread st=new sendThread(dssend);
		receiveThread rt=new receiveThread(dsreceive);
		
		
		sendThread t1=new sendThread(st);
		receiveThread t2=new receiveThread(rt);
		
		t1.start();
		t2.start();
		
		
	}
}
