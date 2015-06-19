package com.Club.Dao.Impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Club.Dao.*;
import com.Club.Model.PersonalMember;

public class PersonalMemberDaoImpl implements PersonalMemberDao{

	private static PersonalMemberDaoImpl personalMemberDao=new PersonalMemberDaoImpl();
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	
	private PersonalMemberDaoImpl(){
		
	}
	
	public static PersonalMemberDaoImpl getInstance(){
		return personalMemberDao;
	}
	
	
	public PersonalMember findPersonalMember(String account) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try{
			ps=con.prepareStatement("select * from personalmember where account=?");
			ps.setString(1,account);
			rs=ps.executeQuery();
			if(rs.next()){
				PersonalMember personalMember=new PersonalMember();
				personalMember.setAccount(rs.getString("account"));
				personalMember.setPassword(rs.getString("password"));
				personalMember.setGender(rs.getString("gender"));
				personalMember.setAge(rs.getInt("age"));
				personalMember.setAddress(rs.getString("address"));
				personalMember.setBankCardAccount(rs.getString("bankcardaccount"));
				personalMember.setMemberstate(rs.getString("memberstate"));
				personalMember.setIdCard(rs.getString("idcard"));
				return personalMember;
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

	
	public boolean addPersonalMember(PersonalMember personalMember) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		
		
		try{
			ps=con.prepareStatement("INSERT INTO `healthclub`.`personalmember` (`account`, `password`, `gender`, `age`, `address`, `bankcardaccount`, `memberstate`,`idcard`) VALUES (?,?,?,?,?,?,?,?)");
			ps.setString(1,personalMember.getAccount());
			ps.setString(2,personalMember.getPassword());
			ps.setString(3,personalMember.getGender());
			ps.setInt(4,personalMember.getAge());
			ps.setString(5,personalMember.getAddress());
			ps.setString(6,personalMember.getBankCardAccount());
			ps.setString(7,personalMember.getMemberstate());
			ps.setString(8,personalMember.getIdCard());
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

	
	public boolean deletePersonalMember(String account) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		
		try{
			ps=con.prepareStatement("delete from personalmember where account=?");
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

	
	public boolean updatePersonalMember(PersonalMember personalMember) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		try{
			ps=con.prepareStatement("UPDATE `healthclub`.`personalmember` SET `account`=?, `password`=?, `gender`=?, `age`=?," +
		"`address`=?,`bankcardaccount`=?,`memberstate`=?,`idcard`=? WHERE `account`=?");
			
			
			ps.setString(1,personalMember.getAccount());
			ps.setString(2,personalMember.getPassword());
			ps.setString(3,personalMember.getGender());
			ps.setInt(4,personalMember.getAge());
			ps.setString(5,personalMember.getAddress());
			ps.setString(6,personalMember.getBankCardAccount());
			ps.setString(7,personalMember.getMemberstate());
			ps.setString(8,personalMember.getIdCard());
			ps.setString(9,personalMember.getAccount());
			
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

	
	public ArrayList<PersonalMember> findAll() {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try{
			ps=con.prepareStatement("select * from personalmember");
			rs=ps.executeQuery();
			ArrayList<PersonalMember> member=new ArrayList<PersonalMember>();
			while(rs.next()){
				PersonalMember personalMember=new PersonalMember();
				personalMember.setAccount(rs.getString("account"));
				personalMember.setPassword(rs.getString("password"));
				personalMember.setGender(rs.getString("gender"));
				personalMember.setAge(rs.getInt("age"));
				personalMember.setAddress(rs.getString("address"));
				personalMember.setBankCardAccount(rs.getString("bankcardaccount"));
				personalMember.setMemberstate(rs.getString("memberstate"));
				personalMember.setIdCard(rs.getString("idcard"));
				member.add(personalMember);
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
