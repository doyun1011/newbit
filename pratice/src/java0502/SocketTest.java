package java0502;

import java.io.IOException;
import java.net.Socket;

public class SocketTest {

	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("192.168.0.70", 8111);
			System.out.println("연결되었습니다." +socket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
