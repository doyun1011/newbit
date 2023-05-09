package java0508;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread implements Runnable {

	@Override
	public void run() {
		Scanner scan = new Scanner(System.in);
		ServerSocket serverSocket = null;
		Socket socket1 = null;
		Socket socket2 = null;
		BufferedReader in = null;
		PrintWriter out1 = null;
		PrintWriter out2 = null;
			try {

				serverSocket = new ServerSocket(5001);
				System.out.println("연결을 기다리고 있음");
				socket1 = serverSocket.accept();
				socket2 = serverSocket.accept();
				out1 = new PrintWriter(socket1.getOutputStream());
				System.out.println("클라이언트1와 연결 되었음...");
				out2 = new PrintWriter(socket2.getOutputStream());
				System.out.println("클라이언트2와 연결 되었음...");
				ChatInputThread t1 = new ChatInputThread(socket1);
				Thread input1 = new Thread(t1);
				ChatOutputThread t2 = new ChatOutputThread(socket1);
				Thread output1 = new Thread(t2);
				
				ChatInputThread t3 = new ChatInputThread(socket2);
				Thread input2 = new Thread(t3);
				ChatOutputThread t4 = new ChatOutputThread(socket2);
				Thread output2 = new Thread(t4);
				while (true) {
				input1.start();
				output1.start();
				input2.start();
				output2.start();
				}
			} catch (Exception e) {

		}
	}

}
