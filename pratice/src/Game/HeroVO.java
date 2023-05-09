package Game;

import java.io.Serializable;

import lombok.Data;

@Data
public class HeroVO implements Serializable {

	private String name = "나";
	private int level;
	private int damage;
	private int health;
	private int exp;
}
