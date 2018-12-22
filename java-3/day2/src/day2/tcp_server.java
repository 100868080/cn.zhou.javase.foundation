package day2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class tcp_server {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(9999);
		Socket s = ss.accept();
		InputStream is = s.getInputStream();

		byte[] bys = new byte[1024];
		int len = is.read(bys);
		String server = new String(bys, 0, len);

		System.out.println("server:" + server);

		OutputStream os = s.getOutputStream();
		os.write("数据已收到".getBytes());
		s.close();

	}
}
