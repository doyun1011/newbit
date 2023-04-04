package exam02;

import java.util.Scanner;

public class Teacher {

	String id = "admin";
	String password = "1234";

	public static void main(String[] args) {
		Login login = new Login();
		Scanner scan = new Scanner(System.in);
		System.out.println("로그인이 필요합니다.");
		System.out.println("id를 입력해주세요.");
		String id = scan.next();
		System.out.println("password를 입력해주세요.");
		String password = scan.next();
		if (login.login(id, password) == 1) {
			System.out.println("사용할 기능을 선택하세요. 1.학생 등록   2.학생전체조회  3.학생정보수정  4.학생정보삭제");
			int selector = scan.nextInt();
			StudentManager manager = new StudentManager();
			switch (selector) {
			case 1:
				manager.resistStudent();
				manager.printAllStudentInfo(); 
				break;
			case 2:
				manager.printAllStudentInfo();
				break;
			case 3:
				manager.printAllStudentInfo();
				manager.modifyStudentInfo();
				manager.printAllStudentInfo();
				break;
				
			case 4:
				manager.printAllStudentInfo();
				manager.removeStudentInfo();
				manager.printAllStudentInfo();
				break;

			default:
				
				break;
			}
			
			
		}
	}

}
