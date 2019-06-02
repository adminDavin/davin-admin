package com.words.admin.manage.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.web.common.CustomException;
import com.web.response.RespUtils;
import com.words.admin.Utils.ValiedParams;
import com.words.admin.config.Constant;
import com.words.admin.manage.bean.RoleInfoBean;
import com.words.admin.manage.bean.ServiceInfoBean;
import com.words.admin.manage.bean.UserInfoBean;
import com.words.admin.manage.bean.UserStatusEnum;
import com.words.admin.manage.service.EmailService;
import com.words.admin.manage.service.ManageService;
import com.words.admin.resource.TransferService;

import jodd.json.JsonArray;
import jodd.json.JsonObject;
import jodd.json.JsonParser;

@RequestScope
@RestController
public class HelloController {
	Logger logger = LogManager.getLogger(HelloController.class.getName());

	
	@Autowired
	private TransferService transferService;
	@Autowired
	private ManageService manageService;

	@Autowired
	private EmailService emailService;
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
		// System.out.println("fff");
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

	@RequestMapping("/deleteRole")
	public void deleteRole(HttpServletRequest request, HttpServletResponse response) {
		String authKey = "deleteRole";
		Map<String, String[]> roleInfoMap = ValiedParams.checkKeyExist(response, request.getParameterMap(),
				Constant.DELETEROLEINFO);

		if (roleInfoMap == null) {
			return;
		}
		Integer managerId = Integer.parseInt(request.getParameter(Constant.MANAGEID));
		 try {
			manageService.checkManagerAuth(response, managerId, authKey);
			manageService.deleteRole(response, roleInfoMap);
		 } catch (CustomException e) {
		 e.printStackTrace();
		 RespUtils.responseJsonFailed(response, "auth failed!");
		 return;
		 }

		JsonObject result = new JsonObject();
		result.put("message", "role is delete success");
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
		String loginName = request.getParameter("loginName");
		String password = request.getParameter(Constant.PASSWORD);
		String isManage = request.getParameter("isManage");
		System.out.println("ddddddddddddddddddddddddd");
		int userState = 0;
		if ("true".equals(isManage)) {
			userState = 5;
		}
		if (!checkLoginParams(loginName, password, response)) {
			return;
		}
		JsonObject login;
		try {
			login = manageService.getloginInfoByAuth(response, loginName,
					new String(Base64.decodeBase64(password.getBytes("UTF-8"))), userState);
			if (login == null) {
				return;
			}
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
		if (list != null) {
			JsonObject result = new JsonObject();
			JsonArray data = new JsonArray();

			for (UserInfoBean user : list) {
				data.add(user.getJsonInfo());
			}

			result.put("data", data);
			RespUtils.responseJsonSuccess(response, result);
		}
	}

	@RequestMapping("/getUserListByState")
	public void getUserListByState(HttpServletRequest request, HttpServletResponse response) {
		String userStateStr = request.getParameter("userState");
		List<Integer> userStateList = null;
		try {
			if (userStateStr != null) {
				userStateList = new JsonParser().parse(userStateStr);
			}
		} catch (Exception e) {
			RespUtils.responseJsonFailed(response, "params 'userState' is invalied!");
			return;
		}

		List<UserInfoBean> list = manageService.selectUserAll(response, userStateList);
		if (list != null) {
			JsonObject result = new JsonObject();
			JsonArray data = new JsonArray();
			for (UserInfoBean user : list) {
				data.add(user.getJsonInfo());
			}
			result.put("data", data);
			RespUtils.responseJsonSuccess(response, result);
		}
	}

	@RequestMapping("/getUserListByUserId")
	public void getUserListByUserId(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter(Constant.USERID);
		// System.out.println(userId);
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
			e.printStackTrace();
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
		Map<String, String[]> param = ValiedParams.checkKeyExist(response, request.getParameterMap(),
				Constant.UPDATEUSERINFO);
		logger.info("action:updateUserInfo request params:" + JSON.toJSONString(param));
		if (param == null) {
			return;
		}
		int userId = 0;
		try {
			userId = Integer.parseInt(request.getParameter(Constant.USERID));
		} catch (Exception e) {
			RespUtils.responseJsonFailed(response, "userId is not exist!");
			return;
		}
		UserInfoBean item = manageService.selectUserInfoById(response, userId);
		item.setNamePin(param.get(Constant.NAMEPIN)[0]);
		item.setOrganize(param.get(Constant.ORGANIZE)[0]);
		item.setRemark(param.get(Constant.REMARK)[0]);
		item.setPhone(param.get(Constant.PHONE)[0]);
		item.setAddress(param.get(Constant.ADDRESS)[0]);
		item.setName(param.get(Constant.NAME)[0]);
		// item.setNamePin(param.get(Constant.BIRTHDATE)[0]);
		String results = manageService.updateUserInfo(response, item);
		JsonObject result = new JsonObject();
		JsonObject data = new JsonObject();
		data.put("userId", results);
		result.put("data", data);
		result.put("message", "user is update success");
		RespUtils.responseJsonSuccess(response, result);
	}

	@RequestMapping("/updateUserStatus")
	public void updateUserStatus(HttpServletRequest request, HttpServletResponse response) throws CustomException {
		Map<String, String[]> param = ValiedParams.checkKeyExist(response, request.getParameterMap(),
				Constant.UPDATEUSERSTATUSPARAMS);
		String authKey = "updateUserStatus";
		if (param == null) {
			return;
		}
		int userId = 0;
		int managerId = 0;
		try {
			userId = Integer.parseInt(request.getParameter(Constant.USERID));
			managerId = Integer.parseInt(request.getParameter(Constant.ACCEPTER));
		} catch (Exception e) {
			RespUtils.responseJsonFailed(response, "userId or accepter is not integer!");
		}
		try {
			int status = UserStatusEnum.getName(param.get(Constant.STATUSACTION)[0]);
			if (status == -1) {
				throw new CustomException(" status is invalid!");
			}
			manageService.checkManagerAuth(response, managerId, authKey);
			int updateRows = manageService.updateUserStatus(userId, status, param.get(Constant.MESSAGE)[0], managerId);
			JsonObject result = new JsonObject();
			JsonObject data = new JsonObject();
			data.put("updateRows", updateRows);
			result.put("data", data);
			result.put("message", "user is success updated");
			RespUtils.responseJsonSuccess(response, result);

		} catch (CustomException e) {
			RespUtils.responseJsonFailed(response, e.getMessage());
			return;
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "unknow error!");
			return;
		}
	}

