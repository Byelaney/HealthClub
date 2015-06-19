package com.Club.Dao;


import java.util.ArrayList;

import com.Club.Model.HouseMember;

public interface HouseMemberDao {
	public HouseMember findHouseMember(String account);
	public boolean addHouseMember(HouseMember houseMember);	
	public boolean deleteHouseMember(String account);
	public boolean updateHouseMember(HouseMember houseMember);
	public ArrayList<HouseMember> findAll();
}
