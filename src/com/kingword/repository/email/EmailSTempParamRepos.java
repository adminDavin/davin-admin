package com.kingword.repository.email;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

 import com.kingword.entity.email.EmailSendTempletParam;

public interface EmailSTempParamRepos  extends PagingAndSortingRepository<EmailSendTempletParam, Long>{
	@Query("select rkd from EmailSendTempletParam rkd")
	public List<EmailSendTempletParam> findAllEmailSTempParam();
}
