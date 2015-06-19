package com.Club.Dao;

import java.util.ArrayList;

import com.Club.Model.PayRecord;

public interface PayRecordDao {
	
	public PayRecord findPayRecord(int payRecordId);
	public ArrayList<PayRecord> findPayRecord(String account);
	public boolean addPayRecord(PayRecord payRecord);
	public boolean deletePayRecord(String account);
	public boolean deletePayRecord(int payRecordId);
	public boolean updatePayRecord(PayRecord payRecord);
	
}
