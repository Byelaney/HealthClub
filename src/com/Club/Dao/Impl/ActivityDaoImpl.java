package com.Club.Dao.Impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Club.Dao.ActivityDao;
import com.Club.Dao.DaoHelper;
import com.Club.Model.Activity;
import com.Club.Model.Participate;


public class ActivityDaoImpl implements ActivityDao{

	private static ActivityDaoImpl activityDao=new ActivityDaoImpl();
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	
	private ActivityDaoImpl(){
		
	}
	
	public static ActivityDaoImpl getInstance(){
		return activityDao;
	}
	
	public ArrayList<Activity> findUnDueActivity(String date,String account) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			ps=con.prepareStatement("select * from activity a where a.date>=? and a.activityid not in(select b.activityid from participate b where b.account=?)");
			ps.setString(1,date);
			ps.setString(2,account);
			rs=ps.executeQuery();
			ArrayList<Activity> result=new ArrayList<Activity>();
			
			while(rs.next()){
				Activity activity=new Activity();
				activity.setActivityID(rs.getInt("activityid"));
				activity.setGround(rs.getString("ground"));
				activity.setCoach(rs.getString("coach"));
				activity.setDate(rs.getDate("date"));
				activity.setTime(rs.getString("time"));
				
				result.add(activity);
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

	
	public ArrayList<Activity> findActivityByAccount(String account) {
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
			
			ArrayList<Activity> activities=new ArrayList<Activity>();
			for(int i=0;i<result.size();i++){
				Activity newActivity=findActivity(result.get(i).getActivityId());
				activities.add(newActivity);
			}
			
			return activities;
			
		
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			daoHelper.closeResult(rs);
			daoHelper.closePreparedStatement(ps);
			daoHelper.closeConnection(con);
		}
		
		return null;
		
		
	}

	
	public Activity findActivity(int activityId) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try{
			ps=con.prepareStatement("select * from activity where activityId=?");
			ps.setInt(1,activityId);
			rs=ps.executeQuery();
			if(rs.next()){
				Activity activity=new Activity();
				activity.setActivityID(rs.getInt("activityid"));
				activity.setGround(rs.getString("ground"));
				activity.setCoach(rs.getString("coach"));
				activity.setDate(rs.getDate("date"));
				activity.setTime(rs.getString("time"));
				return activity;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			daoHelper.closeResult(rs);
			daoHelper.closePreparedStatement(ps);
			daoHelper.closeConnection(con);
		}
		
		return null;
	}

	
	public boolean addActivity(Activity activity) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		
		
		try{
			ps=con.prepareStatement("INSERT INTO `healthclub`.`activity` (`activityid`,`ground`,`coach`,`date`,`time`) VALUES (?,?,?,?,?)");
			ps.setInt(1,0);
			ps.setString(2,activity.getGround());
			ps.setString(3,activity.getCoach());
			ps.setString(4,activity.DateToString());
			ps.setString(5,activity.getTime());
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

	
	public boolean deleteActivity(int activityId) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		
		try{
			ps=con.prepareStatement("delete from activity where activityid=?");
			ps.setInt(1,activityId);
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

	
	public boolean updateActivity(Activity activity) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		try{
			ps=con.prepareStatement("UPDATE `healthclub`.`activity` SET `activityid`=?, `ground`=?,`coach`=?,`date`=?,`time`=? where `activityid`=?");
			ps.setInt(1,activity.getActivityID());
			ps.setString(2,activity.getGround());
			ps.setString(3,activity.getCoach());
			ps.setString(4,activity.DateToString());
			ps.setString(5,activity.getTime());
			ps.setInt(6,activity.getActivityID());
			
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

	
	public ArrayList<Activity> findUnDueActivity(String date) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			ps=con.prepareStatement("select * from activity where date>=?");
			ps.setString(1,date);
			rs=ps.executeQuery();
			ArrayList<Activity> result=new ArrayList<Activity>();
			
			while(rs.next()){
				Activity activity=new Activity();
				activity.setActivityID(rs.getInt("activityid"));
				activity.setGround(rs.getString("ground"));
				activity.setCoach(rs.getString("coach"));
				activity.setDate(rs.getDate("date"));
				activity.setTime(rs.getString("time"));
				
				result.add(activity);
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

	
}
