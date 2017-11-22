package com.kingword.controller.securityServ;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.kingword.entity.security.OperatorMessage;
import com.kingword.entity.security.StaffMessage;
import com.kingword.repository.security.OperatorMessRepos;

@Component("operatorMessServImpl")
public class OperatorMessServImpl implements OperatorMessServ {
	@Resource(name = "operatorMessRepos")
	private OperatorMessRepos operatorMessRepos;

	@Override
	public List<OperatorMessage> findAllOperatorMess() {
		// TODO Auto-generated method stub
		return operatorMessRepos.findAllOperatorMess();
	}

	@Override
	public OperatorMessage saveOperator(OperatorMessage operatorMessage) {
		// TODO Auto-generated method stub
		return operatorMessRepos.save(operatorMessage);
	}

	@Override
	public Iterable<OperatorMessage> findAllOperators(Pageable pageable) {
		// TODO Auto-generated method stub
		return operatorMessRepos.findAllPage(pageable);
	}

	@Override
	public int getAllCount() {
		// TODO Auto-generated method stub
		return operatorMessRepos.getAllCount();
	}

	@Override
	public OperatorMessage findlogin(String sUserName, String sPassword) {
		// TODO Auto-generated method stub
		return operatorMessRepos.findlogin(sUserName, sPassword);

	}

	@Override
	public List<OperatorMessage> getOperatorbystaffid(StaffMessage staffMessage1) {
		// TODO Auto-generated method stub
		return operatorMessRepos.getOperatorbystaffid(staffMessage1);
	}

	@Override
	public OperatorMessage findlogin(String sUserName, String sPassword, int i) {
		// TODO Auto-generated method stub
		return operatorMessRepos.findlogin(sUserName, sPassword, i);
	}

	@Override
	public String deleteOperbystaffId(StaffMessage staffMass) {
		// TODO Auto-generated method stub

		// EntityManagerFactory emfactor = Persistence
		// .createEntityManagerFactory("emailcfg");
		// EntityManager entitymanage = emfactor.createEntityManager();
		// entitymanage.getTransaction().begin();
		// Query query1 = entitymanage.createQuery(
		// "delete from EmailConfig rkd where emailCfgId in ?1")
		// .setParameter(1, staffMass.getStaffMassId());
		// query1.executeUpdate();
		// entitymanage.getTransaction().commit();
		// entitymanage.close();
		// emfactor.close();
		EntityManagerFactory emfactor = Persistence
				.createEntityManagerFactory("emailcfg");
		EntityManager entitymanage = emfactor.createEntityManager();
		Query query1 = entitymanage.createQuery(
				"select rkd from EmailConfig rkd where emailCfgId in ?1")
				.setParameter(1, staffMass.getStaffMassId());

		if (query1.getResultList().size() > 0) {
			return "del_Fail";
		}
		entitymanage.close();
		emfactor.close();
		EntityManagerFactory emfactory = Persistence
				.createEntityManagerFactory("Security");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager
				.createQuery(
						"delete from OperatorMessage item where item.staffMessage in(?1)")
				.setParameter(1, staffMass);
		query.executeUpdate();
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return "apply_del";
	}
}
