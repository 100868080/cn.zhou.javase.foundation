package day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class tcp_send2 {
	public static void main(String[] args) throws IOException {
		Socket s = new Socket("127.168.12.13", 1237);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

		String line = null;

		while ((line = br.readLine()) != null) {
			if("886".equals(line)){
				break;
			}
			bw.write(line);
			bw.newLine();
			bw.flush();
		}

//		bw.close();
//		br.close();
		s.close();
	}
}
