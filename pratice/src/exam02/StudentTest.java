package exam02;

import java.util.Scanner;

public class StudentTest {
	
	
	public static void main(String[] args) {
		
		StudentManager manager = new StudentManager();
		Scanner scan = new Scanner(System.in);
		System.out.println("로그인이 필요합니다.");
		System.out.println("id를 입력해주세요.");
		String id = scan.next();
		System.out.println("password를 입력해주세요.");
		String password = scan.next();
		
		Login login = new Login();
		if(login.login(id, password) == 2) {
			
			int index = login.key;
			manager.printStudentInfo(index);
		}
		
		
		
	}
}
