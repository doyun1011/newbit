package java0503;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		Socket socket = null;
		ObjectInputStream in = null;
		ObjectOutputStream out = null;

		Scanner scan = new Scanner(System.in);
		StudentDAO dao = new StudentDAO();

		try {
			serverSocket = new ServerSocket(8122);
			System.out.println("연결을 기다리고 있음");

			socket = serverSocket.accept();
			in = new ObjectInputStream(socket.getInputStream());
			out = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("연결완료\n");

			while (true) {
				// Object 받기
				Object inObject = in.readObject();
				// Object 타입이 String일 때 <메시지 받기>
				if (inObject instanceof String) {
					if (inObject.equals("quit")) {
						break;
					}
					String msg = (String) inObject;
					System.out.println("<부산지사> : " + msg);
				}

				// Object 타입이 ArrayList일 때 <학생 정보 저장>
				else if (inObject instanceof ArrayList) {
					System.out.println("부산지사에서 새로운 학생정보를 보냈습니다.");
					// 학생 정보 저장
					for (StudentDTO stu : (ArrayList<StudentDTO>) inObject) {
						dao.resistServer(stu);
					}
					System.out.println("저장완료");
					continue;
				}

				// input 끝난 뒤 메시지 보내기
				System.out.print("메시지를 입력하세요. >> ");
				String msg = scan.nextLine();
				Object outObject = msg;
				out.writeObject(outObject);
				out.flush();
			}
		} catch (Exception e) {

		} finally {
			try {
				out.close();
				in.close();
				socket.close();
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
