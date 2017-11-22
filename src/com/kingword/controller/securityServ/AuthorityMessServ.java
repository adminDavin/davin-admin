package com.kingword.controller.securityServ;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.kingword.entity.security.AuthorityMessage;
import com.kingword.entity.security.RoleMessage;

public interface AuthorityMessServ {
	List<AuthorityMessage> findAllAuthorityMess();

	Iterable<AuthorityMessage> findAllRole(Pageable pageable, int authListflag);

	Iterable<AuthorityMessage> findByRole(Iterable<RoleMessage> roleList1);

}
