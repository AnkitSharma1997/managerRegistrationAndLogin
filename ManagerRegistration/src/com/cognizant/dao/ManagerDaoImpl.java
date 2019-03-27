package com.cognizant.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cognizant.entity.Manager;
import com.cognizant.model.ManagerModel;

@Repository("ManagerDaoImpl")
public class ManagerDaoImpl implements ManagerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void managerRegister(Manager manager){
		
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.persist(manager);
		
		tx.commit();
		
	}


	@Override
	public boolean managerCredentials(ManagerModel model) {
		Session session = sessionFactory.openSession();
		Manager manager;
	String manager_id = model.getManager_id();
         manager=(Manager)session.get(Manager.class,manager_id);
        System.out.println("heyyyy    "+manager);
		//tx.commit();
		if(manager !=null)
			return true;		
		return false;
	}
}
