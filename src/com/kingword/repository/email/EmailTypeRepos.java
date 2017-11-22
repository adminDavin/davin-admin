package com.kingword.repository.email;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.kingword.entity.email.EmailType;

public interface EmailTypeRepos  extends PagingAndSortingRepository<EmailType, Long>{
	@Query("select rkd from EmailType rkd")
	public List<EmailType> findAllEmailType();
}
