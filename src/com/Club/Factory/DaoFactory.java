package com.Club.Factory;

import com.Club.Dao.ActivityDao;
import com.Club.Dao.BankCardDao;
import com.Club.Dao.ClubManagerDao;
import com.Club.Dao.HouseMemberDao;
import com.Club.Dao.ParticipateDao;
import com.Club.Dao.PayRecordDao;
import com.Club.Dao.PersonalMemberDao;
import com.Club.Dao.StatisticsDao;
import com.Club.Dao.WaitressDao;
import com.Club.Dao.Impl.*;

public class DaoFactory {
	public static PersonalMemberDao getPersonalMemberDao(){
		return PersonalMemberDaoImpl.getInstance();
	}
	
	public static HouseMemberDao getHouseMemberDao(){
		return HouseMemberDaoImpl.getInstance();
	}
	
	public static WaitressDao getWaitressDao(){
		return WaitressDaoImpl.getInstance();
	}
	
	public static ClubManagerDao getClubManagerDao(){
		return ClubManagerDaoImpl.getInstance();
	}
	
	public static BankCardDao getBankCardDao(){
		return BankCardDaoImpl.getInstance();
	}
	
	public static ActivityDao getActivityDao(){
		return ActivityDaoImpl.getInstance();
	}
	
	public static ParticipateDao getParticipateDao(){
		return ParticipateDaoImpl.getInstance();
	}
	
	public static PayRecordDao getPayRecordDao(){
		return PayRecordDaoImpl.getInstance();
	}
	
	public static StatisticsDao getStatisticsDao(){
		return StatisticsDaoImpl.getInstance();
	}
	
}
