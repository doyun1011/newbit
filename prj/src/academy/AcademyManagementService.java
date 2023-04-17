package academy;

import java.util.ArrayList;

public class AcademyManagementService {
	ArrayList<StudentVO> studentList = new ArrayList<>();
	ArrayList<TeacherVO> teacherList = new ArrayList<>();
	ArrayList<EmployeeVO> employeeList = new ArrayList<>();
	
	public AcademyManagementService() {
		TeacherVO tc = new TeacherVO();
		tc.setName("援먯궗");
		tc.setAge(42);
		tc.setSubject("Java");
		teacherList.add(tc);    
		  
		EmployeeVO emp = new EmployeeVO();
		emp.setEmpno("g-001");
		emp.setName("吏곸썝");
		emp.setDepartment("�뻾�젙");
		emp.setPosition("�궗�썝");
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
	
	//�븰�깮/援먯궗/吏곸썝�벑濡�
	public void regist(Person p) {
		System.out.println("regist....�벑濡앹쨷...");
		if(p.getClass() == StudentVO.class) {
			StudentVO s = (StudentVO)p;
			studentList.add(s);
		}else if(p instanceof TeacherVO) {
			TeacherVO tc = (TeacherVO)p;
			teacherList.add(tc);
		}else {
			EmployeeVO emp = (EmployeeVO)p;
			employeeList.add(emp);
		}
	}
	
	//�븰�깮議고쉶(�쟾泥�)
	public ArrayList<StudentVO> getStudnetList(){
		return studentList;
	}
	//�븰�깮媛쒕퀎議고쉶
	public StudentVO getStudent(int sno) {
		StudentVO stu = null;
		for(StudentVO s : studentList) {
			if(s.getSno() == sno) {
				stu = s;
				break;
			}
		}
		return stu;
	}
	
	//援먯궗議고쉶(�쟾泥�)
	public ArrayList<TeacherVO> getTeacherList(){
		return teacherList;
	}
	
	//吏곸썝議고쉶(�쟾泥�)
	public ArrayList<EmployeeVO> getEmployeeList(){
		return employeeList;
	}
}
