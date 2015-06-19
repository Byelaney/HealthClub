package com.Club.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Club.Dao.*;
import com.Club.Model.PayRecord;

public class PayRecordDaoImpl implements PayRecordDao{

	private static PayRecordDaoImpl payRecordDao=new PayRecordDaoImpl();
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	
	private PayRecordDaoImpl(){
		
	}
	
	public static PayRecordDaoImpl getInstance(){
		return payRecordDao;
	}
	
	public PayRecord findPayRecord(int payRecordId) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try{
			ps=con.prepareStatement("select * from payrecord where payrecordid=?");
			ps.setInt(1,payRecordId);
			rs=ps.executeQuery();
			if(rs.next()){
				PayRecord payRecord=new PayRecord();
				payRecord.setPayRecordId(rs.getInt("payrecordid"));
				payRecord.setAccount(rs.getString("account"));
				payRecord.setPayment(rs.getDouble("payment"));
				payRecord.setDate(rs.getDate("date"));
				return payRecord;
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

	
	public ArrayList<PayRecord> findPayRecord(String account) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try{
			ps=con.prepareStatement("select * from payrecord where account=?");
			ps.setString(1,account);
			rs=ps.executeQuery();
			
			ArrayList<PayRecord> result=new ArrayList<PayRecord>();
			while(rs.next()){
				PayRecord payRecord=new PayRecord();
				payRecord.setPayRecordId(rs.getInt("payrecordid"));
				payRecord.setAccount(rs.getString("account"));
				payRecord.setPayment(rs.getDouble("payment"));
				payRecord.setDate(rs.getDate("date"));

				result.add(payRecord);
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

	
	public boolean addPayRecord(PayRecord payRecord) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		
		try{
			ps=con.prepareStatement("INSERT INTO `healthclub`.`payrecord` (`payrecordid`,`account`, `payment`,`date`) VALUES (?,?,?,?)");
			
			ps.setInt(1,0);
			ps.setString(2,payRecord.getAccount());
			ps.setDouble(3, payRecord.getPayment());
			ps.setString(4, payRecord.DateToString());
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

	
	public boolean deletePayRecord(String account) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		
		try{
			ps=con.prepareStatement("delete from payrecord where account=?");
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

	
	public boolean deletePayRecord(int payRecordId) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		
		try{
			ps=con.prepareStatement("delete from payrecord where payrecordid=?");
			ps.setInt(1,payRecordId);
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

	
	public boolean updatePayRecord(PayRecord payRecord) {
		Connection con=daoHelper.getConnection();
		PreparedStatement ps=null;
		try{
			ps=con.prepareStatement("UPDATE `healthclub`.`payrecord` SET `account`=?,`payment`=?,`date`=? where `account`=? and `payrecordid`=?");
			ps.setString(1,payRecord.getAccount());
			ps.setDouble(2,payRecord.getPayment());
			ps.setString(3,payRecord.DateToString());
			ps.setString(4,payRecord.getAccount());
			ps.setInt(5,payRecord.getPayRecordId());
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
