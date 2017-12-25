package com.words.admin.manage.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

import com.web.response.RespUtils;
import com.words.admin.Utils.ValiedParams;
import com.words.admin.config.Constant;
import com.words.admin.manage.bean.RoleInfoBean;
import com.words.admin.manage.bean.ServiceInfoBean;
import com.words.admin.manage.bean.UserInfoBean;
import com.words.admin.manage.service.ManageService;
import com.words.admin.resource.TransferService;

import jodd.json.JsonArray;
import jodd.json.JsonObject;

@RequestScope
@RestController
public class HelloController {

	@Autowired(required = true)
	private TransferService transferService;
	@Autowired(required = true)
	private ManageService manageService;
	private int count = 0;

	@RequestMapping("/hello")
	public String handle(HttpServletRequest request) {
		JsonObject result = new JsonObject();
		transferService.counter();
		this.getCount();
		if ("true".equals(request.getParameter("login"))) {
			manageService.login();
		}
		result.put("login", manageService.login());
		return RespUtils.success(result);
	}

	@RequestMapping("/hello1")
	public Callable<String> processUpload(final MultipartFile file) {
		System.out.println("fff");
		return new Callable<String>() {
			public String call() throws Exception {
				// ...
				return "someView";
			}
		};
	}

	@RequestMapping("/roleinfo")
	public void addRole(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String[]> roleInfoMap = ValiedParams.checkKeyExist(response, request.getParameterMap(),
				Constant.ROLEINFO);
		if (roleInfoMap == null) {
			return;
		}
		String roleId = manageService.addRoleInfo(response, roleInfoMap);
		if (roleId == null) {
			return;
		}
		JsonObject result = new JsonObject();
		JsonObject data = new JsonObject();
		data.put("userId", roleId);
		result.put("data", data);
		result.put("message", "role is add success");
		RespUtils.responseJsonSuccess(response, result);
	}

	@RequestMapping("/register")
	public void register(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String[]> userinfoMap = ValiedParams.checkKeyExist(response, request.getParameterMap(),
				Constant.USERINFO);
		if (userinfoMap == null) {
			return;
		}
		String userId = manageService.addUserInfo(response, userinfoMap);
		if (userId == null) {
			return;
		}

		JsonObject result = new JsonObject();
		JsonObject data = new JsonObject();
		data.put("userId", userId);
		result.put("data", data);
		result.put("message", "user is register success");
		RespUtils.responseJsonSuccess(response, result);
	}

