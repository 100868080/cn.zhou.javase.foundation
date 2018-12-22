package day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class tcp_server3 {
	public static void main(String[] args) throws IOException {
		ServerSocket ss=new ServerSocket(1237);
		
		Socket s=ss.accept();
		
		
		BufferedReader br=newBufferedReader(new InputStreamReader(s.getInputStream())); 
		
		BufferedWriter bw=new BufferedWriter(new FileWriter("a.txt"));
		
		String line=null;
		while((line=br.readLine())!=null) {
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		
		
		bw.close();
		s.close();
	}

	private static BufferedReader newBufferedReader(InputStreamReader inputStreamReader) {
		// TODO Auto-generated method stub
		return null;
	}
}
