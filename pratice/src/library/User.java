package library;

import java.util.Arrays;

public class User {

	private String name;
	private int ssn;
	static int userCount = 0;
	private int phoneNumber;
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



	@Override
	public String toString() {
	String toString = ""+ "User [�̸�:" + name + ", �ֹι�ȣ:" + ssn + ", �ڵ�����ȣ:" + phoneNumber + " id:" + id + ", password:" + password + "  ����å:";
	for (int i = 0; i < borrowedBooks.length; i++) {
		if(borrowedBooks[0] == null) {
			return toString =  toString + "����" +"]";
			}
		if(borrowedBooks[i] != null) {
		 toString = borrowedBooks[i] + " " +"]";
		}
	}
		return  toString;
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
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		phoneNumber = phoneNumber;
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

	public int getBorrowedCount() {
		return borrowedCount;
	}

	public void setBorrowedBooks(String bookName) {
		int index = borrowedCount;
		borrowedBooks[index] = bookName;
		borrowedCount++;
	}

}
