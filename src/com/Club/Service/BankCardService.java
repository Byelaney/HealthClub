package com.Club.Service;

import com.Club.Factory.DaoFactory;
import com.Club.Model.BankCard;

public class BankCardService implements BankCardServiceInterface{

	private static BankCardService bankCardService=new BankCardService();
	
	private BankCardService(){
		
	}
	
	public static BankCardService getInstance(){
		return bankCardService;
	}
	
	public boolean charge(String bankCardID,double toPay) {
		BankCard bankCard=DaoFactory.getBankCardDao().findBankCard(bankCardID);
		
		if(bankCard!=null){
		double balance=bankCard.getBalance();
		if(balance-toPay>=0){
			BankCard newBankCard=new BankCard(bankCard.getBankCardId(),balance-toPay);
			boolean isSucceed=DaoFactory.getBankCardDao().updateBankCard(newBankCard);
			return isSucceed;
		}
		
		}
		return false;
	}

	
	public boolean recover(String bankCardID,double balance) {
		BankCard bankCard=new BankCard(bankCardID,balance);
		boolean isSucceed=DaoFactory.getBankCardDao().updateBankCard(bankCard);
		return isSucceed;
	}

	
	public double findBalance(String bankCardID) {
		BankCard bankCard=DaoFactory.getBankCardDao().findBankCard(bankCardID);
		if(bankCard!=null){
			return bankCard.getBalance();
		}
		return -1;
	}

}
