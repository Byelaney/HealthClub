package com.Club.Service;

import java.util.ArrayList;

import com.Club.Factory.DaoFactory;
import com.Club.Model.PayRecord;

public class PayRecordService implements PayRecordServiceInterface{

	private static PayRecordService payRecordService=new PayRecordService();
	
	private PayRecordService(){}
	
	public static PayRecordService getInstance(){
		return payRecordService;
	}
	
	public ArrayList<PayRecord> getPayRecord(String account) {
		return DaoFactory.getPayRecordDao().findPayRecord(account);
	}

	
	public boolean update(PayRecord payRecord) {
		return DaoFactory.getPayRecordDao().updatePayRecord(payRecord);
	}

	
	public void save(PayRecord payRecord) {
		// TODO Auto-generated method stub
		DaoFactory.getPayRecordDao().addPayRecord(payRecord);
	}

}
