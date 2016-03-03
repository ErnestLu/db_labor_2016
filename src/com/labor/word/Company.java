package com.labor.word;

import java.util.Calendar;

public class Company {
	
	/**
	 * 科室
	 */
	private int kesh;
	
	/**
	 * 公司
	 */
	private String comp;
	
	
	/**
	 * 审批时间
	 */
	private Calendar shen;
	
	/**
	 * 身份
	 */
	private int type;
	
	/**
	 * 类型
	 */
	private int shenfen;
	/**
	 * 性别
	 */
	private int sex;
	
	
	private String extra2 = "";


	public int getKesh() {
		return kesh;
	}


	public void setKesh(int kesh) {
		this.kesh = kesh;
	}


	public String getComp() {
		return comp;
	}


	public void setComp(String comp) {
		this.comp = comp;
	}


	public Calendar getShen() {
		return shen;
	}


	public void setShen(Calendar shen) {
		this.shen = shen;
	}


	public int getShenfen() {
		return shenfen;
	}


	public void setShenfen(int shenfen) {
		this.shenfen = shenfen;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public int getSex() {
		return sex;
	}


	public void setSex(int sex) {
		this.sex = sex;
	}


	public String getExtra2() {
		return extra2;
	}


	public void setExtra2(String extra2) {
		this.extra2 = extra2;
	}


	
	
	
	

}
