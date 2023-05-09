package java0502;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer1 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		OutputStream out = null;
		try {
			serverSocket = new ServerSocket(8222);
			System.out.println("서버 준비 완료...");
			socket = serverSocket.accept();
			System.out.println("클라이언트 연결완료...");
			byte[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
			out = socket.getOutputStream();
			out.write(arr);
		}catch(Exception e) {
			
		}finally {
			try {
				out.close();
				socket.close();
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
