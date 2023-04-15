package java230407;

import java.util.ArrayList;

import java230411.Student;

public class ArrayListTest {

	public static void main(String[] args) {

		Student stu1 = new Student();
		stu1.setSno(1);
		stu1.setName("길동");
		Student stu2 = new Student(2);
		stu2.setName("꺽정");
		Student stu3 = new Student(3, "지매");

		Student[] sArray = new Student[3];
		sArray[0] = stu1;
		sArray[1] = stu2;
		sArray[2] = stu3;

		ArrayList<Student> slist1 = new ArrayList<Student>();
		ArrayList<Student> slist2 = new ArrayList<>();
		slist1.add(stu1);
		slist1.add(stu2);
		slist1.add(stu3);
		Student s = slist1.get(0);
		System.out.println(s);
		System.out.println();
		for (int i = 0; i < slist1.size(); i++) {
			Student ss = slist1.get(i);
			System.out.println(ss);
		}
		System.out.println();

		slist1.set(1, stu3);
		for (Student sss : slist1) {
			System.out.println(sss);
		}
		System.out.println();
		slist1.add(1, stu3);
		for (Student sss : slist1) {
			System.out.println(sss);
		}
	}
}
