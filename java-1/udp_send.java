import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
//import java.net.UnknowHostException;

public class udp_send{
  public static void main(String[]args)throws IOException{
  	DatagramSocket ds=new DatagramSocket();
  	
  	byte[]bys="hello,udp,I'm coming!".getBytes();
  	
  	int length=bys.length;
  	
  	InetAddress address=InetAddress.getByName("192.168.12.13");
  	
  	int port =10086;
  	
  	DatagramPacket dp=new DatagramPacket(bys,length,address,port);
  	
  	ds.send(dp);
  	ds.close();
  	
  }
}
