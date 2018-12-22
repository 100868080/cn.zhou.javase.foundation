package day2;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class j1 {
 public static void main(String[]args) throws UnknownHostException {
	 InetAddress address=InetAddress.getByName("162.192.16.12");
	 
	 String name=address.getHostName();
	 
	 String ip=address.getHostAddress();
	 System.out.println(name+"---"+ip);
 }
}
