package com.Club.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Club.Dao.DaoHelper;
import com.Club.Dao.HouseMemberDao;
import com.Club.Model.HouseMember;

public class HouseMemberDaoImpl implements HouseMemberDao{

	private static HouseMemberDaoImpl houseMemberDaoImpl=new HouseMemberDaoImpl();
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	
	private HouseMemberDaoImpl(){
		
	}
	
	public static HouseMemberDaoImpl getInstance(){
		return houseMemberDaoImpl;
	}
	
	
	public HouseMember findHouseMember(String account) {
	
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try{
			ps=con.prepareStatement("select * from housemember where account=?");
			ps.setString(1,account);
			rs=ps.executeQuery();
			
			
			if(rs.next()){
				HouseMember houseMember=new HouseMember();
				houseMember.setAccount(rs.getString("account"));
				houseMember.setPassword(rs.getString("password"));
				houseMember.setAddress(rs.getString("address"));
				houseMember.setBankCardAccount(rs.getString("bankcardaccount"));
				houseMember.setMemberState(rs.getString("memberstate"));
				houseMember.setCouples(rs.getInt("couples"));
				houseMember.setChildren(rs.getInt("children"));
				houseMember.setIdCard(rs.getString("idcard"));
				houseMember.setGender(rs.getString("gender"));
				return houseMember;
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

	
	public boolean addHouseMember(HouseMember houseMember) {
		
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		
		
		try{
			ps=con.prepareStatement("INSERT INTO `healthclub`.`housemember` (`account`, `password`,`address`, `bankcardaccount`, `memberstate`,`couples`,`children`,`idcard`,`gender`) VALUES (?,?,?,?,?,?,?,?,?)");
			ps.setString(1,houseMember.getAccount());
			ps.setString(2,houseMember.getPassword());
			ps.setString(3,houseMember.getAddress());
			ps.setString(4,houseMember.getBankCardAccount());
			ps.setString(5,houseMember.getMemberState());
			ps.setInt(6,houseMember.getCouples());
			ps.setInt(7,houseMember.getChildren());
			ps.setString(8,houseMember.getIdCard());
			ps.setString(9,houseMember.getGender());
			
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

	
	public boolean deleteHouseMember(String account) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		
		try{
			ps=con.prepareStatement("delete from housemember where account=?");
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

	
	public boolean updateHouseMember(HouseMember houseMember) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		try{
			ps=con.prepareStatement("UPDATE `healthclub`.`housemember` SET `account`=?, `password`=?, `address`=?," +
					"`bankcardaccount`=?, `memberstate`=?,`couples`=?,`children`=?,`idcard`=?,`gender`=? WHERE `account`=?");
			
			ps.setString(1,houseMember.getAccount());
			ps.setString(2,houseMember.getPassword());
			ps.setString(3,houseMember.getAddress());
			ps.setString(4,houseMember.getBankCardAccount());
			ps.setString(5,houseMember.getMemberState());
			ps.setInt(6,houseMember.getCouples());
			ps.setInt(7,houseMember.getChildren());
			ps.setString(8,houseMember.getIdCard());
			ps.setString(9,houseMember.getGender());
			ps.setString(10, houseMember.getAccount());
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

	
	public ArrayList<HouseMember> findAll() {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try{
			ps=con.prepareStatement("select * from housemember");
			rs=ps.executeQuery();
			
			ArrayList<HouseMember> member=new ArrayList<HouseMember>();
			while(rs.next()){
				HouseMember houseMember=new HouseMember();
				houseMember.setAccount(rs.getString("account"));
				houseMember.setPassword(rs.getString("password"));
				houseMember.setAddress(rs.getString("address"));
				houseMember.setBankCardAccount(rs.getString("bankcardaccount"));
				houseMember.setMemberState(rs.getString("memberstate"));
				houseMember.setCouples(rs.getInt("couples"));
				houseMember.setChildren(rs.getInt("children"));
				houseMember.setIdCard(rs.getString("idcard"));
				houseMember.setGender(rs.getString("gender"));
				member.add(houseMember);
			}
			
			return member;	
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
