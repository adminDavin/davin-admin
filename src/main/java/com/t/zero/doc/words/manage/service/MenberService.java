package com.t.zero.doc.words.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t.zero.basic.common.base.page.Page;
import com.t.zero.doc.words.dao.auto.LogininfoMapper;
import com.t.zero.doc.words.dao.auto.UserinfoMapper;
import com.t.zero.doc.words.dao.manu.ManuUserinfoMapper;
import com.t.zero.doc.words.dao.manu.UserinfoFilters;
import com.t.zero.doc.words.model.auto.Logininfo;
import com.t.zero.doc.words.model.auto.LogininfoExample;
import com.t.zero.doc.words.model.auto.Userinfo;

@Service
public class MenberService {

	@Autowired
	private ManuUserinfoMapper manuUserinfoMapper;

	@Autowired
	private LogininfoMapper logininfoMapper;
	@Autowired
	private UserinfoMapper userinfoMapper;
	
	@Autowired
	private NotifyEmailService notifyEmailService;

	public Page<Userinfo> list(UserinfoFilters i) {
		Page<Userinfo> page = Page.build(i.getCurrentPage(), i.getPageSize());
		page.setList(manuUserinfoMapper.selectListWithPageByFilter(i, page.getOffset(), page.getPageSize()));
		page.setTotalCount(manuUserinfoMapper.selectCountWithPageByFilter(i));
		return page;
	}


	public void updateUserStatus(Userinfo userinfo) {
		var l = new Logininfo();
		l.setState(userinfo.getState());
		var e = new LogininfoExample();
		e.createCriteria().andUseridEqualTo(userinfo.getUserid());
		logininfoMapper.updateByExampleSelective(l, e);
		userinfoMapper.updateByPrimaryKeySelective(userinfo);
//		notifyEmailService.remindUserApplyResult(userinfo.getEmail(), userinfo.getState());
	}


	public void deleteUser(Userinfo userinfo) {
		var e = new LogininfoExample();
		e.createCriteria().andUseridEqualTo(userinfo.getUserid());
		logininfoMapper.deleteByExample(e);
		userinfoMapper.deleteByPrimaryKey(userinfo.getUserid());
		
	}


}
