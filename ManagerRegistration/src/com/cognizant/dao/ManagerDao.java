package com.cognizant.dao;

import com.cognizant.entity.Manager;
import com.cognizant.model.ManagerModel;

public interface ManagerDao {

	public void managerRegister(Manager manager);
	
	public boolean managerCredentials(ManagerModel model);
}
