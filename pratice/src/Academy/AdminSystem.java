package Academy;

import java.util.Scanner;

public class AdminSystem {
	Student student = new Student();
	Teacher teacher = new Teacher();
	Employee employee = new Employee();
	Scanner scan = new Scanner(System.in);
	Student[] studentList = new Student[100];
	Teacher[] teacherList = new Teacher[100];
	Employee[] employeeList = new Employee[100];
	int studentCnt = 0;
	int teacherCnt = 0;
	int employeeCnt = 0;

	public static void main(String[] args) {
		AdminSystem admin = new AdminSystem();
		Scanner scan = new Scanner(System.in);
		System.out.println("1.���� 2.������");
		int selector = scan.nextInt();
		if(selector ==1) {
			admin.adminService();
		}else if(selector ==2) {
			admin.printStudentList();
		}
	}
	public void adminService() {
		while (true) {
			System.out.println("� ������ �Ͻðڽ��ϱ�?");
			System.out.println("1.���   2.��ȸ   3.����  4.����");

			int selector = scan.nextInt();
			switch (selector) {
			case 1:
				registInfoList();
				break;
			case 2:
				printAllList();
				break;
			case 3:
				deleteList();
				break;
			case 4:
				correctList();
				break;

			default:
				return;
				
			}
		}
	}

	public void registInfoList() {
		System.out.println("� ������ �߰��ұ��?");
		System.out.println("1.�л�   2.����   3.����");
		int selector = scan.nextInt();
		switch (selector) {
		case 1:
			Human human1 = new Student();
			inputInfoList(human1);
			break;
		case 2:
			Human human2 = new Teacher();
			inputInfoList(human2);
			break;
		case 3:
			Human human3 = new Employee();
			inputInfoList(human3);
			break;

		default:
			break;
		}

	}

	public void inputInfoList(Human human) {
		if (human instanceof Student) {
			Student student = (Student) human;
			inputStudentInfo(student);
		} else if (human instanceof Teacher) {
			Teacher teacher = (Teacher) human;
			inputTeacherInfo(teacher);
		} else if (human instanceof Employee) {
			Employee employee = (Employee) human;
			inputEmployeeInfo(employee);
		}
	}

	public void inputStudentInfo(Student student) {
		System.out.println("�̸��� �Է��ϼ���.");
		String name = scan.next();
		System.out.println("���̸� �Է��ϼ���.");
		int age = scan.nextInt();
		System.out.println("������ �Է��ϼ���.");
		String subject = scan.next();
		System.out.println("������ �Է��ϼ���.");
		int score = scan.nextInt();

		student.setName(name);
		student.setAge(age);
		student.setSubject(subject);
		student.setScore(score);
		studentList[studentCnt++] = student;
	}

	public void inputTeacherInfo(Teacher teacher) {
		System.out.println("�̸��� �Է��ϼ���.");
		String name = scan.next();
		System.out.println("���̸� �Է��ϼ���.");
		int age = scan.nextInt();
		System.out.println("������ �Է��ϼ���.");
		String subject = scan.next();
		System.out.println("�޿��� �Է��ϼ���.");
		int salary = scan.nextInt();

		teacher.setName(name);
		teacher.setAge(age);
		teacher.setSubject(subject);
		teacher.setSalary(salary);
		teacherList[teacherCnt++] = teacher;
	}

	public void inputEmployeeInfo(Employee employee) {
		System.out.println("�̸��� �Է��ϼ���.");
		String name = scan.next();
		System.out.println("���̸� �Է��ϼ���.");
		int age = scan.nextInt();
		System.out.println("�μ��� �Է��ϼ���.");
		String department = scan.next();
		System.out.println("�޿��� �Է��ϼ���.");
		int salary = scan.nextInt();

		employee.setName(name);
		employee.setAge(age);
		employee.setDepartment(department);
		employee.setSalary(salary);
		employeeList[employeeCnt++] = employee;
	}

