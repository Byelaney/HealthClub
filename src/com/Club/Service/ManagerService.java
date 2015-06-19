package com.Club.Service;

import com.Club.Factory.DaoFactory;
import com.Club.Model.ClubManager;

public class ManagerService implements ManagerServiceInterface{

	private static ManagerService managerService=new ManagerService();
	
	private ManagerService(){}
	
	public static ManagerService getInstance(){
		return managerService;
	}
	
	public ClubManager validate(String account, String password) {
		ClubManager manager=DaoFactory.getClubManagerDao().findManager(account);
		if(manager!=null){
			if(password.equals(manager.getPassword()))
				return manager;
		}
		return null;
	}

}
