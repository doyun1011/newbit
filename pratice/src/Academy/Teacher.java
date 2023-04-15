package Academy;

public class Teacher extends Human {

	private static int teacherCnt = 1;
	private String subject;
	private int salary;
	private int sno = teacherCnt;
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	
	public static int getTeacherCnt() {
		return teacherCnt;
	}

	public static void setTeacherCnt(int teacherCnt) {
		Teacher.teacherCnt = teacherCnt;
	}

	@Override
	public String toString() {
		
		return  "[" +sno +"번  "+"이름:" +getName()+"  나이:"+getAge() +"  과목:" + subject + "  급여:" + salary + "]";
	}
}
