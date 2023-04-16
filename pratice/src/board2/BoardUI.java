package board2;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardUI {

	private String introTitle = "\t\t--------------- Green Comunity ---------------";
	private String menu = "1.글쓰기   2.페이지 이동   3.게시물 보기   4.수정   5.삭제";

	private int pageNum = 1;
	 
	BoardService boardService = new BoardService();
	Scanner scan = new Scanner(System.in);

	public void intro() {
		System.out.println(introTitle);
	}
	
	public void showPage() throws Exception {
		showPageAllBoard();
		showPageListNumber();
	}
	
	private void showPageAllBoard() throws Exception {
		ArrayList<BoardVO2> boardList = boardService.getPageAllBoard(pageNum);
		for(BoardVO2 board : boardList) {
			System.out.println(board);
		}
	}
	private void showPageListNumber() throws Exception {
		int pageCnt = boardService.getTotalPageCnt();
		for (int i = 1; i <= pageCnt; i++) {
			System.out.print(i + "   ");
		}
		System.out.println("현재 페이지: " + pageNum);
	}
	
	public void menuSelect() throws Exception {

		System.out.println(menu);
		int selector = scan.nextInt();

		switch (selector) {
		case 1: 
			System.out.println("제목을 입력하세요.");
			scan.nextLine();
			String title = scan.nextLine();
			System.out.println("내용을 입력하세요.");
			String content = scan.nextLine();
			System.out.println("작성자 닉네임을 입력하세요.");
			String writer = scan.nextLine();
			
			BoardVO2 board = new BoardVO2();
			board.setTitle(title);
			board.setContent(content);
			board.setWriter(writer);
			
			boardService.resistBoard(board);
			
			break;
		case 2: 
			System.out.println("이동할 페이지를 입력하세요.");
			pageNum = scan.nextInt();
			intro();
			showPageAllBoard();
			showPageListNumber();

			break;
		case 3: 
			System.out.println("보고자 하는 게시물의 번호를 입력해주세요.");
			int bno = scan.nextInt();
			BoardVO2 showBoard = boardService.getBoard(bno);
			System.out.println(showBoard);
			System.out.println("내용:  " +showBoard.getContent());
			break;
			
		case 4:
			System.out.println("수정할 게시물의 번호를 입력하세요.");
			int modifyBno = scan.nextInt();
			System.out.println("무엇을 수정하시겠습니까? 1.제목   2.내용");
			int target = scan.nextInt();
			scan.nextLine();
			System.out.println("수정할 값을 적어주세요.");
			String inputData = scan.nextLine();
			
			if(target == 1) {
				boardService.modifyTitle(modifyBno, inputData);
			}else if(target == 2) {
				boardService.modifyContent(modifyBno, inputData);
			}else {
				System.out.println("잘못된 입력입니다.");
			}
			break;
			
		case 5:
			System.out.println("삭제할 게시물의 번호를 입력하세요.");
			int deleteBno = scan.nextInt();
			boardService.deleteBoard(deleteBno);
			break;

		default:
			System.out.println("잘못된 입력입니다.");
			break;
		}

	}
	
	public int selectEnd() {
		System.out.println("계속하시겠습니까?   1.계속하기   0.그만두기");
		int end = scan.nextInt();
		
		return end;
	}

}
