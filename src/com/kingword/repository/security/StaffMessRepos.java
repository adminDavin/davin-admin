package com.kingword.repository.security;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.kingword.entity.security.StaffMessage;

public interface StaffMessRepos extends
		PagingAndSortingRepository<StaffMessage, Long> {
	@Query("select rkd from StaffMessage rkd")
	public List<StaffMessage> findAllStaffMess();

	@Query("select rkd from StaffMessage rkd where staffMassId in ?1")
	public StaffMessage findByStaffMassId(int staffMassId);

	@Query("select rkd from StaffMessage rkd where staffState in ?1")
	public Page<StaffMessage> findAllStaffUpply(Pageable pageable, int state);

	@Query("select count(rkd) from StaffMessage rkd where staffState in ?1")
	public int countCondition(int userStatus);

	@Query("select rkd from StaffMessage rkd where staffState in (?1)")
	public StaffMessage[] findByStaffMassIdPart(int[] findAllEmailConfigID);

	@Query("select rkd from StaffMessage rkd where staffEmail in (?1)")
	public StaffMessage findStaffByEmail(String staffEmail);

}
