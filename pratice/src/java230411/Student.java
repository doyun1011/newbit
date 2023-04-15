package java230411;

import java.io.Serializable;

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	private int sno;
	private String name;
	public Student() {
		
	}
	public Student(int sno) {
		this.sno = sno;
	}
	public Student(int sno, String name) {
		this.sno = sno;
		this.name = name;
	}
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
	
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", name=" + name + "]";
	}
}
