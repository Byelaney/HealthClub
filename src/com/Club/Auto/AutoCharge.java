package com.Club.Auto;

import java.util.Calendar;
import java.util.TimerTask;

import com.Club.Factory.ServiceFactory;

public class AutoCharge extends TimerTask{

	
	public void run() {
		// TODO Auto-generated method stub
		
		Calendar c=Calendar.getInstance();
		int day=c.get(Calendar.DAY_OF_MONTH);
		
		//ֻ����ÿ�µ�һ��ſ�Ǯ
		if(day==1){
			ServiceFactory.getAutoChargeServiceInstance().charge();
		}
		
		
	}

}
