package board;

import java.util.ArrayList;

public class BoardService {

	private BoardDAO dao = new BoardDAO();

	// 게시물 등록
	public void registPost(BoardVO board) throws Exception {
		dao.registPost(board);
	}

	// 해당 페이지의 게시물 전체 조회
	public ArrayList<BoardVO> getPageBoard(int pageNum) throws Exception {
		return dao.getPageBoard(pageNum);
	}

	// 게시물 조회
	public BoardVO showBoard(int bno) throws Exception {
		return dao.getBoard(bno);
	}

	// 게시물 제목 수정
	public void modifyTitle(int bno, String inputData) throws Exception {
		dao.modifyTitle(bno, inputData);
	}

	// 게시물 내용 수정
	public void modifyContent(int bno, String inputData) throws Exception {
		dao.modifyContent(bno, inputData);
	}

	// 게시물 삭제
	public void deletePost(int bno) throws Exception {
		dao.deletePost(bno);
	}

	// 페이지 최대 개수 리턴
	public int getPageCnt() throws Exception {
		return dao.getPageCnt();
	}
}
