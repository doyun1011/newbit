package java230410;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DiaryProgram {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("------일기장 프로그램------");
		System.out.println("1. 일기쓰기\t2. 일기보기\t0. 종료");
		System.out.println("메뉴를 선택하세요>>");
		int sel = scan.nextInt();
		switch (sel) {
		case 1:
			String content = "";
			try {
				FileWriter fw = new FileWriter("C:\\temp\\diaryProgram.txt");
				while (true) {
					content = scan.nextLine();
					if (content.equals("일기끝")) {
						fw.close();
						break;
					}
					content = content + "\n";
					fw.write(content);
				}

			} catch (Exception e) {

			}

			break;
		case 2:
			System.out.println("일기를 봅니다.");
			try {

				char[] buffer = new char[20];
				FileReader fr = new FileReader("C:\\temp\\diaryProgram.txt");

				fr.read(buffer);
				for (int i = 0; i < buffer.length; i++) {
					System.out.print(buffer[i]);

				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case 0:
			System.out.println("종료합니다.");
			break;

		default:
			System.out.println("제대로 선택해주세요...");
			break;
		}
	}
}
