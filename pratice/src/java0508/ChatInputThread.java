package java0508;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatInputThread implements Runnable {

	String msg;
	Socket socket = null;
	BufferedReader in = null;

	public ChatInputThread(Socket socket) {
		this.socket = socket;
	}

	Scanner scan = new Scanner(System.in);

	@Override
	public void run() {
		try {
			while (true) {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String msg = in.readLine();
				System.out.println("상대가 보냄>>" + msg);
				this.msg = msg;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public String getMsg() {
		return msg;
	}

}
