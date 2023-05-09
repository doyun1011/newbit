package Game;

import java.io.Serializable;

import lombok.Data;

@Data
public class MonsterVO implements Serializable  {

	private String name;
	private int level;
	private int damage;
	private int health;
	private int exp;
}
