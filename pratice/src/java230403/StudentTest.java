package java230403;

public class StudentTest {
	public static void main(String[] args) {
		
		Student student = new Student("ö��", "A");
		Student student2 = new Student("����", "A");
		Student student3 = new Student("����", "B");
		Student student4 = new Student("����", "A");
		Student student5 = new Student("ö��", "B");
		Student student6 = new Student("����", "B");
		Student student7 = new Student("����", "B");
		Student student8 = new Student("����", "A");
		Student student9 = new Student("����", "C");
		Student student10 = new Student("����", "A");
		
		student.printClassStudentInfo("A");
		line();
		student.printClassStudentInfo("B");
		line();
		student.printClassStudentInfo("C");
		line();
		student.totalStudentNum();
	}
	static void line() {
		System.out.println("==================================");
	}
}
