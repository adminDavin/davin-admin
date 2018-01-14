package com.words.admin.manage.repository;

import java.util.List;
import java.util.Map;

import com.words.admin.manage.bean.RoleInfoBean;
import com.words.admin.manage.bean.ServiceInfoBean;
import com.words.admin.manage.bean.UserInfoBean;

public interface ManageRepository {
	public Map<String, String[]> getUserInfo() throws Exception;

	public UserInfoBean getUserInfoByEmail(String email) throws Exception;

	public int insertUserInfo(UserInfoBean userinfo);

	public UserInfoBean getUserInfoById(int userId);

	public RoleInfoBean getRoleInfoByName(String name);

	public int insertRoleInfo(RoleInfoBean roleInfo);

	public List<UserInfoBean> getUserList();

	public List<RoleInfoBean> getRoleList();

	public List<RoleInfoBean> getRoleList(int userId);

	public List<ServiceInfoBean> getServiceList(int serviceId);

	public List<ServiceInfoBean> getServiceList();

	public int updateUserInfo(UserInfoBean item);

	public RoleInfoBean getRoleInfoById(int roleId);

	public int updateRoleInfo(RoleInfoBean item);

	public Map<String, Object> getloginInfoByAuth(Map<String, Object> params);

	public int insertSimpleUserInfo(String email);

	public int insertloginInfo(Map<String, Object> params);

	public Map<String, Object> getloginInfoByLoginName(Map<String, Object> params);

	public int updateLoginInfoState(Map<String, Object> params);

	public Map<String, Object> getloginInfoByUserId(Map<String, Object> params);

	public boolean checkVariCode(String loginName, String vairiCode);

	public void updateloginPass(String loginName, String newPass);

	public void insertVariCode(Map<String, Object> params);

	public void updateVariCodeState(Map<String, Object> params);

	public List<UserInfoBean> getUserList(List<Integer> userState);

	public Map<String, Object> checkManagerAuth(Map<String, Object> condition);

	public int updateUserStatus(Map<String, Object> item);

}
