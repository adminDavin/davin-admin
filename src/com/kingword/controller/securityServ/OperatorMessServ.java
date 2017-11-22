package com.kingword.controller.securityServ;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.kingword.entity.security.OperatorMessage;
import com.kingword.entity.security.StaffMessage;

public interface OperatorMessServ {
	List<OperatorMessage> findAllOperatorMess();

	OperatorMessage saveOperator(OperatorMessage operatorMessage);

	Iterable<OperatorMessage> findAllOperators(Pageable pageable);

	int getAllCount();

	OperatorMessage findlogin(String sUserName, String sPassword);

	List<OperatorMessage> getOperatorbystaffid(StaffMessage staffMessage1);

	OperatorMessage findlogin(String sUserName, String sPassword, int i);

	String deleteOperbystaffId(StaffMessage staffMessage1);

}
