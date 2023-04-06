package java230405;

public class UnitTest {

	public static void main(String[] args) {
		Unit[] units = new Unit[3];
		units[0] = new Marine();
		units[1] = new Hydra();
		units[2] = new Zealot();
		
		for (int i = 0; i < units.length; i++) {
			units[i].attack();
			System.out.println(units[i].str);
			
		}
	}
}
