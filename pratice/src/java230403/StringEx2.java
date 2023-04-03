package java230403;

import java.util.Scanner;

public class StringEx2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] chars = new char[10];
		
		
		String str = "avbxcqwemz";

		
		for (int i = 0; i < chars.length; i++) {
			chars[i] = '*';
		}
		
		
		System.out.println("문자를 입력하세요.");
		char c = scan.next().charAt(0);
		
		int result = str.indexOf(c);
		chars[result] = c;
		
		for (int i = 0; i < chars.length; i++) {
			System.out.print(chars[i] +" "); 
		}
		
	}
}
