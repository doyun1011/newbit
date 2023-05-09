package java0502;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

	public static void main(String[] args) {
		while (true) {
			Scanner scan = new Scanner(System.in);
			Socket socket = null;
			OutputStream out = null;
			DataOutputStream dos = null;

			try {
				socket = new Socket("192.168.0.70", 8112);
				System.out.println("서버 연결 완료...");
				out = socket.getOutputStream();
				dos = new DataOutputStream(out);
				while (true) {
					System.out.println("서버로 전송할 메시지를 입력하세요.");
					String msg = scan.nextLine();
					dos.writeUTF(msg);
					if (msg.equals("끝")) {
						break;
					}
				}
			} catch (Exception e) {

			} finally {
				try {
					dos.close();
					out.close();
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
