package com.kingword.repository.security;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.kingword.entity.security.AuthorityMessage;
import com.kingword.entity.security.RoleAuthManage;

public interface AuthorityMessRepos extends
		PagingAndSortingRepository<AuthorityMessage, Long> {
	@Query("select rkd from AuthorityMessage rkd")
	public List<AuthorityMessage> findAllAuthorityMess();

	@Query("select rkd from AuthorityMessage rkd ")
	public Page<AuthorityMessage> findAllAuth(Pageable pageable);

	@Query("select rkd from AuthorityMessage rkd where rkd.roleAuthManages in ?1")
	public Iterable<AuthorityMessage> findByRole(Set<RoleAuthManage> roleList1);

}
