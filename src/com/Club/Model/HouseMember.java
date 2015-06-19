package com.Club.Model;

import java.io.Serializable;

public class HouseMember implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idCard;
	private String account;
	private String password;
	private String address;
	private String bankCardAccount;
	private String memberState;
	private String gender;
	
	private int couples;//多少对夫妻
	private int children;//多少个10~18岁的小孩
	
	public HouseMember(){
		
	}
	
	


	public HouseMember(String idCard, String account, String password,
			String address, String bankCardAccount, String memberState,
			String gender, int couples, int children) {
		super();
		this.idCard = idCard;
		this.account = account;
		this.password = password;
		this.address = address;
		this.bankCardAccount = bankCardAccount;
		this.memberState = memberState;
		this.gender = gender;
		this.couples = couples;
		this.children = children;
	}








	public String getIdCard() {
		return idCard;
	}




	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}




	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBankCardAccount() {
		return bankCardAccount;
	}
	public void setBankCardAccount(String bankCardAccount) {
		this.bankCardAccount = bankCardAccount;
	}
	public String getMemberState() {
		return memberState;
	}
	public void setMemberState(String memberState) {
		this.memberState = memberState;
	}
	
	public int getCouples() {
		return couples;
	}


	public void setCouples(int couples) {
		this.couples = couples;
	}


	public int getChildren() {
		return children;
	}


	public void setChildren(int children) {
		this.children = children;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
