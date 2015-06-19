package com.Club.Dao;

import java.util.ArrayList;

import com.Club.Model.*;

public interface ParticipateDao {
	//�����û��μӹ������л,���ص���participate����
	public ArrayList<Participate> findParticipateByAccount(String account);
	public boolean addParticipate(Participate participate);
	//ɾ���û�������Ļ��Ϣ
	public boolean deleteParticipateByAccount(String account);
	public boolean deleteParticipate(String account,int activityId);
	//account��IdΨһȷ��һ����¼
	public boolean updateParticipate(String account,int activityId,Participate participate);
	public boolean addParticipate(ArrayList<Participate> participate);
	
	//���������û�������Ļ,����joinedRecord����
	public ArrayList<JoinedRecord> findJoinedActivity(String account);
	
	public boolean updateJoinedRecord(JoinedRecord joinedRecord);
}
