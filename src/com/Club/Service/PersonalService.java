package com.Club.Service;

import java.util.ArrayList;

import com.Club.Factory.DaoFactory;
import com.Club.Model.PersonalMember;

public class PersonalService implements PersonalServiceInterface{
	private static PersonalService personalService=new PersonalService();
	
	private PersonalService(){
		
	}	
	
	public static PersonalService getInstance(){
		return personalService;
	}
	
	
	
	public PersonalMember validate(String account, String password) {
		PersonalMember member=DaoFactory.getPersonalMemberDao().findPersonalMember(account);
		if(member!=null){
			if(password.equals(member.getPassword()))
				return member;
		}
		return null;
	}

	
	public PersonalMember validateAccount(String account) {
		PersonalMember member=DaoFactory.getPersonalMemberDao().findPersonalMember(account);
		if(member!=null){
			return member;
		}
		
		return null;
	}

	
	public boolean addPersonalMember(PersonalMember personalMember) {
		boolean isSucceed=DaoFactory.getPersonalMemberDao().addPersonalMember(personalMember);
		
		return isSucceed;
	}

	
	public boolean updatePersonalMember(PersonalMember personalMember) {
		boolean isSucceed=DaoFactory.getPersonalMemberDao().updatePersonalMember(personalMember);
	
		return isSucceed;
	}

	
	public ArrayList<PersonalMember> findAll() {
		return DaoFactory.getPersonalMemberDao().findAll();
	}

}
