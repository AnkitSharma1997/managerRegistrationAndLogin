package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cognizant.entity.Manager;
import com.cognizant.model.ManagerModel;
import com.cognizant.service.ManagerService;


@Controller
public class ManagerController {

	@Autowired //@Qualifier("AddManagerDetailsServiceImpl")
	ManagerService managerService;
	
	@RequestMapping("/")
	public String display(){
		return "index";
	}
	
	@RequestMapping("managerReg.html")
	public String viewRegistrationPage(@ModelAttribute("model") ManagerModel model){
		System.out.println(model);
		managerService.managerRegister(model);
		return "index";
	}
	
	@RequestMapping("managerView")
	public String viewManager(@ModelAttribute("model") ManagerModel model){
		if(managerService.checkCredentilas(model))
			return "managerView";
		return "index";
	}
	
	@RequestMapping("managerReg")
	public String viewManagerReg(){
		return "managerRegistration";
	}

	@ModelAttribute("model")
	public ManagerModel managerObject(){
		ManagerModel  model = new ManagerModel();
		return model;
	}
	
}
