package com.Club.Model;

import java.io.Serializable;

public class ClubManager implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String account;
	private String password;
	
	public ClubManager(){
		
	}

	
	public ClubManager(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}


	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
