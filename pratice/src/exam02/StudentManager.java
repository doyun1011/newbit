package exam02;

import java.util.Scanner;

public class StudentManager {
	Scanner scan = new Scanner(System.in);
	Student student = new Student();

	void resistStudent() {
		Scanner scan = new Scanner(System.in);
		System.out.println("학생 이름을 입력해주세요.");
		student.name = scan.next();
		System.out.println("학생 id를 입력해주세요.");
		student.id = scan.next();
		System.out.println("학생 password를 입력해주세요.");
		student.password = scan.next();
		System.out.println("학생 국어 성적을 입력해주세요.");
		student.korScore = scan.nextInt();
		System.out.println("학생 영어 성적을 입력해주세요.");
		student.engScore = scan.nextInt();
		System.out.println("학생 수학 성적을 입력해주세요.");
		student.mathScore = scan.nextInt();
		student.addStudentList(student);
	}

	public void printAllStudentInfo() {
		Student[] studentList = student.getStudentList();
		for (int i = 0; i < student.studentCount; i++) {
			printStudentInfo(i);
		}
	}

	public void modifyStudentInfo() {
		System.out.println("정보를 수정할 학생의 번호를 입력하세요.");
		int selectorSmo = scan.nextInt() - 1;
		Student[] studentList = student.getStudentList();
		System.out.println("어떤 정보를 수정하시겠어요?");
		System.out.println("1.이름  2.id  3.password 4.국어성적  5.영어성적  6.수학성적");
		System.out.println("수정할 정보를 입력하세요.");
		int selector = scan.nextInt();
		switch (selector) {
		case 1:
			studentList[selectorSmo].name = scan.next();
			break;
		case 2:
			studentList[selectorSmo].id = scan.next();
			break;
		case 3:
			studentList[selectorSmo].password = scan.next();
			break;
		case 4:
			studentList[selectorSmo].korScore = scan.nextInt();
			break;
		case 5:
			studentList[selectorSmo].engScore = scan.nextInt();
			break;
		case 6:
			studentList[selectorSmo].mathScore = scan.nextInt();
			break;

		default:
			System.out.println("잘못된 입력입니다.");
			break;

		}
	}

	public void removeStudentInfo() {
		System.out.println("정보를 삭제할 학생의 번호를 입력하세요.");
		int selectorSmo = scan.nextInt() - 1;
		Student[] studentList = student.getStudentList();

		Student[] tmpArray = new Student[studentList.length - 1];
		for (int i = 0; i < tmpArray.length; i++) {
			if (selectorSmo <= i) {
				tmpArray[i] = studentList[i + 1];
			} else {
				tmpArray[i] = studentList[i];
			}
		}
		Student.studentList = tmpArray;

		for (int i = 0; i < Student.studentList.length; i++) {
			Student.studentList[i].smo = i + 1;
		}
		student.studentCount = studentList.length - 1;
	}

	public void printStudentInfo(int index) {
		Student[] studentList = student.getStudentList();
		System.out.printf("번호:%d  이름:%s  id:%s  password:%s 국어:%d  영어:%d  수학:%d\n", studentList[index].smo,
				studentList[index].name, studentList[index].id, studentList[index].password,
				studentList[index].korScore, studentList[index].engScore, studentList[index].mathScore);
	}

}
