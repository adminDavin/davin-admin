package com.words.admin.manage.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.web.common.CustomException;
import com.words.admin.manage.bean.RoleInfoBean;
import com.words.admin.manage.bean.ServiceInfoBean;
import com.words.admin.manage.bean.UserInfoBean;

import jodd.json.JsonObject;

public interface ManageService {

	public boolean islogined();

	public boolean login();

	public String addUserInfo(HttpServletResponse response, Map<String, String[]> map);

	public String addRoleInfo(HttpServletResponse response, Map<String, String[]> roleInfoMap);

	public List<UserInfoBean> selectUserAll(HttpServletResponse response);

	public List<RoleInfoBean> selectRoleAll(HttpServletResponse response);

	public List<RoleInfoBean> selectRoleAll(HttpServletResponse response, int userId);

	public List<ServiceInfoBean> selectServiceAll(HttpServletResponse response, int serviceId);

	public List<ServiceInfoBean> selectServiceAll(HttpServletResponse response);

	public UserInfoBean selectUserInfoById(HttpServletResponse response, int userId);

	public String updateUserInfo(HttpServletResponse response, UserInfoBean item, Map<String, String[]> param);

	public RoleInfoBean selectRoleInfoById(HttpServletResponse response, int roleId);

	public String updateRoleInfo(HttpServletResponse response, RoleInfoBean item, Map<String, String[]> param);

	public String addLoginInfo(HttpServletResponse response, String loginName, String password);

	public JsonObject getloginInfoByAuth(HttpServletResponse response, String loginName, String string, int userState);

	public String updateUserInfo(HttpServletResponse response, UserInfoBean item);

	public String updateSingleUserInfo(HttpServletResponse response, UserInfoBean item, Map<String, String[]> param);

	public String updateloginPass(HttpServletResponse response, Map<String, Object> param);

	public JsonObject getLogininfoByName(HttpServletResponse response, String loginName);

	public boolean insertVariCode(HttpServletResponse response, String loginName, String variCode);

	public List<UserInfoBean> selectUserAll(HttpServletResponse response, List<Integer> userStateList);

	public boolean checkManagerAuth(HttpServletResponse response, int managerId, String authKey) throws CustomException;

	public int updateUserStatus(int userId, int status, String message, int managerId) throws CustomException;

}
