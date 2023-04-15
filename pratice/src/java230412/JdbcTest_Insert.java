package java230412;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class JdbcTest_Insert {

	public static void main(String[] args) throws Exception {

		ArrayList<Member> mlist = new ArrayList<Member>();
		Scanner scan = new Scanner(System.in);
		// driver명, db주소, id, pw 준비
		final String driverName = "org.mariadb.jdbc.Driver";
		final String url = "jdbc:mariadb://localhost:3306/green01";
		final String uid = "root";
		final String upw = "1234";
		System.out.print("이름을 입력하세요>>");
		String sName = scan.next();
		System.out.print("핸드폰번호를 입력하세요>>");
		String sPhone = scan.next();
		System.out.print("id를 입력하세요>>");
		String sId = scan.next();
		System.out.print("pw를 입력하세요>>");
		String sPw = scan.next();

		Class.forName(driverName);

		// 접속 객체 생성(Connection)
		Connection cn = null;
		cn = DriverManager.getConnection(url, uid, upw);
		// 쿼리 실행 객체 생성(Statement)
		//VALUES 앞에띄어쓰기 해라 
		Statement stt = cn.createStatement();
		String queryInsert = "INSERT INTO member (name, phone, id, pw) "
				+ "VALUES('"+ sName +"','" + sPhone +"','" + sId +"','" +sPw+ "')";
	
//		int resultInsert = stt.executeUpdate(queryInsert);
	
		
		String queryDelete = "DELETE FROM member "
				+ " WHERE mno >28 AND mno<=30 OR name ='sName'";
		int resultDelete = stt.executeUpdate(queryDelete);
		
		String queryUpdate ="UPDATE member SET name ='길동이'"
				+ " WHERE name ='QQQQQQQQ'";
		int resultUpdate = stt.executeUpdate(queryUpdate);
		
		
		String querySelect = "SELECT * FROM member"
				+ " ORDER BY mno DESC";
		ResultSet rs = stt.executeQuery(querySelect);
		// 쿼리 실행(executeUpdata())
		
		while (rs.next()) {
			Member member = new Member();
			int mno = rs.getInt("mno");
			String name = rs.getString("name");
			String id = rs.getString("id");
			String pw = rs.getString("pw");
			member.setMno(mno);
			member.setName(name);
			member.setId(id);
			member.setPw(pw);
			mlist.add(member);
		}
		for(Member m:mlist) {
			System.out.println(m);
		}
	}

}
