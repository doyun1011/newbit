package java230413;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcTest_Inset {

	Scanner scan = new Scanner(System.in);
	
	public  Connection getConnection() throws Exception {
		final String driverName = "org.mariadb.jdbc.Driver";
		final String url = "jdbc:mariadb://localhost:3306/green01";
		final String uid = "root";
		final String upw = "1234";
		
		Class.forName(driverName);
		return DriverManager.getConnection(url,uid,upw);
	}
	public void Insert(Connection conn) throws Exception {
		System.out.print("이름 입력 >>");
		String keyword1 = scan.nextLine();
		System.out.print("폰번호 입력 >>");
		String keyword2 = scan.nextLine();
		System.out.print("id 입력 >>");
		String keyword3 = scan.nextLine();
		System.out.print("pw 입력 >>");
		String keyword4 = scan.nextLine();
		String queryInsert = "INSERT INTO member (name,phone,id,pw) "
				+ " VALUES(?, ?, ?, ?)";
		PreparedStatement stt = conn.prepareStatement(queryInsert);
		stt.setString(1, keyword1);
		stt.setString(2, keyword2);
		stt.setString(3, keyword3);
		stt.setString(4, keyword4);
		int result = stt.executeUpdate();
	}
	public void select(Connection conn) throws Exception{
		String querySelect = "SELECT * FROM member WHERE name Like ? ";
		PreparedStatement stt = conn.prepareStatement(querySelect);
		System.out.print("검색할 이름 입력 >>");
		String keyword = scan.nextLine();
		stt.setString(1, keyword);
		ResultSet rs = stt.executeQuery();
		
		while(rs.next()) {
			int mno =rs.getInt("mno");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String id = rs.getString("id");
			
			System.out.println(""+ mno +" " + name +" " + phone +" " + id );
		}
	}
	public void allSelect(Connection conn) throws Exception{
		String querySelect = "SELECT * FROM member";
		PreparedStatement stt = conn.prepareStatement(querySelect);
		ResultSet rs = stt.executeQuery();
		
		while(rs.next()) {
			int mno =rs.getInt("mno");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String id = rs.getString("id");
			
			System.out.println(""+ mno +" " + name +" " + phone +" " + id );
		}
	}
	public void delete(Connection conn) throws Exception {
		String queryDelete = "DELETE FROM member WHERE name Like ?";
		PreparedStatement stt = conn.prepareStatement(queryDelete);
		System.out.print("삭제할 이름 입력 >>");
		String keyword = scan.nextLine();
		stt.setString(1, keyword);
		ResultSet rs = stt.executeQuery();
		allSelect(conn);
	}
	public void update(Connection conn) throws Exception {
		String queryUpdate = "UPDATE member SET  name = ? WHERE name Like ?";
		PreparedStatement stt = conn.prepareStatement(queryUpdate);
		System.out.print("수정할 이름 입력 >>");
		String keyword1 = scan.nextLine();
		System.out.print("새로운 이름 입력 >>");
		String keyword2 = scan.nextLine();
		stt.setString(1, keyword2);
		stt.setString(2, keyword1);
		ResultSet rs = stt.executeQuery();
		allSelect(conn);
	}
}
