package board;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardUI {
 
	BoardService boardService = new BoardService();
	Scanner scan = new Scanner(System.in);

	String introTitle = "-------- greenComunity --------";
	String menu = "1.게시글등록    2.페이지변경    3.수정    4.삭제";

	int pageNum = 1;

	public void intro() {
		System.out.println(introTitle);
	}

	public void printPage() throws Exception {
		// 게시물 출력(페이지 이동 유지됨)
		ArrayList<BoardVO> boardList = boardService.getPageBoard(pageNum);
		for (BoardVO boar : boardList) {
			System.out.println(boar);
		}

		// 페이지 하단에 페이지 넘버 출력
		int pageCnt = boardService.getPageCnt();
		for (int i = 1; i <= pageCnt; i++) {
			System.out.print(i + "   ");
		}
		System.out.println();
	}

	public void menuSelect() throws Exception {

		// 메뉴
		System.out.println(menu);
		int selector = scan.nextInt();
		scan.nextLine();

		switch (selector) {
		case 1: // 게시글 등록
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
			boardService.getPageBoard(pageNum);
			break;

		case 3:// 게시글 수정
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

		case 4:// 게시글 삭제
			System.out.println("삭제할 게시물의 번호를 입력하세요.");
			int deleteBno = scan.nextInt();
			boardService.deletePost(deleteBno);
			break;

		default:
			System.out.println("정상적인 입력값이 아닙니다.");
			break;
		}
	}

	public int endSelect() {
		System.out.println("계속하시겠습니까? 1.계속하기 0. 종료");
		int end = scan.nextInt();

		return end;
	}

}
