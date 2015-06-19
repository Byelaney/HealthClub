package com.Club.Model;

import java.io.Serializable;
import java.util.Date;

public class JoinedRecord implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int activityID;
	private String account;
	private String ground;
	private String coach;
	private Date activityDate;
	private String time;
	private String requestTime;
	
	public JoinedRecord(){
		
	}

	
	
	







	public JoinedRecord(int activityID, String account, String ground,
			String coach, Date activityDate, String time, String requestTime) {
		super();
		this.activityID = activityID;
		this.account = account;
		this.ground = ground;
		this.coach = coach;
		this.activityDate = activityDate;
		this.time = time;
		this.requestTime = requestTime;
	}











	public String getAccount() {
		return account;
	}











	public void setAccount(String account) {
		this.account = account;
	}











	public int getActivityID() {
		return activityID;
	}







	public void setActivityID(int activityID) {
		this.activityID = activityID;
	}







	public String getGround() {
		return ground;
	}

	public void setGround(String ground) {
		this.ground = ground;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public Date getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}
	
	
	
}
