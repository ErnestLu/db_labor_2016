package com.labor.word;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Person_Temp {
	/**
	 * 1.��ˮ��
	 */
	private String serialNo;
	
	
	/**
	 * 2.������
	 */
	private String acceptNo;
	
	/**
	 * 3.���֤��
	 */
	private String idNo;


	/**
	 * 4.����
	 */
	private String name;

	/**
	 * 5.��˾
	 */
	private String company;

	/**
	 * 6.����
	 */
	private int office;

	/**
	 * 7.�Ա�
	 */
	private int sex;



	/**
	 * 8.����ʱ��
	 */
	private Calendar accepttime;
	
	
	/**
	 * 9.�绰
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
		System.out.println("��ˮ�ţ�" + getSerialNo());
		
		System.out.println("�����ţ�" + getAcceptNo());
		
		System.out.println("���֤�ţ�" + getIdNo());
		
		System.out.println("������" + getName());
		
		System.out.println("��λ���ƣ�" + getCompany());
		
		System.out.println("���ң�" + getOffice());
		
		System.out.println("�Ա�" + getSex());
		
		System.out.println("����ʱ�䣺" + dfYMD.format(getAccepttime().getTime()));
		
		System.out.println("�绰��" + getTelephone());
		
		return "";
	}
	
	
	
}
