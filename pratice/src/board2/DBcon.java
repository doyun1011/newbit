package board2;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBcon {

	public static Connection getConnection() throws Exception {
		String driverName ="org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3306/mydb";
		String uid = "root";
		String upw = "1234"; 
		
		Class.forName(driverName);
		Connection conn = DriverManager.getConnection(url, uid, upw);
		return conn;
	}
}
