package java0508;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Clinet5 {

	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;

		try {
			socket = new Socket("localhost", 5001);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());

			ChatInputThread t1 = new ChatInputThread(socket);
			Thread input = new Thread(t1);
			ChatOutputThread t2 = new ChatOutputThread(socket);
			Thread output = new Thread(t2);
			input.start();
			output.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
