package exam02;

public class Student {

	static Student[] studentList = { new Student("√∂¿Ã", "ow", "1234", 40, 50, 60),
	new Student("±π¿Ã", "owe", "1234", 60, 50, 70)};
	int smo = 0;
	static int studentCount = 0;
	String name;
	String id;
	String password;
	int korScore;
	int engScore;
	int mathScore;

	public Student() {
		smo = ++studentCount;
		System.out.println(smo);
	}

	Student(String name, String id, String password, int KorScore, int engScore, int mathScore) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.korScore = KorScore;
		this.engScore = engScore;
		this.mathScore = mathScore;
		smo = ++studentCount;
	}

	public Student[] getStudentList() {
		return studentList;
	}

	public void addStudentList(Student student) {
		expandStudentList();
		studentCount++;
		
		studentList[studentCount - 1] = student;
		studentList[studentCount - 1].smo = studentCount;

	}

	public void expandStudentList() {
		Student[] tmpArray = new Student[studentList.length + 1];
		for (int i = 0; i < studentList.length; i++) {
			tmpArray[i] = studentList[i];
		}
		studentList = tmpArray;
	}


}