	public void printEmployeeList() {
		for (int i = 0; i < employeeList.length; i++) {
			if(employeeList[i] == null) {
				return;
			}
			System.out.print("�̸�:" + employeeList[i].getName() + "  ����:" + employeeList[i].getAge());
			System.out.println("  �μ�:" + employeeList[i].getDepartment() + "  �޿�" + employeeList[i].getSalary());
		}
	}

	public void printStudentList() {
		for (int i = 0; i < studentList.length; i++) {
			if(studentList[i] == null) {
				return;
			}
			System.out.print("�̸�:" + studentList[i].getName() + "  ����:" + studentList[i].getAge());
			System.out.println("  ����:" + studentList[i].getSubject() + "  ����" + studentList[i].getScore());
		}
	}

	public void printTeacherList() {
		for (int i = 0; i < teacherList.length; i++) {
			if(teacherList[i] == null) {
				return;
			}
			System.out.print("�̸�:" + teacherList[i].getName() + "  ����:" + teacherList[i].getAge());
			System.out.println("  ����:" + teacherList[i].getSubject() + "  �޿�" + teacherList[i].getSalary());
		}
	}

	public void printAllList() {
		System.out.println("� ������ ��ȸ�ұ��?");
		System.out.println("1.�л�   2.����   3.����");
		int selector = scan.nextInt();
		switch (selector) {
		case 1:
			printStudentList();
			break;
		case 2:
			printTeacherList();
			break;
		case 3:
			printEmployeeList();
			break;

		default:
			break;
		}
	}
	public void deleteList() {
		System.out.println("� ������ �����ұ��?");
		System.out.println("1.�л�   2.����   3.���� ");
		int selector = scan.nextInt();
		switch (selector) {
		case 1:
			deleteStudent();
			break;
		case 2:
			deleteTeacher();
			break;
		case 3:
			deleteEmployee();
			break;

		default:
			break;
		}
	}
		public void deleteStudent() {
			printStudentList();
			System.out.println("������ �л��� �̸��� �Է����ּ���.");
			String name = scan.next();
			for (int i = 0; i < studentList.length; i++) {
				if(studentList[i] == null) {
					return;
				}
				if(studentList[i].equals(name)) {
					reduceStudentList(i);
				}
			}
			printStudentList();
		}
		public void reduceStudentList(int index) {
			Student[] tmpArray = new Student[studentList.length-1];
			for (int i = 0; i < tmpArray.length; i++) {
				tmpArray[i] = studentList[i];
				if(index<= i) {
					tmpArray[i] = studentList[i+1];
				}
			}
			studentList = tmpArray;
		}
		public void deleteTeacher() {
			printTeacherList();
			System.out.println("������ �л��� �̸��� �Է����ּ���.");
			String name = scan.next();
			for (int i = 0; i < teacherList.length; i++) {
				if(teacherList[i] == null) {
					return;
				}
				if(teacherList[i].equals(name)) {
					reduceTeacherList(i);
				}
			}
			printTeacherList();
		}
		public void reduceTeacherList(int index) {
			Teacher[] tmpArray = new Teacher[teacherList.length-1];
			for (int i = 0; i < tmpArray.length; i++) {
				tmpArray[i] = teacherList[i];
				if(index<= i) {
					tmpArray[i] = teacherList[i+1];
				}
			}
			teacherList = tmpArray;
		}
		public void deleteEmployee() {
			printEmployeeList();
			System.out.println("������ �л��� �̸��� �Է����ּ���.");
			String name = scan.next();
			for (int i = 0; i < employeeList.length; i++) {
				if(employeeList[i] == null) {
					return;
				}
				if(employeeList[i].equals(name)) {
					reduceEmployeeList(i);
				}
			}
			printEmployeeList();
		}
		public void reduceEmployeeList(int index) {
			Employee[] tmpArray = new Employee[employeeList.length-1];
			for (int i = 0; i < tmpArray.length; i++) {
				tmpArray[i] = employeeList[i];
				if(index<= i) {
					tmpArray[i] = employeeList[i+1];
				}
			}
			employeeList = tmpArray;
		}
		public void correctList() {
			System.out.println("� ������ �����ұ��?");
			System.out.println("1.�л�   2.����   3.���� ");
			int selector = scan.nextInt();
			switch (selector) {
			case 1:
				correctStudent();
				break;
			case 2:
				correctTeacher();
				break;
			case 3:
				correctEmployee();
				break;

			default:
				break;
			}
		}



