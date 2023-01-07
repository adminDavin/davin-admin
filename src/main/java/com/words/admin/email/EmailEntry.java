package com.words.admin.email;

public class EmailEntry {

	private String fromAddress;
	private String toAddress;
	private String subject;
	private String message;
	public String getFromAddress() {
		return fromAddress;
	}
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	public String getToAddress() {
		return toAddress;
	}
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public EmailEntry(String fromAddress, String toAddress, String subject, String message) {
		super();
		this.fromAddress = fromAddress;
		this.toAddress = toAddress;
		this.subject = subject;
		this.message = message;
	}
}
