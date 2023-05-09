package academy2;

public class EmployeeVO extends Person{
	private String empno;
	private String name;
	private String department;
	private String Position;
	private String id;
	private String pw;
	
	public EmployeeVO() {
		this.id = "emp";
		this.pw = "1234";
	}
	
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String position) {
		Position = position;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getPw() {
		return pw;
	}
	@Override
	public String toString() {
		return "EmployeeVO [empno=" + empno + ", name=" + name + ", department=" + department + ", Position=" + Position
				+ "]";
	}
	
	
	
}
