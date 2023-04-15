package board;

public class BoardTest {

	
	public static void main(String[] args) throws Exception {
		BoardDAO boardDao = new BoardDAO();
		boardDao.insert();
		boardDao.allGet();
		boardDao.delete();
		boardDao.update();
		boardDao.get();
	}
}
