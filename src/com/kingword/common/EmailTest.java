package com.kingword.common;

import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;

public class EmailTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Integer(1);
		EmailSendModel emailSendModel = new EmailSendModel();
		// 邮箱服务器类型
		String smtpHost = "smtp.163.com";
		// 邮箱服务器类型
		int smtpport = 25;
		// 邮箱发送者
		String from = "18758268513@163.com";
		// 邮箱发送者的登录名
		String fromUserName = "m18758268513@163.com";
		// 邮箱发送者的登录名
		String fromUserPassword = "123456l";
		// 邮箱收件人
		String[] to = new String[] { "1628422089@qq.com" };
		// 邮箱发送主题
		String subject = "我的大学";
		// 邮箱发送内容
		String messageText = "请耐心等待方法反反复复 ！顶顶顶顶顶顶顶顶顶顶";
		emailSendModel.setFrom(from);
		emailSendModel.setFromUserName(fromUserName);
		emailSendModel.setFromUserPassword(fromUserPassword);
		emailSendModel.setMessageText(messageText);
		emailSendModel.setSmtpHost(smtpHost);
		emailSendModel.setSubject(subject);
		emailSendModel.setTo(to);
		emailSendModel.setSmtpport(smtpport);
		try {
			EmailSendUtil.emailSend(emailSendModel);
		} catch (AuthenticationFailedException e) {
			System.out.println("用户名或者密码错误");
			e.printStackTrace();
		} catch (MessagingException e) {
			System.out.println("邮件发送失败");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("其他异常，导致邮件发送失败");
			e.printStackTrace();
		}
	}

}
