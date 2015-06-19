package com.Club.Dao;

import com.Club.Model.Waitress;

public interface WaitressDao {
	public Waitress findWaitress(String account);
	public boolean addWaitress(Waitress waitress);
	public boolean deleteWaitress(String account);
	public boolean updateWaitress(Waitress waitress);
	
}
