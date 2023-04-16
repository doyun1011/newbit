package board2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import board.BoardVO;

public class BoardDAO {
	
	private ArrayList<BoardVO2> boardList2 = new ArrayList<BoardVO2>();
	private LocalDate now = LocalDate.now();
	private String nowDate ="" + now;
	
	int pageDivideUnit = 3;

	public void resistBoard(board2.BoardVO2 board) throws Exception {
		Connection conn = DBcon.getConnection();
		String query = "INSERT INTO board (title, content, writer, regDate, modifyDate)"
				+ "VALUES (?, ?, ?, ?, ?)";
		PreparedStatement pstt = conn.prepareStatement(query);
		
		pstt.setString(1, board.getTitle());
		pstt.setString(2, board.getContent());
		pstt.setString(3, board.getWriter());
		pstt.setString(4, nowDate);
		pstt.setString(5, nowDate);
		pstt.executeUpdate();
	}
	public ArrayList<BoardVO2> getPageAllBoard(int pageNum) throws Exception {
		Connection conn = DBcon.getConnection();
		String query = "SELECT * FROM board LIMIT ?, ?";
		PreparedStatement pstt = conn.prepareStatement(query);
		
		int pageFirstBoard = (pageNum -1) * pageDivideUnit;
		pstt.setInt(1,pageFirstBoard);
		pstt.setInt(2, pageDivideUnit);
		ResultSet rs = pstt.executeQuery();
		
		int preListSize = boardList2.size();
		while(rs.next()) {
			BoardVO2 board = new BoardVO2();
			board.setBno(rs.getInt("bno"));
			board.setTitle(rs.getString("title"));
			board.setContent(rs.getString("content"));
			board.setWriter(rs.getString("writer"));
			board.setRegDate(rs.getString("regDate"));
			board.setModifyDate(rs.getString("modifyDate"));
			boardList2.add(board);
		}
		
		for (int i = 0; i < preListSize; i++) {
				boardList2.remove(0);
		}
		return boardList2;
	} 

	public BoardVO2 getBoard(int bno) throws Exception {
		Connection conn = DBcon.getConnection();
		String query = "SELECT * FROM board WHERE bno = ?";
		PreparedStatement pstt = conn.prepareStatement(query);
		pstt.setInt(1, bno);
		ResultSet rs = pstt.executeQuery();
		
		rs.next();
		BoardVO2 board = new BoardVO2();
		board.setBno(rs.getInt("bno"));
		board.setTitle(rs.getString("title"));
		board.setContent(rs.getString("content"));
		board.setWriter(rs.getString("writer"));
		board.setRegDate(rs.getString("regDate"));
		board.setModifyDate(rs.getString("modifyDate"));
		
		return board;
	}

	public void modifyTitle(int bno, String inputData) throws Exception {
		Connection conn = DBcon.getConnection();
		String query = "UPDATE board SET title = ? WHERE bno = ?";
		PreparedStatement pstt = conn.prepareStatement(query);
		
		pstt.setString(1, inputData);
		pstt.setInt(2, bno);
		pstt.executeUpdate();
		
		BoardVO2 board = new BoardVO2();
		int index = convertBnoToIndex(bno);
		board = boardList2.get(index);
		board.setTitle(inputData);
		boardList2.set(index, board);
		
	}

	public void modifyContent(int bno, String inputData) throws Exception {
		Connection conn = DBcon.getConnection();
		String query = "UPDATE board SET content = ? WHERE bno = ?";
		PreparedStatement pstt = conn.prepareStatement(query);
		
		pstt.setString(1, inputData);
		pstt.setInt(2, bno);
		pstt.executeUpdate();
		
		BoardVO2 board = new BoardVO2();
		int index = convertBnoToIndex(bno);
		board = boardList2.get(index);
		board.setContent(inputData);
		boardList2.set(index, board);
		
	}

	public void deleteBoard(int bno) throws Exception {
		Connection conn = DBcon.getConnection();
		String query = "DELETE FROM board WHERE bno = ?";
		PreparedStatement pstt = conn.prepareStatement(query);
		pstt.setInt(1, bno);
		pstt.executeUpdate();

		int index = convertBnoToIndex(bno);
		boardList2.remove(index);
	}

	public int getTotalPageCnt() throws Exception {
		Connection conn = DBcon.getConnection();
		String query = "SELECT * FROM board";
		PreparedStatement pstt = conn.prepareStatement(query);
		ResultSet rs = pstt.executeQuery();
		
		int totalBoardCnt = 0;
		while(rs.next()) {
			totalBoardCnt++;
		}
		
		int pageCnt = 1;
		if(totalBoardCnt < pageDivideUnit) {
			pageCnt = 1;
		}
		else if(totalBoardCnt % pageDivideUnit == 0) {
			pageCnt = totalBoardCnt / pageDivideUnit;
		}else if(totalBoardCnt % pageDivideUnit != 0){
			pageCnt = totalBoardCnt / pageDivideUnit +1;
		}
		return pageCnt;
	}
	
	private int convertBnoToIndex(int bno) {
		int index = 0;
		for(BoardVO2 board : boardList2) {
			if(board.getBno() == bno) {
				break;
			}
			index++;
		}
		return index;
	}

	

}
