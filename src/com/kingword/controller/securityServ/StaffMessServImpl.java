package com.kingword.controller.securityServ;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.kingword.entity.security.StaffMessage;
import com.kingword.repository.security.StaffMessRepos;

@Component("staffMessServImpl")
public class StaffMessServImpl implements StaffMessServ {
	@Resource(name = "staffMessRepos")
	private StaffMessRepos staffMessRepos;

	@Override
	public List<StaffMessage> findAllStaffMess() {
		// TODO Auto-generated method stub
		return staffMessRepos.findAllStaffMess();
	}

	@Override
	public StaffMessage savestaff(StaffMessage staffMessage) {
		// TODO Auto-generated method stub
		return staffMessRepos.save(staffMessage);
	}

	@Override
	public Iterable<StaffMessage> findAllStaffMessPage(Pageable pageable) {
		Page<StaffMessage> persons = staffMessRepos.findAll(pageable);
		Iterable<StaffMessage> staffMessages = persons;
		return staffMessages;
	}

	@Override
	public int getAllCount(int userStatus) {
		// TODO Auto-generated method stub
		return staffMessRepos.countCondition(userStatus);
	}

	@Override
	public StaffMessage findByStaffMassId(int staffMassId) {
		// TODO Auto-generated method stub
		return staffMessRepos.findByStaffMassId(staffMassId);
	}

	@Override
	public Iterable<StaffMessage> findAllStaffUpply(Pageable pageable) {
		// TODO Auto-generated method stub
		Page<StaffMessage> persons = staffMessRepos.findAllStaffUpply(pageable,
				1);
		Iterable<StaffMessage> staffMessages = persons;
		return staffMessages;
	}

	@Override
	public Iterable<StaffMessage> findAllStaff(Pageable pageable, int userStatus) {
		// TODO Auto-generated method stub
		Page<StaffMessage> persons = staffMessRepos.findAllStaffUpply(pageable,
				userStatus);
		Iterable<StaffMessage> staffMessages = persons;
		return staffMessages;
	}

	@Override
	public int getAllCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<StaffMessage> findByStaffMassIdPart(int[] findAllEmailConfigID) {
		// TODO Auto-generated method stub
		List<StaffMessage> list = new LinkedList<StaffMessage>();
		for (int staffMassId : findAllEmailConfigID) {
			list.add(staffMessRepos.findByStaffMassId(staffMassId));
		}
		return list;
	}

	@Override
	public void deletestaffid(Integer staffMassId) {
		// TODO Auto-generated method stub
		EntityManagerFactory emfactory = Persistence
				.createEntityManagerFactory("Security");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createQuery(
				"delete from StaffMessage item where item.staffMassId in(?1)")
				.setParameter(1, staffMassId);
		query.executeUpdate();
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

	@Override
	public StaffMessage getStaffByEmail(String staffEmail) {
		// TODO Auto-generated method stub
		return staffMessRepos.findStaffByEmail(staffEmail);
	}

}
