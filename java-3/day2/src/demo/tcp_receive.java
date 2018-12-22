package demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * tcp协议接收数据
 * 1.创建接收端的socket对象
 * 2.监听客户端链接，返回对应的socket对象
 * 3.获取输入流，读取数据显示在控制台
 * 4.释放资源
 */
public class tcp_receive {
	public static void main(String[]args) throws IOException {
		ServerSocket ss=new ServerSocket(10086);
		Socket s=ss.accept();
		InputStream is=s.getInputStream();
		byte[]bys=new byte[1024];
		int len=is.read(bys);
		String str=new String(bys,0,len);
		System.out.println(str);
		s.close();
		//ss.close();   //服务器不应该关闭
		
		
		
	}
}
