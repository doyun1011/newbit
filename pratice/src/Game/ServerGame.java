package Game;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ServerGame {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		ObjectInputStream in = null;
		ObjectOutputStream out = null;

		MonsterDAO mon = new MonsterDAO();
		ArrayList<MonsterVO> mList = new ArrayList<MonsterVO>();
		Scanner scan = new Scanner(System.in);
		try {
			serverSocket = new ServerSocket(8122);
			System.out.println("연결을 기다리고 있음");

			socket = serverSocket.accept();
			in = new ObjectInputStream(socket.getInputStream());
			out = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("연결완료\n");
			while (true) {
				HeroVO hero = (HeroVO) in.readObject();
				int level = hero.getLevel();
				for (int i = 0; i < 3; i++) {
					MonsterVO monster = mon.callMonster(level);
					int code = 'A' + i;
					monster.setName(monster.getName() + (char) code);
					mList.add(monster);
				}
				Object obj = mList;
				out.writeObject(mList);
				out.flush();

				obj = in.readObject();

			}

			// 레벨별 테이블 테이블에서 랜덤으로 불러오기
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
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
}
