package java230403;

import java.util.Scanner;

public class StringQuiz {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String answer1 = "����ȭ";
		String answer2 = "RoseofSharon";
		int wrongCount = 0;

		for (int i = 0; i <5; i++) {
			
			System.out.print("���ѹα��� ��ȭ�� �����Դϱ�? >>");
			String userAnswer = scan.next();
			
			if (userAnswer.equalsIgnoreCase("Rose")) {
				String userAnswer2 = scan.next();
				String userAnswer3 = scan.next();
				userAnswer = userAnswer.concat(userAnswer2);
				userAnswer = userAnswer.concat(userAnswer3);
			}
			
			
			if (answer1.equalsIgnoreCase(userAnswer) || answer2.equalsIgnoreCase(userAnswer)) {
				System.out.println("�����Դϴ�.");
				break;
			} else {
				System.out.print("Ʋ�Ƚ��ϴ�. ");
				System.out.println("���� ��ȸ: " + (4 - wrongCount));
				wrongCount++;
			}
			
		}

	}

}
