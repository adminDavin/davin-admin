package com.t.zero.doc.words.manage.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.t.zero.doc.words.components.RequestParamsConvert;
import com.t.zero.doc.words.config.Constant;
import com.t.zero.doc.words.manage.service.AuthService;
import com.t.zero.doc.words.manage.service.NotifyEmailService;
import com.t.zero.doc.words.manage.service.helper.AuthServiceHelper;
import com.t.zero.doc.words.model.auto.Logininfo;
import com.t.zero.doc.words.model.auto.Userinfo;
import com.t.zero.doc.words.response.RespUtils;

import jodd.json.JsonObject;

@RequestScope
@RestController
@RequestMapping("/auth")
public class AuthController {
	Logger logger = LogManager.getLogger(AuthController.class.getName());
	private String RESET_PASSWD_CONTENT = "Words Admin varify code for change Password of this system";
	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private RequestParamsConvert requestParamsConvert;

	@Autowired
	private AuthServiceHelper authServiceHelper;

	@Autowired
	private AuthService authService;

	@Autowired
	private NotifyEmailService notifyEmailService;

	@RequestMapping("/login")
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		var params = requestParamsConvert.json(request);
		String loginName = params.get("loginName").asText();
		String password = params.get(Constant.PASSWORD).asText();
		Boolean isManage = params.get("isManage").asBoolean();
		int userState = isManage ? 5 : 0;
		if (!authServiceHelper.checkLoginParams(loginName, password, response)) {
			return;
		}
		var passwd = new String(Base64.decodeBase64(password.getBytes("UTF-8")));
		Logininfo login = authService.getloginInfoByAuth(response, loginName, passwd, userState);
		if (login == null) {
			return;
		}

		String key = login.getLoginname() + "(#)" + login.getUserid() + "(#)" + login.getPassword() + "(#)"
				+ login.getState();
		ObjectNode data = mapper.createObjectNode();
		data.put("key", jodd.util.Base64.encodeToString(key.getBytes("UTF-8")));
		data.put(Constant.LOGINNAME, login.getLoginname());
		data.put(Constant.USERID, login.getUserid());
		data.put(Constant.STATE, login.getState());
		ObjectNode result = mapper.createObjectNode();
		result.set("data", data);
		result.put("message", "user is register success");
		RespUtils.responseJsonSuccess(response, result);
	}

	@RequestMapping("/register")
	public void simpleRegist(HttpServletRequest request, HttpServletResponse response) throws IOException {
		var params = requestParamsConvert.json(request);
		String loginName = params.get(Constant.LOGINNAME).asText();
		String password = params.get(Constant.PASSWORD).asText();
		if (!authServiceHelper.checkLoginParams(loginName, password, response)) {
			return;
		}
		var passwd = new String(Base64.decodeBase64(password.getBytes("UTF-8")));
		String userId = authService.addLoginInfo(response, loginName, passwd);
		if (userId == null) {
			return;
		}

		String key = loginName + "(#)" + userId + "(#)" + password;
		ObjectNode result = mapper.createObjectNode();
		ObjectNode data = mapper.createObjectNode();
		data.put("userId", userId);
		data.put("state", 0);
		try {
			data.put("key", jodd.util.Base64.encodeToString(key.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		data.put("loginName", loginName);
		result.set("data", data);
		result.put("message", "user is register success");
		RespUtils.responseJsonSuccess(response, result);
	}

	@RequestMapping("/getUserInfoByUserId")
	public void getUserListByUserId(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter(Constant.USERID);
		if (userId == null) {
			RespUtils.responseJsonFailed(response, "userId is required!");
			return;
		}
		try {
			var item = authService.selectUserInfoById(response, Integer.parseInt(userId));
			ObjectNode result = mapper.createObjectNode();
			result.set("data", mapper.convertValue(item, ObjectNode.class));
			result.put("message", "user is update success");
			RespUtils.responseJsonSuccess(response, result);
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "params is invalied!");
			return;
		}
	}

	@RequestMapping("/updateUserInfo")
	public void updateUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		var params = requestParamsConvert.json(request);
		var item = authService.updateUserInfo(response, mapper.convertValue(params, Userinfo.class));
		ObjectNode result = mapper.createObjectNode();
		result.set("data", mapper.convertValue(item, ObjectNode.class));
		result.put("message", "user is update success");
		RespUtils.responseJsonSuccess(response, result);
	}

	@RequestMapping("/sendVariCode")
	public void sendVariCode(HttpServletRequest request, HttpServletResponse response) {
		String loginName = request.getParameter("loginName");
		var loginInfo = authService.getLogininfoByName(response, loginName);
		if (loginInfo == null) {
			return;
		}

		Random random = new Random();
		String variCode = String.valueOf(1000000 + random.nextInt(900000));
		JsonObject result = new JsonObject();
		boolean sendEmailFlag = notifyEmailService.sendEmail(loginName, RESET_PASSWD_CONTENT,
				Constant.EMAILMESSAGEFORPASS + variCode);
		if (sendEmailFlag) {
			authService.insertVariCode(response, loginName, variCode);
			result.put("data", "success");
			result.put("message", "varify code send success");
			RespUtils.responseJsonSuccess(response, result);
			return;

		} else {
			result.put("data", "failed");
			result.put("message", "send email failed");
			RespUtils.responseJsonSuccess(response, result);
		}
	}

	@RequestMapping("/modifyPass")
	public void updateLoginInfoPass(HttpServletRequest request, HttpServletResponse response) throws IOException {
		var params = requestParamsConvert.json(request);
		var vairiCode = params.get("variCode").asText();
		var newPass = params.get("password").asText();
		var loginName = params.get("loginName").asText();
		var password = new String(Base64.decodeBase64(newPass.getBytes("UTF-8")));
		var results = authService.updateloginPass(response, loginName, password, vairiCode);
		if (results == null) {
			return;
		}
		ObjectNode result = mapper.createObjectNode();
		result.put("message", "password is update success");
		RespUtils.responseJsonSuccess(response, result);
	}
}
