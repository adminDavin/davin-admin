package com.words.admin.manage.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.web.common.CustomException;
import com.web.response.RespUtils;
import com.words.admin.config.Constant;
import com.words.admin.manage.bean.RoleInfoBean;
import com.words.admin.manage.bean.ServiceInfoBean;
import com.words.admin.manage.bean.UserInfoBean;
import com.words.admin.manage.bean.UserStatusEnum;
import com.words.admin.manage.repository.ManageRepository;

import jodd.json.JsonObject;

@SessionScope
@Service("userInfoService")
public class ManageServiceImpl implements ManageService {
	@Autowired(required = true)
	private ManageRepository manageRepository;

	private boolean loginFlag;

	@PostConstruct
	public void afterInit() {
		// System.out.println("Init UserInfoService success!");
	}

	@Override
	public boolean islogined() {
		return loginFlag;
	}

	@Override
	public boolean login() {
		this.loginFlag = true;
		try {
			manageRepository.getUserInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginFlag;
	}

	@Override
	public String addUserInfo(HttpServletResponse response, Map<String, String[]> map) {
		UserInfoBean userinfo = new UserInfoBean();
		try {
			userinfo.setName(map.get(Constant.NAME)[0]);
			userinfo.setNamePin(map.get(Constant.NAMEPIN)[0]);
			userinfo.setOrganize(map.get(Constant.ORGANIZE)[0]);
			String sex = map.get(Constant.SEX)[0];
			userinfo.setSex(Integer.parseInt(sex));
			userinfo.setEmail(map.get(Constant.EMAIL)[0]);
			userinfo.setPhone(map.get(Constant.PHONE)[0]);
			userinfo.setZoneqq(map.get(Constant.ZONEQQ)[0]);
			userinfo.setRemark(map.get(Constant.REMARK)[0]);
			userinfo.setAddress(map.get(Constant.ADDRESS)[0]);
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "user is register failed for error message!");
			return null;
		}

		try {
			UserInfoBean user = manageRepository.getUserInfoByEmail(userinfo.getEmail());
			if (user == null) {
				int userId = manageRepository.insertUserInfo(userinfo);
				return String.valueOf(userId);
			} else {
				RespUtils.responseJsonFailed(response, "user is register failed for email is exists!");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "user is register failed for insert database!");
			return null;
		}
	}

	@Override
	public String addRoleInfo(HttpServletResponse response, Map<String, String[]> map) {
		RoleInfoBean roleInfo = new RoleInfoBean();
		try {
			roleInfo.setName(map.get(Constant.ROLENAME)[0]);
			roleInfo.setDesc(map.get(Constant.ROLEDESC)[0]);
			String service = map.get(Constant.ROLESERVICE)[0];
			roleInfo.setService(Integer.parseInt(service));
			String userId = map.get(Constant.USERID)[0];
			roleInfo.setUserId(Integer.parseInt(userId));
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "role is register failed for error message!");
			return null;
		}

		try {
			UserInfoBean user = manageRepository.getUserInfoById(roleInfo.getUserId());
			if (user == null) {
				RespUtils.responseJsonFailed(response, "role is add failed for user is invalid!");
				return null;
			}

			RoleInfoBean role = manageRepository.getRoleInfoByName(roleInfo.getName());
			if (role == null) {
				int roleId = manageRepository.insertRoleInfo(roleInfo);
				return String.valueOf(roleId);
			} else {
				RespUtils.responseJsonFailed(response, "role is add failed for role name repeat!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "role is add failed for user is invalid!");
			return null;
		}

		return null;
	}

	@Override
	public List<UserInfoBean> selectUserAll(HttpServletResponse response) {
		try {
			return manageRepository.getUserList();
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "select database failed!");
			return null;
		}
	}

