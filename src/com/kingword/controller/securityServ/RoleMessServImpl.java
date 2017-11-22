package com.kingword.controller.securityServ;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.kingword.entity.security.RoleMessage;
import com.kingword.repository.security.RoleMessRepos;

@Component("roleMessServImpl")
public class RoleMessServImpl implements RoleMessServ {
	@Resource(name = "roleMessRepos")
	private RoleMessRepos roleMessRepos;

	@Override
	public List<RoleMessage> findAllRoleMess() {
		// TODO Auto-generated method stub
		return roleMessRepos.findAllRoleMess();
	}

	@Override
	public Iterable<RoleMessage> findAllRole(Pageable pageable, int roleListflag) {
		// TODO Auto-generated method stub
		Page<RoleMessage> persons = roleMessRepos.findAllRole(pageable);
		Iterable<RoleMessage> persons1 = persons;
		return persons1;
	}

	@Override
	public Iterable<RoleMessage> findByRoleId(int roleId) {
		// TODO Auto-generated method stub
		return roleMessRepos.findByRoleId(roleId);
	}

}
