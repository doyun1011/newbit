package academy;

import java.util.ArrayList;
import java.util.Scanner;

public class AcademyUI {
	
	Scanner sc = new Scanner(System.in);
	AcademyManagementService ams = new AcademyManagementService();
	
	String title = "----- ??κ΄?λ¦? ?λ‘κ·Έ?¨ -----";
	String empMenu = "===== μ§μ λ©λ΄ ====\n1. ?? ?±λ‘?  2. ?? μ‘°ν(? μ²?) 3. ?? κ°λ³ μ‘°ν  4. κ΅μ¬?±λ‘?  5. κ΅μ¬μ‘°ν(? μ²?)  0. μ’λ£\n";
	String tcMenu = "***** κ΅μ¬ λ©λ΄ *****\n1. ?? ? μ²? μ‘°ν  0. μ’λ£";
	int menuSel = -99;
	
	public void intro() {
		System.out.println(title);
	}
	public int showLogin(){
		System.out.print("id ?? ₯ >> ");
		String id = sc.next();
		System.out.print("pw ?? ₯ >> ");
		String pw = sc.next();
		int result = ams.loginCheck(id, pw);	
		System.out.println(result);
		return result;
	}
	
	public void showEmpView() {
		while(menuSel != 0) {
			System.out.println(empMenu);
			System.out.print("? ? >> ");
			menuSel = sc.nextInt();
			switch(menuSel) {
			case 1://?? ?±λ‘?
				StudentVO stu = new StudentVO();
				System.out.print("λ²νΈ : ");
				int sno = sc.nextInt();
				System.out.print("?΄λ¦? : ");
				String name = sc.next();
				System.out.print("??΄ : ");
				int age = sc.nextInt();
				System.out.print("κ³Όλͺ© : ");
				String subject = sc.next();
				System.out.print("? ? : ");
				char type = sc.next().charAt(0);
				stu.setSno(sno);
				stu.setName(name);
				stu.setAge(age);
				stu.setSubject(subject);
				stu.setType(type);
				
				ams.regist(stu);
				break;
			case 2://?? μ‘°ν(? μ²?)
				ArrayList<StudentVO> slist = ams.getStudnetList();
				for(StudentVO s: slist) {
					System.out.println(s);
				}
				break;
			case 3://?? κ°λ³ μ‘°ν
				System.out.print("μ‘°ν?  ?? λ²νΈ : ");
				sno = sc.nextInt();
				StudentVO s = ams.getStudent(sno);
				if(s != null) {
					System.out.println(s);
				}else {
					System.out.println("?΄?Ή λ²νΈ? ???? μ‘΄μ¬?μ§? ??΅??€.");
				}
				break;
			case 4://κ΅μ¬ ?±λ‘?
				TeacherVO tc = new TeacherVO();
				System.out.print("?΄λ¦? : ");
				name = sc.next();
				System.out.print("??΄ : ");
				age = sc.nextInt();
				System.out.print("κ³Όλͺ© : ");
				subject = sc.next();
				break;
			case 5://κ΅μ¬ μ‘°ν(? μ²?)
				ArrayList<TeacherVO> tclist = ams.getTeacherList();
				for(TeacherVO teacher: tclist) {
					System.out.println(teacher);
				}
				break;
			case 0://μ’λ£
				break;
				
			}
		}
		
	}
	
	public void showTeacherView() {
		System.out.println(tcMenu);
	}
	
}
