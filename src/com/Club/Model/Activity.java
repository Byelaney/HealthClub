package com.Club.Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Activity implements Serializable{
	
	
	/*
	Activity a=new Activity();
	Date date=new Date();//ȡʱ��
	 Calendar calendar = new GregorianCalendar();
	 calendar.setTime(date);
	 calendar.add(calendar.DATE,1);//��������������һ��.����������,������ǰ�ƶ�
	 date=calendar.getTime(); //���ʱ���������������һ��Ľ�� 
	 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	 String dateString = formatter.format(date);
	 System.out.println(dateString);
	*/
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ActivityID;
	private String ground;
	private String coach;
	private Date date;
	private String time;
	
	public String DateToString(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(this.date);
		
		return dateString;
	}
	
	
	public Activity(){
		
	}
	
	
	
	public Activity(int activityID, String ground, String coach,
			 Date date, String time) {
		super();
		ActivityID = activityID;
		this.ground = ground;
		this.coach = coach;
		this.date = date;
		this.time = time;
	}


	public int getActivityID() {
		return ActivityID;
	}
	public void setActivityID(int activityID) {
		ActivityID = activityID;
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
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	
	
	
}
