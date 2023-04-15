package academy;

import java.util.ArrayList;

public class AcademyManagementService {
	ArrayList<StudentVO> studentList = new ArrayList<>();
	ArrayList<TeacherVO> teacherList = new ArrayList<>();
	ArrayList<EmployeeVO> employeeList = new ArrayList<>();
	
	public AcademyManagementService() {
		TeacherVO tc = new TeacherVO();
		tc.setName("?´ë¨?ê¶?");
		tc.setAge(42);
		tc.setSubject("Java");
		teacherList.add(tc);    
		  
		EmployeeVO emp = new EmployeeVO();
		emp.setEmpno("g-001");
		emp.setName("ï§ê³¸?");
		emp.setDepartment("ï¿½ë»¾ï¿½ì ™");
		emp.setPosition("ï¿½ê¶—ï¿½ì");
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
	
	//ï¿½ë¸°ï¿½ê¹®/?´ë¨?ê¶?/ï§ê³¸?ï¿½ë²‘æ¿¡ï¿½
	public void regist(Person p) {
		System.out.println("regist....ï¿½ë²‘æ¿¡ì•¹ì¨?...");
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
	
	//ï¿½ë¸°ï¿½ê¹®è­°ê³ ?‰¶(ï¿½ìŸ¾ï§£ï¿½)
	public ArrayList<StudentVO> getStudnetList(){
		return studentList;
	}
	//ï¿½ë¸°ï¿½ê¹®åª›ì’•?è?°ê³ ?‰¶
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
	
	//?´ë¨?ê¶—è?°ê³ ?‰¶(ï¿½ìŸ¾ï§£ï¿½)
	public ArrayList<TeacherVO> getTeacherList(){
		return teacherList;
	}
	
	//ï§ê³¸?è­°ê³ ?‰¶(ï¿½ìŸ¾ï§£ï¿½)
	public ArrayList<EmployeeVO> getEmployeeList(){
		return employeeList;
	}
}
