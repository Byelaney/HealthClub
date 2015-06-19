package com.Club.Service;

import java.util.ArrayList;

import com.Club.Factory.DaoFactory;
import com.Club.Model.JoinedRecord;
import com.Club.Model.Participate;

public class ParticipateService implements ParticipateServiceInterface{

	private static ParticipateService participateService=new ParticipateService();
	
	private ParticipateService(){
		
	}
	
	public static ParticipateService getInstance(){
		return participateService;
	}
	
	public boolean addParticipate(ArrayList<Participate> participate) {
		return DaoFactory.getParticipateDao().addParticipate(participate);
	}

	
	public ArrayList<JoinedRecord> findJoinedActivity(String account) {
		return DaoFactory.getParticipateDao().findJoinedActivity(account);
	}

	
	public boolean updateJoinedRecord(JoinedRecord joinedRecord) {
	
		return DaoFactory.getParticipateDao().updateJoinedRecord(joinedRecord);
	}

}
