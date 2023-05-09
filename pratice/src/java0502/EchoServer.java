package java0502;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream in = null;
		DataInputStream dis = null;

		try {
			serverSocket = new ServerSocket(8112);
			System.out.println("서버 준비 완료");
			socket = serverSocket.accept();
			System.out.println("클라이언트 연결 완료");

			in = socket.getInputStream();
			dis = new DataInputStream(in);
			while (true) {
				String userMsg = dis.readUTF();
				System.out.println("사용자 메시지 : " + userMsg);
				if (userMsg.equals("끝")) {
					break;
				}
			}
		} catch (Exception e) {

		} finally {
			try {
				dis.close();
				in.close();
				socket.close();
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
