package com.Club.Model;

import java.io.Serializable;

public class BankCard implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bankCardId;
	private double balance;
	
	public BankCard(){
		
	}

	public BankCard(String bankCardId, double balance) {
		super();
		this.bankCardId = bankCardId;
		this.balance = balance;
	}

	public String getBankCardId() {
		return bankCardId;
	}

	public void setBankCardId(String bankCardId) {
		this.bankCardId = bankCardId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
}
