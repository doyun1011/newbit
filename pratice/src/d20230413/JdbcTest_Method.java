package d20230413;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class JdbcTest_Method {
	static final String url = "jdbc:mariadb://localhost:3306/green01";
	static final String uid = "root";
	static final String upw = "1234";
	static final String driverName = "org.mariadb.jdbc.Driver";
	static Connection conn = null;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		JdbcTest_Method jm = new JdbcTest_Method();

		Class.forName(driverName);
		//Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int sel = -1;
		while(sel != 0) {
			
			System.out.println("1. 등록 \t 2. 조회 \t 0. 종료");
			sel = sc.nextInt();
			sc.nextLine();
			if (sel == 1) {
				// 등록
				System.out.println("이름을 입력하세요..");
				String name = sc.nextLine();
				System.out.println("전화번호를 입력하세요..");
				String phone = sc.nextLine();
				System.out.println("아이디를 입력하세요..");
				String id = sc.nextLine();
				System.out.println("패스워드를 입력하세요..");
				String pw = sc.nextLine();
				Member m = new Member(name, phone, id, pw);
				jm.insert(conn, m);
				
			} else if (sel == 2) {
				// 조회
				//ArrayList<Member> list = jm.select(conn);
				ArrayList<Member> list = jm.select();
				for(Member m : list) {
					System.out.println(m);
				}
			} else if (sel == 0) {
				System.out.println("종료합니다.");
			} else {
				System.out.println("잘 보고 입력하라고요..");
			}
		}
	}

	public Connection getConnection() {

		return null;
	}

	public void insert(Connection conn, Member m) {
		String query = "INSERT INTO member (name, phone, id, pw) VALUES (?, ?, ?, ?)";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, m.getName());
			stmt.setString(2, m.getPhone());
			stmt.setString(3, m.getId());
			stmt.setString(4, m.getPw());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//public ArrayList<Member> select(Connection conn) {
	public ArrayList<Member> select() {
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement stmt = null;
		String query = "SELECT * FROM member";
		try {
			
			stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Member m = new Member();
				int mno = rs.getInt("mno");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				m.setMno(mno);
				m.setName(name);
				m.setPhone(phone);
				m.setId(id);
				m.setPw(pw);
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return list;
	}
}
