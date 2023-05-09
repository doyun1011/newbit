package java0502;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer2 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		OutputStream out = null;
		DataOutputStream dos = null;
		String str = "이 문자열은 몇 바이트인지 모르겠습니다만...";
		try {
			serverSocket = new ServerSocket(8112);
			System.out.println("서버 준비 완료");
			socket = serverSocket.accept();
			System.out.println("클라이언트 연결 완료...");
			out = socket.getOutputStream();
			dos = new DataOutputStream(out);
			dos.writeUTF(str);
		}catch(Exception e) {
			
		}finally {
			try {
				dos.close();
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
