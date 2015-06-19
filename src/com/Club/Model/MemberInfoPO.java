package com.Club.Model;

import java.io.Serializable;

public class MemberInfoPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int age10_25;
	private int age25_40;
	private int age40_55;
	private int age55_70;
	
	private int male;
	private int female;
	
	
	private int normal;
	private int cease;
	private int pause;
	private int cancel;
	
	public MemberInfoPO(){}

	public MemberInfoPO(int age10_25, int age25_40, int age40_55, int age55_70,
			int male, int female, int normal, int cease, int pause, int cancel) {
		super();
		this.age10_25 = age10_25;
		this.age25_40 = age25_40;
		this.age40_55 = age40_55;
		this.age55_70 = age55_70;
		this.male = male;
		this.female = female;
		this.normal = normal;
		this.cease = cease;
		this.pause = pause;
		this.cancel = cancel;
	}

	public int getAge10_25() {
		return age10_25;
	}

	public void setAge10_25(int age10_25) {
		this.age10_25 = age10_25;
	}

	public int getAge25_40() {
		return age25_40;
	}

	public void setAge25_40(int age25_40) {
		this.age25_40 = age25_40;
	}

	public int getAge40_55() {
		return age40_55;
	}

	public void setAge40_55(int age40_55) {
		this.age40_55 = age40_55;
	}

	public int getAge55_70() {
		return age55_70;
	}

	public void setAge55_70(int age55_70) {
		this.age55_70 = age55_70;
	}

	public int getMale() {
		return male;
	}

	public void setMale(int male) {
		this.male = male;
	}

	public int getFemale() {
		return female;
	}

	public void setFemale(int female) {
		this.female = female;
	}

	public int getNormal() {
		return normal;
	}

	public void setNormal(int normal) {
		this.normal = normal;
	}

	public int getCease() {
		return cease;
	}

	public void setCease(int cease) {
		this.cease = cease;
	}

	public int getPause() {
		return pause;
	}

	public void setPause(int pause) {
		this.pause = pause;
	}

	public int getCancel() {
		return cancel;
	}

	public void setCancel(int cancel) {
		this.cancel = cancel;
	}
	
	
	
	
}
