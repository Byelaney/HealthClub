package com.Club.Service;

import com.Club.Factory.DaoFactory;
import com.Club.Model.Waitress;

public class WaitressService implements WaitressServiceInterface{

	private static WaitressService waitressService=new WaitressService();
	
	private WaitressService(){}
	
	public static WaitressService getInstance(){
		return waitressService;
	}
	
	public Waitress validate(String account, String password) {
		Waitress waitress=DaoFactory.getWaitressDao().findWaitress(account);
		if(waitress!=null){
			if(password.equals(waitress.getPassword()))
				return waitress;
		}
		return null;
	}

}
