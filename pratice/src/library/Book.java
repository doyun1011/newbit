package library;

public class Book {

	private String title;
	private String publisher;
	private String writter;
	private String catagoryCode;
	private boolean borrowStatus = false;

	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public Book(String title, String publisher, String writter, String catagoryCode) {
		this.title= title; 
		this.publisher = publisher;
		this.writter = writter;
		this.catagoryCode =catagoryCode;
	}

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
	@Override
	public String toString() {
		return "[제목:" + title + " 출판사:" + publisher + " 작가:" + writter + " 카테고리:"
				+ catagoryCode + " 빌림유무=" + borrowStatus + "]";
	}

}
