package com.words.admin.manage.service;

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

import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailServiceImpl implements EmailService {
	// private static final Logger logger =
	// LoggerFactory.getLogger(EmailService.class);

	private Session session;

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
}
