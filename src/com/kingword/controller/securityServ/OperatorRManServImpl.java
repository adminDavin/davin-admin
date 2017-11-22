package com.kingword.controller.securityServ;

 
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.kingword.entity.security.OperatorRoleManage;
import com.kingword.repository.security.OperatorRManRepos;

@Component("operatorRManServImpl")
public class OperatorRManServImpl implements OperatorRManServ{
	@Resource(name="operatorRManRepos")
    private OperatorRManRepos operatorRManRepos;
	

	@Override
	public int getAllCount(int userStatus) {
		return operatorRManRepos.getAllCount();
	}

	@Override
	public int getAllCount() {
		// TODO Auto-generated method stub
		return operatorRManRepos.getAllCount();
	}

	@Override
	public List<OperatorRoleManage> findAllOperatorRMan() {
		// TODO Auto-generated method stub
		return operatorRManRepos.getAll();
	}

	

}
