package com.words.admin.manage.repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.words.admin.config.Constant;
import com.words.admin.manage.bean.RoleInfoBean;
import com.words.admin.manage.bean.ServiceInfoBean;
import com.words.admin.manage.bean.UserInfoBean;

@Repository("manageRepository")
public class ManageRepositoryImpl implements ManageRepository {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public Map<String, String[]> getUserInfo() throws Exception {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectOne("manage.getAppName");
		}
	}

	public UserInfoBean getUserInfoByEmail(String email) throws Exception {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectOne("manage.getUserinfoByEmail", email);
		}
	}

	@Override
	public int insertUserInfo(UserInfoBean userinfo) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			int userid = sqlSession.insert("manage.insertUserInfo", userinfo);
			sqlSession.commit();
			return userid;
		}
	}

	@Override
	public UserInfoBean getUserInfoById(int userId) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectOne("manage.getUserinfoById", userId);
		}
	}

	@Override
	public RoleInfoBean getRoleInfoByName(String name) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectOne("manage.getRoleinfoByName", name);
		}
	}

	@Override
	public int insertRoleInfo(RoleInfoBean roleInfo) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			int roleId = sqlSession.insert("manage.insertRoleInfo", roleInfo);
			sqlSession.commit();
			return roleId;
		}
	}

	@Override
	public List<UserInfoBean> getUserList() {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectList("manage.getUserinfoList");
		}
	}

	@Override
	public List<RoleInfoBean> getRoleList() {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectList("manage.getRoleinfoList");
		}
	}

	@Override
	public List<RoleInfoBean> getRoleList(int userId) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectList("manage.getRoleinfoListByUserId", userId);
		}
	}

	@Override
	public List<ServiceInfoBean> getServiceList(int serviceId) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectList("manage.getServiceListByServiceId", serviceId);
		}
	}

	@Override
	public List<ServiceInfoBean> getServiceList() {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectList("manage.getServiceListAll");
		}
	}

	@Override
	public int updateUserInfo(UserInfoBean item) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			int result = sqlSession.update("manage.updateUserInfo", item);
			sqlSession.commit();
			return result;
		}
	}

	@Override
	public RoleInfoBean getRoleInfoById(int roleId) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectOne("manage.getRoleInfoById", roleId);
		}
	}

	@Override
	public int updateRoleInfo(RoleInfoBean item) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			item.setModifyDate(new Timestamp(System.currentTimeMillis()));
			int result = sqlSession.update("manage.updateRoleInfo", item);
			sqlSession.commit();
			return result;
		}

	}

	@Override
	public Map<String, Object> getloginInfoByAuth(Map<String, Object> params) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectOne("manage.getloginInfoByAuth", params);
		}
	}

	@Override
	public Map<String, Object> getloginInfoByLoginName(Map<String, Object> params) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectOne("manage.getloginInfoByLoginName", params);
		}
	}

	@Override
	public int insertSimpleUserInfo(String email) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			UserInfoBean user = new UserInfoBean();
			user.setEmail(email);
			sqlSession.insert("manage.insertSimpleUserInfo", user);
			sqlSession.commit();
			return user.getUserId();
		}
	}

	@Override
	public int insertloginInfo(Map<String, Object> params) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			int userid = sqlSession.insert("manage.insertloginInfo", params);
			sqlSession.commit();
			return userid;
		}
	}

	@Override
	public int updateLoginInfoState(Map<String, Object> params) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			int result = sqlSession.update("manage.updateLoginInfoState", params);
			sqlSession.commit();
			return result;
		}
	}

	@Override
	public Map<String, Object> getloginInfoByUserId(Map<String, Object> params) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectOne("manage.getloginInfoByUserId", params);
		}
	}

	@Override
	public boolean checkVariCode(String loginName, String vairiCode) {
		Map<String, Object> params = new ConcurrentHashMap<String, Object>(3);
		params.put(Constant.LOGINNAME, loginName);
		params.put("vairiCode", vairiCode);
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			Map<String, Object> vari = sqlSession.selectOne("manage.getloginInfoByUserId", params);
			if (vari == null) {
				return false;
			} else {
				sqlSession.update("manage.updateVariCode", params);
				sqlSession.commit();
				return true;
			}
		}
	}

	@Override
	public void updateloginPass(String loginName, String newPass) {
		Map<String, Object> params = new ConcurrentHashMap<String, Object>(3);
		params.put(Constant.LOGINNAME, loginName);
		params.put(Constant.PASSWORD, newPass);
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			sqlSession.update("manage.updateLoginPass", params);
			sqlSession.commit();
		}

	}

	@Override
	public void insertVariCode(Map<String, Object> params) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			sqlSession.insert("manage.insertVariCode", params);
			sqlSession.commit();
		}
	}

	@Override
	public void updateVariCodeState(Map<String, Object> params) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			sqlSession.insert("manage.updateVariCodeState", params);
			sqlSession.commit();
		}
	}

	@Override
	public List<UserInfoBean> getUserList(List<Integer> userState) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectList("manage.getUserinfoList", userState);
		}
	}

	@Override
	public Map<String, Object> checkManagerAuth(Map<String, Object> condition) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectOne("manage.checkManagerAuth", condition);
		}
	}

	@Override
	public int updateUserStatus(Map<String, Object> item) {

		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			int result = sqlSession.update("manage.updateUserStatus", item);
			sqlSession.commit();
			return result;
		}
	}

	@Override
	public int deleteData(List<Map<String, Object>> datas, String table) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			int result = sqlSession.delete("manage.delete" + table, datas);
			sqlSession.commit();
			return result;
		}

	}

	@Override
	public int insertData(List<Map<String, Object>> datas, String table) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			int userid = sqlSession.insert("manage.insert" + table, datas);
			sqlSession.commit();
			return userid;
		}
	}

	@Override
	public List<RoleInfoBean> getRoleInfoBeanDatas(Map<String, Object> item, String table) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectList("manage.get" + table, item);
		}

	}

	@Override
	public int deleteDataByMap(Map<String, Object> item, String table) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			int result = sqlSession.delete("manage.delete" + table, item);
			sqlSession.commit();
			return result;
		}

	}

	@Override
	public List<ServiceInfoBean> getServiceListByRole(int roleId) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectList("manage.getServiceListByRole", roleId);
		}
	}

}