	@RequestMapping("/updateSingleUserInfo")
	public void updateSingleUserInfo(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String[]> param = ValiedParams.checkKeyModify(response, request.getParameterMap(),
				Constant.UPDATEUSERINFOSINGLE);
		int userId = 0;
		try {
			userId = Integer.parseInt(request.getParameter(Constant.USERID));
		} catch (Exception e) {
			RespUtils.responseJsonFailed(response, "userId is not exist!");
			return;
		}
		UserInfoBean item = manageService.selectUserInfoById(response, userId);
		String results = manageService.updateSingleUserInfo(response, item, param);
		JsonObject result = new JsonObject();
		JsonObject data = new JsonObject();
		data.put("userId", results);
		result.put("data", data);
		result.put("message", "role is update success");
		RespUtils.responseJsonSuccess(response, result);
	}

	@RequestMapping("/sendVariCode")
	public void sendVariCode(HttpServletRequest request, HttpServletResponse response) {
		String loginName = "";
		try {
			loginName = request.getParameter("loginName");
			if (loginName == null) {
				throw new Exception();
			}
			JsonObject loginInfo = manageService.getLogininfoByName(response, loginName);
			if (loginInfo == null) {
				return;
			}
		} catch (Exception e) {
			RespUtils.responseJsonFailed(response, "params is invalid!");
			return;
		}

		Random random = new Random();
		String variCode = String.valueOf(1000000 + random.nextInt(900000));
		JsonObject result = new JsonObject();
		boolean sendEmailFlag = emailService.sendEmail(loginName,
				"Words Admin varify code for change Password of this system", Constant.EMAILMESSAGEFORPASS + variCode);
		if (sendEmailFlag) {
			boolean insertFlag = manageService.insertVariCode(response, loginName, variCode);
			if (insertFlag) {
				result.put("data", "success");
				result.put("message", "varify code send success");
				RespUtils.responseJsonSuccess(response, result);
				return;
			} else {
				RespUtils.responseJsonFailed(response, "insert database failed!");
				return;
			}
		} else {
			result.put("data", "failed");
			result.put("message", "send email failed");
			RespUtils.responseJsonSuccess(response, result);
		}
	}

