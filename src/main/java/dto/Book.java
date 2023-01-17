package dto;

public class Book {
	private String ID;
	private String ISBN;
	private String bookname;
	private String writer;
	private String shupansha;
	public Book(String iD, String iSBN, String bookname, String writer, String shupansha) {
		super();
		ID = iD;
		ISBN = iSBN;
		this.bookname = bookname;
		this.writer = writer;
		this.shupansha = shupansha;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getShupansha() {
		return shupansha;
	}
	public void setShupansha(String shupansha) {
		this.shupansha = shupansha;
	}

	
	
	
}
