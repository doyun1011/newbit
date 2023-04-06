package java230405;

public class StringEx {

	public static void main(String[] args) {

		String tt = " aaa aa ";
		System.out.println("trim() 사용전: " + tt.length());
		String tt2 = tt.trim();
		System.out.println("trim() 사용후: " + tt2.length());
		System.out.println(tt);
		System.out.println(tt2);

		System.out.println("=====================");
		String uuu = "Abcd Efgh";
		String www = uuu.toLowerCase();
		System.out.println("toLower:" + www);
		www = uuu.toUpperCase();
		System.out.println("toUpper:" + www);
		System.out.println("=====================");
		
		www = uuu.replace("cd", "xx");
		System.out.println(www);
	}
}
