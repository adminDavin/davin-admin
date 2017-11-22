package com.kingword.repository.security;





import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.kingword.entity.security.OperatorRoleManage;

 
public interface OperatorRManRepos  extends PagingAndSortingRepository<OperatorRoleManage, Long>{

	@Query("select count(rkd) from OperatorRoleManage rkd")
	public int getAllCount();
	@Query("select rkd from OperatorRoleManage rkd")
	public List<OperatorRoleManage> getAll();
}
