package demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class receiveThread  implements Runnable{
public static void main(String[]args) {
	
}

private DatagramSocket ds;

public receiveThread(DatagramSocket ds) {
	this.ds=ds;
}

@Override
public void run() {
	// TODO Auto-generated method stub
	while(true)
		try {
			{
				byte[]bys=new byte[1024];
				DatagramPacket dp=new DatagramPacket(bys,bys.length);
				String ip=dp.getAddress().getHostAddress();
				String s=new String(dp.getData(),0,dp.getLength());
System.out.println("from"+ip+"data is:"+s);
				
				try {
					ds.receive(dp);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("---");
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}

private void receive(DatagramPacket dp) {
	// TODO Auto-generated method stub
	
}

public void start() {
	// TODO Auto-generated method stub
	
}
}
