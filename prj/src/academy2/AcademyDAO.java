package academy2;

import java.util.ArrayList;

public class AcademyDAO {
	ArrayList<StudentVO> studentList = new ArrayList<>();
	ArrayList<TeacherVO> teacherList = new ArrayList<>();
	ArrayList<EmployeeVO> employeeList = new ArrayList<>();
	
	public AcademyDAO() {
		TeacherVO tc = new TeacherVO();
		tc.setName("교사");
		tc.setAge(42);
		tc.setSubject("Java");
		teacherList.add(tc);
		
		EmployeeVO emp = new EmployeeVO();
		emp.setEmpno("g-001");
		emp.setName("직원");
		emp.setDepartment("행정");
		emp.setPosition("사원");
		employeeList.add(emp);
	}
	
	public int loginCheck(String id, String pw) {
		int result = 0;
		for(TeacherVO tc : teacherList) {
			if(tc.getId().equals(id)) {
				if(tc.getPw().equals(pw)) {
					result = 1;
					break;
				}
			}
		}
		if(result != 1) {
			for(EmployeeVO emp : employeeList) {
				if(emp.getId().equals(id)) {
					if(emp.getPw().equals(pw)) {
						result = -1;
						break;
					}
				}
			}
		}
		return result;
	}
	
	//학생/교사/직원등록
	public void regist(Person p) {
		
		if(p.getClass() == StudentVO.class) {
			System.out.println("학생....등록중...");
			StudentVO s = (StudentVO)p;
			studentList.add(s);
		}else if(p instanceof TeacherVO) {
			System.out.println("교사등록...");
			TeacherVO tc = (TeacherVO)p;
			teacherList.add(tc);
		}else {
			System.out.println("직원등록...");
			EmployeeVO emp = (EmployeeVO)p;
			employeeList.add(emp);
		}
	}
	
	//학생조회(전체)
	public ArrayList<StudentVO> getStudnetList(){
		return studentList;
	}
	//학생개별조회
	public StudentVO getStudent(int sno) {
		StudentVO stu = null;
		for(StudentVO s : studentList) {
			if(s.getSno() == sno) {
				stu = s;
			}
		}
		return stu;
	}
	
	//교사조회(전체)
	public ArrayList<TeacherVO> getTeacherList(){
		return teacherList;
	}
	
	//직원조회(전체)
	public ArrayList<EmployeeVO> getEmployeeList(){
		return employeeList;
	}
}
