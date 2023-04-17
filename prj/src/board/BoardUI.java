package board;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardUI {

	private BoardService boardService = new BoardService();
	private Scanner scan = new Scanner(System.in);

	private String introTitle = "\t\t-------------- greenComunity --------------";
	private String menu = "1.게시글등록    2.페이지변경   3.게시물 보기    4.수정    5.삭제";

	private int pageNum = 1;

	public void intro() {
		System.out.println(introTitle);
	}

	public void printPage() throws Exception {
		// 해당 페이지의 게시물 전체 출력
		ArrayList<BoardVO> boardList = boardService.getPageBoard(pageNum);
		for (BoardVO board : boardList) {
			System.out.println(board);
		}

		// 페이지 하단에 페이지 넘버 출력
		int pageCnt = boardService.getPageCnt();
		for (int i = 1; i <= pageCnt; i++) {
			System.out.print(i + "   ");
		}
		System.out.println("현재 페이지:" + pageNum);
	}

	public void menuSelect() throws Exception {
		// 메뉴
		System.out.println(menu);
		int selector = scan.nextInt();
		scan.nextLine();

		switch (selector) {
		case 1: // 게시물 등록
			BoardVO board = new BoardVO();
			System.out.print("제목을 입력하세요.>>");
			String title = scan.nextLine();
			System.out.print("내용을 입력하세요.>>");
			String content = scan.nextLine();
			System.out.print("닉네임을 입력하세요.>>");
			String writer = scan.nextLine();

			board.setTitle(title);
			board.setContent(content);
			board.setWriter(writer);
			boardService.registPost(board);
			break;

		case 2:// 페이지 이동
			System.out.print("이동할 Page 번호를 입력하세요.>>");
			pageNum = scan.nextInt();
			intro();
			printPage();
			break;

		case 3:// 게시물 조회
			System.out.print("보고 싶은 게시물 번호를 입력하세요.>>");
			int bno = scan.nextInt();
			BoardVO board3 = boardService.showBoard(bno);
			System.out.println(board3);
			System.out.println("내용: " + board3.getContent());
			break;

		case 4:// 게시물 수정
			System.out.print("변경할 게시물의 번호를 입력하세요. >>");
			int modifyBno = scan.nextInt();
			System.out.print("무엇을 수정하시겠습니까? >> 1.제목  2.내용");
			int target = scan.nextInt();
			System.out.print("무엇으로 수정하시겠습니까?");
			scan.nextLine();
			String inputData = scan.nextLine();

			if (target == 1) {
				boardService.modifyTitle(modifyBno, inputData);
			} else if (target == 2) {
				boardService.modifyContent(modifyBno, inputData);
			}
			break;

		case 5:// 게시물 삭제
			System.out.println("삭제할 게시물의 번호를 입력하세요.");
			int deleteBno = scan.nextInt();
			boardService.deletePost(deleteBno);
			break;

		default:
			System.out.println("정상적인 입력값이 아닙니다.");
			break;
		}
	}

	// 종료
	public int endSelect() {
		System.out.println("계속하시겠습니까? 1.계속하기 0. 종료");
		int end = scan.nextInt();

		return end;
	}

}
