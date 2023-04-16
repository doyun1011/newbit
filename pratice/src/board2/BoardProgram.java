package board2;

public class BoardProgram {

	public static void main(String[] args) throws Exception {
		BoardUI ui = new BoardUI();
		int end = 0;
		do {
			ui.intro();
			ui.showPage();
			ui.menuSelect();
			end = ui.selectEnd();
		}while (end != 0);
	} 
}
