package com.kingword.common;

import java.util.Date;
import java.util.Properties;

import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class EmailSendUtil {
	private static final Log log = LogFactory.getLog(EmailSendUtil.class);

	public static String emailSend(EmailSendModel emailSendModel)
			throws AuthenticationFailedException, MessagingException, Exception {

		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
		new MyAuthenticator(emailSendModel.getFromUserName(),
				emailSendModel.getFromUserPassword());
		// 设定mail server
		senderImpl.setHost(emailSendModel.getSmtpHost());
		// 建立邮件消息
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		// 设置收件人，寄件人 用数组发送多个邮件
		mailMessage.setTo(emailSendModel.getTo());
		mailMessage.setFrom(emailSendModel.getFrom());
		mailMessage.setSubject(emailSendModel.getSubject());
		mailMessage.setText(emailSendModel.getMessageText());
		// 根据自己的情况,设置username
		senderImpl.setUsername(emailSendModel.getFromUserName());
		// 根据自己的情况, 设置password
		senderImpl.setPassword(emailSendModel.getFromUserPassword());

		Properties prop = new Properties();
		// 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
		prop.put("mail.smtp.host", emailSendModel.getSmtpHost());
		prop.put("mail.smtp.port", emailSendModel.getSmtpport());
		prop.put("mail.smtp.auth", "true");
		senderImpl.setJavaMailProperties(prop);
		// 发送邮件
		System.out.println("邮箱正在发送中，请注意查收！");

		senderImpl.send(mailMessage);

		System.out.println("邮箱正在发送结束，请注意查收！");
		return " 邮件发送成功.. ";
	}

	public static void sendEmail(EmailSendModel emailSendModel) {
		MyAuthenticator myauth = new MyAuthenticator(
				emailSendModel.getFromUserName(),
				emailSendModel.getFromUserPassword());
		Properties prop = new Properties();
		// 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
		prop.put("mail.smtp.host", emailSendModel.getSmtpHost());
		prop.put("mail.smtp.port", emailSendModel.getSmtpport());
		prop.put("mail.smtp.auth", "true");

		String to = emailSendModel.getFrom();
		String subject = "subject";
		String content = "content";
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.qq.com");
		properties.put("mail.smtp.port", "25");
		properties.put("mail.smtp.auth", "true");
		Authenticator authenticator = new EmailAuthenticator(
				emailSendModel.getFromUserName(),
				emailSendModel.getFromUserPassword());
		javax.mail.Session sendMailSession = javax.mail.Session
				.getDefaultInstance(properties, authenticator);
		MimeMessage mailMessage = new MimeMessage(sendMailSession);
		try {
			mailMessage.setFrom(new InternetAddress(emailSendModel.getFrom()));
			mailMessage.setRecipient(Message.RecipientType.TO,
					new InternetAddress(to));
			mailMessage.setSubject(subject, "UTF-8");
			mailMessage.setSentDate(new Date());
			Multipart mainPart = new MimeMultipart();
			BodyPart html = new MimeBodyPart();
			html.setContent(content.trim(), "text/html; charset=utf-8");
			mainPart.addBodyPart(html);
			mailMessage.setContent(mainPart);
			Transport.send(mailMessage);
		} catch (MessagingException e) {

			e.printStackTrace();
		}
	}
}
