package model;

public class MailVO {
	
	
	private String from;
	private String to;
	private String body;
	private String subject;
	
	
	public MailVO(String from, String to, String body, String subject) {
		super();
		this.from = from;
		this.to = to;
		this.body = body;
		this.subject = subject;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	

}
