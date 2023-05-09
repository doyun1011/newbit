package Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HeroDAO {

	public HeroVO Status() throws Exception {
		Connection conn = DBcon.getConnection();
		String query = "SELECT * FROM hero;";
		PreparedStatement pstt = conn.prepareStatement(query);
		ResultSet rs = pstt.executeQuery();
		rs.next();
		
		HeroVO hero = new HeroVO();
		hero.setLevel(rs.getInt("level"));
		hero.setDamage(rs.getInt("damage"));
		hero.setHealth(rs.getInt("health"));
		
		conn.close();
		rs.close();
		pstt.close();
		return hero;
	}
}
