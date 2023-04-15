package java230403;

public class Singleton {

	private static Singleton single;
	private int n;
	private Singleton() {
		// TODO Auto-generated constructor stub
	}
	
	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public static Singleton getInstance() {
		if(single == null) {
			single = new Singleton();
		}
		return single;
	}
}
