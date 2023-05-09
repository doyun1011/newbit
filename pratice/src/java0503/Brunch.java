package java0503;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Brunch {

	public static void main(String[] args) {
		Socket socket = null;
		ObjectInputStream in = null;
		ObjectOutputStream out = null;

		ModeSelector mode = new ModeSelector();
		ArrayList<StudentDTO> sList = new ArrayList<StudentDTO>();
		Scanner scan = new Scanner(System.in);

		try {
			socket = new Socket("localhost", 8122);
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());

			System.out.println("어떤 업무를 하시겠어요? 1.학생정보 등록   2.채팅");
			int selector = scan.nextInt();

			while (true) {
				// 서버로 보낼 Object 입력 <1.학생 정보 2.문자열>
				Object obj = mode.modeSelect(selector);

				// 입력한 Object가 학생정보일 때
				if (selector == 1) {
					// ArrayList에 Object 저장
					sList.add((StudentDTO) obj);
					System.out.println("더 등록하시겠어요? 1.등록  2.채팅   0.종료");
					int end = scan.nextInt();

					// 반복
					if (end == 1) {
						continue;
					}
					// ArrayList를 서버에 보내고 채팅 시작
					else if (end == 2) {
						obj = sList;
						selector = 2;
						out.writeObject(obj);
						out.flush();
						continue;
					}
					// ArrayList를 서버에 보내고 종료.
					else if (end == 0) {
						obj = sList;
						out.writeObject(obj);
						out.flush();
						break;
					}
				}

				// 채팅용 출력메서드
				out.writeObject(obj);
				out.flush();

				// 서버가 보낸 Object 받기
				Object inObject = in.readObject();
				if (inObject.equals("quit")) {
					break;
				}
				// 출력
				String msg = (String) inObject;
				System.out.println("<본점> : " + msg);
			}

		} catch (Exception e) {

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
