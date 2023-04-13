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
		// 1. ���� ��ü ����: db �ּ�, db���� id, db ���� pw
		Connection conn = null;
		conn = DriverManager.getConnection(url, uid, upw);
		// 2. ����(����)�� ������.
		// 2-1. ������ ������ �غ� �Ѵ�.
		Statement stmt = null;
		stmt = conn.createStatement();
		String query = "SELECT * FROM member";
		ResultSet rs = stmt.executeQuery(query);// select ���� ������ executeUpdate
		System.out.println(rs);

		// ���྿ ����, ù���� ǥ�� �ǹ̾��� ���� �� ���� �ǹ� ���� ������ �� �ѱ��false�� ��
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
		System.out.println("����Ʈ�� ����� Member ��ü �� " + mlist.size());
		for (Member m : mlist) {
			System.out.println(m);
		}
	}
}
