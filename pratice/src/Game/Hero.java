package Game;

import java.util.ArrayList;
import java.util.Scanner;

public class Hero {
	Scanner scan = new Scanner(System.in);

	public ArrayList<MonsterVO> attack(int selector, ArrayList<MonsterVO> mons, HeroVO he) throws InterruptedException {
		System.out.println("대상 하나에게 강력한 베기 공격을 가합니다.\n");
		mons = cut(mons, he);
		return mons;

	}

	public ArrayList<MonsterVO> cut(ArrayList<MonsterVO> mons, HeroVO he) throws InterruptedException {
		int damage = 40;
		System.out.println("대상을 지정하세요.");
		int i = 1;
		for(MonsterVO mon : mons) {
			System.out.print(i + "." + mon.getName() + "   ");
			i++;
		}
		System.out.println();
		int index = scan.nextInt() - 1;
		MonsterVO monster = mons.get(index);
		int health = monster.getHealth() - damage;
		System.out.println("베기를 시전했습니다. 데미지" + damage);
		System.out.println();
		Thread.sleep(300);
		System.out.println(monster.getName() + " 생명력 " + health);
		if (health <= 0) {
			Thread.sleep(150);
			System.out.println(monster.getName() + " 을(를) 잡았습니다!!");
			Thread.sleep(150);
			System.out.println("경험치 " + monster.getExp() + "를 획득했습니다.\n");
			Thread.sleep(150);
			level(monster.getExp(), he);
			mons.remove(index);
		}
		monster.setHealth(health);

		return mons;
	}

	private void level(int exp, HeroVO he) throws InterruptedException {
		exp = he.getExp() + exp;
		he.setExp(exp);
		Thread.sleep(500);
		int level = he.getLevel();
		if (level == 1 && exp >= 15) {
			level++;
			he.setLevel(level);
			System.out.println("레벨업!!");
			System.out.println("레벨 " + level);
		}
	}

}
