package exam02;

public class Login {

	Student student = new Student();
	Teacher teacher = new Teacher();
	int key;

	public int login(String id, String pw) {
		Teacher teacher = new Teacher();
		if (teacher.id.equals(id) && teacher.password.equals(pw)) {

			System.out.println("�ȳ��ϼ���! ������ ���� �α��� �Ǿ����ϴ�.");
			return 1;
		}

		Student[] studentList = student.studentList;
		for (int i = 0; i < studentList.length; i++) {
			if (studentList[i].id.equals(id) && studentList[i].password.equals(pw)) {
				System.out.println("�ȳ��ϼ���!" + studentList[i].name + "�� ");
				key = i;
				return 2;
			}
		}
		System.out.println("�Է��Ͻ� ���̵� Ȥ�� ��й�ȣ�� �߸��Ǿ����ϴ�.");
		return -1;
	}
}
