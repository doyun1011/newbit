package library;

import java.util.Scanner;

public class UserInterface {
	Book book = new Book();
	User user = new User();
	int key;
	int remainBorrowCount = 3;
	Scanner scan = new Scanner(System.in);
	Book[] bookList = { new Book("�ڹ�������", "���", "���ü�", "A") };
	Date date = new Date();
	ReadingRoom readRoom = new ReadingRoom();
	ReadingRoom[] readRoomList = new ReadingRoom[35];
	static User[] userList = { new User("admin", "1234", "������") };
	static Administrator administrator = new Administrator();

	public static void main(String[] args) {
		while (true) {
			UserInterface li = new UserInterface();
			Scanner scan = new Scanner(System.in);
			System.out.println("����ϰ��� �ϴ� ���񽺸� ������ �ֽʽÿ�. 1.����  2.�ݳ�  3.å �˻�  4.������ �̿� 5.�׸��α�");
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
			System.out.println("1.�Խ�  2.�������  3.��������Ȯ��");
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
				System.out.println("�����Ͻðڽ��ϱ�? 1.����  2.����       ������ ����ð��� 22:00���� �Դϴ�. ");
				int StartEndKey = scan.nextInt();
				if (StartEndKey == 2) {
					return;
				}
				System.out.println("����ð�  " + date.getHour() + "��  " + date.getMinute() + "��");
				System.out.println("������ �ð��� �Է��ϼ���.");
				int startHour = scan.nextInt();
				System.out.println("������ ��(minute)�� �Է��ϼ���.");
				int startMinute = scan.nextInt();
				if(!timeTest(startHour, startMinute)) {
					continue;
				}
				
				System.out.println("�������� �� �ð��� �Է��ϼ���.");
				int endHour = scan.nextInt();
				System.out.println("�������� �� ��(minute)�� �Է��ϼ���.");
				int endMinute = scan.nextInt();
				if(!timeTest(endHour, endMinute)) {
					continue;
				}
			
				System.out.println("������ �¼��� �����ϼ���. 0 ~ 35��");
				printReservSeat();
				int seatNum = scan.nextInt();
				if (seatNum < 0 || seatNum > 35) {
					System.out.println("�߸��Է��ϼ̽��ϴ�.");
				
				}

				readRoom.setStartHour(startHour);
				readRoom.setStartMinute(startMinute);
				readRoom.setEndHour(endHour);
				readRoom.setEndMinute(endMinute);
				readRoomList[seatNum] = readRoom;
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
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
		System.out.println("�Խ� �Ϸ�Ǿ����ϴ�.");
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
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
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
			System.out.println("������ ��ð��� �ƴմϴ�.");
			return false;
		}else if(reservTime < currentTime) {
			System.out.println("����ð� ���ķ� �������ּ���.");
		}
		
		return true;

	}

	private void logInService() {
		System.out.println("�α����� �ʿ��� �����Դϴ�. �α����Ͻðڽ��ϱ�? ");
		while (true) {
			System.out.println("1.�α���  2.ȸ������  3.���̵�/��й�ȣ ã�� 4.�׸��α� ");
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
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
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

				System.out.println("������ �Ϸ�Ǿ����ϴ�. " + "���� ���Ⱑ�� Ƚ��:" + remainBorrowCount);
				userList[key].setBorrowedBooks(title);
				bookList[i].setBorrowStatus(true);
				return;
			} else if (title.equals(bookList[i].getTitle()) && bookList[i].getborrowStatus() == true) {
				System.out.println("�̹� ����� ���� �Դϴ�. �ٸ� ������ �Է����ּ���.");
				return;
			}
		}
		System.out.println("�Է��Ͻ� ����� ��ġ�ϴ� å�� �������� �ʽ��ϴ�.");
		return;
	}

	private void findIdPassword() {
		Scanner scan = new Scanner(System.in);
		System.out.println("���̵� �Է����ּ���.");
		String id = scan.next();
		System.out.println("�̸��� �Է��ϼ���.");
		String name = scan.next();
		System.out.println("�ڵ��� ��ȣ�� �Է��ϼ���.");
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
				System.out.println("������ ��ġ�մϴ�. Id:" + userList[i].getId() + "  password: " + userList[i].getPassword());
				return;
			}
		}
		System.out.println("ȸ�� ������ ��ġ���� �ʽ��ϴ�.");
	}

	private void joinMembership() {
		Administrator administrator = new Administrator();

		Scanner scan = new Scanner(System.in);
		User user = new User();
		System.out.println("ȸ�������� �����մϴ�.\n");
		System.out.println("����ϰ��� �ϴ� id�� �Է��ϼ���.");
		String id = scan.next();
		System.out.println("����ϰ��� �ϴ� ��й�ȣ�� �Է��ϼ���.");
		String password = scan.next();
		if (duplicateCheck(id)) {// ������ id �Է�
			user.setId(id);
			user.setPassword(password);
		}
		System.out.println("�̸��� �Է��ϼ���.");
		String name = scan.next();
		System.out.println("�ڵ��� ��ȣ�� �Է��ϼ���.");
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
			System.out.println("�ݳ��Ͻ� å�� ������ �Է����ּ���. �׸��α� 'n'");
			String title = scan.next();
			for (int j = 0; j < borrowedList.length; j++) {
				if (borrowedList[j] == null) {
					continue;
				}

				if (borrowedList[j].equals(title)) {
					System.out.println("�ݳ��� �����Ͽ����ϴ�.");
					borrowedList[j] = null;
					return;
				}
			}

			System.out.println("�Է��Ͻ� ����� ��ġ�ϴ� å�� �������� �ʽ��ϴ�.");
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
		System.out.println("ID�� �Է����ּ���.");
		String userId = scan.next();
		System.out.println("��й�ȣ�� �Է����ּ���.");
		String userPassword = scan.next();
		key = getIndexUserList(userId, userPassword);
		if (key == -1) {
			System.out.println("���̵� Ȥ�� ��й�ȣ�� �߸� �Է��ϼ̽��ϴ�.");
			return false;
		}
		return true;
	}

	private void printBookList() {

	}

	private int getIndexUserList(String userId, String userPassword) {
		for (int i = 0; i < userList.length; i++) {
			if (userList[i].getId().equals(userId) && userList[i].getPassword().equals(userPassword)) {
				System.out.println("�������." + userList[i].getName() + "�� �׸��������� �湮�Ͻ� ���� ȯ���մϴ�!\n\n");
				return i;
			}
		}
		return -1;
	}

	public static User[] getUserList() {
		return userList;
	}

}
