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
		System.out.println("1.직원 2.선생님");
		int selector = scan.nextInt();
		if(selector ==1) {
			admin.adminService();
		}else if(selector ==2) {
			admin.printStudentList();
		}
	}
	public void adminService() {
		while (true) {
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.등록   2.조회   3.삭제  4.수정");

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
		System.out.println("어떤 정보를 추가할까요?");
		System.out.println("1.학생   2.강사   3.직원");
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
		System.out.println("이름을 입력하세요.");
		String name = scan.next();
		System.out.println("나이를 입력하세요.");
		int age = scan.nextInt();
		System.out.println("과목을 입력하세요.");
		String subject = scan.next();
		System.out.println("성적을 입력하세요.");
		int score = scan.nextInt();

		student.setName(name);
		student.setAge(age);
		student.setSubject(subject);
		student.setScore(score);
		studentList[studentCnt++] = student;
	}

	public void inputTeacherInfo(Teacher teacher) {
		System.out.println("이름을 입력하세요.");
		String name = scan.next();
		System.out.println("나이를 입력하세요.");
		int age = scan.nextInt();
		System.out.println("과목을 입력하세요.");
		String subject = scan.next();
		System.out.println("급여를 입력하세요.");
		int salary = scan.nextInt();

		teacher.setName(name);
		teacher.setAge(age);
		teacher.setSubject(subject);
		teacher.setSalary(salary);
		teacherList[teacherCnt++] = teacher;
	}

	public void inputEmployeeInfo(Employee employee) {
		System.out.println("이름을 입력하세요.");
		String name = scan.next();
		System.out.println("나이를 입력하세요.");
		int age = scan.nextInt();
		System.out.println("부서를 입력하세요.");
		String department = scan.next();
		System.out.println("급여를 입력하세요.");
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
			System.out.print("이름:" + employeeList[i].getName() + "  나이:" + employeeList[i].getAge());
			System.out.println("  부서:" + employeeList[i].getDepartment() + "  급여" + employeeList[i].getSalary());
		}
	}

	public void printStudentList() {
		for (int i = 0; i < studentList.length; i++) {
			if(studentList[i] == null) {
				return;
			}
			System.out.print("이름:" + studentList[i].getName() + "  나이:" + studentList[i].getAge());
			System.out.println("  과목:" + studentList[i].getSubject() + "  성적" + studentList[i].getScore());
		}
	}

	public void printTeacherList() {
		for (int i = 0; i < teacherList.length; i++) {
			if(teacherList[i] == null) {
				return;
			}
			System.out.print("이름:" + teacherList[i].getName() + "  나이:" + teacherList[i].getAge());
			System.out.println("  과목:" + teacherList[i].getSubject() + "  급여" + teacherList[i].getSalary());
		}
	}

	public void printAllList() {
		System.out.println("어떤 정보를 조회할까요?");
		System.out.println("1.학생   2.강사   3.직원");
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
		System.out.println("어떤 정보를 삭제할까요?");
		System.out.println("1.학생   2.강사   3.직원 ");
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
			System.out.println("삭제할 학생의 이름을 입력해주세요.");
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
			System.out.println("삭제할 학생의 이름을 입력해주세요.");
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
			System.out.println("삭제할 학생의 이름을 입력해주세요.");
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
			System.out.println("어떤 정보를 수정할까요?");
			System.out.println("1.학생   2.강사   3.직원 ");
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
			System.out.println("수정할 학생의 이름을 입력해주세요.");
			String name1 = scan.next();
			for (int i = 0; i < studentList.length; i++) {
				if(studentList[i] == null) {
					return;
				}
				if(studentList[i].getName().equals(name1)) {
					correctSwitchStudent(i,name1);
				}
			}
			System.out.println("일치하는 이름이 존재하지 않습니다.");
			printStudentList();
		}
		public void correctSwitchStudent(int index, String name1) {
			System.out.println("수정할 정보를 선택하세요.");
			System.out.println("1.이름  2.나이  3.과목  4.성적");
			int selector = scan.nextInt();
			System.out.println("수정할 정보를 입력하세요.");
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
			System.out.println("수정이 완료되었습니다.");
		}
		private void correctTeacher() {
			printTeacherList();
			System.out.println("수정할 학생의 이름을 입력해주세요.");
			String name1 = scan.next();
			for (int i = 0; i < teacherList.length; i++) {
				if(teacherList[i] == null) {
					return;
				}
				if(teacherList[i].getName().equals(name1)) {
					correctSwitchStudent(i,name1);
				}
			}
			System.out.println("일치하는 이름이 존재하지 않습니다.");
			printTeacherList();
		}
		public void correctSwitchTeacher(int index, String name1) {
			System.out.println("수정할 정보를 선택하세요.");
			System.out.println("1.이름  2.나이  3.과목  4.성적");
			int selector = scan.nextInt();
			System.out.println("수정할 정보를 입력하세요.");
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
			System.out.println("수정이 완료되었습니다.");
		}
	
		private void correctEmployee() {
			printEmployeeList();
			System.out.println("수정할 학생의 이름을 입력해주세요.");
			String name1 = scan.next();
			for (int i = 0; i < employeeList.length; i++) {
				if(employeeList[i] == null) {
					return;
				}
				if(employeeList[i].getName().equals(name1)) {
					correctSwitchStudent(i,name1);
				}
			}
			System.out.println("일치하는 이름이 존재하지 않습니다.");
			printEmployeeList();
		}
		public void correctSwitchEmplyee(int index, String name1) {
			System.out.println("수정할 정보를 선택하세요.");
			System.out.println("1.이름  2.나이  3.과목  4.성적");
			int selector = scan.nextInt();
			System.out.println("수정할 정보를 입력하세요.");
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
			System.out.println("수정이 완료되었습니다.");
		}
		
		
}
