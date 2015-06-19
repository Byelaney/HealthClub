package com.Club.Service;

import java.util.ArrayList;

import com.Club.Model.JoinedRecord;
import com.Club.Model.Participate;

public interface ParticipateServiceInterface {
	public boolean addParticipate(ArrayList<Participate> participate);
	public ArrayList<JoinedRecord> findJoinedActivity(String account);
	public boolean updateJoinedRecord(JoinedRecord joinedRecord);
	
}
