package com.cognizant.service;

import com.cognizant.model.ManagerModel;

public interface ManagerService {

	public void managerRegister(ManagerModel model);

	public boolean checkCredentilas(ManagerModel model);
	
}
