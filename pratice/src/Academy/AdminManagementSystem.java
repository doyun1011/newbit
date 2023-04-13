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

	//변수는 한 클레스에 모으자
	//다른 클래스에서 참조타입이 필요하다면 지역변수로 최대한 해결
	//메소드에 선언과 필드에 선언의 차이
	//넘겨준 변수의 값변화
	//다른 클래스에서 List에 객체 저장법
	//get, set 
	//다른 클래스에 동일한 배열을 선언했다면
	//main과 static 그리고 method
	
	

		public static void main(String[] args) {
			AdminManagementSystem admin2 = new AdminManagementSystem();
			AdminSystem admin = new AdminSystem();
			Scanner scan = new Scanner(System.in);
			System.out.println("1.직원 2.선생님");
			int selector = scan.nextInt();
			if(selector ==1) {
				admin2.adminService();
			}else if(selector ==2) {
				admin2.printStudentList();
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
					modifyList();
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
				student.setSno(++studentCnt);
				
				studentList.add(student);
			}
			public void inputTeacherInfo() {
				Teacher teacher = new Teacher();
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
				teacher.setSno(++teacherCnt);
				
				teacherList.add(teacher);
			}

			public void inputEmployeeInfo() {
				Employee employee = new Employee();
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
				employee.setSno(++employeeCnt);
				
				employeeList.add(employee);
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
				System.out.println("1.학생  2.강사  3.직원");
				int selector = scan.nextInt();
				printStudentList();
				System.out.println("정보를 삭제하고 싶은 사람의 번호를 입력하세요.");
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
				System.out.println("1.학생  2.강사  3.직원");
				int selector = scan.nextInt();
				printStudentList();
				System.out.println("정보를 수정하고 싶은 사람의 번호를 입력하세요.");
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
				System.out.println("수정할 정보를 선택하세요.");
				System.out.println("1.이름  2.나이  3.과목  4.성적");
				int selector = scan.nextInt();
				System.out.println("수정할 정보를 입력하세요.");
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
				System.out.println("수정이 완료되었습니다.");
			}
			
			private void modifyTeacherList(int index) {
				System.out.println("수정할 정보를 선택하세요.");
				System.out.println("1.이름  2.나이  3.과목  4.급여");
				int selector = scan.nextInt();
				System.out.println("수정할 정보를 입력하세요.");
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
				System.out.println("수정이 완료되었습니다.");
			}
			private void modifyEmployeeList(int index) {
				System.out.println("수정할 정보를 선택하세요.");
				System.out.println("1.이름  2.나이  3.부서  4.급여");
				int selector = scan.nextInt();
				System.out.println("수정할 정보를 입력하세요.");
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
				System.out.println("수정이 완료되었습니다.");
			}
			
		
	}

