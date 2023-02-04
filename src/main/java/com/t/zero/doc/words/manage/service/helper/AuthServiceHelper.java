package com.t.zero.doc.words.manage.service.helper;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.t.zero.doc.words.response.RespUtils;

@Component
public class AuthServiceHelper {
	
	public boolean checkLoginParams(String loginName, String passwordBase, HttpServletResponse response) {
		// String loginName = request.getParameter(Constant.LOGINNAME);
		// String passwordBase = request.getParameter(Constant.PASSWORD);
		// System.out.println(loginName + " " + passwordBase);
		// 745854511@qq.com UUFad3N4MTEyNA==
		// loginName = "7458545111@qq.com";
		// passwordBase = "UUFad3N4MTEyNA==";
		// String password = new
		// String(Base64.decodeBase64(passwordBase.getBytes("UTF-8")));
		try {
			if (loginName == null) {
				RespUtils.responseJsonFailed(response, "loginName is required!");
				return false;
			}
			if (passwordBase == null) {
				RespUtils.responseJsonFailed(response, "password is required!");
				return false;
			}

		} catch (Exception e) {
			RespUtils.responseJsonFailed(response, "password is invalied!");
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
