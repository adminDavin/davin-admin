package com.kingword.repository.email;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.kingword.entity.email.EmailConfig;

public interface EmailConfigRepos extends
		PagingAndSortingRepository<EmailConfig, Long> {
	@Query("select rkd from EmailConfig rkd")
	public List<EmailConfig> findAllEmailConfig();

	@Query("select rkd from EmailConfig rkd where emailCfgId in ?1")
	public EmailConfig findById(Integer staffAcceptId);

	@Query("select rkd from EmailConfig rkd where emailCfgType in ?1")
	public List<EmailConfig> findAllEmailConfig(int i);

	@Query("select count(rkd) from EmailConfig rkd")
	public int findAllCount();

	@Query("select  rkd  from EmailConfig rkd")
	public List<EmailConfig> findAllemailConfig(Pageable pageable);
}
