package com.kingword.common;


public class EmailTestQQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmailSendModel emailSendModel = new EmailSendModel();
		// 邮箱服务器类型
		String smtpHost = "smtp.qq.com";
		// 邮箱服务器类型
		int smtpport = 587;
		// 邮箱发送者
		String from = "745854511@qq.com";
		// 邮箱发送者的登录名
		String fromUserName = "745854511@qq.com";
		// 邮箱发送者的登录名
		String fromUserPassword = "izbglvvuadhpbdaj";
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

		EmailSendUtil.sendEmail(emailSendModel);

	}

}
