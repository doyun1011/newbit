package Academy;

public class Student extends Human {

	private String subject;
	private int score;
	private int sno;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	@Override
	public String toString() {
		
		return  "[" +sno +"��  "+"�̸�:" +getName()+"  ����:"+getAge() +"  ����:" + subject + "  ����:" + score + "]";
	}
	
}
