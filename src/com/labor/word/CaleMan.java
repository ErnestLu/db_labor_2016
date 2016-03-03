package com.labor.word;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CaleMan {

	public static void main(String[] args) throws ParseException {

		String join = "1988-11";// 参加工作时间
		String shen = "2011-10";// 退休时间

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");

		Calendar join1 = Calendar.getInstance();
		Calendar shen1 = Calendar.getInstance();

		join1.setTime(df.parse(join));
		shen1.setTime(df.parse(shen));

		int age = Util.getMonthNum(join1, shen1);

		System.out.println("缴费年限为：" + age / 12 + "年" + age % 12 + "月");

	}
}
