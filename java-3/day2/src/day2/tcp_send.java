package day2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class tcp_send {
public static void main(String[]args) throws UnknownHostException, IOException {
	Socket s=new Socket("127.168.12.13",9999);
	
	OutputStream os=s.getOutputStream();
	
	os.write("today is rainy".getBytes());
	
	InputStream is=s.getInputStream();
	
	byte[]bys=new byte[1024];
	
	int len=is.read(bys);
	String client=new String(bys,0,len);
	
	System.out.println("client:"+client);
	
	s.close();
	
}
}
