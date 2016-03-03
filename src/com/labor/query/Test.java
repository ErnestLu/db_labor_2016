package com.labor.query;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test {

	
	public static void main(String[] args) throws ParseException {
		
		
		Calendar shen = Calendar.getInstance();

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		
		
		shen.setTime(df.parse("1992-12"));//受理时间
		
		System.out.println(df.format(shen.getTime()));
		
		shen.add(Calendar.YEAR, 15);
		
		System.out.println(df.format(shen.getTime()));
		
//		SimpleDateFormat dfYM = new SimpleDateFormat("yyyy-MM");
		
		
	}
	
}
