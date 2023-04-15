package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class BoardDAO {

	private ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();
	private Scanner scan = new Scanner(System.in);

	private LocalDate now = LocalDate.now();
	private String nowDate = "" + now;

	private int dividePageUnit = 3;
	private int preListSize = 0;

	// 게시물 등록
	public void registPost(BoardVO board) throws Exception {
		Connection conn = DBcon.getConnection();
		String query = "INSERT INTO board (title, content, writer, regDate, modifyDate)" + " VALUES(?, ?, ?, ?, ?)";
		PreparedStatement pstt = conn.prepareStatement(query);

		pstt.setString(1, board.getTitle());
		pstt.setString(2, board.getContent());
		pstt.setString(3, board.getWriter());
		pstt.setString(4, nowDate);
		pstt.setString(5, nowDate);
		int result = pstt.executeUpdate();
	}

	// 해당 페이지의 게시물 전체 조회
	public ArrayList<BoardVO> getPageBoard(int pageNum) throws Exception {
		Connection conn = DBcon.getConnection();
		String query = "SELECT * FROM board LIMIT ? , ?";
		PreparedStatement pstt = conn.prepareStatement(query);

		int pageFirstBoard = (pageNum - 1) * dividePageUnit;
		pstt.setInt(1, pageFirstBoard);
		pstt.setInt(2, dividePageUnit);
		ResultSet rs = pstt.executeQuery();

		preListSize = boardList.size();
		while (rs.next()) {
			BoardVO board = new BoardVO();
			board.setBno(rs.getInt("bno"));
			board.setTitle(rs.getString("title"));
			board.setContent(rs.getString("content"));
			board.setWriter(rs.getString("writer"));
			board.setRegDate(rs.getString("regDate"));
			board.setModifyDate(rs.getString("modifyDate"));
			boardList.add(board);
		}
		for (int i = 0; i < preListSize; i++) {
			boardList.remove(0);
		}
		return boardList;
	}

	// 게시물 조회
	public BoardVO getBoard(int bno) throws Exception {
		Connection conn = DBcon.getConnection();
		String query = "SELECT * FROM board WHERE bno = ? ";
		PreparedStatement pstt = conn.prepareStatement(query);
		pstt.setInt(1, bno);
		ResultSet rs = pstt.executeQuery();

		rs.next();
		BoardVO board = new BoardVO();
		board.setBno(rs.getInt("bno"));
		board.setTitle(rs.getString("title"));
		board.setContent(rs.getString("content"));
		board.setWriter(rs.getString("writer"));
		board.setRegDate(rs.getString("regDate"));
		board.setModifyDate(rs.getString("modifyDate"));

		return board;
	}

	// 게시물 제목 수정
	public void modifyTitle(int bno, String inputData) throws Exception {
		Connection conn = DBcon.getConnection();
		String query = "UPDATE board SET title = ? , modifyDate = ? WHERE bno = ?";
		PreparedStatement pstt = conn.prepareStatement(query);

		pstt.setString(1, inputData);
		pstt.setString(2, nowDate);
		pstt.setInt(3, bno);
		int result = pstt.executeUpdate();

		// 수정한 title, boardList에 갱신
		int index = getListIndex(bno);
		BoardVO board = new BoardVO();
		board = boardList.get(index);
		board.setTitle(inputData);
		boardList.set(index, board);
	}

	// 게시물 내용 수정
	public void modifyContent(int bno, String inputData) throws Exception {
		Connection conn = DBcon.getConnection();
		String query = "UPDATE board SET content = ? , modifyDate = ? WHERE bno = ?";
		PreparedStatement pstt = conn.prepareStatement(query);

		pstt.setString(1, inputData);
		pstt.setString(2, nowDate);
		pstt.setInt(3, bno);
		int result = pstt.executeUpdate();

		// 수정한 content, boardList에 갱신
		int index = getListIndex(bno);
		BoardVO board = new BoardVO();
		board = boardList.get(index);
		board.setContent(inputData);
		boardList.set(index, board);
	}

	// 게시물 삭제
	public void deletePost(int bno) throws Exception {
		Connection conn = DBcon.getConnection();
		String query = "DELETE FROM board WHERE bno = ?";
		PreparedStatement pstt = conn.prepareStatement(query);
		pstt.setInt(1, bno);
		int result = pstt.executeUpdate();

		int index = getListIndex(bno);
		boardList.remove(index);
	}

	// 페이지 최대 개수 리턴
	public int getPageCnt() throws Exception {
		Connection conn = DBcon.getConnection();
		String query = "SELECT * FROM board";
		PreparedStatement pstt = conn.prepareStatement(query);
		ResultSet rs = pstt.executeQuery();

		int totalBoardCnt = 0;
		while (rs.next()) {
			totalBoardCnt++;
		}

		int pageCnt = totalBoardCnt / dividePageUnit;
		if (totalBoardCnt % dividePageUnit != 0 || pageCnt == 0) {
			pageCnt++;
		}
		return pageCnt;
	}

	// 게시물 번호를 BoardList index로 변환
	private int getListIndex(int bno) {
		int index = 0;
		for (BoardVO board : boardList) {
			if (board.getBno() == bno) {
				break;
			}
			index++;
		}
		return index;
	}

}
