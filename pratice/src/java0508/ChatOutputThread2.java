package java0508;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatOutputThread2 implements Runnable{

	Socket socket = null;
	String msg;
	PrintWriter out = null;
	
	public ChatOutputThread2(Socket socket, String msg) {
		this.socket = socket;
		this.msg = msg;
	}
	
	Scanner scan = new Scanner(System.in);
	@Override
	public void run() {
		try {
			while (true) {
			out = new PrintWriter(socket.getOutputStream());
			out.println(msg);
			out.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
