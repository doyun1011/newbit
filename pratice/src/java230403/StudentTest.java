package java230403;

public class StudentTest {
	public static void main(String[] args) {
		
		Student student = new Student("Ã¶¼ö", "A");
		Student student2 = new Student("¿µÈñ", "A");
		Student student3 = new Student("³ªÈñ", "B");
		Student student4 = new Student("³²ÀÌ", "A");
		Student student5 = new Student("Ã¶ÀÌ", "B");
		Student student6 = new Student("±¹ÀÌ", "B");
		Student student7 = new Student("¹¬ÀÌ", "B");
		Student student8 = new Student("¼³ÀÌ", "A");
		Student student9 = new Student("³ª¿µ", "C");
		Student student10 = new Student("ÁöÈÆ", "A");
		
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
