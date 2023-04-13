package java230413;

import java.sql.Connection;

public class JdbcTest {
	public static void main(String[] args) throws Exception {
		JdbcTest_Inset jdbc = new JdbcTest_Inset();
		
		Connection conn = null;
		conn = jdbc.getConnection();
		jdbc.Insert(conn);
		jdbc.select(conn);
		jdbc.delete(conn);
		jdbc.update(conn);
	}

}
