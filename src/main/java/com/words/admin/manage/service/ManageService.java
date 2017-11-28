package com.words.admin.manage.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.words.admin.manage.bean.RoleInfoBean;
import com.words.admin.manage.bean.ServiceInfoBean;
import com.words.admin.manage.bean.UserInfoBean;

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

}
