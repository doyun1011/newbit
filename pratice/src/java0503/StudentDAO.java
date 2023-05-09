package java0503;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentDAO {

	public void resistServer(StudentDTO stu) throws Exception {
		Connection conn = DBcon.getConnection();
		String query = "INSERT INTO serverstudent VALUES (?, ?, ?);";
		PreparedStatement pstt = conn.prepareStatement(query);
		pstt.setString(1, stu.getName());
		pstt.setString(2, stu.getPhone());
		pstt.setInt(3, stu.getScore());
		pstt.executeUpdate();

	}

	public void resistBranch(StudentDTO stu) throws Exception {
		Connection conn = DBcon.getConnection();
		String query = "INSERT INTO brunchstudent VALUES (?, ?, ?);";
		PreparedStatement pstt = conn.prepareStatement(query);
		pstt.setString(1, stu.getName());
		pstt.setString(2, stu.getPhone());
		pstt.setInt(3, stu.getScore());
		pstt.executeUpdate();

	}
}
