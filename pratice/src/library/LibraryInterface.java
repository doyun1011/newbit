package library;

import java.util.Scanner;

public class LibraryInterface {
	Book book = new Book();
	User user = new User();
	int key;
	int remainBorrowCount = 3;

	public static void main(String[] args) {

		LibraryInterface li = new LibraryInterface();
		Scanner scan = new Scanner(System.in);
		System.out.println("����ϰ��� �ϴ� ���񽺸� ������ �ֽʽÿ�. 1.����  2.�ݳ�  3.å �˻�");
		int selectorService = scan.nextInt();
		if (selectorService == 1) {
			System.out.println("�α����� �ʿ��� �����Դϴ�. �α����Ͻðڽ��ϱ�? ");
			System.out.println("1.�α���  2.ȸ������  3.���̵�/��й�ȣ ã�� 4.�׸��α� ");
			int selector = scan.nextInt();
			switch (selector) {
			case 1:
				li.login();
				li.borrowBook();
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

	private void borrowBook() {
		while (true) {
			if (remainBorrowCount == 0) {
				System.out.println("�� �̻� ������ �Ұ����մϴ�.");
				return;
			}
			Scanner scan = new Scanner(System.in);
			System.out.println("�����ϰ��� �ϴ� å�� ������ �Է��ϼ���. �׸��α� 'n'");
			String title = scan.next();
			Book[] bookList = book.getBookList();
			if (title == "n") {
				return;
			}
			availableBorrow(title, bookList);
		}
	}

	private void availableBorrow(String title, Book[] bookList) {
		for (int i = 0; i < bookList.length; i++) {
			if (title.equals(bookList[i].getTitle()) && bookList[i].getborrowStatus() == false) {
				remainBorrowCount--;
				System.out.println("������ �Ϸ�Ǿ����ϴ�. " + "���� ���Ⱑ�� Ƚ��:" + remainBorrowCount);
				return;
			} else if (title.equals(bookList[i].getTitle()) && bookList[i].getborrowStatus() == true) {
				System.out.println("�̹� ����� ���� �Դϴ�. �ٸ� ������ �Է����ּ���.");
				return;
			}
		}
		System.out.println("�Է��Ͻ� ����� ��ġ�ϴ� å�� �������� �ʽ��ϴ�.");
		return;
	}

	private static void findIdPassword() {
		// TODO Auto-generated method stub

	}

	private static void joinMembership() {
		// TODO Auto-generated method stub

	}

	private void login() {
		user.adminCreate("admin", "1234");
		Scanner scan = new Scanner(System.in);
		System.out.println("ID�� �Է����ּ���.");
		String userId = scan.next();
		System.out.println("��й�ȣ�� �Է����ּ���.");
		String userPassword = scan.next();
		User[] userList = user.getUserList();
		key = getIndexUserList(userList, userId, userPassword);
		if (key == -1) {
			System.out.println("���̵� Ȥ�� ��й�ȣ�� �߸� �Է��ϼ̽��ϴ�.");
			return;
		}

	}

	private int getIndexUserList(User[] userList, String userId, String userPassword) {
		for (int i = 0; i < userList.length; i++) {
			if (userList[i].getId().equals(userId) && userList[i].getPassword().equals(userPassword)) {
				System.out.println("�������." + userList[i].getName() + "�� �׸��������� �湮�Ͻ� ���� ȯ���մϴ�!\n\n");
				return i;
			}
		}
		return -1;
	}
}
