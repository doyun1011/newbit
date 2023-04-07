package Academy;

public class Employee  extends Human{

	private String department;
	private static int employeeCnt = 1;
	private int salary;
	private int sno = employeeCnt;
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public static int getEmployeeCnt() {
		return employeeCnt;
	}
	public static void setEmployeeCnt(int employeeCnt) {
		Employee.employeeCnt = employeeCnt;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	@Override
	public String toString() {
		
		return  "[" +sno +"번  "+"이름:" +getName()+"  나이:"+getAge() +"  부서:" + department + "  급여:" + salary + "]";
	}
}