		private void correctStudent() {
			printStudentList();
			System.out.println("������ �л��� �̸��� �Է����ּ���.");
			String name1 = scan.next();
			for (int i = 0; i < studentList.length; i++) {
				if(studentList[i] == null) {
					return;
				}
				if(studentList[i].getName().equals(name1)) {
					correctSwitchStudent(i,name1);
				}
			}
			System.out.println("��ġ�ϴ� �̸��� �������� �ʽ��ϴ�.");
			printStudentList();
		}
		public void correctSwitchStudent(int index, String name1) {
			System.out.println("������ ������ �����ϼ���.");
			System.out.println("1.�̸�  2.����  3.����  4.����");
			int selector = scan.nextInt();
			System.out.println("������ ������ �Է��ϼ���.");
			switch (selector) {
			case 1:
				String name2 = scan.next();
				studentList[index].setName(name2);
				break;
			case 2:
				int age = scan.nextInt();
				studentList[index].setAge(age);
				break;
			case 3:
				String subject = scan.next();
				studentList[index].setSubject(subject);;
				break;
			case 4:
				int score = scan.nextInt();
				studentList[index].setScore(score);
				break;

			default:
				break;
			}
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		}
		private void correctTeacher() {
			printTeacherList();
			System.out.println("������ �л��� �̸��� �Է����ּ���.");
			String name1 = scan.next();
			for (int i = 0; i < teacherList.length; i++) {
				if(teacherList[i] == null) {
					return;
				}
				if(teacherList[i].getName().equals(name1)) {
					correctSwitchStudent(i,name1);
				}
			}
			System.out.println("��ġ�ϴ� �̸��� �������� �ʽ��ϴ�.");
			printTeacherList();
		}
		public void correctSwitchTeacher(int index, String name1) {
			System.out.println("������ ������ �����ϼ���.");
			System.out.println("1.�̸�  2.����  3.����  4.����");
			int selector = scan.nextInt();
			System.out.println("������ ������ �Է��ϼ���.");
			switch (selector) {
			case 1:
				String name2 = scan.next();
				teacherList[index].setName(name2);
				break;
			case 2:
				int age = scan.nextInt();
				teacherList[index].setAge(age);
				break;
			case 3:
				String subject = scan.next();
				teacherList[index].setSubject(subject);
				break;
			case 4:
				int salary = scan.nextInt();
				teacherList[index].setSalary(salary);
				break;
				
			default:
				break;
			}
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		}
	
		private void correctEmployee() {
			printEmployeeList();
			System.out.println("������ �л��� �̸��� �Է����ּ���.");
			String name1 = scan.next();
			for (int i = 0; i < employeeList.length; i++) {
				if(employeeList[i] == null) {
					return;
				}
				if(employeeList[i].getName().equals(name1)) {
					correctSwitchStudent(i,name1);
				}
			}
			System.out.println("��ġ�ϴ� �̸��� �������� �ʽ��ϴ�.");
			printEmployeeList();
		}
		public void correctSwitchEmplyee(int index, String name1) {
			System.out.println("������ ������ �����ϼ���.");
			System.out.println("1.�̸�  2.����  3.����  4.����");
			int selector = scan.nextInt();
			System.out.println("������ ������ �Է��ϼ���.");
			switch (selector) {
			case 1:
				String name2 = scan.next();
				employeeList[index].setName(name2);
				break;
			case 2:
				int age = scan.nextInt();
				employeeList[index].setAge(age);
				break;
			case 3:
				String department = scan.next();
				employeeList[index].setDepartment(department);
				break;
			case 4:
				int salary = scan.nextInt();
				employeeList[index].setSalary(salary);
				break;
				
			default:
				break;
			}
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		}
		
		
}
