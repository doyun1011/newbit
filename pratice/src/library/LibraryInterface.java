package library;

import java.util.Scanner;

public class LibraryInterface {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("����ϰ��� �ϴ� ���񽺸� ������ �ֽʽÿ�. 1.����  2.�ݳ�  3.å �˻�");
		int selectorService = scan.nextInt();
		if (selectorService == 1) {
			System.out.println("�α����� �ʿ��� �����Դϴ�. �α����Ͻðڽ��ϱ�? ");
			System.out.println("1.�α���  2.ȸ������  3.���̵�/��й�ȣ ã�� 4.�׸��α� ");
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