	private boolean checkLoginParams(String loginName, String passwordBase, HttpServletResponse response) {
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

	@RequestMapping("/simpleRegist")
	public void simpleRegist(HttpServletRequest request, HttpServletResponse response) {
		String loginName = request.getParameter(Constant.LOGINNAME);
		String password = request.getParameter(Constant.PASSWORD);
		if (!checkLoginParams(loginName, password, response)) {
			return;
		}
		String userId;
		try {
			userId = manageService.addLoginInfo(response, loginName,
					new String(Base64.decodeBase64(password.getBytes("UTF-8"))));
		} catch (UnsupportedEncodingException e) {
			return;
		}
		if (userId == null) {
			return;
		}

		String key = loginName + "(#)" + userId + "(#)" + password;
		JsonObject result = new JsonObject();
		JsonObject data = new JsonObject();
		data.put("userId", userId);
		try {
			data.put("key", jodd.util.Base64.encodeToString(key.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		data.put("loginName", loginName);
		result.put("data", data);
		result.put("message", "user is register success");
		RespUtils.responseJsonSuccess(response, result);
	}

	@RequestMapping("/login")
	public void login(HttpServletRequest request, HttpServletResponse response) {
		String loginName = request.getParameter(Constant.LOGINNAME);
		String password = request.getParameter(Constant.PASSWORD);
		if (!checkLoginParams(loginName, password, response)) {
			return;
		}
		JsonObject login;
		try {
			login = manageService.getloginInfoByAuth(response, loginName,
					new String(Base64.decodeBase64(password.getBytes("UTF-8"))));
		} catch (UnsupportedEncodingException e) {
			return;
		}
		String key = login.getString(Constant.LOGINNAME) + "(#)" + login.getString(Constant.USERID) + "(#)"
				+ login.getString(Constant.PASSWORD) + "(#)" + login.getString(Constant.STATE);

		try {
			login.put("key", jodd.util.Base64.encodeToString(key.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		login.remove(Constant.PASSWORD);
		login.remove(Constant.STATE);
		JsonObject result = new JsonObject();
		result.put("data", login);
		result.put("message", "user is register success");
		RespUtils.responseJsonSuccess(response, result);
	}

	@RequestMapping("/getUserList")
	public void getUserInfo(HttpServletRequest request, HttpServletResponse response) {
		List<UserInfoBean> list = manageService.selectUserAll(response);
		if (list == null) {
			return;
		}
		JsonObject result = new JsonObject();
		JsonArray data = new JsonArray();

		for (UserInfoBean user : list) {
			data.add(user.getJsonInfo());
		}

		result.put("data", data);
		RespUtils.responseJsonSuccess(response, result);
	}

	@RequestMapping("/getUserListByUserId")
	public void getUserListByUserId(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter(Constant.USERID);
		System.out.println(userId);
		if (userId == null) {
			RespUtils.responseJsonFailed(response, "userId is required!");
			return;
		}
		try {
			UserInfoBean item = manageService.selectUserInfoById(response, Integer.parseInt(userId));
			JsonObject result = new JsonObject();
			result.put("data", item.getJsonInfo());
			result.put("message", "user is update success");
			RespUtils.responseJsonSuccess(response, result);
		} catch (Exception e) {
			RespUtils.responseJsonFailed(response, "params is invalied!");
			return;
		}
	}

	@RequestMapping("/getRoleList")
	public void getRoleInfo(HttpServletRequest request, HttpServletResponse response) {
		List<RoleInfoBean> list = manageService.selectRoleAll(response);
		if (list == null) {
			return;
		}
		JsonObject result = new JsonObject();
		JsonArray data = new JsonArray();

		for (RoleInfoBean obj : list) {
			JsonObject objJson = obj.getJsonInfo();
			data.add(objJson);
		}

		result.put("data", data);
		RespUtils.responseJsonSuccess(response, result);
	}

	@RequestMapping("/updateUserInfo")
	public void updateUserInfo(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String[]> param = ValiedParams.checkKeyModify(response, request.getParameterMap(),
				Constant.USERINFO);
		int userId = 0;
		try {
			userId = Integer.parseInt(request.getParameter(Constant.USERID));
		} catch (Exception e) {
			RespUtils.responseJsonFailed(response, "userId is not exist!");
			return;
		}
		UserInfoBean item = manageService.selectUserInfoById(response, userId);
		String results = manageService.updateUserInfo(response, item, param);
		JsonObject result = new JsonObject();
		JsonObject data = new JsonObject();
		data.put("userId", results);
		result.put("data", data);
		result.put("message", "user is update success");
		RespUtils.responseJsonSuccess(response, result);
	}

	@RequestMapping("/updateRoleInfo")
	public void updateRoleInfo(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String[]> param = ValiedParams.checkKeyModify(response, request.getParameterMap(),
				Constant.ROLEINFO);
		int roleId = 0;
		try {
			roleId = Integer.parseInt(request.getParameter(Constant.USERID));
		} catch (Exception e) {
			RespUtils.responseJsonFailed(response, "roleId is not exist!");
			return;
		}
		RoleInfoBean item = manageService.selectRoleInfoById(response, roleId);
		String results = manageService.updateRoleInfo(response, item, param);
		JsonObject result = new JsonObject();
		JsonObject data = new JsonObject();
		data.put("userId", results);
		result.put("data", data);
		result.put("message", "role is update success");
		RespUtils.responseJsonSuccess(response, result);
	}

	@RequestMapping("/getRoleByUserId")
	public void getRoleInfoByUserId(HttpServletRequest request, HttpServletResponse response) {
		int userId = 0;
		try {
			userId = Integer.parseInt(request.getParameter(Constant.USERID));
		} catch (Exception e) {
			RespUtils.responseJsonFailed(response, "userId is not exist!");
			return;
		}

		List<RoleInfoBean> list = manageService.selectRoleAll(response, userId);
		if (list == null) {
			return;
		}
		JsonObject result = new JsonObject();
		JsonArray data = new JsonArray();

		for (RoleInfoBean obj : list) {
			JsonObject objJson = obj.getJsonInfo();
			data.add(objJson);
		}

		result.put("data", data);
		RespUtils.responseJsonSuccess(response, result);
	}

	@RequestMapping("/getServerByRoleId")
	public void getServerInfoByRoleId(HttpServletRequest request, HttpServletResponse response) {
		int serviceId = 0;
		try {
			serviceId = Integer.parseInt(request.getParameter(Constant.ROLESERVICE));
		} catch (Exception e) {
			RespUtils.responseJsonFailed(response, "userId is not exist!");
			return;
		}
		List<ServiceInfoBean> list = manageService.selectServiceAll(response, serviceId);
		if (list == null) {
			return;
		}
		JsonObject result = new JsonObject();
		JsonArray data = new JsonArray();

		for (ServiceInfoBean obj : list) {
			JsonObject objJson = obj.getJsonInfo();
			data.add(objJson);
		}

		result.put("data", data);
		RespUtils.responseJsonSuccess(response, result);
	}

	@RequestMapping("/getServerList")
	public void getServerList(HttpServletRequest request, HttpServletResponse response) {

		List<ServiceInfoBean> list = manageService.selectServiceAll(response);
		if (list == null) {
			return;
		}
		JsonObject result = new JsonObject();
		JsonArray data = new JsonArray();

		for (ServiceInfoBean obj : list) {
			JsonObject objJson = obj.getJsonInfo();
			data.add(objJson);
		}

		result.put("data", data);
		RespUtils.responseJsonSuccess(response, result);
	}

	public int getCount() {
		this.count++;
		System.out.println("the hello counter is :" + count);
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
