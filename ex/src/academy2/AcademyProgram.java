package academy2;

public class AcademyProgram {

	public static void main(String[] args) {
		AcademyUI ui = new AcademyUI();
		int end = 0;
		do {
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
			end = ui.contiue();
		}while(end != 0);  
		
		
		System.out.println("�봽濡쒓렇�옩�쓣 醫낅즺�빀�땲�떎.");
	}

}
