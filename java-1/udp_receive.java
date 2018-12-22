import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class udp_receive{
  public static void main(String[]args)throws IOException{
  	DatagramSocket ds=new DatagramSocket(10086);
  	
  	byte bys[]=new byte[1024];
  	int length =bys.length;
  	DatagramPacket dp=new DatagramPacket(bys,length);
  	
  	ds.receive(dp);
  	
  	InetAddress address=dp.getAddress();
  	String ip=address.getHostAddress();
  	byte[]bys2=dp.getData();
  	int len=dp.getLength();
  	String s=new String(bys2,0,len);
  	System.out.println(ip+":"+s);
  	ds.close();
  	
  }
}
