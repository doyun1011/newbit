package library;

import java.util.Scanner;

public class UserInterface {
	Book book = new Book();
	User user = new User();
	int key;
	int remainBorrowCount = 3;
	Scanner scan = new Scanner(System.in);
	Book[] bookList = { new Book("자바의정석", "모아", "남궁성", "A") };
	Date date = new Date();
	ReadingRoom readRoom = new ReadingRoom();
	ReadingRoom[] readRoomList = new ReadingRoom[35];
	static User[] userList = { new User("admin", "1234", "관리자") };
	static Administrator administrator = new Administrator();

	public static void main(String[] args) {
		while (true) {
			UserInterface li = new UserInterface();
			Scanner scan = new Scanner(System.in);
			System.out.println("사용하고자 하는 서비스를 선택해 주십시오. 1.대출  2.반납  3.책 검색  4.열람실 이용 5.그만두기");
			int selectorService = scan.nextInt();
			switch (selectorService) {
			case 1:
				li.logInService();
				li.borrowBook();
				break;
			case 2:
				li.logInService();
				li.returnBook();
				break;
			case 3:
				Administrator administrator = new Administrator();
				administrator.printBookList();
				break;
			case 4:
				li.logInService();
				li.readingRoomService();
				break;
			case 5:
				
				return;

			default:
				break;
			}
			if (selectorService == 1) {
				li.logInService();
				li.borrowBook();
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

	private void readingRoomService() {
		String userId = userList[key].getId();
		String reservId = readRoom.getUserId();
		if (userId.equals(reservId)) {
			System.out.println("1.입실  2.예약취소  3.예약정보확인");
			int selector = scan.nextInt();
			switch (selector) {
			case 1:
				entrance();
				break;
			case 2:
				reservCancel();
				break;
			case 3:
				printReservInfo();
				break;

			default:
				break;
			}
		} else {
			while (true) {
				ReadingRoom readRoom = new ReadingRoom();
				System.out.println("예약하시겠습니까? 1.예약  2.종료       도서관 종료시간은 22:00까지 입니다. ");
				int StartEndKey = scan.nextInt();
				if (StartEndKey == 2) {
					return;
				}
				System.out.println("현재시간  " + date.getHour() + "시  " + date.getMinute() + "분");
				System.out.println("예약할 시간을 입력하세요.");
				int startHour = scan.nextInt();
				System.out.println("예약할 분(minute)을 입력하세요.");
				int startMinute = scan.nextInt();
				if(!timeTest(startHour, startMinute)) {
					continue;
				}
				
				System.out.println("예약종료 할 시간을 입력하세요.");
				int endHour = scan.nextInt();
				System.out.println("예약종료 할 분(minute)을 입력하세요.");
				int endMinute = scan.nextInt();
				if(!timeTest(endHour, endMinute)) {
					continue;
				}
			
				System.out.println("예약할 좌석을 선택하세요. 0 ~ 35번");
				printReservSeat();
				int seatNum = scan.nextInt();
				if (seatNum < 0 || seatNum > 35) {
					System.out.println("잘못입력하셨습니다.");
				
				}

				readRoom.setStartHour(startHour);
				readRoom.setStartMinute(startMinute);
				readRoom.setEndHour(endHour);
				readRoom.setEndMinute(endMinute);
				readRoomList[seatNum] = readRoom;
				System.out.println("예약이 완료되었습니다.");
				return;
			}
		}

	}

	private void printReservInfo() {
		for (int i = 0; i < readRoomList.length; i++) {
			String userId = userList[key].getId();
			String reservId = readRoomList[i].getUserId();
			if(userId.equals(reservId)) {
				System.out.println(readRoomList[i]);
			}

		}
	}

	private void reservCancel() {
		readRoom.setReservStatus(false);
	}

	private void entrance() {
		System.out.println("입실 완료되었습니다.");
		readRoom.setEntranceStatus(true);
	}

	private void printReservSeat() {
		for (int i = 0; i < readRoomList.length; i++) {
			if (readRoomList[i] == null) {
				continue;
			}
			String reservId = readRoomList[i].getUserId();
			
				System.out.println(readRoomList[i]);
			
		}
		System.out.println();

	}

	private boolean minuteTest(int minute) {
		if (minute < 0 || minute > 60) {
			System.out.println("잘못 입력하셨습니다.");
			return false;
		}
		return true;
	}

	private boolean timeTest(int hour, int minute) {
		int reservTime = hour*60 + minute;
		int openTime = 9*60;
		int closeTime = 22*60;
		int currentTime = date.getHour()*60 + date.getMinute();
		
		if(reservTime < openTime || reservTime> closeTime ) {
			System.out.println("도서관 운영시간이 아닙니다.");
			return false;
		}else if(reservTime < currentTime) {
			System.out.println("현재시간 이후로 예약해주세요.");
		}
		
		return true;

	}

	private void logInService() {
		System.out.println("로그인이 필요한 서비스입니다. 로그인하시겠습니까? ");
		while (true) {
			System.out.println("1.로그인  2.회원가입  3.아이디/비밀번호 찾기 4.그만두기 ");
			int selector = scan.nextInt();
			switch (selector) {
			case 1:
				login();
				return;
			case 2:
				joinMembership();
				break;
			case 3:
				findIdPassword();
				break;
			case 4:
				return;

			default:
				System.out.println("잘못입력하셨습니다.");
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
				if (borrowedList[j] == null) {
					continue;
				}

				if (borrowedList[j].equals(title)) {
					System.out.println("반납에 성공하였습니다.");
					borrowedList[j] = null;
					return;
				}
			}

			System.out.println("입력하신 제목과 일치하는 책이 존재하지 않습니다.");
			if (borrowedList[i] == null) {
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
