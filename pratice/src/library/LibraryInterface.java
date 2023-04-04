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
		System.out.println("사용하고자 하는 서비스를 선택해 주십시오. 1.대출  2.반납  3.책 검색");
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
				System.out.println("더 이상 대출이 불가능합니다.");
				return;
			}
			Scanner scan = new Scanner(System.in);
			System.out.println("대출하고자 하는 책의 제목을 입력하세요. 그만두기 'n'");
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
				System.out.println("대출이 완료되었습니다. " + "남은 대출가능 횟수:" + remainBorrowCount);
				return;
			} else if (title.equals(bookList[i].getTitle()) && bookList[i].getborrowStatus() == true) {
				System.out.println("이미 대출된 도서 입니다. 다른 도서를 입력해주세요.");
				return;
			}
		}
		System.out.println("입력하신 제목과 일치하는 책이 존재하지 않습니다.");
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
		System.out.println("ID를 입력해주세요.");
		String userId = scan.next();
		System.out.println("비밀번호를 입력해주세요.");
		String userPassword = scan.next();
		User[] userList = user.getUserList();
		key = getIndexUserList(userList, userId, userPassword);
		if (key == -1) {
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
			return;
		}

	}

	private int getIndexUserList(User[] userList, String userId, String userPassword) {
		for (int i = 0; i < userList.length; i++) {
			if (userList[i].getId().equals(userId) && userList[i].getPassword().equals(userPassword)) {
				System.out.println("어서오세요." + userList[i].getName() + "님 그린도서관에 방문하신 것을 환영합니다!\n\n");
				return i;
			}
		}
		return -1;
	}
}
