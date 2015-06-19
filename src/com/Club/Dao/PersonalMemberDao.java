package com.Club.Dao;

import java.util.ArrayList;

import com.Club.Model.PersonalMember;

public interface PersonalMemberDao {

public PersonalMember findPersonalMember(String account);
public boolean addPersonalMember(PersonalMember psersonalMember);	
public boolean deletePersonalMember(String account);
public boolean updatePersonalMember(PersonalMember personalMember);
public ArrayList<PersonalMember> findAll();

}
