package tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class send {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s=new Socket("127.168.132.13",1132);
		
		
		BufferedInputStream bis=new BufferedInputStream(s.getInputStream());
		
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("Earth.jpg"));
		
		byte[]bs=new byte[1024];
		int len=0;
		while((len=bis.read(bs))!=-1) {
			bos.write(bs,0,len);
			//bos.flush();
		}
		InputStream is=s.getInputStream();
		byte bys[]=new byte[1024];
		int len2=is.read(bys);
		String client=new String(bys,0,len2);
		
		
		
		bis.close();
		s.close();
		
		
	}
}
