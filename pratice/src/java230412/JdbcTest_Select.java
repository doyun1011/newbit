package java230412;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class JdbcTest_Select {

	public static void main(String[] args) throws Exception {
		ArrayList<Member> mlist = new ArrayList<>();
		final String driverName = "org.mariadb.jdbc.Driver";
		final String url = "jdbc:mariadb://localhost:3306/green01";
		final String uid = "root";
		final String upw = "1234";

		Class.forName(driverName);
		// 1. 접속 객체 생성: db 주소, db접속 id, db 접속 pw
		Connection conn = null;
		conn = DriverManager.getConnection(url, uid, upw);
		// 2. 쿼리(질문)를 날린다.
		// 2-1. 쿼리를 실행할 준비를 한다.
		Statement stmt = null;
		stmt = conn.createStatement();
		String query = "SELECT * FROM member";
		ResultSet rs = stmt.executeQuery(query);// select 전용 나머진 executeUpdate
		System.out.println(rs);

		// 한행씩 받음, 첫장은 표지 의미없다 다음 장 부터 의미 있음 마지막 장 넘기면false로 끝
		while (rs.next()) {
//			Member member = new Member();
//			int mno = rs.getInt("mno");
//			String name = rs.getString("name");
//			String phone = rs.getString("phone");
//			String id = rs.getString("id");
//			String pw = rs.getString("pw");
			Member member = new Member();
			int mno = rs.getInt(1);
			String name = rs.getString(2);
			String phone = rs.getString(3);
			String id = rs.getString(4);
			String pw = rs.getString(5);
			member.setMno(mno);
			member.setName(name);
			member.setId(id);
			member.setPw(pw);
			mlist.add(member);
		}
		System.out.println("리스트에 저장된 Member 객체 수 " + mlist.size());
		for (Member m : mlist) {
			System.out.println(m);
		}
	}
}
