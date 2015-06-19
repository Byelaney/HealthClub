package com.Club.Service;

import java.util.ArrayList;

import com.Club.Factory.DaoFactory;
import com.Club.Model.HouseMember;


public class HouseService implements HouseMemberServiceInterface{

	private static HouseService houseService=new HouseService();
	
	private HouseService(){
		
	}
	
	public static HouseService getInstance(){
		return houseService;
	}
	
	
	public HouseMember validate(String account, String password) {
		HouseMember member=DaoFactory.getHouseMemberDao().findHouseMember(account);
		if(member!=null){
			if(member.getPassword().equals(password))
				return member;
		}
		return null;
	}

	
	public HouseMember validateAccount(String account) {
		HouseMember member=DaoFactory.getHouseMemberDao().findHouseMember(account);
		if(member!=null){
			return member;
		}
		return null;
	}

	public boolean addHouseMember(HouseMember houseMember){
		return DaoFactory.getHouseMemberDao().addHouseMember(houseMember);
	}

	
	public boolean updateHouseMember(HouseMember houseMember) {
		boolean isSucceed=DaoFactory.getHouseMemberDao().updateHouseMember(houseMember);
		return isSucceed;
	}

	
	public ArrayList<HouseMember> findAll() {
		return DaoFactory.getHouseMemberDao().findAll();
	}
}
