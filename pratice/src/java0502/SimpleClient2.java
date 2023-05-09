package java0502;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SimpleClient2 {

	public static void main(String[] args) {
		Socket socket = null;
		InputStream in = null;
		DataInputStream dis = null;
		try {
			socket = new Socket("192.168.0.70", 8112);
			System.out.println("서버 연결 완료");
			
			in = socket.getInputStream();
			dis = new DataInputStream(in);
			
			String msg = dis.readUTF();
			System.out.println("받은 메시지 : " + msg);
			
		}catch(Exception e) {
			
		}finally {
			try {
				dis.close();
				in.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
