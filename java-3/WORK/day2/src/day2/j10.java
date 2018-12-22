package day2;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class j1 {
	public static void main(String[]das) throws UnknownHostException {
		InetAddress address=InetAddress.getByName("zhou");
		String name=address.getHostName();
		String ip=address.getHostAddress();
		System.out.println(name+"-----"+ip);
	}
}
