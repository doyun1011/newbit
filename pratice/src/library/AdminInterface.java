package library;

import java.util.Scanner;

public class AdminInterface {

	public static void main(String[] args) {
		
	}
	Scanner scan = new Scanner(System.in);
	UserInterface library = new UserInterface();
	User[] userList = library.getUserList();
	Book[] bookList = {new Book("�ڹ�������", "���", "���ü�", "A")};

	public void printUserList() {
		for (int i = 0; i < userList.length; i++) {
			int ssn = userList[i].getSsn();
			int phonNumber = userList[i].getPhoneNumber();
			String password = userList[i].getPassword();
			String id = userList[i].getId();

			System.out.println("id: " + id + " password: " + password + " ssn: " + ssn);
		}
	}

	public void modifyUserList() {
		System.out.println("ȸ�������� �����Ͻ÷��� �ش� id�� �Է����ּ���.");
		String userId = scan.next();
		int index = searchId(userList, userId);
		modifySwitchUser(index);
	}

	public int searchId(User[] userList, String userId) {
		int index = 0;
		for (int i = 0; i < userList.length; i++) {
			if (userList[i].getId() == userId) {
				return i;
			} else {
				System.out.println("�ش� id�� �������� �ʽ��ϴ�.");
			}
		}
		return -1;
	}

	public void modifySwitchUser(int index) {
		System.out.println("� ������ �����Ͻðڽ��ϱ�?. 1.�̸�  2.�ֹι�ȣ  3. �ڵ��� ��ȣ");
		int modifySelector = scan.nextInt();
		System.out.println("������ �庸�� �Է��ϼ���.");
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
		userList = reductionUserList(index);

	}

	public User[] reductionUserList(int index) {
		User[] tmpArray = new User[userList.length - 1];
		for (int i = 0; i < tmpArray.length; i++) {
			tmpArray[i] = userList[i];
			if (index <= i) {
				tmpArray[i] = userList[i + 1];
			}
		}
		userList = tmpArray;
		return userList;
	}

	public void printBookList() {
		for (int i = 0; i < bookList.length; i++) {
			String title = bookList[i].getTitle();
			String publisher = bookList[i].getPublisher();
			String writter = bookList[i].getWritter();
			String categoryCode = bookList[i].getCatagoryCode();
			boolean borrowStatus = bookList[i].getborrowStatus();

			System.out.print("title: " + title + "  publisher: " + publisher + "  writter: " + writter + " ");
			System.out.println("  categoryCode: " + categoryCode + "  borrowStatus: " + borrowStatus);
		}
	}

	public void modifyBookList() {
		System.out.println("å������ �����Ͻ÷��� ������ �Է����ּ���.");
		String bookTitle = scan.next();
		int index = searchTitle(bookTitle);
		modifySwitchBook( index);
	}

	public int searchTitle(String bookTitle) {
		int index = 0;
		for (int i = 0; i < bookList.length; i++) {
			if (bookList[i].getTitle() == bookTitle) {
				return i;
			} else {
				System.out.println("�ش��ϴ� ������ �������� �ʽ��ϴ�.");
			}
		}
		return -1;
	}

	public void modifySwitchBook(int index) {
		System.out.println("� ������ �����Ͻðڽ��ϱ�?. 1.�̸�  2.�ֹι�ȣ  3. �ڵ��� ��ȣ");
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
			bookList[index].setBorrowStatus(!(bookList[index].isBorrowStatus()));
			break;

		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			break;
		}
	}

	public void deleteBookList() {
		System.out.println("å������ �����Ͻ÷��� ������ �Է����ּ���.");
		String bookTitle = scan.next();
		Book[] bookList = getBookList();
		int index = searchTitle(bookTitle);
		setBookList(reductionBookList(index));
	}

	public Book[] reductionBookList(int index) {
		Book[] tmpArray = new Book[bookList.length - 1];
		for (int i = 0; i < tmpArray.length; i++) {
			tmpArray[i] = bookList[i];
			if (index <= i) {
				tmpArray[i] = bookList[i + 1];
			}
		}
		bookList = tmpArray;
		return bookList;
	}

//	public void resistUser(User user) {
//		int index = userList.length - 1;
//		userList[index] = user;
//		UserListExpand();
//	}

	public User[] UserListExpand() {
		User[] tmpArray = new User[userList.length + 1];
		for (int i = 0; i < userList.length; i++) {
			tmpArray[i] = userList[i];
		}
		userList = tmpArray;
		
		return userList;
		
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
	public Book[] getBookList() {
		return bookList;
	}
	public void setBookList(Book[] bookList) {
		this.bookList = bookList;
	}

}


