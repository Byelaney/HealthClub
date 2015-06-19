package com.Club.Dao;

import com.Club.Model.CoachUsePO;
import com.Club.Model.MemberInfoPO;
import com.Club.Model.MonthPO;

public interface StatisticsDao {
	public MonthPO findMonthPO();
	public CoachUsePO findCoachPO();
	public MemberInfoPO findMemberInfoPO();
}
