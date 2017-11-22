package com.kingword.common.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import com.kingword.entity.email.EmailConfig;

public class SecurityUtil {
	public static String ManagerConfirm(HttpSession session, Integer staffMassId) {
		String returnString;
		EntityManagerFactory emailfactory = Persistence
				.createEntityManagerFactory("emailcfg");
		EntityManager entitymanager = emailfactory.createEntityManager();
		Query query = entitymanager.createQuery(
				"select rkd from EmailConfig rkd where emailCfgId in ?1")
				.setParameter(1, staffMassId);
		List<?> a = query.getResultList();
		entitymanager.close();
		emailfactory.close();
		if (a.size() == 0) {
			returnString = "notManagers";
		} else {
			EmailConfig emailConfig = (EmailConfig) a.get(0);
			session.setAttribute("managerType", emailConfig.getEmailCfgType());
			System.out.println(emailConfig.getEmailCfgType());
			returnString = "managers";
		}

		return returnString;

	}
}
