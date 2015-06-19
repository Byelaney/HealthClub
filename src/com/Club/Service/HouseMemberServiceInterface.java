package com.Club.Service;

import java.util.ArrayList;

import com.Club.Model.HouseMember;

public interface HouseMemberServiceInterface {
	public HouseMember validate(String account,String password);
	public HouseMember validateAccount(String account);
	public boolean addHouseMember(HouseMember houseMember);
	public boolean updateHouseMember(HouseMember houseMember);
	public ArrayList<HouseMember> findAll();
}
