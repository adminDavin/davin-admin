package com.kingword.repository.email;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

 import com.kingword.entity.email.EmailSendTemplet;

public interface EmailSTempRepos  extends PagingAndSortingRepository<EmailSendTemplet, Long>{
	@Query("select rkd from EmailSendTemplet rkd")
	public List<EmailSendTemplet> findAllEmailSTemp();
}
