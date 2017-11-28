package com.words.admin.manage.repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.words.admin.manage.bean.RoleInfoBean;
import com.words.admin.manage.bean.ServiceInfoBean;
import com.words.admin.manage.bean.UserInfoBean;

@Repository("manageRepository")
public class ManageRepositoryImpl implements ManageRepository {
	@Autowired(required = true)
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
}
