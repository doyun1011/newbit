package library;

import java.util.Scanner;

public class Administrator {
	private String id;
	private String password;
	User user = new User();
	Book book = new Book();
	Scanner scan = new Scanner(System.in);
	UserInterface library = new UserInterface();
	User[] userList = library.getUserList();
	Book[] bookList = { new Book("�ڹ�������", "���", "���ü�", "A") };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Administrator admin = new Administrator();
		System.out.println("1.��������  2.å����");
		int selector = scan.nextInt();

		int selectorOfUser;
		int selectorOfBook;

		if (selector == 1) {
			admin.printUserList();
			System.out.println("1.���� ���� 2.���� ����");
			selectorOfUser = scan.nextInt();

			if (selectorOfUser == 1) {
				admin.modifyUserList();
			} else if (selectorOfUser == 2) {
				admin.deleteUserList();
			}
			admin.printUserList();
		}

		else if (selector == 2) {
			admin.printBookList();
			System.out.println("1.å ���� 2.å ����");
			selectorOfBook = scan.nextInt();

			if (selectorOfBook == 1) {
				admin.modifyBookList();
			} else if (selectorOfBook == 2) {
				admin.deleteBookList();
			}
			admin.printBookList();
		}

	}

	public void printUserList() {
		for (int i = 0; i < userList.length; i++) {
			System.out.println(userList[i]);
		}
	}

	public void modifyUserList() {
		System.out.println("ȸ�������� �����Ͻ÷��� �ش� id�� �Է����ּ���.");
		String userId = scan.next();
		int index = searchId(userList, userId);
		if (index == -1) {
			return;
		}
		modifySwitchUser(index);
	}

	public int searchId(User[] userList, String userId) {
		for (int i = 0; i < userList.length; i++) {
			if (userList[i].getId().equals(userId)) {
				return i;
			}

		}
		System.out.println("�ش� id�� �������� �ʽ��ϴ�.");
		return -1;
	}

	public void modifySwitchUser(int index) {
		System.out.println("� ������ �����Ͻðڽ��ϱ�?. 1.�̸�  2.�ֹι�ȣ  3. �ڵ��� ��ȣ");
		int modifySelector = scan.nextInt();
		System.out.println("������ ������ �Է��ϼ���.");
		switch (modifySelector) {
		case 1:
			String newName = scan.next();
			userList[index].setName(newName);
			break;
		case 2:
			int newSsn = scan.nextInt();
			userList[index].setSsn(newSsn);
			break;
		case 3:
			int newPhoneNumber = scan.nextInt();
			userList[index].setPhoneNumber(newPhoneNumber);
			break;
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			break;
		}
	}

	public void deleteUserList() {
		System.out.println("ȸ�������� �����Ͻ÷��� �ش� id�� �Է����ּ���.");
		String userId = scan.next();
		int index = searchId(userList, userId);
		if (index != -1) {
			reductionUserList(index);
			System.out.println("�����Ǿ����ϴ�.");
		}
	}

	public void reductionUserList(int index) {
		User[] tmpArray = new User[userList.length - 1];
		for (int i = 0; i < tmpArray.length; i++) {
			tmpArray[i] = userList[i];
			if (index <= i) {
				tmpArray[i] = userList[i + 1];
			}
		}
		userList = tmpArray;
	}

	public void printBookList() {
		for (int i = 0; i < bookList.length; i++) {
			System.out.println(bookList[i]);
		}
	}

	public void modifyBookList() {
		System.out.println("å������ �����Ͻ÷��� ������ �Է����ּ���.");
		String bookTitle = scan.next();
		int index = searchTitle(bookTitle);
		if (index != -1) {
			modifySwitchBook(index);
		}
	}

	public int searchTitle(String bookTitle) {
		int index = 0;
		for (int i = 0; i < bookList.length; i++) {
			if (bookList[i].getTitle().equals(bookTitle)) {
				return i;
			} else {
				System.out.println("�ش��ϴ� ������ �������� �ʽ��ϴ�.");
			}
		}
		return -1;
	}

	public void modifySwitchBook(int index) {
		System.out.println("� ������ �����Ͻðڽ��ϱ�?. 1.����  2.�ۺ���  3.�۾��� 4.ī�װ� 5.��������");
		int modifySelector = scan.nextInt();
		System.out.println("������ ������ �Է��ϼ���.");
		switch (modifySelector) {
		case 1:
			String newTitle = scan.next();
			bookList[index].setTitle(newTitle);
			break;
		case 2:
			String newPublisher = scan.next();
			bookList[index].setPublisher(newPublisher);
			break;
		case 3:
			String newWritter = scan.next();
			bookList[index].setWritter(newWritter);
			break;
		case 4:
			String newCategoryCode = scan.next();
			bookList[index].setCatagoryCode(newCategoryCode);
			break;
		case 5:
			boolean borrowStatus = bookList[index].isBorrowStatus();
			bookList[index].setBorrowStatus(!borrowStatus);
			break;

		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			break;
		}
	}

	public void deleteBookList() {
		System.out.println("å������ �����Ͻ÷��� ������ �Է����ּ���.");
		String bookTitle = scan.next();
		int index = searchTitle(bookTitle);
		if (index != -1) {
			reductionBookList(index);
			System.out.println("�����Ǿ����ϴ�.");
		}
	}

	public void reductionBookList(int index) {
		Book[] tmpArray = new Book[bookList.length - 1];
		for (int i = 0; i < tmpArray.length; i++) {
			tmpArray[i] = bookList[i];
			if (index <= i) {
				tmpArray[i] = bookList[i + 1];
			}
		}
		bookList = tmpArray;
	}

//	public void resistUser(User user) {
//		int index = userList.length - 1;
//		userList[index] = user;
//		UserListExpand();
//	}

	public void UserListExpand() {
		User[] tmpArray = new User[userList.length + 1];
		for (int i = 0; i < userList.length; i++) {
			tmpArray[i] = userList[i];
		}
		userList = tmpArray;


	}

	public void bookListExpand() {
		Book[] tmpArray = new Book[bookList.length + 1];
		for (int i = 0; i < bookList.length; i++) {
			tmpArray[i] = bookList[i];
		}
		bookList = tmpArray;
	}

	public void resistBook(Book book) {

		int index = bookList.length - 1;
		bookList[index] = book;
		bookListExpand();
	}


}
