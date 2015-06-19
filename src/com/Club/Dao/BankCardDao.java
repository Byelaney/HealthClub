package com.Club.Dao;

import com.Club.Model.BankCard;

public interface BankCardDao {
	public BankCard findBankCard(String bankCardID);
	public boolean addBankCard(BankCard bankCard);
	public boolean deleteBankCard(String bankCardID);
	public boolean updateBankCard(BankCard bankCard);
}
