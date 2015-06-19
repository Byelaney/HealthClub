package com.Club.Service;

public interface BankCardServiceInterface {
	public boolean charge(String bankCardID,double toPay);
	public boolean recover(String bankCardID,double balance);
	public double findBalance(String bankCardID);
}
