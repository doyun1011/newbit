package library;

import java.util.Scanner;

public class Administrator {
	private String id;
	private String password;
	User user = new User();
	Book book = new Book();
	Scanner scan = new Scanner(System.in);

	public void printUserList() {
		User[] userList = user.getUserList();
		for (int i = 0; i < userList.length; i++) {
			int ssn = userList[i].getSsn();
			int phonNumber = userList[i].getPhoneNumber();
			String password = userList[i].getPassword();
			String id = userList[i].getId();

			System.out.println("id: " + id + " password: " + password + " ssn: " + ssn);
		}
	}

	public void modifyUserList() {
		System.out.println("회원정보를 수정하시려면 해당 id를 입력해주세요.");
		String userId = scan.next();
		User[] userList = user.getUserList();
		int index = searchId(userList, userId);
		modifySwitchUser(userList, index);
	}

	public int searchId(User[] userList, String userId) {
		int index = 0;
		for (int i = 0; i < userList.length; i++) {
			if (userList[i].getId() == userId) {
				return i;
			} else {
				System.out.println("해당 id는 존재하지 않습니다.");
			}
		}
		return -1;
	}

	public void modifySwitchUser(User[] userList, int index) {
		System.out.println("어떤 정보를 수정하시겠습니까?. 1.이름  2.주민번호  3. 핸드폰 번호");
		int modifySelector = scan.nextInt();
		System.out.println("수정할 장보를 입력하세요.");
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
			System.out.println("잘못 입력하셨습니다.");
			break;
		}
	}

	public void deleteUserList() {
		System.out.println("회원정보를 삭제하시려면 해당 id를 입력해주세요.");
		String userId = scan.next();
		User[] userList = user.getUserList();
		int index = searchId(userList, userId);
		user.setUserList(reductionUserList(userList, index));
		
	}

	public User[] reductionUserList(User[] userList, int index) {
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
		Book[] bookList = book.getBookList();
		for (int i = 0; i < bookList.length; i++) {
			String title = bookList[i].getTitle();
			String publisher = bookList[i].getPublisher();
			String writter = bookList[i].getWritter();
			String categoryCode = bookList[i].getCatagoryCode();
			boolean borrowStatus = bookList[i].getborrowStatus();

			System.out.print("title: " + title + " publisher: " + publisher + " writter: " + writter +" ");
			System.out.println("categoryCode: " + categoryCode + " borrowStatus: " + borrowStatus);
		}
	}

	public void modifyBookList() {
		System.out.println("책정보를 수정하시려면 제목을 입력해주세요.");
		String bookTitle = scan.next();
		Book[] bookList = book.getBookList();
		int index = searchTitle(bookList, bookTitle);
		modifySwitchBook(bookList, index);
	}
	public int searchTitle(Book[] bookList, String bookTitle) {
		int index = 0;
		for (int i = 0; i < bookList.length; i++) {
			if (bookList[i].getTitle() == bookTitle) {
				return i;
			} else {
				System.out.println("해당하는 제목이 존재하지 않습니다.");
			}
		}
		return -1;
	}
	public void modifySwitchBook(Book[] bookList, int index) {
		System.out.println("어떤 정보를 수정하시겠습니까?. 1.이름  2.주민번호  3. 핸드폰 번호");
		int modifySelector = scan.nextInt();
		System.out.println("수정할 장보를 입력하세요.");
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
			System.out.println("잘못 입력하셨습니다.");
			break;
		}
	}

	public void deleteBookList() {
		System.out.println("책정보를 삭제하시려면 제목을 입력해주세요.");
		String bookTitle = scan.next();
		Book[] bookList = book.getBookList();
		int index = searchTitle(bookList, bookTitle);
		book.setBookList(reductionBookList(bookList, index));
	}
	public Book[] reductionBookList(Book[] bookList, int index) {
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

}
