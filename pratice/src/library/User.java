package library;

public class User {

	private String name;
	private int ssn;
	private int PhoneNumber;
	private String id;
	private String password;
	private String[] borrowedBooks = new String[3];
	private User[] userList = new User[1];
	private int borrowedCount = 0;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public int getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String[] getBorrowedBooks() {
		return borrowedBooks;
	}
	
	public void addBorrowedBook(String bookName) {
		int index = borrowedCount++;
		borrowedBooks[index] = bookName;
		borrowedCount++;
	}
	public void resistUser(User user) {
		
		int index= userList.length -1;
		userList[index] = user;
		UserListExpand();
	}
	
	public void UserListExpand() {
		User[] tmpArray = new User[userList.length+1];
		for (int i = 0; i < userList.length; i++) {
			tmpArray[i] = userList[i];
		}
		userList=tmpArray;
	}
	public User[] getUserList() {
		return userList;
	}
	public void setUserList(User[] userList) {
		this.userList = userList;
	}
	
	
}
