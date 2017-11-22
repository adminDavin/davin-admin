package com.kingword.repository.security;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.kingword.entity.security.OperatorMessage;
import com.kingword.entity.security.StaffMessage;

 
public interface OperatorMessRepos  extends PagingAndSortingRepository<OperatorMessage, Long>{
	@Query("select rkd from OperatorMessage rkd")
	public List<OperatorMessage> findAllOperatorMess();
	@Query("select count(rkd) from OperatorMessage rkd")
	public int getAllCount();
	@Query("select rkd from OperatorMessage rkd")
	public Page<OperatorMessage> findAllPage(Pageable pageable);

	@Query("select rkd from OperatorMessage rkd where operatorMessCode in ?1 and operatorMessPass in ?2")
	public OperatorMessage findlogin(String sUserName, String sPassword);
	@Query("select rkd from OperatorMessage rkd where staffMessage in ?1")
	public List<OperatorMessage> getOperatorbystaffid(StaffMessage staffMessage1);
	@Query("select rkd from OperatorMessage rkd where operatorMessCode in ?1 and operatorMessPass in ?2 and operatorMessState in ?3")
	public OperatorMessage findlogin(String sUserName, String sPassword, int i);
}
