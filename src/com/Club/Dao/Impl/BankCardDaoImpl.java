package com.Club.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Club.Dao.BankCardDao;
import com.Club.Dao.DaoHelper;
import com.Club.Model.BankCard;

public class BankCardDaoImpl implements BankCardDao{

	private static BankCardDaoImpl bankCardDao=new BankCardDaoImpl();
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	
	private BankCardDaoImpl(){
		
	}
	
	public static BankCardDaoImpl getInstance(){
		return bankCardDao;
	}
	
	
	public BankCard findBankCard(String bankCardID) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try{
			ps=con.prepareStatement("select * from bankcard where bankcardid=?");
			ps.setString(1,bankCardID);
			rs=ps.executeQuery();
			
			if(rs.next()){
				BankCard bankCard=new BankCard();
				bankCard.setBankCardId(rs.getString("bankcardid"));
				bankCard.setBalance(rs.getDouble("balance"));
				
				return bankCard;
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

	
	public boolean addBankCard(BankCard bankCard) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		
		
		try{
			ps=con.prepareStatement("INSERT INTO `healthclub`.`bankcard` (`bankcardid`, `balance`) VALUES (?,?)");
			ps.setString(1,bankCard.getBankCardId());
			ps.setDouble(2,bankCard.getBalance());
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

	
	public boolean deleteBankCard(String bankCardID) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		
		try{
			ps=con.prepareStatement("delete from bankcard where bankcardid=?");
			ps.setString(1,bankCardID);
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

	
	public boolean updateBankCard(BankCard bankCard) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		try{
			ps=con.prepareStatement("UPDATE `healthclub`.`bankcard` SET `bankcardid`=?, `balance`=? where `bankcardid`=?");
			ps.setString(1,bankCard.getBankCardId());
			ps.setDouble(2,bankCard.getBalance());
			ps.setString(3,bankCard.getBankCardId());
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
