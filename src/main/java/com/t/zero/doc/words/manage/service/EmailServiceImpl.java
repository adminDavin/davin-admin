package com.t.zero.doc.words.manage.service;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.t.zero.doc.words.manage.bean.UserInfoBean;
import com.t.zero.doc.words.manage.bean.UserStatusEnum;
import com.words.admin.email.EmailConstants;

@Service
public class EmailServiceImpl implements EmailService {

	private Session session;
	@Autowired
	private ObjectMapper mapper;

	public Session getSession() {
		return session;
	}

	private boolean authentication = true;
	private boolean smtpServerTTLSEnabled = true;
	private String host = "smtp.163.com";
	private String port = "25";
	private String username = "18758268513@163.com";
	private String password = "123456l";

	@PostConstruct
	public void init() throws Exception {
		Properties props = new Properties();
		props.put("mail.smtp.auth", String.valueOf(authentication));
		props.put("mail.smtp.starttls.enable", smtpServerTTLSEnabled);
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
	}

	public boolean sendEmail(String toEmailAddress, String emailSubject, String emailMessage) {
		// logger.info("toEmailAddress {}, emailSubject {}, emailMessage {} ",
		// toEmailAddress, emailSubject, emailMessage);
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			String[] recipientList = toEmailAddress.split(",");
			InternetAddress[] recipientAddresses = new InternetAddress[recipientList.length];
			int counter = 0;
			for (String recipient : recipientList) {
				recipientAddresses[counter] = new InternetAddress(recipient.trim());
				counter++;
			}
			message.setRecipients(Message.RecipientType.TO, recipientAddresses);
			message.setSubject(emailSubject);
			message.setText(emailMessage);
			Transport.send(message);
			// logger.info("Sent message successfully....");
			return true;
		} catch (MessagingException e) {
			// throw new RuntimeException(e);
			return false;
		}
	}

	@Override
	public void remindRegister(String email, String loginName, String password) {
		String message = EmailConstants.REGISTER_REMIND_MESSAGGE + " \n登錄名:" + loginName + "\n密碼:" + password;
		sendEmail(email, EmailConstants.REGISTER_REMIND_SUBJECT, message);	
	}

	@Override
	public void remindManager(String email, UserInfoBean item) {
		try {
			var message = EmailConstants.MANAGER_REMIND_MESSAGGE + " \n" + mapper.writeValueAsString(item);
			sendEmail(email, EmailConstants.MANAGER_REMIND_SUBJECT + item.getEmail(), message);	
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remindUserForModifyPassword(String email, String newPass) {
		String message = EmailConstants.USERMODIFYPASS_REMIND_MESSAGGE + " \n" + newPass;
		sendEmail(email, EmailConstants.MANAGER_REMIND_SUBJECT, message);			
	}

	@Override
	public void remindUserApplyResult(String email, int state) {
		String message = null;
		if (UserStatusEnum.AGREE.getValue() == state) {
			message = "管理員已審核通過, 歡迎使用索引傢系統";
		} else {
			message = "管理員審核結果未通過, 如有需要,請聯係管理員";
		}
		sendEmail(email, EmailConstants.USERMODIFYPASS_REMIND_SUBJECT, message);			
	}
}
