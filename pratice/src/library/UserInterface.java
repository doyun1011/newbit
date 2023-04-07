package library;

import java.util.Scanner;

public class UserInterface {
	Book book = new Book();
	User user = new User();
	int key;
	int remainBorrowCount = 3;
	Scanner scan = new Scanner(System.in);
	static User[] userList = { new User("admin", "1234", "관리자") };
	Book[] bookList = { new Book("자바의정석", "모아", "남궁성", "A") };
	static Administrator administrator = new Administrator();

	public static void main(String[] args) {
		while (true) {
			UserInterface li = new UserInterface();
			Scanner scan = new Scanner(System.in);
			System.out.println("사용하고자 하는 서비스를 선택해 주십시오. 1.대출  2.반납  3.책 검색   4.그만두기");
			int selectorService = scan.nextInt();
			if (selectorService == 1) {
				
				System.out.println("로그인이 필요한 서비스입니다. 로그인하시겠습니까? ");
				System.out.println("1.로그인  2.회원가입  3.아이디/비밀번호 찾기 4.그만두기 ");
				int selector = scan.nextInt();
				switch (selector) {
				case 1:
						li.login();
						li.borrowBook();
					break;
				case 2:
					li.joinMembership();
					break;
				case 3:
					li.findIdPassword();
					break;
				case 4:
					return;

				default:
					System.out.println("잘못입력하셨습니다.");
					break;
				}
			} else if (selectorService == 2) {
				li.returnBook();
			} else if (selectorService == 3) {
				Administrator administrator = new Administrator();
				administrator.printBookList();
			} else if (selectorService == 4) {
				return;
			}
		}
	}

	private void borrowBook() {
		while (true) {
			if (remainBorrowCount == 0) {
				System.out.println("더 이상 대출이 불가능합니다.");
				return;
			}
			Scanner scan = new Scanner(System.in);
			System.out.println("대출하고자 하는 책의 제목을 입력하세요. 그만두기 'n'");
			String title = scan.next();
			if (title.equals("n")) {
				break;
			}
			availableBorrow(title, bookList);
		}
	}

	private void availableBorrow(String title, Book[] bookList) {
		for (int i = 0; i < bookList.length; i++) {
			if (title.equals(bookList[i].getTitle()) && bookList[i].getborrowStatus() == false) {
				remainBorrowCount--;
				
				System.out.println("대출이 완료되었습니다. " + "남은 대출가능 횟수:" + remainBorrowCount);
				userList[key].setBorrowedBooks(title);
				bookList[i].setBorrowStatus(true);
				return;
			} else if (title.equals(bookList[i].getTitle()) && bookList[i].getborrowStatus() == true) {
				System.out.println("이미 대출된 도서 입니다. 다른 도서를 입력해주세요.");
				return;
			}
		}
		System.out.println("입력하신 제목과 일치하는 책이 존재하지 않습니다.");
		return;
	}

	private void findIdPassword() {
		Scanner scan = new Scanner(System.in);
		System.out.println("아이디를 입력해주세요.");
		String id = scan.next();
		System.out.println("이름을 입력하세요.");
		String name = scan.next();
		System.out.println("핸드폰 번호를 입력하세요.");
		int phoneNumber = scan.nextInt();
		for (int i = 0; i < userList.length; i++) {
			boolean checkTrue1 = false;
			boolean checkTrue2 = false;
			if (userList[i].getId().equals(id)) {
				checkTrue1 = true;

			}
			if (userList[i].getName().equals(name) && userList[i].getPhoneNumber() == phoneNumber) {
				checkTrue2 = true;
			}
			if (checkTrue1 && checkTrue2) {
				System.out.println("정보가 일치합니다. Id:" + userList[i].getId() + "  password: " + userList[i].getPassword());
				return;
			}
		}
		System.out.println("회원 정보가 일치하지 않습니다.");
	}

	private void joinMembership() {
		Administrator administrator = new Administrator();

		Scanner scan = new Scanner(System.in);
		User user = new User();
		System.out.println("회원가입을 시작합니다.\n");
		System.out.println("사용하고자 하는 id를 입력하세요.");
		String id = scan.next();
		System.out.println("사용하고자 하는 비밀번호를 입력하세요.");
		String password = scan.next();
		if (duplicateCheck(id)) {// 유저랑 id 입력
			user.setId(id);
			user.setPassword(password);
		}
		System.out.println("이름을 입력하세요.");
		String name = scan.next();
		System.out.println("핸드폰 번호를 입력하세요.");
		int phoneNumber = scan.nextInt();
		user.setPhoneNumber(phoneNumber);
		user.setName(name);
		user.userCount++;
		int index = user.userCount - 1;
		administrator.UserListExpand();
		userList[index] = user;
		System.out.println(userList[index].getName());

	}

	public void returnBook() {
		Scanner scan = new Scanner(System.in);
		String[] borrowedList = userList[key].getBorrowedBooks();
		for (int i = 0; i < borrowedList.length; i++) {
			System.out.println("반납하실 책의 제목을 입력해주세요. 그만두기 'n'");
			String title = scan.next();
			for (int j = 0; j < borrowedList.length; j++) {
				if(borrowedList[j] == null) {
					continue;
				}
					
				if (borrowedList[j].equals(title)) {
					System.out.println("반납에 성공하였습니다.");
					borrowedList[j] = null;
					return;
				}
			}
			
			System.out.println("입력하신 제목과 일치하는 책이 존재하지 않습니다.");
			if(borrowedList[i] == null) {
				return;
			}
		}

	}

	private boolean duplicateCheck(String id) {
		for (int i = 0; i < userList.length; i++) {
			if (userList[i].getName().equals(id)) {
				return false;
			}
		}
		return true;
	}

	private boolean login() {

		Scanner scan = new Scanner(System.in);
		System.out.println("ID를 입력해주세요.");
		String userId = scan.next();
		System.out.println("비밀번호를 입력해주세요.");
		String userPassword = scan.next();
		key = getIndexUserList(userId, userPassword);
		if (key == -1) {
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
			return false;
		}
		return true;
	}

	private void printBookList() {

	}

	private int getIndexUserList(String userId, String userPassword) {
		for (int i = 0; i < userList.length; i++) {
			if (userList[i].getId().equals(userId) && userList[i].getPassword().equals(userPassword)) {
				System.out.println("어서오세요." + userList[i].getName() + "님 그린도서관에 방문하신 것을 환영합니다!\n\n");
				return i;
			}
		}
		return -1;
	}

	public static User[] getUserList() {
		return userList;
	}
	
}
