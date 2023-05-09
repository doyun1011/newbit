package java0508;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {

			ServerThread2 sv = new ServerThread2();
			Thread t1 = new Thread(sv);
			t1.start();
	}

}
