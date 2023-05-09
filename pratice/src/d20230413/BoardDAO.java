package d20230413;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java0503.DBcon;


public class BoardDAO {

	public void insert(BoardVO board) throws Exception {
		//접속
		Connection conn = DBcon.getConnection();
		
		String query = "INSERT INTO tbl_board (title, content, writer, regdate) "
					 + "VALUES (?, ?, ?, ?)";
		//쿼리실행
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, board.getTitle());
		stmt.setString(2, board.getContent());
		stmt.setString(3, board.getWriter());
		stmt.setString(4, board.getRegDate());
		
		stmt.executeUpdate();
	}
	
	ArrayList<BoardVO> selectAll() throws Exception{
		ArrayList<BoardVO> boardList = new ArrayList<>();
		//db 접속
		Connection conn = DBcon.getConnection();
		
		//쿼리 실행(select문 - executeQuery() --> ResultSet --> 반복)
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM tbl_board");
		
		while(rs.next()) {
			BoardVO board = new BoardVO();
			board.setBno(rs.getInt("bno"));
			board.setTitle(rs.getString("title"));
			board.setWriter(rs.getString("writer"));
			board.setRegDate(rs.getString("regdate"));
			board.setModifyDate(rs.getString("modifydate"));
			
			boardList.add(board);
		}
		
		return boardList;
	}
	
	public ArrayList<BoardVO> selectBoardsByTitle(String title) {
		ArrayList<BoardVO> boardList = new ArrayList<>();
		
		
		return boardList;
	}
}
