package java0503;

import java.util.Scanner;

public class Student {
	Scanner scan = new Scanner(System.in);
	StudentDAO dao = new StudentDAO();

	public StudentDTO resist() throws Exception {

		System.out.println("이름을 입력하세요.");
		String name = scan.next();
		System.out.println("전화번호를 입력하세요.");
		String phone = scan.next();
		System.out.println("점수를 입력하세요.");
		int score = scan.nextInt();

		StudentDTO stu = new StudentDTO();
		stu.setName(name);
		stu.setPhone(phone);
		stu.setScore(score);
		dao.resistBranch(stu);
		// 학생정보 반환
		return stu;
	}
}
