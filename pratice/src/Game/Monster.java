package Game;

import java.util.ArrayList;

public class Monster {

	public HeroVO attack(ArrayList<MonsterVO> mList, HeroVO he) throws InterruptedException {
		for (MonsterVO mon : mList) {
			System.out.println(mon.getName() + "이(가) 공격합니다!!");
			Thread.sleep(300);
			System.out.println("생명력 -" + mon.getDamage());
			Thread.sleep(300);
			int hp = he.getHealth() - mon.getDamage();
			System.out.println("현재 생명력 " + hp);
			he.setHealth(hp);
			System.out.println();
			Thread.sleep(1500);
		}
		return he;
	}
}
