package java230403;

public class Student {
	int smo = 0;
	String name;
	String greenClass;
	static int studentCount = 0;
	static Student[] students = new Student[10];

	public Student() {
		
	}

	public Student(String name, String greenClass) {
		Student student = new Student();
		student.smo = studentCount+1;
		student.name = name;
		student.greenClass = greenClass;
		
		int index = studentCount;
		students[index] = student;
		
		studentCount++;

	}

	public void printStudentCount() {
		System.out.println("총 학생 수는 " + studentCount + "명입니다.");
	}

	public void printClassStudentInfo(String greenClass) {
		for (int i = 0; i < students.length; i++) {
			if (students[i].greenClass.equals(greenClass)) {
				System.out.println(students[i].greenClass + "반\t" + students[i].smo + "번" + "\t이름:" + students[i].name);
			}
		}
	}

}
