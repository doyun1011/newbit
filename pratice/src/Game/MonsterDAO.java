package Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java0503.DBcon;

public class MonsterDAO {

	public MonsterVO callMonster(int level) throws Exception {
		Connection conn = DBcon.getConnection();
		String query = "SELECT * FROM monster WHERE level = ? and NAME ='고블린'";
		PreparedStatement pstt = conn.prepareStatement(query);
		pstt.setInt(1, level);
		ResultSet rs = pstt.executeQuery();
		
		rs.next();
		
		MonsterVO mon = new MonsterVO();
		
		mon.setName(rs.getString("name"));
		mon.setLevel(rs.getInt("level"));
		mon.setDamage(rs.getInt("damage"));
		mon.setHealth(rs.getInt("health"));
		mon.setExp(rs.getInt("exp"));
		
		return mon;
	}
}
