package exam02;

import java.util.Scanner;

public class Teacher {

	String id = "admin";
	String password = "1234";

	public static void main(String[] args) {
		Login login = new Login();
		Scanner scan = new Scanner(System.in);
		System.out.println("�α����� �ʿ��մϴ�.");
		System.out.println("id�� �Է����ּ���.");
		String id = scan.next();
		System.out.println("password�� �Է����ּ���.");
		String password = scan.next();
		if (login.login(id, password) == 1) {
			System.out.println("����� ����� �����ϼ���. 1.�л� ���   2.�л���ü��ȸ  3.�л���������  4.�л���������");
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
