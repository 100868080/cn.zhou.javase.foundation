package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class sendThread implements Runnable{
 private DatagramSocket ds;
	public sendThread(sendThread st) {
		// TODO Auto-generated constructor stub
		this.ds=st;
	}

	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line=null;
		try {
			while((line=br.readLine())!=null) {
				if("886".equals(line)) {
					break;
				}
				byte []bys=line.getBytes();
				DatagramPacket dp=new DatagramPacket(bys,bys.length,
						InetAddress.getByName("127.168.13.12"),12306);
				ds.send(dp);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ds.close();
	
	}

}
