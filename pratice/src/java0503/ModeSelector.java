package java0503;

import java.util.Scanner;

public class ModeSelector {
	Student st = new Student();
	Scanner scan = new Scanner(System.in);
	Object obj;

	public Object modeSelect(int selector) throws Exception {

		switch (selector) {
		case 1:
			// 학생 저장 후 학생 정보 반환
			StudentDTO stu = st.resist();
			obj = stu;
			break;
		case 2:
			// 학생 저장 후 학생 정보 반환
			System.out.print("메시지를 입력하세요. >> ");
			String msg = scan.nextLine();
			obj = msg;
			break;
		default:
			System.out.println("잘못된 입력입니다.");
			break;
		}
		return obj;
	}
}
