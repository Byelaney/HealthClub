package com.Club.Dao;

import com.Club.Model.ClubManager;

public interface ClubManagerDao {
	public ClubManager findManager(String account);

	public boolean addClubManager(ClubManager clubManager);

	public boolean deleteClubManager(String account);

	public boolean updateClubManager(ClubManager clubManager);
}
