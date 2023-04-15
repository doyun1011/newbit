package java230403;

import java.util.Scanner;

public class StringQuiz {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String answer1 = "무궁화";
		String answer2 = "RoseofSharon";
		int wrongCount = 0;

		for (int i = 0; i <5; i++) {
			
			System.out.print("대한민국의 국화는 무엇입니까? >>");
			String userAnswer = scan.next();
			
			if (userAnswer.equalsIgnoreCase("Rose")) {
				String userAnswer2 = scan.next();
				String userAnswer3 = scan.next();
				userAnswer = userAnswer.concat(userAnswer2);
				userAnswer = userAnswer.concat(userAnswer3);
			}
			
			
			if (answer1.equalsIgnoreCase(userAnswer) || answer2.equalsIgnoreCase(userAnswer)) {
				System.out.println("정답입니다.");
				break;
			} else {
				System.out.print("틀렸습니다. ");
				System.out.println("남은 기회: " + (4 - wrongCount));
				wrongCount++;
			}
			
		}

	}

}
