package exam02;

import java.util.Scanner;

public class StudentTest {
	
	
	public static void main(String[] args) {
		
		StudentManager manager = new StudentManager();
		Scanner scan = new Scanner(System.in);
		System.out.println("�α����� �ʿ��մϴ�.");
		System.out.println("id�� �Է����ּ���.");
		String id = scan.next();
		System.out.println("password�� �Է����ּ���.");
		String password = scan.next();
		
		Login login = new Login();
		if(login.login(id, password) == 2) {
			
			int index = login.key;
			manager.printStudentInfo(index);
		}
		
		
		
	}
}
