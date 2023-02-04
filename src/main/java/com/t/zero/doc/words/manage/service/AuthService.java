package com.t.zero.doc.words.manage.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t.zero.doc.words.config.Constant;
import com.t.zero.doc.words.dao.auto.LogininfoMapper;
import com.t.zero.doc.words.dao.auto.UserinfoMapper;
import com.t.zero.doc.words.dao.auto.VaricodeMapper;
import com.t.zero.doc.words.model.auto.Logininfo;
import com.t.zero.doc.words.model.auto.LogininfoExample;
import com.t.zero.doc.words.model.auto.Userinfo;
import com.t.zero.doc.words.model.auto.UserinfoExample;
import com.t.zero.doc.words.model.auto.Varicode;
import com.t.zero.doc.words.model.auto.VaricodeExample;
import com.t.zero.doc.words.response.RespUtils;

@Service
public class AuthService {

	@Autowired
	private LogininfoMapper logininfoMapper;
	@Autowired
	private UserinfoMapper userinfoMapper;
	@Autowired
	private VaricodeMapper varicodeMapper;

	@Autowired
	private NotifyEmailService notifyEmailService;

	public Logininfo getloginInfoByAuth(HttpServletResponse response, String loginName, String password,
			int userState) {
		Map<String, Object> params = new ConcurrentHashMap<String, Object>(3);
		params.put("loginName", loginName);
		params.put(Constant.PASSWORD, password);
		var e = new LogininfoExample();
		e.createCriteria().andLoginnameEqualTo(loginName);
		var logininfos = logininfoMapper.selectByExample(e);
		if (CollectionUtils.isEmpty(logininfos)) {
			RespUtils.responseJsonFailed(response, "not register or password is error!");
			return null;
		}
		var user = logininfos.stream().sorted(Comparator.comparing(Logininfo::getLoginid).reversed()).findFirst().get();
		if (!user.getPassword().equals(password)) {
			RespUtils.responseJsonFailed(response, "password is inconrect!");
			return null;
		}

		if (userState == 5) {
			if (!user.getState().equals(5)) {
				RespUtils.responseJsonFailed(response, "permission isn't enought!");
				return null;
			}
		}
		return user;
	}

	public String addLoginInfo(HttpServletResponse response, String loginName, String password) {
		var e = new UserinfoExample();
		e.createCriteria().andEmailEqualTo(loginName);
		var userinfos = userinfoMapper.selectByExample(e);
		if (CollectionUtils.isNotEmpty(userinfos)) {
			RespUtils.responseJsonFailed(response, "user is register failed for insert database!");
			return "user is register failed for insert database!";
		}

		var user = new Userinfo();
		user.setEmail(loginName);
		user.setState(0);
		user.setApplydate(LocalDateTime.now());
		userinfoMapper.insertSelective(user);

		var login = new LogininfoExample();
		login.createCriteria().andLoginnameEqualTo(loginName);
		logininfoMapper.deleteByExample(login);
		var l = new Logininfo();
		l.setLoginname(loginName);
		l.setPassword(password);
		l.setUserid(user.getUserid());
		l.setState(0);
		l.setCreatedate(LocalDateTime.now());
		l.setUpdatedate(LocalDateTime.now());
		logininfoMapper.insertSelective(l);
		return String.valueOf(user.getUserid());
	}

	public Userinfo selectUserInfoById(HttpServletResponse response, int userId) {
		return userinfoMapper.selectByPrimaryKey(userId);
	}

	public Userinfo updateUserInfo(HttpServletResponse response, Userinfo userinfo) {
		userinfoMapper.updateByPrimaryKeySelective(userinfo);
		return userinfo;
	}

	public Userinfo getLogininfoByName(HttpServletResponse response, String loginName) {
		var e = new UserinfoExample();
		e.createCriteria().andEmailEqualTo(loginName);
		var userinfos = userinfoMapper.selectByExample(e);
		if (CollectionUtils.isEmpty(userinfos)) {
			RespUtils.responseJsonFailed(response, "user is register failed for insert database!");
			return null;
		}
		return userinfos.stream().sorted(Comparator.comparing(Userinfo::getUserid).reversed()).findFirst().get();
	}

	public boolean insertVariCode(HttpServletResponse response, String loginName, String variCode) {
		var e = new VaricodeExample();
		e.createCriteria().andLoginnameEqualTo(loginName);
		varicodeMapper.deleteByExample(e);
		var v = new Varicode();
		v.setCreatedata(LocalDateTime.now());
		v.setLoginname(loginName);
		v.setState(1);
		v.setUpdatedate(LocalDateTime.now());
		v.setVaricode(variCode);
		varicodeMapper.insert(v);
		return true;
	}

	public String updateloginPass(HttpServletResponse response, String loginName, String newPass, String vairiCode) {
		var e = new VaricodeExample();
		e.createCriteria().andLoginnameEqualTo(loginName).andVaricodeEqualTo(vairiCode);
		var v = varicodeMapper.selectByExample(e);
		if (CollectionUtils.isEmpty(v)) {
			RespUtils.responseJsonFailed(response, "check message faild, password modify failed!");
			return null;
		}
		notifyEmailService.remindUserForModifyPassword(loginName, newPass);
		var lmapper = new LogininfoExample();
		lmapper.createCriteria().andLoginnameEqualTo(loginName);
		var item = new Logininfo();
		item.setPassword(newPass);
		logininfoMapper.updateByExampleSelective(item, lmapper);
		return loginName;
	}

}
