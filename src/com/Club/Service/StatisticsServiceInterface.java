package com.Club.Service;

import com.Club.Model.CoachUsePO;
import com.Club.Model.MemberInfoPO;
import com.Club.Model.MonthPO;

public interface StatisticsServiceInterface {
	public MonthPO findMonthPo();
	public CoachUsePO findCoachUsePO();
	public MemberInfoPO findMemberInfoPO();
}
