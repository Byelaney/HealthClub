package com.Club.Dao;

import java.util.ArrayList;

import com.Club.Model.*;

public interface ParticipateDao {
	//查找用户参加过的所有活动,返回的是participate对象
	public ArrayList<Participate> findParticipateByAccount(String account);
	public boolean addParticipate(Participate participate);
	//删除用户参与过的活动信息
	public boolean deleteParticipateByAccount(String account);
	public boolean deleteParticipate(String account,int activityId);
	//account和Id唯一确定一条记录
	public boolean updateParticipate(String account,int activityId,Participate participate);
	public boolean addParticipate(ArrayList<Participate> participate);
	
	//查找所有用户参与过的活动,返回joinedRecord对象
	public ArrayList<JoinedRecord> findJoinedActivity(String account);
	
	public boolean updateJoinedRecord(JoinedRecord joinedRecord);
}
