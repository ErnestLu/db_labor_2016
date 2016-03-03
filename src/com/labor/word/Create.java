package com.labor.word;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.labor.util.Db_Util;
import com.labor.util.WordUtil;
import com.lowagie.text.DocumentException;

public class Create {
	public static void main(String[] args) throws DocumentException,
			IOException, ParseException {

		Calendar bron = Calendar.getInstance();
		Calendar join = Calendar.getInstance();
		Calendar shen = Calendar.getInstance();
		
		Calendar cutbejin =  Calendar.getInstance();
		Calendar cutend = Calendar.getInstance();

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");

		Person person = new Person();

		
		person.setAcceptNo("1105260158860269 ");//���
		person.setName("������");//����

		person.setCompany("ԭ����ӡˢ��");//��˾
		
		person.setOffice(3);//���� 1-ҵ��һ�ƣ�2-ҵ����ƣ�3-ҵ�����ƣ�4-ֱ��


		person.setSex(1);//�Ա� 1-�У�2-Ů
		
		person.setNation(1);//����
		
		
		bron.setTime(df.parse("1964-02"));//��������
		join.setTime(df.parse("1986-04"));//�μӹ���ʱ��
		
		
		person.setIdentity(1);//��� 1-���ˣ�2-�ɲ�
		
		person.setType(4);//���� 1-������2-���ˣ�3-���⹤�֣�4-��ְ�� 5-�Ʋ�

		
		shen.setTime(df1.parse("2011-02-30"));//����ʱ��
//		shen.setTime(df1.parse("2009-11-30"));//����ʱ��
		
		if(person.getType() == 2 || person.getType() == 4) {
		
			person.setBingNum("2012-163");//���˺�
		}

		
		
		cutbejin.setTime(df.parse("1977-06"));//�˼���ʼʱ��
		cutend.setTime(df.parse("1978-07"));  //�˼�����ʱ��
		
		
//		addbejin.setTime(df.parse(""))

//		person.setExtra1("    ���ѹʳ���");//������Ϣ
//		person.setExtra2("    ������д");

	
		
		
		person.setAddorcutbegin(cutbejin);
		person.setAddorcutend(cutend);

		
		person.setBorn(bron);
		person.setJoin(join);
		
		person.setApproveTime(shen);
		

		
		
		
		CreateGroupWord gWord = new CreateGroupWord();

		Db_Util db = Db_Util.getInstance();

		WordUtil wUtil = WordUtil.getInstance();
		wUtil.wordOpen();

		if (Util.check(person)) {
			db.addOnePerson(person);
			gWord.createDocContext(wUtil, person, false);
		}

		wUtil.wordClose();
		db.shutdown();
		
		
//		Db_Util db = Db_Util.getInstance();
//		db.insertStatement(person);
//		db.shutdown();
//
//		
//		CreateWord word = new CreateWord();
//		String file = "d:/demo1.doc";
//		
//		if (Util.check(person)) {
//			try {
//				word.createDocContext(file, person);
//			} catch (DocumentException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
		
		
	}
}
