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

		int selectorUser;
		int selectorBook;
		
		if (selector == 1) {
			admin.printUserList();
			System.out.println("1.���� ���� 2.���� ����");
			selectorUser = scan.nextInt();

			if (selectorUser == 1) {
				admin.modifyUserList();
			} else if (selectorUser == 2) {
				admin.deleteUserList();
			}
			admin.printUserList();
		}

		else if (selector == 2) {
			admin.printBookList();
			System.out.println("1.å ���� 2.å ����");
			selectorBook = scan.nextInt();
			
			if (selectorBook == 1) {
				admin.modifyBookList();
			} else if (selectorBook == 2) {
				admin.deleteBookList();
			}
			admin.printBookList();
		}

	}

	public void printUserList() {
		for (int i = 0; i < userList.length; i++) {
			int ssn = userList[i].getSsn();
			int phonNumber = userList[i].getPhoneNumber();
			String password = userList[i].getPassword();
			String id = userList[i].getId();
			String name = userList[i].getName();
			int phoneNum = userList[i].getPhoneNumber();
			String[] borrowedBooks = userList[i].getBorrowedBooks();

			System.out.print("��ȣ: "+ssn+"  �̸� " +name +" id: " + id + " password: " + password + "  ��ȭ��ȣ  " +phoneNum);
			for (int j = 0; j < borrowedBooks.length; j++) {
				System.out.print("  ����å: ");
				if(borrowedBooks[i] == null) {
					System.out.println("����");
					break;
				}
				System.out.print(borrowedBooks[i]+" ");
			}
			System.out.println();
		}
	}

	public void modifyUserList() {
		System.out.println("ȸ�������� �����Ͻ÷��� �ش� id�� �Է����ּ���.");
		String userId = scan.next();
		int index = searchId(userList, userId);
		if(index == -1) {
			return;
		}
		library.userList = modifySwitchUser(index);
		userList = library.userList;
	}

	public int searchId(User[] userList, String userId) {
		for (int i = 0; i < userList.length; i++) {
			if (userList[i].getId().equals(userId) ) {
				return i;
			} 
			
		}
		System.out.println("�ش� id�� �������� �ʽ��ϴ�.");
		return -1;
	}

	public User[] modifySwitchUser(int index) {
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
		return userList;
	}

	public void deleteUserList() {
		System.out.println("ȸ�������� �����Ͻ÷��� �ش� id�� �Է����ּ���.");
		String userId = scan.next();
		int index = searchId(userList, userId);
		if(index == -1) {
			return;
		}
		userList = reductionUserList(index);
		System.out.println("�����Ǿ����ϴ�.");

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
		modifySwitchBook(index);
	}

	public int searchTitle(String bookTitle) {
		int index = 0;
		for (int i = 0; i < bookList.length; i++) {
			if (bookList[i].getTitle().equals(bookTitle) ) {
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
		System.out.println("�����Ǿ����ϴ�.");
		
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