	@Override
	public UserInfoBean selectUserInfoById(HttpServletResponse response, int userId) {
		try {
			return manageRepository.getUserInfoById(userId);
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "select database failed!");
			return null;
		}
	}

	@Override
	public List<RoleInfoBean> selectRoleAll(HttpServletResponse response) {
		try {
			return manageRepository.getRoleList();
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "select database failed!");
			return null;
		}
	}

	@Override
	public List<RoleInfoBean> selectRoleAll(HttpServletResponse response, int userId) {
		try {
			return manageRepository.getRoleList(userId);
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "select database failed!");
			return null;
		}
	}

	@Override
	public List<ServiceInfoBean> selectServiceAll(HttpServletResponse response, int serviceId) {
		try {
			return manageRepository.getServiceList(serviceId);
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "select database failed!");
			return null;
		}
	}

	@Override
	public List<ServiceInfoBean> selectServiceAll(HttpServletResponse response) {
		try {
			return manageRepository.getServiceList();
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "select database failed!");
			return null;
		}
	}

	@Override
	public String updateUserInfo(HttpServletResponse response, UserInfoBean item) {
		try {
			Map<String, Object> params = new HashMap<String, Object>(2);
			params.put("userId", item.getUserId());
			Map<String, Object> login = manageRepository.getloginInfoByUserId(params);
			if (login == null) {
				RespUtils.responseJsonFailed(response, "user is update failed for login is empty!");
				return null;
			}
			if ((int) login.get(Constant.STATE) == 0) {
				params.put("state", 6);
				item.setState(6);
			}
			manageRepository.updateUserInfo(item);
			params.put("state", login.get(Constant.STATE));
			manageRepository.updateLoginInfoState(params);
			return String.valueOf(item.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "user is register failed for error message!");
			return null;
		}
	}

	@Override
	public String updateUserInfo(HttpServletResponse response, UserInfoBean item, Map<String, String[]> param) {
		try {
			if (param.containsKey(Constant.NAME)) {
				item.setName(param.get(Constant.NAME)[1]);
			}
			if (param.containsKey(Constant.ORGANIZE)) {
				item.setName(param.get(Constant.ORGANIZE)[1]);
			}
			if (param.containsKey(Constant.NAMEPIN)) {
				item.setName(param.get(Constant.NAMEPIN)[1]);
			}
			if (param.containsKey(Constant.PHONE)) {
				item.setName(param.get(Constant.PHONE)[1]);
			}
			if (param.containsKey(Constant.ZONEQQ)) {
				item.setName(param.get(Constant.ZONEQQ)[1]);
			}
			if (param.containsKey(Constant.REMARK)) {
				item.setName(param.get(Constant.REMARK)[1]);
			}
			if (param.containsKey(Constant.ADDRESS)) {
				item.setName(param.get(Constant.ADDRESS)[1]);
			}
			manageRepository.updateUserInfo(item);
			return String.valueOf(item.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "user is register failed for error message!");
			return null;
		}

	}

	@Override
	public RoleInfoBean selectRoleInfoById(HttpServletResponse response, int roleId) {
		try {
			return manageRepository.getRoleInfoById(roleId);
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "select database failed!");
			return null;
		}
	}

	@Override
	public String updateRoleInfo(HttpServletResponse response, RoleInfoBean item, Map<String, String[]> param) {

		try {
			if (param.containsKey(Constant.ROLENAME)) {
				item.setName(param.get(Constant.ROLENAME)[1]);
			}
			if (param.containsKey(Constant.ROLEDESC)) {
				item.setName(param.get(Constant.ROLEDESC)[1]);
			}

			manageRepository.updateRoleInfo(item);
			return String.valueOf(item.getRoleId());
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "user is register failed for error message!");
			return null;
		}
	}

	@Override
	public String addLoginInfo(HttpServletResponse response, String loginName, String password) {
		int userId = 0;
		String email = loginName;
		try {
			UserInfoBean user = manageRepository.getUserInfoByEmail(email);
			if (user == null) {
				userId = manageRepository.insertSimpleUserInfo(email);
			}
			// System.out.println(user.getJsonInfo());
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "user is register failed for insert database!");
			return null;
		}

		Map<String, Object> params = new ConcurrentHashMap<String, Object>(3);
		params.put(Constant.USERID, userId);
		params.put(Constant.LOGINNAME, loginName);
		params.put(Constant.PASSWORD, password);
		try {
			Map<String, Object> user = manageRepository.getloginInfoByLoginName(params);
			if (user == null) {
				manageRepository.insertloginInfo(params);
				return String.valueOf(userId);
			} else {
				RespUtils.responseJsonFailed(response, "user is register failed for email is exists!");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "user is register failed for insert database!");
			return null;
		}

	}

	@Override
	public JsonObject getloginInfoByAuth(HttpServletResponse response, String loginName, String password,
			int userState) {
		Map<String, Object> params = new ConcurrentHashMap<String, Object>(3);
		params.put(Constant.LOGINNAME, loginName);
		params.put(Constant.PASSWORD, password);
		try {
			Map<String, Object> user = manageRepository.getloginInfoByAuth(params);
			if (user == null) {
				RespUtils.responseJsonFailed(response, "not register or password is error!");
				return null;
			}
			if (!user.get(Constant.PASSWORD).equals(password)) {
				RespUtils.responseJsonFailed(response, "password is inconrect!");
				return null;
			}

			if (userState == 5) {
				if (!user.get(Constant.STATE).equals(5)) {
					RespUtils.responseJsonFailed(response, "permission isn't enought!");
					return null;
				}
			}
			JsonObject login = new JsonObject();
			for (Entry<String, Object> item : user.entrySet()) {
				String key = item.getKey();
				// System.out.println(key);

				if (Constant.CREATEDATE.equals(key) || Constant.UPDATEDATE.equals(key)
						|| Constant.EXPIREDATE.equals(key)) {
					Timestamp value = (Timestamp) item.getValue();
					if (value != null) {
						login.put(item.getKey(), value.toInstant().toString());
					} else {
						login.put(item.getKey(), "");
					}
				} else if (Constant.USERID.equals(key) || Constant.LOGINID.equals(key) || Constant.STATE.equals(key)) {
					login.put(item.getKey(), String.valueOf(item.getValue()));
				} else {
					login.put(item.getKey(), (String) (item.getValue()));

				}
			}
			return login;
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "user is register failed for insert database!");
			return null;
		}

	}

	@Override
	public String updateSingleUserInfo(HttpServletResponse response, UserInfoBean item, Map<String, String[]> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateloginPass(HttpServletResponse response, Map<String, Object> param) {
		String oldPass = (String) param.get("oldPass");
		String vairiCode = (String) param.get("vairiCode");
		String newPass = (String) param.get("newPass");
		String loginName = (String) param.get("loginName");
		boolean modifyFlag = false;
		try {
			if (vairiCode != null) {
				modifyFlag = manageRepository.checkVariCode(loginName, vairiCode);
			} else if (oldPass != null) {
				Map<String, Object> params = new ConcurrentHashMap<String, Object>(3);
				params.put(Constant.LOGINNAME, loginName);
				params.put(Constant.PASSWORD, oldPass);
				Map<String, Object> user = manageRepository.getloginInfoByAuth(params);
				if (user != null) {
					modifyFlag = true;
				}
			}
			if (modifyFlag) {
				manageRepository.updateloginPass(loginName, newPass);
				return loginName;
			} else {
				RespUtils.responseJsonFailed(response, "check message faild, password modify failed!");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "inner error!");
			return null;
		}
	}

	@Override
	public JsonObject getLogininfoByName(HttpServletResponse response, String loginName) {
		Map<String, Object> params = new ConcurrentHashMap<String, Object>(3);
		params.put(Constant.LOGINNAME, loginName);
		try {
			Map<String, Object> user = manageRepository.getloginInfoByAuth(params);
			if (user == null) {
				RespUtils.responseJsonFailed(response, "not register or password is error!");
				return null;
			}
			JsonObject login = new JsonObject();
			for (Entry<String, Object> item : user.entrySet()) {
				String key = item.getKey();
				// System.out.println(key);

				if (Constant.CREATEDATE.equals(key) || Constant.UPDATEDATE.equals(key)
						|| Constant.EXPIREDATE.equals(key)) {
					Timestamp value = (Timestamp) item.getValue();
					if (value != null) {
						login.put(item.getKey(), value.toInstant().toString());
					} else {
						login.put(item.getKey(), "");
					}
				} else if (Constant.USERID.equals(key) || Constant.LOGINID.equals(key) || Constant.STATE.equals(key)) {
					login.put(item.getKey(), String.valueOf(item.getValue()));
				} else {
					login.put(item.getKey(), (String) (item.getValue()));

				}
			}
			return login;
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "inner error!");
			return null;
		}

	}

	@Override
	public boolean insertVariCode(HttpServletResponse response, String loginName, String variCode) {
		Map<String, Object> params = new ConcurrentHashMap<String, Object>(2);
		params.put("loginName", loginName);
		params.put("variCode", variCode);
		params.put("state", 1);
		try {
			manageRepository.updateVariCodeState(params);
			manageRepository.insertVariCode(params);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "inner error!");
			return false;
		}

	}

	@Override
	public List<UserInfoBean> selectUserAll(HttpServletResponse response, List<Integer> userState) {
		try {
			return manageRepository.getUserList(userState);
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "select database failed!");
			return null;
		}

	}

	@Override
	public boolean checkManagerAuth(HttpServletResponse response, int managerId, String authKey)
			throws CustomException {
		Map<String, Object> condition = new ConcurrentHashMap<String, Object>(2);
		condition.put(Constant.USERID, managerId);
		condition.put("authKey", authKey);
		Map<String, Object> getAuth = manageRepository.checkManagerAuth(condition);
		if (getAuth == null) {
			throw new CustomException(503, "user auth is failed", response);
		}
		return true;
	}

	@Override
	public int updateUserStatus(int userId, int status, String message, int managerId) throws CustomException {
		UserInfoBean userInfo = manageRepository.getUserInfoById(userId);
		UserInfoBean manager = manageRepository.getUserInfoById(managerId);
		if (userInfo == null) {
			throw new CustomException("user is not exists!");
		}
		if (userInfo.getState() == UserStatusEnum.AUDITING.getValue()) {
			throw new CustomException("user is auditing!");
		} else if (userInfo.getState() == status) {
			throw new CustomException("user is status is same as you wish!");
		}
		Map<String, Object> item = new ConcurrentHashMap<String, Object>(2);
		item.put(Constant.USERID, userId);
		item.put(Constant.STATE, status);
		item.put(Constant.ACCEPTER, managerId);
		item.put(Constant.NAME, manager.getName());
		int updateRrows = manageRepository.updateUserStatus(item);
		return updateRrows;
	}

}
