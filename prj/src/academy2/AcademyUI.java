package academy2;

import java.util.ArrayList;
import java.util.Scanner;

public class AcademyUI {
	
	Scanner sc = new Scanner(System.in);
	AcademyManagementService ams = new AcademyManagementService();
	
	String title = "----- 학원관리 프로그램 -----";
	String empMenu = "===== 직원 메뉴 ====\n1. 학생 등록  2. 학생 조회(전체) 3. 학생 개별 조회  4. 교사등록  5. 교사조회(전체)  0. 종료\n";
	String tcMenu = "***** 교사 메뉴 *****\n1. 학생 전체 조회  0. 종료";
	int menuSel = -99;
	
	public void intro() {
		System.out.println(title);
	}
	public int showLogin(){
		System.out.print("id 입력 >> ");
		String id = sc.next();
		System.out.print("pw 입력 >> ");
		String pw = sc.next();
		int result = ams.loginCheck(id, pw);	
		System.out.println(result);
		return result;
	}
	
	public void showEmpView() {
		while(menuSel != 0) {
			System.out.println(empMenu);
			System.out.print("선택 >> ");
			menuSel = sc.nextInt();
			switch(menuSel) {
			case 1://학생 등록
				StudentVO stu = new StudentVO();
				System.out.print("번호 : ");
				int sno = sc.nextInt();
				System.out.print("이름 : ");
				String name = sc.next();
				System.out.print("나이 : ");
				int age = sc.nextInt();
				System.out.print("과목 : ");
				String subject = sc.next();
				System.out.print("유형 : ");
				char type = sc.next().charAt(0);
				stu.setSno(sno);
				stu.setName(name);
				stu.setAge(age);
				stu.setSubject(subject);
				stu.setType(type);
				
				ams.regist(stu);
				break;
			case 2://학생 조회(전체)
				ArrayList<StudentVO> slist = ams.getStudnetList();
				for(StudentVO s: slist) {
					System.out.println(s);
				}
				break;
			case 3://학생 개별 조회
				System.out.print("조회할 학생 번호 : ");
				sno = sc.nextInt();
				StudentVO s = ams.getStudent(sno);
				if(s != null) {
					System.out.println(s);
				}else {
					System.out.println("해당 번호의 학생은 존재하지 않습니다.");
				}
				break;
			case 4://교사 등록
				TeacherVO tc = new TeacherVO();
				System.out.print("이름 : ");
				name = sc.next();
				System.out.print("나이 : ");
				age = sc.nextInt();
				System.out.print("과목 : ");
				subject = sc.next();
				tc.setName(name);
				tc.setAge(age);
				tc.setSubject(subject);
				ams.regist(tc);
				break;
			case 5://교사 조회(전체)
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
	public int contiue() {
		System.out.print("계속 ? (1: 계속, 0: 그만) >> ");
		int result = sc.nextInt();
		return result;
	}
	
}
