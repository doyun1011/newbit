package library;

import java.util.Scanner;

public class LibraryInterface {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("사용하고자 하는 서비스를 선택해 주십시오. 1.대출  2.반납  3.책 검색");
		int selectorService = scan.nextInt();
		if (selectorService == 1) {
			System.out.println("로그인이 필요한 서비스입니다. 로그인하시겠습니까? ");
			System.out.println("1.로그인  2.회원가입  3.아이디/비밀번호 찾기 4.그만두기 ");
			int selector = scan.nextInt();
			switch (selector) {
			case 1:
				login();
				break;
			case 2:
				joinMembership();
				break;
			case 3:
				findIdPassword();
				break;
			case 4:

				break;

			default:
				break;
			}
		}
	}

	private static void findIdPassword() {
		// TODO Auto-generated method stub

	}

	private static void joinMembership() {
		// TODO Auto-generated method stub

	}

	private static void login() {
		// TODO Auto-generated method stub

	}
}
