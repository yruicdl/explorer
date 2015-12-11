package socketTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket server = new ServerSocket(6666);
		Socket s = server.accept();
		
		//BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
		long start = System.currentTimeMillis();
		DataInputStream dis = new DataInputStream(new BufferedInputStream(s.getInputStream()));
		String filename = dis.readUTF();
		System.out.println(filename);
		long length = dis.readLong();
		System.out.println(length);
		byte[] buff = new byte[5120];
		
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("C:\\dev\\socket\\out.zip")));
		
		int read = 0;
		long passedln = 0;
		
		while((read=dis.read(buff))!=-1){
			passedln+=read;
			dos.write(buff, 0, read);
			System.out.println("文件"+filename+"已经接收: " + passedln * 100L/ length + "%");
		}
		
		dos.flush();
		long end = System.currentTimeMillis();
		System.out.println("time cost: " + (end-start));
		
//		dos.close();
//		dis.close();
//		s.close();
		
//		while(true){
//			String line = reader.readLine();
//			
//			if (line.equals("end"))
//				break;
//			System.out.println(line);
//		}
		

	}

}