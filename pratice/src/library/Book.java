package library;

public class Book {

	private String title;
	private String publisher;
	private String writter;
	private String catagoryCode;
	private boolean borrowStatus = false;

	Book[] bookList = new Book[1];

	public String getTitle() {
		return title;
	}
	public boolean getborrowStatus() {
		return borrowStatus;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getWritter() {
		return writter;
	}

	public void setWritter(String writter) {
		this.writter = writter;
	}

	public String getCatagoryCode() {
		return catagoryCode;
	}
	public void setCatagoryCode(String catagoryCode) {
		this.catagoryCode = catagoryCode;
	}

	

	public boolean isBorrowStatus() {
		return borrowStatus;
	}
	public void setBorrowStatus(boolean borrowStatus) {
		this.borrowStatus = borrowStatus;
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
