package com.Club.Service;

import java.util.ArrayList;
import java.util.Date;

import com.Club.Factory.DaoFactory;
import com.Club.Model.BankCard;
import com.Club.Model.HouseMember;
import com.Club.Model.PayRecord;
import com.Club.Model.PersonalMember;

public class AutoChargeService implements AutoChargeServiceInterface{

	private static AutoChargeService autoChargeService=new AutoChargeService();
	private static final double FEE1=40;
	private static final double FEE2=55;
	private static final double FEE3=10;
	
	
	private AutoChargeService(){
		
	}
	
	public static AutoChargeService getInstance(){
		return autoChargeService;
	}
	
	public void charge() {
		ArrayList<PersonalMember> personal=DaoFactory.getPersonalMemberDao().findAll();
		ArrayList<HouseMember> house=DaoFactory.getHouseMemberDao().findAll();
		
		String bankcardid=null;
		for(int i=0;i<personal.size();i++){
			PersonalMember member=personal.get(i);
			bankcardid=personal.get(i).getBankCardAccount();
			BankCard bankCard=DaoFactory.getBankCardDao().findBankCard(bankcardid);
			double balance=bankCard.getBalance()-FEE1;
			if(balance<0){
				//余额小于0，则把用户状态置换为停用
				member.setMemberstate("cease");
				DaoFactory.getPersonalMemberDao().updatePersonalMember(member);
				continue;
			}
			
			bankCard.setBalance(balance);
			DaoFactory.getBankCardDao().updateBankCard(bankCard);
			PayRecord payRecord=new PayRecord();
			payRecord.setAccount(member.getAccount());
			payRecord.setPayment(balance);
			payRecord.setDate(new Date());
			payRecord.setPayRecordId(0);
			DaoFactory.getPayRecordDao().addPayRecord(payRecord);
		}
		
		for(int i=0;i<house.size();i++){
			HouseMember member=house.get(i);
			bankcardid=house.get(i).getBankCardAccount();
			BankCard bankCard=DaoFactory.getBankCardDao().findBankCard(bankcardid);
			double balance=bankCard.getBalance();
			balance=balance-FEE2*house.get(i).getCouples()-FEE3*house.get(i).getChildren();
			if(balance<0){
				//余额小于0，则把用户状态置换为停用
				member.setMemberState("cease");
				DaoFactory.getHouseMemberDao().updateHouseMember(member);
				continue;
			}
			
			bankCard.setBalance(balance);
			DaoFactory.getBankCardDao().updateBankCard(bankCard);
			PayRecord payRecord=new PayRecord();
			payRecord.setAccount(member.getAccount());
			payRecord.setPayment(balance);
			payRecord.setDate(new Date());
			payRecord.setPayRecordId(0);
			DaoFactory.getPayRecordDao().addPayRecord(payRecord);
		}
		
		
		
	}

}
