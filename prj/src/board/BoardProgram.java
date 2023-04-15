package board;

public class BoardProgram {

	public static void main(String[] args) throws Exception {
		BoardUI boardUi = new BoardUI();
		int end = 0;
		do {
			boardUi.intro();
			boardUi.printPage();
			boardUi.menuSelect();
			
			end = boardUi.endSelect();
		}while(end != 0);
	}
} 
