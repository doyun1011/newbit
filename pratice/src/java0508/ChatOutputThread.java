package java0508;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatOutputThread implements Runnable{

	Socket socket = null;
	PrintWriter out = null;
	
	public ChatOutputThread(Socket socket) {
		this.socket = socket;
	}
	
	Scanner scan = new Scanner(System.in);
	@Override
	public void run() {
		try {
			while (true) {
			out = new PrintWriter(socket.getOutputStream());
			System.out.println("메시지를 입력하세요. >>");
			String msg = scan.nextLine();
			out.println(msg);
			out.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