	@RequestMapping("/modifyPass")
	public void updateLoginInfoPass(HttpServletRequest request, HttpServletResponse response) {
		String oldPass = "";
		String newPass = "";
		String vairiCode = "";
		String loginName = "";

		try {
			oldPass = request.getParameter("oldPassword");
			vairiCode = request.getParameter("variCode");
			newPass = request.getParameter("newPassword");
			loginName = request.getParameter("loginName");
			if (newPass == null) {
				throw new Exception();
			}
			if (vairiCode == null && oldPass == null) {
				throw new Exception();
			}
			if (newPass == null || loginName == null) {
				throw new Exception();
			}
		} catch (Exception e) {
			RespUtils.responseJsonFailed(response, "params is invalid!");
			return;
		}

		Map<String, Object> param = new HashMap<String, Object>(3);
		try {
			if (oldPass != null) {
				param.put("oldPass", new String(Base64.decodeBase64(oldPass.getBytes("UTF-8"))));
			} else {
				param.put("oldPass", null);
			}
			param.put("vairiCode", vairiCode);
			param.put("newPass", new String(Base64.decodeBase64(newPass.getBytes("UTF-8"))));
			param.put("loginName", loginName);
			String results = manageService.updateloginPass(response, param);
			if (results == null) {
				return;
			}
			JsonObject result = new JsonObject();
			JsonObject data = new JsonObject();
			data.put("userId", results);
			result.put("data", data);
			result.put("message", "password is update success");
			RespUtils.responseJsonSuccess(response, result);
		} catch (UnsupportedEncodingException e) {
			RespUtils.responseJsonFailed(response, "inner is error!");
			e.printStackTrace();
		}

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

	@RequestMapping("/getServerListByRole")
	public void getServerListByRole(HttpServletRequest request, HttpServletResponse response) {
		String roleIdStr = request.getParameter(Constant.ROLEID);
		int roleId = 0;
		try {
			roleId = Integer.parseInt(roleIdStr);
		} catch (Exception e) {
			RespUtils.responseJsonFailed(response, "parameter is invalid!");
			return;
		}
		List<ServiceInfoBean> list = manageService.getServiceListByRole(response, roleId);
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

	@RequestMapping("/saveRoleRelService")
	public void saveRoleRelService(HttpServletRequest request, HttpServletResponse response) {
		String authKey = "saveRoleRelService";
		String roleIdStr = request.getParameter(Constant.ROLEID);
		String managerIdStr = request.getParameter("manageId");
		String serviceIdsStr = request.getParameter("serviceIds");
		int managerId = 0;
		int roleId = 0;
		List<Integer> serviceIds = null;
		try {
			managerId = Integer.parseInt(managerIdStr);
			roleId = Integer.parseInt(roleIdStr);
			serviceIds = new JsonParser().parse(serviceIdsStr);
			if (serviceIds.size() == 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			RespUtils.responseJsonFailed(response, "parameter is invalid!");
			return;
		}
		try {
			// manageService.checkManagerAuth(response, managerId, authKey);
			manageService.setRoleService(roleId, managerId, serviceIds);
		} catch (CustomException e) {
			RespUtils.responseJsonFailed(response, e.getMessage());
			return;
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "inner error!");
			return;
		}

		JsonObject result = new JsonObject();
		result.put("data", "user is deleted");
		RespUtils.responseJsonSuccess(response, result);
	}

	@RequestMapping("/deleteUser")
	public void deleteUser(HttpServletRequest request, HttpServletResponse response) {
		String authKey = "deleteUser";
		String userIdStr = request.getParameter(Constant.USERID);
		String managerIdStr = request.getParameter("manager");
		int managerId = 0;
		int userId = 0;
		try {
			managerId = Integer.parseInt(managerIdStr);
			userId = Integer.parseInt(userIdStr);
		} catch (Exception e) {
			RespUtils.responseJsonFailed(response, "parameter is invalid!");
			return;
		}
		try {
			manageService.checkManagerAuth(response, managerId, authKey);
			manageService.deleteUser(userId, managerId);
		} catch (CustomException e) {
			RespUtils.responseJsonFailed(response, e.getMessage());
			return;
		} catch (Exception e) {
			RespUtils.responseJsonFailed(response, "inner error!");
			return;
		}

		JsonObject result = new JsonObject();
		result.put("data", "user is deleted");
		RespUtils.responseJsonSuccess(response, result);
	}

	@RequestMapping("/addManager")
	public void addManager(HttpServletRequest request, HttpServletResponse response) {
		String authKey = "addManager";
		String userIdStr = request.getParameter(Constant.USERID);
		String managerIdStr = request.getParameter("manageId");
		int managerId = 0;
		int userId = 0;
		try {
			managerId = Integer.parseInt(managerIdStr);
			userId = Integer.parseInt(userIdStr);
		} catch (Exception e) {
			RespUtils.responseJsonFailed(response, "parameter is invalid!");
			return;
		}
		try {
			manageService.checkManagerAuth(response, managerId, authKey);
			manageService.updateUserToManager(userId, managerId);
		} catch (CustomException e) {
			RespUtils.responseJsonFailed(response, e.getMessage());
			return;
		} catch (Exception e) {
			RespUtils.responseJsonFailed(response, "inner error!");
			return;
		}

		JsonObject result = new JsonObject();
		result.put("data", "user is deleted");
		RespUtils.responseJsonSuccess(response, result);
	}

	@RequestMapping("/setManageRole")
	public void setManageRole(HttpServletRequest request, HttpServletResponse response) {
		String authKey = "setManageRole";
		String userIdStr = request.getParameter(Constant.USERID);
		String managerIdStr = request.getParameter("manageId");
		String rolesIdStr = request.getParameter("rolesId");
		int managerId = 0;
		int userId = 0;
		List<Integer> rolesId = null;
		try {
			managerId = Integer.parseInt(managerIdStr);
			userId = Integer.parseInt(userIdStr);
			rolesId = new JsonParser().parse(rolesIdStr);
			if (rolesId.size() == 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			RespUtils.responseJsonFailed(response, "parameter is invalid!");
			return;
		}
		try {
			// manageService.checkManagerAuth(response, managerId, authKey);
			manageService.setManageRole(userId, managerId, rolesId);
		} catch (CustomException e) {
			RespUtils.responseJsonFailed(response, e.getMessage());
			return;
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "inner error!");
			return;
		}

		JsonObject result = new JsonObject();
		result.put("data", "user is deleted");
		RespUtils.responseJsonSuccess(response, result);
	}

	@RequestMapping("/getManagerRoles")
	public void getManagerRoles(HttpServletRequest request, HttpServletResponse response) {

		String userIdStr = request.getParameter(Constant.USERID);

		int userId = 0;
		List<Integer> rolesId = null;
		try {
			userId = Integer.parseInt(userIdStr);
		} catch (Exception e) {
			RespUtils.responseJsonFailed(response, "parameter is invalid!");
			return;
		}
		try {
			List<RoleInfoBean> list = manageService.getManagerRoles(userId);
			JsonObject result = new JsonObject();
			JsonArray data = new JsonArray();
			for (RoleInfoBean obj : list) {
				JsonObject objJson = obj.getJsonInfo();
				data.add(objJson);
			}
			result.put("data", data);
			RespUtils.responseJsonSuccess(response, result);
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "inner error!");
			return;
		}

	}

	public int getCount() {
		this.count++;
		// System.out.println("the hello counter is :" + count);
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
