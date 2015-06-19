package com.Club.Factory;

import com.Club.Service.ActivityService;
import com.Club.Service.ActivityServiceInterface;
import com.Club.Service.AutoChargeService;
import com.Club.Service.BankCardService;
import com.Club.Service.BankCardServiceInterface;
import com.Club.Service.HouseMemberServiceInterface;
import com.Club.Service.HouseService;
import com.Club.Service.ManagerService;
import com.Club.Service.ManagerServiceInterface;
import com.Club.Service.ParticipateService;
import com.Club.Service.ParticipateServiceInterface;
import com.Club.Service.PayRecordService;
import com.Club.Service.PayRecordServiceInterface;
import com.Club.Service.PersonalService;
import com.Club.Service.PersonalServiceInterface;
import com.Club.Service.StatisticsService;
import com.Club.Service.StatisticsServiceInterface;
import com.Club.Service.WaitressService;
import com.Club.Service.WaitressServiceInterface;

public class ServiceFactory {
	public static PersonalServiceInterface getPersonalServiceInstance(){
		return PersonalService.getInstance();
	}
	public static HouseMemberServiceInterface getHouseServiceInstance(){
		return HouseService.getInstance();
	}

	public static BankCardServiceInterface getBankCardServiceInstance(){
		return BankCardService.getInstance();
	}
	
	public static ActivityServiceInterface getActivityServiceInstance(){
		return ActivityService.getInstance();
	}
	
	public static ParticipateServiceInterface getParticipateServiceInstance(){
		return ParticipateService.getInstance();
	}
	
	public static PayRecordServiceInterface getPayRecordServiceInstance(){
		return PayRecordService.getInstance();
	}
	
	public static ManagerServiceInterface getManagerServiceInstance(){
		return ManagerService.getInstance();
	}
	
	public static WaitressServiceInterface getWaitressServiceInstance(){
		return WaitressService.getInstance();
	}
	
	public static StatisticsServiceInterface getStatisticsServiceInstance(){
		return StatisticsService.getStatisticsService();
	}
	
	public static AutoChargeService getAutoChargeServiceInstance(){
		return AutoChargeService.getInstance();
	}
}

