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
		//���������
				Date date=new Date();//ȡʱ��
				 Calendar calendar = new GregorianCalendar();
				 calendar.setTime(date);
				 calendar.add(calendar.DATE,1);//��������������һ��.����������,������ǰ�ƶ�
				 date=calendar.getTime(); //���ʱ���������������һ��Ľ�� 
				 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				 String dateString = formatter.format(date);
				
				 
				 ArrayList<Activity> activity=DaoFactory.getActivityDao().findUnDueActivity(dateString,account);	 
				  
				 return activity;
	}

	
	@SuppressWarnings("static-access")
	public ArrayList<Activity> getUnDueActivity() {
		//���������
		Date date=new Date();//ȡʱ��
		 Calendar calendar = new GregorianCalendar();
		 calendar.setTime(date);
		 calendar.add(calendar.DATE,1);//��������������һ��.����������,������ǰ�ƶ�
		 date=calendar.getTime(); //���ʱ���������������һ��Ľ�� 
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 String dateString = formatter.format(date);
		 
		 ArrayList<Activity> activity=DaoFactory.getActivityDao().findUnDueActivity(dateString);	 
		  
		 return activity;
	}

	
	public boolean addActivity(Activity activity) {
		return DaoFactory.getActivityDao().addActivity(activity);
	}

}
