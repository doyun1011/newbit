package exam3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;

		FileWriter fw = null;
		BufferedWriter bw = null;
		Scanner scan = new Scanner(System.in);
		
		try {
			serverSocket = new ServerSocket(9999);
			System.out.println("응답대기중...");
			socket = serverSocket.accept();
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("연결되었어요...");
			
			String now = now();
			fw = new FileWriter("chat" + now + ".txt");
			bw = new BufferedWriter(fw);
			
			String msg = "연결되었어요...";
			out.println(msg);
			out.flush();
			
			while (true) {
				msg = in.readLine();
				if (msg.equalsIgnoreCase("bye")) {
					bw.flush();
					break;
				}
				System.out.println("Client >> " + msg);
				bw.write("Client >> " + msg);
				bw.newLine();
				
				System.out.print("클라이언트에게 보낼 메시지를 입력하세요. >>");
				msg = scan.nextLine();
				out.println(msg);
				out.flush();
				bw.write("Server >> " + msg);
				bw.newLine();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
				bw.close();
				in.close();
				out.close();
				socket.close();
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public static String now() {
		LocalDateTime now = LocalDateTime.now();
		String now1 = now.toString();
		String now2 = "";
		for (int i = 0; i < now1.length(); i++) {
			if (i < 2) {
				continue;
			} else if (i % 3 == 1) {
				continue;
			} else if (i > 18) {
				break;
			}

			now2 = now2 + now1.charAt(i);
		}
		return now2;
	}
}
