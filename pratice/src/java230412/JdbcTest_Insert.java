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
		// driver��, db�ּ�, id, pw �غ�
		final String driverName = "org.mariadb.jdbc.Driver";
		final String url = "jdbc:mariadb://localhost:3306/green01";
		final String uid = "root";
		final String upw = "1234";
		System.out.print("�̸��� �Է��ϼ���>>");
		String sName = scan.next();
		System.out.print("�ڵ�����ȣ�� �Է��ϼ���>>");
		String sPhone = scan.next();
		System.out.print("id�� �Է��ϼ���>>");
		String sId = scan.next();
		System.out.print("pw�� �Է��ϼ���>>");
		String sPw = scan.next();

		Class.forName(driverName);

		// ���� ��ü ����(Connection)
		Connection cn = null;
		cn = DriverManager.getConnection(url, uid, upw);
		// ���� ���� ��ü ����(Statement)
		//VALUES �տ����� �ض� 
		Statement stt = cn.createStatement();
		String queryInsert = "INSERT INTO member (name, phone, id, pw) "
				+ "VALUES('"+ sName +"','" + sPhone +"','" + sId +"','" +sPw+ "')";
	
//		int resultInsert = stt.executeUpdate(queryInsert);
	
		
		String queryDelete = "DELETE FROM member "
				+ " WHERE mno >28 AND mno<=30 OR name ='sName'";
		int resultDelete = stt.executeUpdate(queryDelete);
		
		String queryUpdate ="UPDATE member SET name ='�浿��'"
				+ " WHERE name ='QQQQQQQQ'";
		int resultUpdate = stt.executeUpdate(queryUpdate);
		
		
		String querySelect = "SELECT * FROM member"
				+ " ORDER BY mno DESC";
		ResultSet rs = stt.executeQuery(querySelect);
		// ���� ����(executeUpdata())
		
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
