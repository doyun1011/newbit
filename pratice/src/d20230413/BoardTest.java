package d20230413;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardTest {

	public static void main(String[] args) throws Exception {
		BoardTest bt = new BoardTest();
		BoardDAO boardDao = new BoardDAO();
		
		Scanner sc = new Scanner(System.in);
		int sel = -1;
		
		System.out.println("1. 등록 \t 2. 조회 \t 3. 게시물 선별 조회 \t 0. 종료");
		System.out.print("선택 >> ");
		sel = sc.nextInt();
		sc.nextLine();
		
		if(sel == 1) {
			//등록처리
			//게시물 데이터가 있어야지.(제목, 내용, 작성자, 등록일자)
			System.out.println("게시물 데이터를 입력하세요.");
			System.out.print("제목 >> ");
			String title = sc.nextLine();
			System.out.print("내용 >> ");
			String content = sc.nextLine();
			System.out.print("작성자 >> ");
			String writer = sc.nextLine();
			System.out.print("등록일자 >> ");
			String regDate = sc.nextLine();
			
			BoardVO board = new BoardVO();
			board.setTitle(title);
			board.setContent(content);
			board.setWriter(writer);
			board.setRegDate(regDate);
			
			boardDao.insert(board);
			
			
		}else if(sel == 2) {
			//전체 게시물 조회
			ArrayList<BoardVO> boardList = boardDao.selectAll();
			
			for(BoardVO board : boardList) {
				System.out.println(board);
			}
		}else if(sel == 0) {
			
		}else {
			
		}
	}
	
	void f() {
		
	}

}
