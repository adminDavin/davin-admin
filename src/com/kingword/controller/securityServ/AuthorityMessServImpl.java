package com.kingword.controller.securityServ;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.kingword.entity.security.AuthorityMessage;
import com.kingword.entity.security.RoleAuthManage;
import com.kingword.entity.security.RoleMessage;
import com.kingword.repository.security.AuthorityMessRepos;

@Component("authorityMessServImpl")
public class AuthorityMessServImpl implements AuthorityMessServ {
	@Resource(name = "authorityMessRepos")
	private AuthorityMessRepos authorityMessRepos;

	@Override
	public List<AuthorityMessage> findAllAuthorityMess() {
		return authorityMessRepos.findAllAuthorityMess();
	}

	@Override
	public Iterable<AuthorityMessage> findAllRole(Pageable pageable,
			int authListflag) {
		// TODO Auto-generated method stub
		Page<AuthorityMessage> persons = authorityMessRepos
				.findAllAuth(pageable);
		Iterable<AuthorityMessage> persons1 = persons;
		return persons1;
	}

	@Override
	public Iterable<AuthorityMessage> findByRole(Iterable<RoleMessage> roleList1) {
		// TODO Auto-generated method stub
		for (RoleMessage auth1 : roleList1) {
			List<AuthorityMessage> authall = new ArrayList<AuthorityMessage>();
			RoleAuthManage auth12 = new RoleAuthManage();
			EntityManagerFactory emfactory = Persistence
					.createEntityManagerFactory("Security");
			EntityManager entitymanager = emfactory.createEntityManager();

			Query query = entitymanager
					.createQuery(
							"select item from RoleAuthManage item where item.roleMessage in (?1)")
					.setParameter(1, auth1);
			List<?> a = query.getResultList();
			for (int i = 0; i < a.size(); i++) {
				auth12 = (RoleAuthManage) a.get(i);
				authall.add(auth12.getAuthorityMessage());
			}
			entitymanager.close();
			emfactory.close();
			return authall;

		}
		return null;
	}
}
