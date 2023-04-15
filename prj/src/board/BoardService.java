package board;

import java.util.ArrayList;

public class BoardService {

	BoardDAO dao = new BoardDAO();

	// 게시글 등록
	public void registPost(BoardVO board) throws Exception {
		dao.registPost(board);
	}

	// 첫 페이지 게시글 목록 조회
	public ArrayList<BoardVO> getFirstPage() throws Exception {
		ArrayList<BoardVO> boardList = dao.getFirstPage();
		return boardList;
	}

	// 입력받은 페이지의 게시글 목록 조회
	public ArrayList<BoardVO> getPageBoard(int pageNum) throws Exception {
		return dao.getPageBoard(pageNum);
	}

	// 게시글 제목 수정
	public ArrayList<BoardVO> modifyTitle(int bno, String inputData) throws Exception {
		return dao.modifyTitle(bno, inputData);
	}

	// 게시글 내용 수정
	public ArrayList<BoardVO> modifyContent(int bno, String inputData) throws Exception {
		return dao.modifyContent(bno, inputData);
	}

	// 게시글 삭제
	public ArrayList<BoardVO> deletePost(int bno) throws Exception {
		return dao.deletePost(bno);
	}

	// 페이지 최대 개수 리턴
	public int getPageCnt() throws Exception {
		return dao.getPageCnt();
	}

}
