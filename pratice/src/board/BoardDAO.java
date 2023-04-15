package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class BoardDAO {

	ArrayList<BoardVO> boardlist = new ArrayList<BoardVO>();
	Scanner scan = new Scanner(System.in);
	// �Խù� ũ���

	public void insert() throws Exception {
		int modifyCount =0;
		BoardVO board = new BoardVO();
		System.out.println("������ �Է��ϼ���. >>");
		String title = scan.nextLine();
		System.out.println("������ �Է��ϼ���. >>");
		String content = scan.nextLine();
		System.out.println("��,��,��,�ø� �Է��ϼ���. >>");
		String date = scan.nextLine();
		System.out.println("�ۼ��� id�� �Է��ϼ���. >>");
		String writer = scan.nextLine();
		if(modifyCount == 0) {
			modifyCount =1;
		}
	
		
		Connection conn = DBcon.getConnection();
		String queryInsert = "INSERT INTO board (title,content,regDate,modifyDate,writer)"
				+ " VALUES(?, ?, ?, ?, ?)";
		
		
		modifyCount =1;
		PreparedStatement prestt = conn.prepareStatement(queryInsert);
		prestt.setString(1,title);
		prestt.setString(2,content);
		prestt.setString(3, date);
		prestt.setString(4, date);
		prestt.setString(5,writer);
		int result = prestt.executeUpdate();
		
	}
	public void allGet() throws Exception {
		Connection conn = DBcon.getConnection();
		String querySelect = "SELECT * FROM board";
		
		
		PreparedStatement prestt = conn.prepareStatement(querySelect);
		ResultSet rs =prestt.executeQuery();

		while(rs.next()) {
			int bno = rs.getInt("bno");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String regDate = rs.getString("regDate");
			String modifyDate = rs.getString("modifyDate");
			
			System.out.println(""+ title +" " + regDate +" " + modifyDate );
		}
		
	}
	public void get() throws Exception {
		Connection conn = DBcon.getConnection();
		System.out.println("�˻��� �Խù��� ��ȣ�� �Է��ϼ���.");
		int bno = scan.nextInt();
		String querySelect = "SELECT * FROM board  WHERE bno = ?";
		
		PreparedStatement prestt = conn.prepareStatement(querySelect);
		prestt.setInt(1,bno);
		ResultSet rs =prestt.executeQuery();

		while(rs.next()) {
			int bno1 = rs.getInt("bno");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String regDate = rs.getString("regDate");
			String modifyDate = rs.getString("modifyDate");
			
			System.out.println(""+bno1 +" "+ title +" " + content +" " + regDate +" " + modifyDate );
		}
		
	}
	public void delete() throws Exception {
		get();
		Connection conn = DBcon.getConnection();
		String queryDelete = "DELETE FROM board WHERE bno = ?";
		System.out.println("������ �Խù��� ��ȣ�� �Է��ϼ���.");
		int bno = scan.nextInt();
		PreparedStatement prestt = conn.prepareStatement(queryDelete);
		prestt.setInt(1,bno);
		int result =prestt.executeUpdate();
		get();
	}
	public void update() throws Exception {
		get();
		Connection conn = DBcon.getConnection();
		System.out.println("������ �Խù��� ��ȣ�� �Է��ϼ���.");
		int bno = scan.nextInt();
		
		System.out.println("������ �����Ͻðھ��? 1.���� 2.����");
		int selector = scan.nextInt();
		String	queryUpdate  = "UPDATE board SET content = ? WHERE bno = ?";
		
		switch (selector) {
		case 1:
			System.out.println("������ �Է��ϼ���.");
			String tmp1 = scan.nextLine();
			String title = scan.nextLine();
			 queryUpdate = "UPDATE board SET title = ? WHERE bno = ?";
			 PreparedStatement prestt1 = conn.prepareStatement(queryUpdate);
			 prestt1.setString(1,title);
			 prestt1.setInt(2,bno);
			 int result1 =prestt1.executeUpdate();
			break;
		case 2:
			System.out.println("������ �Է��ϼ���.");
			String tmp2 = scan.nextLine();
			String content = scan.nextLine();
			PreparedStatement prestt2 = conn.prepareStatement(queryUpdate);
			prestt2.setString(1,content);
			prestt2.setInt(2,bno);
			int result2 =prestt2.executeUpdate();
			break;

		default:
			break;
		}
		
		
		get();
	}
	
}
