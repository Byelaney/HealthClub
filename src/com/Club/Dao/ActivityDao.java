package com.Club.Dao;

import java.util.ArrayList;

import com.Club.Model.Activity;


public interface ActivityDao {
	
	public ArrayList<Activity> findUnDueActivity(String date);
	
	//��������δ���ڵ���û�μӹ��Ļ,����������
	public ArrayList<Activity> findUnDueActivity(String date,String account);
	//����һ���û�����������л
	public ArrayList<Activity> findActivityByAccount(String account);
	
	public Activity findActivity(int activityId);
	
	public boolean addActivity(Activity activity);
	
	public boolean deleteActivity(int activityId);
	
	public boolean updateActivity(Activity activity);
	
	
	
}
