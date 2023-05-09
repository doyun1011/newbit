package exam3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		Scanner scan = new Scanner(System.in);
		try {
			socket = new Socket("localhost", 9999);
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			while (true) {
				String msg = in.readLine();
				System.out.println("Server >> " + msg);

				System.out.print("서버에 보낼 메시지를 입력하세요. >>");
				msg = scan.nextLine();
				if(msg.equalsIgnoreCase("bye")) {
					out.println(msg);
					out.flush();
					break;
				}
				out.println(msg);
				out.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
