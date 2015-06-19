package com.Club.Model;

import java.io.Serializable;

public class MonthPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int Jan;
	private int Feb;
	private int Mar;
	private int April;
	private int May;
	private int June;
	private int July;
	private int Aug;
	private int Sep;
	private int Oct;
	private int Nov;
	private int Dec;
	
	public MonthPO(){
		
	}

	
	
	public MonthPO(int jan, int feb, int mar, int april, int may, int june,
			int july, int aug, int sep, int oct, int nov, int dec) {
		super();
		Jan = jan;
		Feb = feb;
		Mar = mar;
		April = april;
		May = may;
		June = june;
		July = july;
		Aug = aug;
		Sep = sep;
		Oct = oct;
		Nov = nov;
		Dec = dec;
	}



	public int getJan() {
		return Jan;
	}

	public void setJan(int jan) {
		Jan = jan;
	}

	public int getFeb() {
		return Feb;
	}

	public void setFeb(int feb) {
		Feb = feb;
	}

	public int getMar() {
		return Mar;
	}

	public void setMar(int mar) {
		Mar = mar;
	}

	public int getApril() {
		return April;
	}

	public void setApril(int april) {
		April = april;
	}

	public int getMay() {
		return May;
	}

	public void setMay(int may) {
		May = may;
	}

	public int getJune() {
		return June;
	}

	public void setJune(int june) {
		June = june;
	}

	public int getJuly() {
		return July;
	}

	public void setJuly(int july) {
		July = july;
	}

	public int getAug() {
		return Aug;
	}

	public void setAug(int aug) {
		Aug = aug;
	}

	public int getSep() {
		return Sep;
	}

	public void setSep(int sep) {
		Sep = sep;
	}

	public int getOct() {
		return Oct;
	}

	public void setOct(int oct) {
		Oct = oct;
	}

	public int getNov() {
		return Nov;
	}

	public void setNov(int nov) {
		Nov = nov;
	}

	public int getDec() {
		return Dec;
	}

	public void setDec(int dec) {
		Dec = dec;
	}
	
	
	
}
