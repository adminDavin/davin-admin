package com.kingword.controller.securityServ;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.kingword.entity.security.RoleAuthManage;
import com.kingword.repository.security.RoleAuthManRepos;

 
 @Component("roleAuthManServImpl")

public class RoleAuthManServImpl implements RoleAuthManServ{

	@Resource(name="roleAuthManRepos")
    private RoleAuthManRepos roleAuthManRepos;
	@Override
	public List<RoleAuthManage> findAllRoleAuthMan() {
		// TODO Auto-generated method stub
		return roleAuthManRepos.findAllRoleAuthMan();
	}

}
