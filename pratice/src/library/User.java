package library;

public class User {

	private String name;
	private int ssn;
	static int userCount =0;
	private int PhoneNumber;
	private String id;
	private String password;
	private String[] borrowedBooks = new String[3];
	private int borrowedCount = 0;
	
	public User() {
	}
	public User(String id, String password, String name) {
		this.id = id;
		this.password = password;
		this.name = name;
		userCount++;
	}
	
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
		int index = borrowedCount;
		borrowedBooks[index] = bookName;
		borrowedCount++;
	}
	
	
	
	
}
