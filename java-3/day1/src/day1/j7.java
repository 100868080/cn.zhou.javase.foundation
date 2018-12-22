package day1;

import java.io.*;

public class j7{
	public static void main(String[]dsa) throws Exception {
		
		File f=new File("a.txt");
     FileWriter w=new FileWriter(f,true);
//		((Object) s).write("go");
 
		w.write("中国");
		w.flush();
		w.close();
	}
}