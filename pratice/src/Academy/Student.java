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
		
		return  "[" +sno +"번  "+"이름:" +getName()+"  나이:"+getAge() +"  과목:" + subject + "  점수:" + score + "]";
	}
	
}
