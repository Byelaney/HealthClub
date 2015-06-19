package com.Club.Service;

import java.util.ArrayList;

import com.Club.Model.PayRecord;

public interface PayRecordServiceInterface {
	public ArrayList<PayRecord> getPayRecord(String account);
	public boolean update(PayRecord payRecord);
	public void save(PayRecord payRecord);
}
