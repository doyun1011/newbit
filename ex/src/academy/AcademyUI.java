package academy;

import java.util.ArrayList;
import java.util.Scanner;

public class AcademyUI {
	
	Scanner sc = new Scanner(System.in);
	AcademyManagementService ams = new AcademyManagementService();
	
	String title = "----- ?•™?›ê´?ë¦? ?”„ë¡œê·¸?¨ -----";
	String empMenu = "===== ì§ì› ë©”ë‰´ ====\n1. ?•™?ƒ ?“±ë¡?  2. ?•™?ƒ ì¡°íšŒ(? „ì²?) 3. ?•™?ƒ ê°œë³„ ì¡°íšŒ  4. êµì‚¬?“±ë¡?  5. êµì‚¬ì¡°íšŒ(? „ì²?)  0. ì¢…ë£Œ\n";
	String tcMenu = "***** êµì‚¬ ë©”ë‰´ *****\n1. ?•™?ƒ ? „ì²? ì¡°íšŒ  0. ì¢…ë£Œ";
	int menuSel = -99;
	
	public void intro() {
		System.out.println(title);
	}
	public int showLogin(){
		System.out.print("id ?…? ¥ >> ");
		String id = sc.next();
		System.out.print("pw ?…? ¥ >> ");
		String pw = sc.next();
		int result = ams.loginCheck(id, pw);	
		System.out.println(result);
		return result;
	}
	
	public void showEmpView() {
		while(menuSel != 0) {
			System.out.println(empMenu);
			System.out.print("?„ ?ƒ >> ");
			menuSel = sc.nextInt();
			switch(menuSel) {
			case 1://?•™?ƒ ?“±ë¡?
				StudentVO stu = new StudentVO();
				System.out.print("ë²ˆí˜¸ : ");
				int sno = sc.nextInt();
				System.out.print("?´ë¦? : ");
				String name = sc.next();
				System.out.print("?‚˜?´ : ");
				int age = sc.nextInt();
				System.out.print("ê³¼ëª© : ");
				String subject = sc.next();
				System.out.print("?œ ?˜• : ");
				char type = sc.next().charAt(0);
				stu.setSno(sno);
				stu.setName(name);
				stu.setAge(age);
				stu.setSubject(subject);
				stu.setType(type);
				
				ams.regist(stu);
				break;
			case 2://?•™?ƒ ì¡°íšŒ(? „ì²?)
				ArrayList<StudentVO> slist = ams.getStudnetList();
				for(StudentVO s: slist) {
					System.out.println(s);
				}
				break;
			case 3://?•™?ƒ ê°œë³„ ì¡°íšŒ
				System.out.print("ì¡°íšŒ?•  ?•™?ƒ ë²ˆí˜¸ : ");
				sno = sc.nextInt();
				StudentVO s = ams.getStudent(sno);
				if(s != null) {
					System.out.println(s);
				}else {
					System.out.println("?•´?‹¹ ë²ˆí˜¸?˜ ?•™?ƒ?? ì¡´ì¬?•˜ì§? ?•Š?Šµ?‹ˆ?‹¤.");
				}
				break;
			case 4://êµì‚¬ ?“±ë¡?
				TeacherVO tc = new TeacherVO();
				System.out.print("?´ë¦? : ");
				name = sc.next();
				System.out.print("?‚˜?´ : ");
				age = sc.nextInt();
				System.out.print("ê³¼ëª© : ");
				subject = sc.next();
				break;
			case 5://êµì‚¬ ì¡°íšŒ(? „ì²?)
				ArrayList<TeacherVO> tclist = ams.getTeacherList();
				for(TeacherVO teacher: tclist) {
					System.out.println(teacher);
				}
				break;
			case 0://ì¢…ë£Œ
				break;
				
			}
		}
		
	}
	
	public void showTeacherView() {
		System.out.println(tcMenu);
	}
	
}
