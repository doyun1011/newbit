package board;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBcon {
	
	public static Connection getConnection() throws Exception {
		
		final String driverName = "org.mariadb.jdbc.Driver";
		final String url = "jdbc:mariadb://localhost:3306/mydb";
		final String uid = "root";
		final String upw = "1234";
		
		Class.forName(driverName);
		 
		Connection conn = null;
		conn = DriverManager.getConnection(url,uid,upw);
		
		return conn;
		 
		
		
	}
}
