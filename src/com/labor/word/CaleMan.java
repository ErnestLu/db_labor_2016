package com.labor.word;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CaleMan {

	public static void main(String[] args) throws ParseException {

		String join = "1988-11";// �μӹ���ʱ��
		String shen = "2011-10";// ����ʱ��

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");

		Calendar join1 = Calendar.getInstance();
		Calendar shen1 = Calendar.getInstance();

		join1.setTime(df.parse(join));
		shen1.setTime(df.parse(shen));

		int age = Util.getMonthNum(join1, shen1);

		System.out.println("�ɷ�����Ϊ��" + age / 12 + "��" + age % 12 + "��");

	}
}
