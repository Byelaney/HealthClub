package com.Club.Service;

import com.Club.Factory.DaoFactory;
import com.Club.Model.CoachUsePO;
import com.Club.Model.MemberInfoPO;
import com.Club.Model.MonthPO;

public class StatisticsService implements StatisticsServiceInterface{

	private static StatisticsService statisticsService=new StatisticsService();
	
	private StatisticsService(){
		
	}
	
	public static StatisticsService getStatisticsService(){
		return statisticsService;
	}
	
	public MonthPO findMonthPo() {
		return DaoFactory.getStatisticsDao().findMonthPO();
	}

	
	public CoachUsePO findCoachUsePO() {
		return DaoFactory.getStatisticsDao().findCoachPO();
	}

	
	public MemberInfoPO findMemberInfoPO() {
		return DaoFactory.getStatisticsDao().findMemberInfoPO();
	}

}
