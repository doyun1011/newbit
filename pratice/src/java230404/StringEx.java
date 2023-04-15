package java230404;

public class StringEx {

	public static void main(String[] args) {
		String str = "abecd ef";
		
		String txt = "ce";
		
		int result = str.indexOf(txt);
		System.out.println(result);
		
		result = str.lastIndexOf('e');
		System.out.println(result);
		
		str = str.concat(txt);
		System.out.println(str);
		
		String s1 ="abcdefghijklmnopqrstuvwxyz";
		String x =s1.substring(0);
		System.out.println(x);

		String x1 =s1.substring(0,4);
		System.out.println(x1);
		
		//split(구분자)
		String y = "2023-04-09";
		String[] yy = y.split("-");
		String yyy ="";
		for (int i = 0; i < yy.length; i++) {
			yyy = yyy+ yy[i];
		}
		System.out.println(yyy);
		
		String result2 ="";
		for (int i = 0; i < yyy.length(); i++) {
			result2 = result2 + yyy.charAt(i);
//			if(yyy.charAt(i) == '0') {
//				result2 = result2 + "/" + yyy.charAt(i);
//			}
		}
		System.out.println(result2);
		
		
		//문자열1.contains(문자열2)
		String fruits = "apple, banana, peach";
		boolean result3 = fruits.contains("apple");
		System.out.println(result3);
	}
	
	
}
