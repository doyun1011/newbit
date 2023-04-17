package academy;

public class TeacherVO extends Person{

	private String name;
	private int age;
	private String subject;
	private String id;
	private String pw;
	
	public TeacherVO() {
		this.id = "teacher";
		this.pw = "1234";
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
		return "TeacherVO [name=" + name + ", age=" + age + ", subject=" + subject + "]";
	}
	
	
}
