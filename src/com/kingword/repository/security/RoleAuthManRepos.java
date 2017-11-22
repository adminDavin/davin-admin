package com.kingword.repository.security;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.kingword.entity.security.RoleAuthManage;

 
public interface RoleAuthManRepos  extends PagingAndSortingRepository<RoleAuthManage, Long>{
	@Query("select rkd from RoleAuthManage rkd")
	public List<RoleAuthManage> findAllRoleAuthMan();
}
