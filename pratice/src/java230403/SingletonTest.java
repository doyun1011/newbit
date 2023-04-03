package java230403;

import java.io.ObjectInputStream.GetField;

public class SingletonTest {

	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		
		s1.setN(100);
		s2.setN(200);
		System.out.println(s1.getN());
		System.out.println(s2.getN());
	}
}
