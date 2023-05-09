package d20230413;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class JdbcTest_Insert2 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		//db에 접속해야지..접속하기위해서는 db주소, id, pw가 필요해
		//db주소
		String url = "jdbc:mariadb://localhost:3306/green01";
		String uid = "root";
		String upw = "1234";
		String driverName = "org.mariadb.jdbc.Driver";
		
		//db 접속
		Class.forName(driverName);
		
		//접속객체 획득
		Connection conn = DriverManager.getConnection(url, uid, upw);
		
		//쿼리 실행 객체 획득(접속객체를 통해서 얻는다)
		System.out.print("검색어1 입력 >> ");
		String keyword1 = sc.nextLine();
		System.out.print("검색어2 입력 >> ");
		String keyword2 = sc.nextLine();
		
		String query = "SELECT * FROM member WHERE id = ?";
		//Statement stmt = conn.createStatement();
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, keyword1);
		//stmt.setString(2, keyword2);
		
		ResultSet rs = stmt.executeQuery();
		
		rs.next();
		System.out.println(rs.getString("name"));
		
		
		
	}

}
