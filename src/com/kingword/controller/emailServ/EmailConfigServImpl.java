package com.kingword.controller.emailServ;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.kingword.entity.email.EmailConfig;
import com.kingword.entity.security.StaffMessage;
import com.kingword.entitycommon.ManegersForm;
import com.kingword.repository.email.EmailConfigRepos;

@Component("emailConfigServImpl")
public class EmailConfigServImpl implements EmailConfigServ {
	@Resource(name = "emailConfigRepos")
	private EmailConfigRepos emailConfigRepos;

	@Override
	public List<EmailConfig> findAllEmailConfigs() {
		System.out.println(new Date());
		return emailConfigRepos.findAllEmailConfig();
	}

	@Override
	public EmailConfig findById(Integer staffAcceptId) {
		// TODO Auto-generated method stub
		return emailConfigRepos.findById(staffAcceptId);
	}

	@Override
	public int[] findAllEmailConfigID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmailConfig> findAllEmailConfig(int i) {
		// TODO Auto-generated method stub
		return emailConfigRepos.findAllEmailConfig(i);
	}

	@Override
	public int getAllCount(int roleListflag) {
		// TODO Auto-generated method stub
		return emailConfigRepos.findAllCount();
	}

	@Override
	public Iterable<ManegersForm> findAllemailConfig(Pageable pageable,
			int roleListflag) {
		List<ManegersForm> list = new ArrayList<ManegersForm>();
		ManegersForm user;
		StaffMessage staffMessage;
		List<EmailConfig> all = emailConfigRepos.findAllemailConfig(pageable);
		EntityManagerFactory emfactory = Persistence
				.createEntityManagerFactory("Security");
		EntityManager entitymanager = emfactory.createEntityManager();
		Query query;
		for (EmailConfig role : all) {
			user = new ManegersForm();
			role.getEmailCfgId();
			query = entitymanager.createQuery(
					"select rkd from StaffMessage rkd where staffMassId in ?1")
					.setParameter(1, role.getEmailCfgId());
			List<?> a = query.getResultList();
			for (int i = 0; i < a.size(); i++) {
				staffMessage = (StaffMessage) a.get(i);
				user.setManegersPhone(staffMessage.getStaffName());
				user.setManegersPin(staffMessage.getStaffNamePin());
				user.setManegersEmail(staffMessage.getStaffEmail());
				user.setManegersPhone(staffMessage.getStaffPhone());
				user.setManegersZoneqq(staffMessage.getStaffZoneqq());
				user.setManegersAddress(staffMessage.getStaffAddress());
				user.setManegersState(staffMessage.getStaffState());
				user.setManegersRemark(staffMessage.getStaffRemark());
			}
			user.setManegersId(role.getEmailCfgId());
			user.setManegersMEmail(role.getEmailLoginName());
			user.setManegersMSeEmail(role.getEmailSendAddr());
			user.setManegersMState(role.getEamailSendState());
			user.setManegersType(role.getEmailCfgType());
			System.out.println(user.toString());
			list.add(user);
		}
		entitymanager.close();
		emfactory.close();
		return list;
	}
}
