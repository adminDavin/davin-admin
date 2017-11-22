package com.kingword.controller.securityServ;

import java.util.List;

import com.kingword.entity.security.OperatorRoleManage;

public interface OperatorRManServ {

	int getAllCount(int userStatus);

	int getAllCount();

	List<OperatorRoleManage> findAllOperatorRMan();


}
