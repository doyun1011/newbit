package java230403;

public class Human {

	static int cnt = 0;
	static int level = 1;
	
	public Human() {
		cnt++;
		if(cnt%100 == 0) {
			level++;
		}
	}
}
