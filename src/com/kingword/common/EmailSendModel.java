package com.kingword.common;

public class EmailSendModel {
	//邮箱服务器类型
	private String smtpHost;
	//邮箱服务器类型
	private int smtpport;
	//邮箱发送者
	private String from;  
	//邮箱发送者的登录名
	private String fromUserName; 
	//邮箱发送者的登录名
	private String fromUserPassword; 
		
	//邮箱收件人
	private String[] to; 
	//邮箱收件人
	private String[] cc; 
	public String[] getCc() {
		return cc;
	}
	public void setCc(String[] cc) {
		this.cc = cc;
	}
	//邮箱发送主题
	private String subject;  
	//邮箱发送内容
	private String messageText;
	public String getSmtpHost() {
		return smtpHost;
	}
	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public String getFromUserPassword() {
		return fromUserPassword;
	}
	public void setFromUserPassword(String fromUserPassword) {
		this.fromUserPassword = fromUserPassword;
	}
	public String[] getTo() {
		return to;
	}
	public void setTo(String[] to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	public int getSmtpport() {
		return smtpport;
	}
	public void setSmtpport(int smtpport) {
		this.smtpport = smtpport;
	}
}
