package Academy;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminManagementSystem {

	Student student = new Student();
	Teacher teacher = new Teacher();
	Employee employee = new Employee();
	Scanner scan = new Scanner(System.in);
	ArrayList<Student> studentList = new ArrayList<Student>();
	ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
	ArrayList<Employee> employeeList = new ArrayList<Employee>();
	int studentCnt;
	int teacherCnt;
	int employeeCnt;

	//������ �� Ŭ������ ������
	//�ٸ� Ŭ�������� ����Ÿ���� �ʿ��ϴٸ� ���������� �ִ��� �ذ�
	//�޼ҵ忡 ����� �ʵ忡 ������ ����
	//�Ѱ��� ������ ����ȭ
	//�ٸ� Ŭ�������� List�� ��ü �����
	//get, set 
	//�ٸ� Ŭ������ ������ �迭�� �����ߴٸ�
	//main�� static �׸��� method
	
	

		public static void main(String[] args) {
			AdminManagementSystem admin2 = new AdminManagementSystem();
			AdminSystem admin = new AdminSystem();
			Scanner scan = new Scanner(System.in);
			System.out.println("1.���� 2.������");
			int selector = scan.nextInt();
			if(selector ==1) {
				admin2.adminService();
			}else if(selector ==2) {
				admin2.printStudentList();
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
					modifyList();
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
				inputStudentInfo();
				break;
			case 2:
				inputTeacherInfo();
				break;
			case 3:
				inputEmployeeInfo();
				break;

			default:
				break;
			}

		}
			public void inputStudentInfo() {
				Student student = new Student();
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
				student.setSno(++studentCnt);
				
				studentList.add(student);
			}
			public void inputTeacherInfo() {
				Teacher teacher = new Teacher();
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
				teacher.setSno(++teacherCnt);
				
				teacherList.add(teacher);
			}

			public void inputEmployeeInfo() {
				Employee employee = new Employee();
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
				employee.setSno(++employeeCnt);
				
				employeeList.add(employee);
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
			private void printStudentList() {
				for(Student student: studentList) {
					System.out.println(student);
				}
			}
			private void printTeacherList() {
				for(Teacher teacher: teacherList) {
					System.out.println(teacher);
				}
			}
			private void printEmployeeList() {
				for(Employee employee: employeeList) {
					System.out.println(employee);
				}
			}
			private void deleteList() {
				System.out.println("1.�л�  2.����  3.����");
				int selector = scan.nextInt();
				printStudentList();
				System.out.println("������ �����ϰ� ���� ����� ��ȣ�� �Է��ϼ���.");
				int selectNum = scan.nextInt()-1;
				switch (selector) {
				case 1: 
					deleteStudentList(selectNum);
					break;
				case 2:
					deleteTeacherList(selectNum);
					break;
				case 3:
					deleteEmployeeList(selectNum);
					break;

				default:
					break;
				}
			}
			private void deleteStudentList(int num) {
				studentList.remove(num);
			}
			private void deleteTeacherList(int num) {
				teacherList.remove(num);
			}
			private void deleteEmployeeList(int num) {
				employeeList.remove(num);
			}
			
			private void modifyList() {
				System.out.println("1.�л�  2.����  3.����");
				int selector = scan.nextInt();
				printStudentList();
				System.out.println("������ �����ϰ� ���� ����� ��ȣ�� �Է��ϼ���.");
				int selectNum = scan.nextInt()-1;
				
				switch (selector) {
				case 1: 
					modifyStudentList(selectNum);
					break;
				case 2:
					modifyTeacherList(selectNum);
					break;
				case 3:
					modifyEmployeeList(selectNum);
					break;

				default:
					break;
				}
				printStudentList();
			}
			
			
			private void modifyStudentList(int index) {
				System.out.println("������ ������ �����ϼ���.");
				System.out.println("1.�̸�  2.����  3.����  4.����");
				int selector = scan.nextInt();
				System.out.println("������ ������ �Է��ϼ���.");
				Student student = new Student();
				switch (selector) {
				case 1:
					String name = scan.next();
					student= studentList.get(index);
					student.setName(name);
					studentList.set(index, student);
					break;
				case 2:
					int age = scan.nextInt();
					student= studentList.get(index);
					student.setAge(age);
					studentList.set(index, student);
					break;
				case 3:
					String subject = scan.next();
					student= studentList.get(index);
					student.setSubject(subject);
					studentList.set(index, student);
					break;
				case 4:
					int score = scan.nextInt();
					student= studentList.get(index);
					student.setScore(score);
					studentList.set(index, student);
					break;

				default:
					break;
				}
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
			}
			
			private void modifyTeacherList(int index) {
				System.out.println("������ ������ �����ϼ���.");
				System.out.println("1.�̸�  2.����  3.����  4.�޿�");
				int selector = scan.nextInt();
				System.out.println("������ ������ �Է��ϼ���.");
				Teacher teacher = new Teacher();
				switch (selector) {
				case 1:
					String name = scan.next();
					teacher= teacherList.get(index);
					teacher.setName(name);
					teacherList.set(index, teacher);
					break;
				case 2:
					int age = scan.nextInt();
					teacher= teacherList.get(index);
					teacher.setAge(age);
					teacherList.set(index, teacher);
					break;
				case 3:
					String subject = scan.next();
					teacher= teacherList.get(index);
					teacher.setSubject(subject);
					teacherList.set(index, teacher);
					break;
				case 4:
					int salary = scan.nextInt();
					teacher= teacherList.get(index);
					teacher.setSalary(salary);
					teacherList.set(index, teacher);
					break;

				default:
					break;
				}
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
			}
			private void modifyEmployeeList(int index) {
				System.out.println("������ ������ �����ϼ���.");
				System.out.println("1.�̸�  2.����  3.�μ�  4.�޿�");
				int selector = scan.nextInt();
				System.out.println("������ ������ �Է��ϼ���.");
				Employee employee = new Employee();
				switch (selector) {
				case 1:
					String name = scan.next();
					employee= employeeList.get(index);
					employee.setName(name);
					employeeList.set(index, employee);
					break;
				case 2:
					int age = scan.nextInt();
					employee= employeeList.get(index);
					employee.setAge(age);
					employeeList.set(index, employee);
					break;
				case 3:
					String department = scan.next();
					employee= employeeList.get(index);
					employee.setDepartment(department);
					employeeList.set(index,employee);
					break;
				case 4:
					int salary = scan.nextInt();
					employee= employeeList.get(index);
					employee.setSalary(salary);
					employeeList.set(index, employee);
					break;

				default:
					break;
				}
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
			}
			
		
	}

