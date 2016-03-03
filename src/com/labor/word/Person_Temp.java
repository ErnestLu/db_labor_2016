package com.labor.word;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Person_Temp {
	/**
	 * 1.流水号
	 */
	private String serialNo;
	
	
	/**
	 * 2.受理编号
	 */
	private String acceptNo;
	
	/**
	 * 3.身份证号
	 */
	private String idNo;


	/**
	 * 4.姓名
	 */
	private String name;

	/**
	 * 5.公司
	 */
	private String company;

	/**
	 * 6.科室
	 */
	private int office;

	/**
	 * 7.性别
	 */
	private int sex;



	/**
	 * 8.受理时间
	 */
	private Calendar accepttime;
	
	
	/**
	 * 9.电话
	 */
	private String telephone;
	
	
	
	private String ifprint;
	
	private String ifuse;
	
	private String ifSpecial;


	
	
	public String getIfuse() {
		return ifuse;
	}


	public void setIfuse(String ifuse) {
		this.ifuse = ifuse;
	}


	public String getIfprint() {
		return ifprint;
	}


	public void setIfprint(String ifprint) {
		this.ifprint = ifprint;
	}


	public String getSerialNo() {
		return serialNo;
	}


	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}


	public String getAcceptNo() {
		return acceptNo;
	}


	public void setAcceptNo(String acceptNo) {
		this.acceptNo = acceptNo;
	}


	public String getIdNo() {
		return idNo;
	}


	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public int getOffice() {
		return office;
	}


	public void setOffice(int office) {
		this.office = office;
	}


	public int getSex() {
		return sex;
	}


	public void setSex(int sex) {
		this.sex = sex;
	}


	public Calendar getAccepttime() {
		return accepttime;
	}


	public void setAccepttime(Calendar accepttime) {
		this.accepttime = accepttime;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
	
	public String getIfSpecial() {
		return ifSpecial;
	}


	public void setIfSpecial(String ifSpecial) {
		this.ifSpecial = ifSpecial;
	}


	@Override
	public String toString() {
		
		
		SimpleDateFormat dfYMD = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println("");
		System.out.println("流水号：" + getSerialNo());
		
		System.out.println("受理编号：" + getAcceptNo());
		
		System.out.println("身份证号：" + getIdNo());
		
		System.out.println("姓名：" + getName());
		
		System.out.println("单位名称：" + getCompany());
		
		System.out.println("科室：" + getOffice());
		
		System.out.println("性别：" + getSex());
		
		System.out.println("受理时间：" + dfYMD.format(getAccepttime().getTime()));
		
		System.out.println("电话：" + getTelephone());
		
		return "";
	}
	
	
	
}
