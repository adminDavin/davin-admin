package com.kingword.controller.securityServ;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.kingword.entity.security.RoleMessage;

public interface RoleMessServ {
	List<RoleMessage> findAllRoleMess();

	Iterable<RoleMessage> findAllRole(Pageable pageable, int roleListflag);

	Iterable<RoleMessage> findByRoleId(int roleId);

}
