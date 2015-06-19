package com.Club.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Club.Dao.ClubManagerDao;
import com.Club.Dao.DaoHelper;
import com.Club.Model.ClubManager;
public class ClubManagerDaoImpl implements ClubManagerDao{
	
	private static ClubManagerDaoImpl clubManagerDao=new ClubManagerDaoImpl();
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	
	private ClubManagerDaoImpl(){
		
	}
	
	public static ClubManagerDaoImpl getInstance(){
		return clubManagerDao;
	}
	
	
	public ClubManager findManager(String account) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try{
			ps=con.prepareStatement("select * from clubmanager where account=?");
			ps.setString(1,account);
			rs=ps.executeQuery();
			if(rs.next()){
				ClubManager clubManager=new ClubManager();
				clubManager.setAccount(rs.getString("account"));
				clubManager.setPassword(rs.getString("password"));
				
				return clubManager;
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

	public boolean addClubManager(ClubManager clubManager) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		
		
		try{
			ps=con.prepareStatement("INSERT INTO `healthclub`.`clubmanager` (`account`, `password`) VALUES (?,?)");
			ps.setString(1,clubManager.getAccount());
			ps.setString(2,clubManager.getPassword());
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

	
	public boolean deleteClubManager(String account) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		
		try{
			ps=con.prepareStatement("delete from clubmanager where account=?");
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

	
	public boolean updateClubManager(ClubManager clubManager) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		try{
			ps=con.prepareStatement("UPDATE `healthclub`.`clubmanager` SET `account`=?, `password`=? where `account`=?");
			ps.setString(1,clubManager.getAccount());
			ps.setString(2,clubManager.getPassword());
			ps.setString(3,clubManager.getAccount());
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
