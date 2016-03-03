package com.labor.query;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.labor.word.Person;
import com.labor.word.Util;

public class Year {
	
	public static void main(String[] args) throws ParseException {
		
		Calendar bron = Calendar.getInstance();
		Calendar join = Calendar.getInstance();
		Calendar shen = Calendar.getInstance();
		Calendar rjon = Calendar.getInstance();
		
		
		Calendar cutbejin =  Calendar.getInstance();
		Calendar cutend = Calendar.getInstance();

		SimpleDateFormat dfYM = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat dfYMD = new SimpleDateFormat("yyyy-MM-dd");
		
		
		Person person = new Person();
		Person rpersn = new Person();
		
		bron.setTime(dfYM.parse("1960-02"));//��������
		
		join.setTime(dfYM.parse("1978-06"));//�μӹ���ʱ��
		
		rjon.setTime(dfYM.parse("1975-04"));
		
		shen.setTime(dfYMD.parse("2014-12-30"));//����ʱ��
		
		
//		cutbejin.setTime(dfYM.parse("1992-01"));
//		
//		cutend.setTime(dfYM.parse("1995-06"));
//		
//		person.setIfaddorcut("2");
//		person.setAddorcutbegin(cutbejin);
//		person.setAddorcutend(cutend);
		
		
		
		
		person.setBorn(bron);
		person.setJoin(join);
		
		person.setApproveTime(shen);
		
		
		System.out.println("ԭ�μ�ʱ��:" + join.get(Calendar.YEAR) + "��" + (join.get(Calendar.MONTH)+1) + "��");
		System.out.println("�ɷ�����Ϊ:" + Util.getYear(person) + "��" + Util.getMonth(person) + "��");
		System.out.println("�ɷ�����Ϊ:" + (Util.getYear(person)*12  + Util.getMonth(person)) + "��");
		System.out.println("���幤�ɷ��϶�Ϊ:" + (Util.getYear(person)-4) + "��" + Util.getMonth(person) + "��");
		System.out.println("���幤�ɷ�����Ϊ:" + (Util.getYear(person)*12  + Util.getMonth(person) - 48) + "��");
		
		
//		����
//		System.out.println("\n�ɷ�����Ϊ:" + (Util.getYear(person)*12  + Util.getMonth(person)) + "��");
		
		
//		���幤
//		System.out.println("\n�ɷ�����Ϊ:" + (Util.getYear(person)*12  + Util.getMonth(person) - 48) + "��");
		
		
		
		
		
		rpersn.setBorn(bron);
		rpersn.setJoin(rjon);
		
		person.setIfaddorcut("2");
		rpersn.setAddorcutbegin(cutbejin);
		rpersn.setAddorcutend(cutend);
		
		rpersn.setApproveTime(shen);
		
		
		System.out.println("\n�ֲμ�ʱ��:" + rjon.get(Calendar.YEAR) + "��" + (rjon.get(Calendar.MONTH)+1) + "��");
		System.out.println("�����϶�Ϊ:" + Util.getYear(rpersn) + "��" + Util.getMonth(rpersn) + "��");
		System.out.println("�ɷ�����Ϊ:" + (Util.getYear(rpersn)*12  + Util.getMonth(rpersn)) + "��");
		System.out.println("���幤�����϶�Ϊ:" + (Util.getYear(rpersn)-4) + "��" + Util.getMonth(rpersn) + "��");
		System.out.println("���幤�ɷ�����Ϊ:" + (Util.getYear(rpersn)*12  + Util.getMonth(rpersn) - 48) + "��");
		
		
		System.out.println("\n������ʱ��:" + shen.get(Calendar.YEAR) + "��" + (shen.get(Calendar.MONTH)+1) + "��");
		
		
	}
	
	
	
	
	
}
