package com.t.zero.doc.words.manage.service;

import com.t.zero.doc.words.manage.bean.UserInfoBean;

public interface EmailService {
	public boolean sendEmail(String toEmailAddress, String emailSubject, String emailMessage);

	public void remindRegister(String email, String loginName, String password);

	public void remindManager(String email, UserInfoBean item);

	public void remindUserForModifyPassword(String loginName, String newPass);

	public void remindUserApplyResult(String email, int state);
}
