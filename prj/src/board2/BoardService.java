package board2;

import java.util.ArrayList;

public class BoardService {

	BoardDAO dao = new BoardDAO();
	
	public void resistBoard(BoardVO board) throws Exception {
		dao.resistBoard(board);
	}

	public ArrayList<BoardVO> getPageAllBoard(int pageNum) throws Exception {
		return dao.getPageAllBoard(pageNum);
	}

	public BoardVO getBoard(int bno) throws Exception {
		return dao.getBoard(bno);
	}

	public void modifyTitle(int bno, String inputData) throws Exception {
		dao.modifyTitle(bno, inputData);
	}

	public void modifyContent(int bno, String inputData) throws Exception {
		dao.modifyContent(bno, inputData);
	}

	public void deleteBoard(int bno) throws Exception {
		dao.deleteBoard(bno);
	}

	public int getTotalPageCnt() throws Exception {
		return dao.getTotalPageCnt();
	}

}
