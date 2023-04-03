package java230403;

public class HumanTest {

	public static void main(String[] args) {
		Human human = new Human();
		for (int i = 1; i < 200; i++) {
			Human humanCount = new Human();
		}
		System.out.println("human.level: "+ human.level);
	}
}
