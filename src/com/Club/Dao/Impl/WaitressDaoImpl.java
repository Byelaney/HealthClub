package com.Club.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Club.Dao.DaoHelper;
import com.Club.Dao.WaitressDao;
import com.Club.Model.Waitress;

public class WaitressDaoImpl implements WaitressDao{

	private static WaitressDaoImpl waitressDao=new WaitressDaoImpl();
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	
	
	private WaitressDaoImpl(){
		
	}
	
	public static WaitressDaoImpl getInstance(){
		return waitressDao;
	}
	
	public Waitress findWaitress(String account) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try{
			ps=con.prepareStatement("select * from waitress where account=?");
			ps.setString(1,account);
			rs=ps.executeQuery();
			if(rs.next()){
				Waitress waitress=new Waitress();
				waitress.setAccount(rs.getString("account"));
				waitress.setPassword(rs.getString("password"));
				
				return waitress;
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

	
	public boolean addWaitress(Waitress waitress) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		
		
		try{
			ps=con.prepareStatement("INSERT INTO `healthclub`.`waitress` (`account`, `password`) VALUES (?,?)");
			ps.setString(1,waitress.getAccount());
			ps.setString(2,waitress.getPassword());
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

	
	public boolean deleteWaitress(String account) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		
		try{
			ps=con.prepareStatement("delete from waitress where account=?");
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

	
	public boolean updateWaitress(Waitress waitress) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		try{
			ps=con.prepareStatement("UPDATE `healthclub`.`waitress` SET `account`=?, `password`=? where `account`=?");
			ps.setString(1,waitress.getAccount());
			ps.setString(2,waitress.getPassword());
			ps.setString(3,waitress.getAccount());
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
