package com.Club.Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PayRecord implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int payRecordId;
	private String account;
	private double payment;
	private Date date;
	
	public PayRecord(){
		
	}

	public String DateToString(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(this.date);
		
		return dateString;
	}
	
	
	public PayRecord(int payRecordId, String account, double payment, Date date) {
		super();
		this.payRecordId = payRecordId;
		this.account = account;
		this.payment = payment;
		this.date = date;
	}

	public int getPayRecordId() {
		return payRecordId;
	}

	public void setPayRecordId(int payRecordId) {
		this.payRecordId = payRecordId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
