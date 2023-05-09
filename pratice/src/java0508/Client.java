package java0508;

import java.io.BufferedReader;
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
			out = new PrintWriter(socket.getOutputStream());

			ChatInputThread t1 = new ChatInputThread(socket);
			Thread input = new Thread(t1);
			input.start();
			while (true) {
				out = new PrintWriter(socket.getOutputStream());
				System.out.println("메시지를 입력하세요. >>");
				String msg = scan.nextLine();
				out.println(msg);
				out.flush();
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
