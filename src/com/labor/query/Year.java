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
		
		bron.setTime(dfYM.parse("1960-02"));//出生年月
		
		join.setTime(dfYM.parse("1978-06"));//参加工作时间
		
		rjon.setTime(dfYM.parse("1975-04"));
		
		shen.setTime(dfYMD.parse("2014-12-30"));//受理时间
		
		
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
		
		
		System.out.println("原参加时间:" + join.get(Calendar.YEAR) + "年" + (join.get(Calendar.MONTH)+1) + "月");
		System.out.println("缴费年限为:" + Util.getYear(person) + "年" + Util.getMonth(person) + "月");
		System.out.println("缴费月数为:" + (Util.getYear(person)*12  + Util.getMonth(person)) + "月");
		System.out.println("集体工缴费认定为:" + (Util.getYear(person)-4) + "年" + Util.getMonth(person) + "月");
		System.out.println("集体工缴费月数为:" + (Util.getYear(person)*12  + Util.getMonth(person) - 48) + "月");
		
		
//		正常
//		System.out.println("\n缴费月数为:" + (Util.getYear(person)*12  + Util.getMonth(person)) + "月");
		
		
//		集体工
//		System.out.println("\n缴费月数为:" + (Util.getYear(person)*12  + Util.getMonth(person) - 48) + "月");
		
		
		
		
		
		rpersn.setBorn(bron);
		rpersn.setJoin(rjon);
		
		person.setIfaddorcut("2");
		rpersn.setAddorcutbegin(cutbejin);
		rpersn.setAddorcutend(cutend);
		
		rpersn.setApproveTime(shen);
		
		
		System.out.println("\n现参加时间:" + rjon.get(Calendar.YEAR) + "年" + (rjon.get(Calendar.MONTH)+1) + "月");
		System.out.println("重新认定为:" + Util.getYear(rpersn) + "年" + Util.getMonth(rpersn) + "月");
		System.out.println("缴费月数为:" + (Util.getYear(rpersn)*12  + Util.getMonth(rpersn)) + "月");
		System.out.println("集体工重新认定为:" + (Util.getYear(rpersn)-4) + "年" + Util.getMonth(rpersn) + "月");
		System.out.println("集体工缴费月数为:" + (Util.getYear(rpersn)*12  + Util.getMonth(rpersn) - 48) + "月");
		
		
		System.out.println("\n现退休时间:" + shen.get(Calendar.YEAR) + "年" + (shen.get(Calendar.MONTH)+1) + "月");
		
		
	}
	
	
	
	
	
}
