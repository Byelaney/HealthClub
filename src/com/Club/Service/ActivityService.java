package com.Club.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.Club.Factory.DaoFactory;
import com.Club.Model.Activity;

public class ActivityService implements ActivityServiceInterface{

	private static ActivityService activityService=new ActivityService();
	
	private ActivityService(){}
	
	public static ActivityService getInstance(){
		return activityService;
	}
	
	@SuppressWarnings("static-access")
	public ArrayList<Activity> getUnDueActivity(String account) {
		//今天的日期
				Date date=new Date();//取时间
				 Calendar calendar = new GregorianCalendar();
				 calendar.setTime(date);
				 calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
				 date=calendar.getTime(); //这个时间就是日期往后推一天的结果 
				 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				 String dateString = formatter.format(date);
				
				 
				 ArrayList<Activity> activity=DaoFactory.getActivityDao().findUnDueActivity(dateString,account);	 
				  
				 return activity;
	}

	
	@SuppressWarnings("static-access")
	public ArrayList<Activity> getUnDueActivity() {
		//今天的日期
		Date date=new Date();//取时间
		 Calendar calendar = new GregorianCalendar();
		 calendar.setTime(date);
		 calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
		 date=calendar.getTime(); //这个时间就是日期往后推一天的结果 
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 String dateString = formatter.format(date);
		 
		 ArrayList<Activity> activity=DaoFactory.getActivityDao().findUnDueActivity(dateString);	 
		  
		 return activity;
	}

	
	public boolean addActivity(Activity activity) {
		return DaoFactory.getActivityDao().addActivity(activity);
	}

}
