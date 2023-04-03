package java230403;

public class StringEx {

	public static void main(String[] args) {

		String s = "eeee++ee+_+3deeee";

		int eCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'e') {
				eCount++;
			}
		}
		System.out.println("eÀÇ °³¼ö: " + eCount);
	}
}
