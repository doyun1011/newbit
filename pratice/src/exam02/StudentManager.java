package exam02;

import java.util.Scanner;

public class StudentManager {
	Scanner scan = new Scanner(System.in);
	Student student = new Student();

	void resistStudent() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�л� �̸��� �Է����ּ���.");
		student.name = scan.next();
		System.out.println("�л� id�� �Է����ּ���.");
		student.id = scan.next();
		System.out.println("�л� password�� �Է����ּ���.");
		student.password = scan.next();
		System.out.println("�л� ���� ������ �Է����ּ���.");
		student.korScore = scan.nextInt();
		System.out.println("�л� ���� ������ �Է����ּ���.");
		student.engScore = scan.nextInt();
		System.out.println("�л� ���� ������ �Է����ּ���.");
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
		System.out.println("������ ������ �л��� ��ȣ�� �Է��ϼ���.");
		int selectorSmo = scan.nextInt() - 1;
		Student[] studentList = student.getStudentList();
		System.out.println("� ������ �����Ͻðھ��?");
		System.out.println("1.�̸�  2.id  3.password 4.�����  5.�����  6.���м���");
		System.out.println("������ ������ �Է��ϼ���.");
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
			System.out.println("�߸��� �Է��Դϴ�.");
			break;

		}
	}

	public void removeStudentInfo() {
		System.out.println("������ ������ �л��� ��ȣ�� �Է��ϼ���.");
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
		System.out.printf("��ȣ:%d  �̸�:%s  id:%s  password:%s ����:%d  ����:%d  ����:%d\n", studentList[index].smo,
				studentList[index].name, studentList[index].id, studentList[index].password,
				studentList[index].korScore, studentList[index].engScore, studentList[index].mathScore);
	}

}
