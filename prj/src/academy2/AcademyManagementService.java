package academy2;

import java.util.ArrayList;

public class AcademyManagementService {
	
	AcademyDAO dao = new AcademyDAO();
	
	public AcademyManagementService() {
	}
	public int loginCheck(String id, String pw) {
		int result = dao.loginCheck(id, pw);
		
		return result;
	}
	
	//학생/교사/직원등록
	public void regist(Person p) {
		dao.regist(p);
	}
	
	//학생조회(전체)
	public ArrayList<StudentVO> getStudnetList(){
		return dao.getStudnetList();
	}
	//학생개별조회
	public StudentVO getStudent(int sno) {
		StudentVO stu = dao.getStudent(sno);
		
		return stu;
	}
	
	//교사조회(전체)
	public ArrayList<TeacherVO> getTeacherList(){
		return dao.getTeacherList();
	}
	
	//직원조회(전체)
	public ArrayList<EmployeeVO> getEmployeeList(){
		return dao.getEmployeeList();
	}
}
