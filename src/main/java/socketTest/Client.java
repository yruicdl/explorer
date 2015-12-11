package socketTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
	
	public static void main(String[] args) throws IOException {
		Socket s = new Socket("localhost",6666);
//		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
//		w.write("hello\n");
//		w.write("world\n");
//		w.write("end");
//		w.flush();
//		w.close();
//		s.close();
		File infile = new File("C:\\dev\\socket\\in.zip");
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(infile)));
		
		//DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		
		dos.writeUTF(infile.getName());
		dos.flush();
		
		dos.writeLong(infile.length());
		dos.flush();
		
		int read = 0;
		byte[] buff = new byte[1024];
		while((read=dis.read(buff))!=-1){
			dos.write(buff, 0, read);
		}
		dos.flush();
		
		dos.close();
		dis.close();
		s.close();
		
		
	}

}
