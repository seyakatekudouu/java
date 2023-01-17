package dto;

public class Individual {
	private String mail;
	private String pw;
	public Individual(String mail, String pw) {
		super();
		this.mail = mail;
		this.pw = pw;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPW() {
		return pw;
	}
	public void setPW(String PW) {
		PW = pw;
	}
}
