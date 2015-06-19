package com.Club.Model;

import java.io.Serializable;

public class CoachUsePO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int Mike;
	private int Marshal;
	private int Suby;
	private int Tom;
	
	public CoachUsePO(){}

	
	
	public CoachUsePO(int mike, int marshal, int suby, int tom) {
		super();
		Mike = mike;
		Marshal = marshal;
		Suby = suby;
		Tom = tom;
	}



	public int getMike() {
		return Mike;
	}

	public void setMike(int mike) {
		Mike = mike;
	}

	public int getMarshal() {
		return Marshal;
	}

	public void setMarshal(int marshal) {
		Marshal = marshal;
	}

	public int getSuby() {
		return Suby;
	}

	public void setSuby(int suby) {
		Suby = suby;
	}

	public int getTom() {
		return Tom;
	}

	public void setTom(int tom) {
		Tom = tom;
	}
	
	
}
