package java0502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		
		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		
		Scanner scan = new Scanner(System.in);
		
		try {
			socket = new Socket("localhost", 5001);
			//print 메서드 사용가능 문자열로 자동변환이 있어 편리하다.
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String msg = "";
			
			while(true) {
				System.out.println("서버로 보낼 문자열을 입력하세요..");
				System.out.println(">>");
				msg = scan.nextLine();
				if(msg.equalsIgnoreCase("quit")) {
					out.println(msg);
					out.flush();
					break;
				}
				out.println(msg);
				out.flush();
				msg = in.readLine();
				System.out.println("서버로부터 온 메시지" + msg);
			}
		} catch (Exception e) {
			
		}finally {
			try {
				scan.close();
				out.close();
				in.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
