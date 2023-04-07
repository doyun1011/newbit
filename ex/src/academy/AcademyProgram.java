package academy;

public class AcademyProgram {

	public static void main(String[] args) {
		AcademyUI ui = new AcademyUI();
		ui.intro();
		int sel = ui.showLogin();
		System.out.println(sel);
		switch(sel) {
		case -1: 
			ui.showEmpView();
			break;
		case 1:
			ui.showTeacherView();
			break;
		default:
			System.out.println(".....");
		}
		System.out.println("?๋ก๊ทธ?จ? ์ข๋ฃ?ฉ??ค.");
	}

}
