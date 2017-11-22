package com.kingword.repository.security;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.kingword.entity.security.RoleMessage;

public interface RoleMessRepos extends
		PagingAndSortingRepository<RoleMessage, Long> {
	@Query("select rkd from RoleMessage rkd")
	public List<RoleMessage> findAllRoleMess();

	@Query("select rkd from RoleMessage rkd ")
	public Page<RoleMessage> findAllRole(Pageable pageable);

	@Query("select rkd from RoleMessage rkd where roleMessId in ?1")
	public Iterable<RoleMessage> findByRoleId(int roleId);
}
