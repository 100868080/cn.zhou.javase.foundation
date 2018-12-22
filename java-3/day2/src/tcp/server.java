package tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
	public static void main(String[] args) throws IOException {
		ServerSocket ss=new ServerSocket(1132);
		Socket s=ss.accept();
		
		
		//封装通道内的流
		BufferedInputStream bis=new BufferedInputStream(s.getInputStream());
		BufferedOutputStream bos=new BufferedOutputStream
				(new FileOutputStream("name.jpg"));
		
		
		byte[]bys=new byte[1024];
		
		int len=0;
		while((len=bis.read(bys))!=-1) {
			bos.write(bys,0,len);
		}
		OutputStream os=s.getOutputStream();
		os.write("成功".getBytes());
		bos.close();
		bis.close();
		s.close();
		
		
	}
}
