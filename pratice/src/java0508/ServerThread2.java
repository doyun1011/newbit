package java0508;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread2 implements Runnable {

	@Override
	public void run() {
		Scanner scan = new Scanner(System.in);
		ServerSocket serverSocket = null;
		Socket[] socket = new Socket[5];
		BufferedReader in = null;
		PrintWriter out = null;
		ChatInputThread[] t1 = new ChatInputThread[5];
		ChatOutputThread[] t2 = new ChatOutputThread[5];
		Thread[] input = new Thread[5];
		Thread[] output = new Thread[5];
		try {
			serverSocket = new ServerSocket(5001);
			for (int index = 0; index < socket.length; index++) {

				System.out.println("연결을 기다리고 있음");
				socket[index] = serverSocket.accept();
				out = new PrintWriter(socket[index].getOutputStream());
				System.out.println("클라이언트" + (index + 1) + " 와 연결 되었음...");
				t1[index] = new ChatInputThread(socket[index]);
				t2[index] = new ChatOutputThread(socket[index]);
				input[index] = new Thread(t1[index]);
				output[index] = new Thread(t2[index]);
			}
			System.out.println("입장 완료...");
			int index = 0;
			while (true) {
				if (index == 5) {
					index = 0;
				}
				input[index].start();
				String msg = t1[index].getMsg();
				System.out.println(msg + "안됨");
				out = new PrintWriter(socket[index].getOutputStream());
				out.println(msg);
				out.flush();

				index++;
			}
		} catch (Exception e) {

		}
	}
}
