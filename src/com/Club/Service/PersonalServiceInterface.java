package com.Club.Service;

import java.util.ArrayList;

import com.Club.Model.PersonalMember;

public interface PersonalServiceInterface {
	public PersonalMember validate(String account,String password);
	public PersonalMember validateAccount(String account);
	public boolean addPersonalMember(PersonalMember personalMember);
	public boolean updatePersonalMember(PersonalMember personalMember);
	public ArrayList<PersonalMember> findAll();
}
