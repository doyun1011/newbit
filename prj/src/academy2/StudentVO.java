package academy2;

public class StudentVO extends Person{
	private int sno;
	private String name;
	private int age;
	private String subject; //Java
	private char type; // A : 실업자, B : 재직자, , C : 일반
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "StudentVO [sno=" + sno + ", name=" + name + ", age=" + age + ", subject=" + subject + ", type=" + type
				+ "]";
	}
	
	
	
}
