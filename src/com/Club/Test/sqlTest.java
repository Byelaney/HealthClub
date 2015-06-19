package com.Club.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.Club.Dao.PersonalMemberDao;
import com.Club.Dao.Impl.PersonalMemberDaoImpl;
import com.Club.Factory.DaoFactory;
import com.Club.Model.Activity;
import com.Club.Model.PersonalMember;
public class sqlTest {

	public static void main(String []args) throws ParseException{
		
		
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式

		Date aa=new Date("yyyy-MM-dd");
		
		Date asss=dateFormat.parse("2014-02-02");
		String hehe = dateFormat.format( now ); 
		System.out.println(aa); 
	
		/*
		String time="2014/02/02 21:52:15";
		String []aa=time.split("/");
		
		int i=Integer.parseInt(aa[1]);
		System.out.println(i);
		*/
	}
	
	
public static ArrayList<Activity> diffActivity(ArrayList<Activity> activity,String []ids){
		
		for(int i=0;i<ids.length;i++){
			int id=Integer.parseInt(ids[i]);
			
			for(int j=0;j<activity.size();j++){
				if(id==activity.get(j).getActivityID()){
					activity.remove(j);
				}
				
			}
		}
		
		
		return activity;
	}
}
