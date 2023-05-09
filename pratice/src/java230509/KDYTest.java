package java230509;

import java.util.Scanner;

public class KDYTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("연도를 입력하세요. 숫자만 입력하시면 됩니다. (예시) 2023");
		int year = scan.nextInt();
		System.out.println("월을 입력하세요. 숫자만 입력하시면 됩니다. (예시) 7");
		int month = scan.nextInt();
		System.out.println("일을 입력하세요. 숫자만 입력하시면 됩니다. (예시) 23");
		int day = scan.nextInt();

		KDY kdy = new KDY(year, month, day);
		String result = kdy.getDate();
		System.out.println(result);
		
		result = kdy.delimiterDate("/");
		System.out.println(result);
		result = kdy.delimiterDate(".");
		System.out.println(result);
		result = kdy.delimiterDate("_");
		System.out.println(result);
	}
}
