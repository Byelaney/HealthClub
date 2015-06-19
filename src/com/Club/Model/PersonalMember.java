package com.Club.Model;

import java.io.Serializable;


public class PersonalMember implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idCard;//第一次注册时的卡号
	private String account;
	private String password;
	private String gender;
	private int age;
	private String address;
	private String bankCardAccount;
	private String Memberstate;
	
	public PersonalMember(){
		
	}
	


	public PersonalMember(String idCard, String account, String password,
			String gender, int age, String address, String bankCardAccount,
			String memberstate) {
		super();
		this.idCard = idCard;
		this.account = account;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.bankCardAccount = bankCardAccount;
		Memberstate = memberstate;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	public String getMemberstate() {
		return Memberstate;
	}
	public void setMemberstate(String memberstate) {
		Memberstate = memberstate;
	}
	
}
