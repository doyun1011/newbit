package academy;

import java.util.ArrayList;
import java.util.Scanner;

public class AcademyUI {
	
	Scanner sc = new Scanner(System.in);
	AcademyManagementService ams = new AcademyManagementService();
	
	String title = "----- ?��?���?�? ?��로그?�� -----";
	String empMenu = "===== 직원 메뉴 ====\n1. ?��?�� ?���?  2. ?��?�� 조회(?���?) 3. ?��?�� 개별 조회  4. 교사?���?  5. 교사조회(?���?)  0. 종료\n";
	String tcMenu = "***** 교사 메뉴 *****\n1. ?��?�� ?���? 조회  0. 종료";
	int menuSel = -99;
	
	public void intro() {
		System.out.println(title);
	}
	public int showLogin(){
		System.out.print("id ?��?�� >> ");
		String id = sc.next();
		System.out.print("pw ?��?�� >> ");
		String pw = sc.next();
		int result = ams.loginCheck(id, pw);	
		System.out.println(result);
		return result;
	}
	
	public void showEmpView() {
		while(menuSel != 0) {
			System.out.println(empMenu);
			System.out.print("?��?�� >> ");
			menuSel = sc.nextInt();
			switch(menuSel) {
			case 1://?��?�� ?���?
				StudentVO stu = new StudentVO();
				System.out.print("번호 : ");
				int sno = sc.nextInt();
				System.out.print("?���? : ");
				String name = sc.next();
				System.out.print("?��?�� : ");
				int age = sc.nextInt();
				System.out.print("과목 : ");
				String subject = sc.next();
				System.out.print("?��?�� : ");
				char type = sc.next().charAt(0);
				stu.setSno(sno);
				stu.setName(name);
				stu.setAge(age);
				stu.setSubject(subject);
				stu.setType(type);
				
				ams.regist(stu);
				break;
			case 2://?��?�� 조회(?���?)
				ArrayList<StudentVO> slist = ams.getStudnetList();
				for(StudentVO s: slist) {
					System.out.println(s);
				}
				break;
			case 3://?��?�� 개별 조회
				System.out.print("조회?�� ?��?�� 번호 : ");
				sno = sc.nextInt();
				StudentVO s = ams.getStudent(sno);
				if(s != null) {
					System.out.println(s);
				}else {
					System.out.println("?��?�� 번호?�� ?��?��?? 존재?���? ?��?��?��?��.");
				}
				break;
			case 4://교사 ?���?
				TeacherVO tc = new TeacherVO();
				System.out.print("?���? : ");
				name = sc.next();
				System.out.print("?��?�� : ");
				age = sc.nextInt();
				System.out.print("과목 : ");
				subject = sc.next();
				break;
			case 5://교사 조회(?���?)
				ArrayList<TeacherVO> tclist = ams.getTeacherList();
				for(TeacherVO teacher: tclist) {
					System.out.println(teacher);
				}
				break;
			case 0://종료
				break;
				
			}
		}
		
	}
	
	public void showTeacherView() {
		System.out.println(tcMenu);
	}
	
}
