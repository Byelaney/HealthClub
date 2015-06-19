package com.Club.Model;

import java.io.Serializable;

public class Participate implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String account;
	private int activityId;
	private String time;
	
	public Participate(){}

	public Participate(String account, int activityId, String time) {
		super();
		this.account = account;
		this.activityId = activityId;
		this.time = time;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
	
}
