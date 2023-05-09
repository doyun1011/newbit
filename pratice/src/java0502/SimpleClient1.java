package java0502;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Arrays;

public class SimpleClient1 {

	public static void main(String[] args) {
		Socket socket = null;
		InputStream in = null;
		try {
			socket = new Socket("192.168.0.70", 8222);
			System.out.println("서버 연결 완료");
			in = socket.getInputStream();
			byte[] basket = new byte[10];
			in.read(basket);
			System.out.println(Arrays.toString(basket));
		} catch (Exception e) {

		} finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
