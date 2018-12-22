package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class tcp_server2 {
	public static void main(String[] args) throws IOException {
		
		
		ServerSocket ss=new ServerSocket(1237);
		//监听客户端
		Socket s=ss.accept();
		//包装通道内的流
		
		BufferedReader br=new BufferedReader(new 
			InputStreamReader(s.getInputStream()));
		String line=null;
		while((line=br.readLine())!=null) {
			System.out.println(line);
		}
		
		s.close();
		
		
		
	}
}
