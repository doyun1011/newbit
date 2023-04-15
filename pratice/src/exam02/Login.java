package exam02;

public class Login {

	Student student = new Student();
	Teacher teacher = new Teacher();
	int key;

	public int login(String id, String pw) {
		Teacher teacher = new Teacher();
		if (teacher.id.equals(id) && teacher.password.equals(pw)) {

			System.out.println("안녕하세요! 관리자 계정 로그인 되었습니다.");
			return 1;
		}

		Student[] studentList = student.studentList;
		for (int i = 0; i < studentList.length; i++) {
			if (studentList[i].id.equals(id) && studentList[i].password.equals(pw)) {
				System.out.println("안녕하세요!" + studentList[i].name + "님 ");
				key = i;
				return 2;
			}
		}
		System.out.println("입력하신 아이디 혹은 비밀번호가 잘못되었습니다.");
		return -1;
	}
}
