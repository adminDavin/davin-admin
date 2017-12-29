package com.words.admin.manage.service;

public interface EmailService {
	public boolean sendEmail(String toEmailAddress, String emailSubject, String emailMessage);
}
