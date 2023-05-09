package Game;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientGame {

	public static void main(String[] args) {
		Socket socket = null;
		ObjectInputStream in = null;
		ObjectOutputStream out = null;

		HeroVO hero = new HeroVO();
		HeroDAO dao = new HeroDAO();
		Scanner scan = new Scanner(System.in);
		ArrayList<MonsterVO> mList = new ArrayList<MonsterVO>();
		try {
			socket = new Socket("localhost", 8122);
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
			Hero he = new Hero();
			Monster mon = new Monster();
			Object obj;
			
			
			while (true) {
				int selector = 1;
				if(mList.isEmpty()) {
				hero = dao.Status();
				obj = hero;
				out.writeObject(obj);
				out.flush();
				
					System.out.println("캐릭터 이동 중...");
					Thread.sleep(2000);
					obj = in.readObject();
					mList = (ArrayList<MonsterVO>) obj;
					System.out.println("적과 조우했습니다. 싸우시겠습니까? 1.싸운다.  2.도망친다.");
					selector = scan.nextInt();
				}
				if (selector == 1) {
					for(MonsterVO mons : mList) {
						System.out.print(" \t" + mons.getName());
					}
					System.out.println();
					System.out.print(" 레벨");
					for(MonsterVO mons : mList) {
						System.out.print("\t" + mons.getLevel());
					}
					System.out.println();
					System.out.print(" 생명력");
					for(MonsterVO mons : mList) {
						System.out.print("\t" + mons.getHealth());
					}
					System.out.println("\n");
					
					

					System.out.println(" \t" + hero.getName());
					System.out.println(" 레벨\t" + hero.getLevel());
					System.out.println(" 생명력\t" + hero.getHealth());
					System.out.println();

					System.out.println("공격을 하시겠습니까? 1.베기   ");
					selector = scan.nextInt();
					mList = he.attack(selector, mList, hero);
					if (mList.isEmpty()) {
						System.out.println("적을 모두 처치하셨습니다!!\n");
						obj = mList;
						out.writeObject(obj);
						out.flush();
					}
					else {
					System.out.println("적이 공격할 차례입니다.\n");
					Thread.sleep(2000);
					hero = mon.attack(mList, hero);
					}

				} else if (selector == 2) {
					System.out.println("빠르게 자리에서 벗어난다.");
					System.out.println("이동 중...");
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
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