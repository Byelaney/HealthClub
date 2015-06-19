package com.Club.Dao;

import java.util.ArrayList;

import com.Club.Model.Activity;


public interface ActivityDao {
	
	public ArrayList<Activity> findUnDueActivity(String date);
	
	//查找所有未过期的且没参加过的活动,参数是日期
	public ArrayList<Activity> findUnDueActivity(String date,String account);
	//查找一个用户参与过的所有活动
	public ArrayList<Activity> findActivityByAccount(String account);
	
	public Activity findActivity(int activityId);
	
	public boolean addActivity(Activity activity);
	
	public boolean deleteActivity(int activityId);
	
	public boolean updateActivity(Activity activity);
	
	
	
}
