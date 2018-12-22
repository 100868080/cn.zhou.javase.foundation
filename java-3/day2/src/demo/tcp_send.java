package demo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class tcp_send {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s=new Socket("127.168.12.13",10086);
		
		OutputStream os=s.getOutputStream();
		
		os.write("hello,i go".getBytes());
		
		s.close();
	}
}
