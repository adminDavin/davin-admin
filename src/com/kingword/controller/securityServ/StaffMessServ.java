package com.kingword.controller.securityServ;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.kingword.entity.security.StaffMessage;

public interface StaffMessServ {
	List<StaffMessage> findAllStaffMess();

	StaffMessage savestaff(StaffMessage staffMessage);

	Iterable<StaffMessage> findAllStaffMessPage(Pageable pageable);

	int getAllCount(int userStatus);

	StaffMessage findByStaffMassId(int staffMassId);

	Iterable<StaffMessage> findAllStaffUpply(Pageable pageable);

	Iterable<StaffMessage> findAllStaff(Pageable pageable, int userStatus);

	int getAllCount();

	List<StaffMessage> findByStaffMassIdPart(int[] findAllEmailConfigID);

	void deletestaffid(Integer staffMassId);

	StaffMessage getStaffByEmail(String staffEmail);

}
