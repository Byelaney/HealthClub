package com.Club.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Club.Dao.DaoHelper;
import com.Club.Dao.ParticipateDao;
import com.Club.Factory.DaoFactory;
import com.Club.Model.Activity;
import com.Club.Model.JoinedRecord;
import com.Club.Model.Participate;

public class ParticipateDaoImpl implements ParticipateDao{

	private static ParticipateDaoImpl participateDao=new ParticipateDaoImpl();
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	
	private ParticipateDaoImpl(){}
	
	public static ParticipateDaoImpl getInstance(){
		return participateDao;
	}
	
	
	public ArrayList<Participate> findParticipateByAccount(String account) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try{
			ps=con.prepareStatement("select * from participate where account=?");
			ps.setString(1,account);
			rs=ps.executeQuery();
			ArrayList<Participate> result=new ArrayList<Participate>();
			
			while(rs.next()){
				Participate participate=new Participate();
				participate.setAccount(rs.getString("account"));
				participate.setActivityId(rs.getInt("activityid"));
				participate.setTime(rs.getString("time"));
				result.add(participate);
			}
			
			return result;
		
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			daoHelper.closeResult(rs);
			daoHelper.closePreparedStatement(ps);
			daoHelper.closeConnection(con);
		}
		
		return null;
	}

	
	public boolean addParticipate(Participate participate) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		
		
		try{
			ps=con.prepareStatement("INSERT INTO `healthclub`.`participate` (`account`, `activityid`,`time`) VALUES (?,?,?)");
			ps.setString(1,participate.getAccount());
			ps.setInt(2,participate.getActivityId());
			ps.setString(3,participate.getTime());
			ps.execute();			
			return true;
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			daoHelper.closePreparedStatement(ps);
			daoHelper.closeConnection(con);
		}
		
		
		return false;
	}

	
	public boolean deleteParticipateByAccount(String account) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		
		try{
			ps=con.prepareStatement("delete from participate where account=?");
			ps.setString(1,account);
			ps.execute();
		
			return true;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			daoHelper.closePreparedStatement(ps);
			daoHelper.closeConnection(con);
		}
		return false;
	}

	
	public boolean updateParticipate(String account, int activityId,Participate participate) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		try{
			ps=con.prepareStatement("UPDATE `healthclub`.`participate` SET `account`=?, `activityid`=?,`time`=? where `account`=? and `activityid`=?");
			ps.setString(1,participate.getAccount());
			ps.setInt(2,participate.getActivityId());
			ps.setString(3,participate.getTime());
			ps.setString(4,account);
			ps.setInt(5,activityId);
			ps.execute();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			daoHelper.closePreparedStatement(ps);
			daoHelper.closeConnection(con);
		}
		
		return false;
	}

	
	public boolean deleteParticipate(String account, int activityId) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		
		try{
			ps=con.prepareStatement("delete from participate where account=? and activityid=?");
			ps.setString(1,account);
			ps.setInt(2,activityId);
			ps.execute();
		
			return true;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			daoHelper.closePreparedStatement(ps);
			daoHelper.closeConnection(con);
		}
		return false;
	}

	
	public boolean addParticipate(ArrayList<Participate> participates) {
		Participate participate=new Participate();
		
		for(int i=0;i<participates.size();i++){
			participate=participates.get(i);
			boolean isSucceed=addParticipate(participate);
			if(isSucceed==false){
				return false;
			}
		}
		return true;
	}

	
	public ArrayList<JoinedRecord> findJoinedActivity(String account) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try{
			ps=con.prepareStatement("select * from activity a,participate b where a.activityid=b.activityid and b.account=?");
			ps.setString(1,account);
			rs=ps.executeQuery();
			ArrayList<JoinedRecord> result=new ArrayList<JoinedRecord>();
			
			while(rs.next()){
				JoinedRecord record=new JoinedRecord();
				record.setActivityID(rs.getInt(1));
				record.setGround(rs.getString("ground"));
				record.setCoach(rs.getString("coach"));
				record.setActivityDate(rs.getDate("date"));
				record.setTime(rs.getString(5));
				record.setRequestTime(rs.getString(8));
				record.setAccount(rs.getString(6));
				result.add(record);
			}
			
			return result;
		
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			daoHelper.closeResult(rs);
			daoHelper.closePreparedStatement(ps);
			daoHelper.closeConnection(con);
		}
		
		return null;
	}

	
	
	public boolean updateJoinedRecord(JoinedRecord joinedRecord) {
		Activity activity=new Activity();
		activity.setActivityID(joinedRecord.getActivityID());
		activity.setCoach(joinedRecord.getCoach());
		activity.setDate(joinedRecord.getActivityDate());
		activity.setGround(joinedRecord.getGround());
		activity.setTime(joinedRecord.getTime());
		
		DaoFactory.getActivityDao().updateActivity(activity);
		
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		
		try{
			ps=con.prepareStatement("UPDATE `healthclub`.`participate` SET `account`=?, `activityid`=?,`time`=? where `account`=? and `activityid`=?");
			ps.setString(1,joinedRecord.getAccount());
			ps.setInt(2,joinedRecord.getActivityID());
			ps.setString(3,joinedRecord.getTime());
			ps.setString(4,joinedRecord.getAccount());
			ps.setInt(5,joinedRecord.getActivityID());
			ps.execute();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			daoHelper.closePreparedStatement(ps);
			daoHelper.closeConnection(con);
		}
		
		return false;
	}

}
