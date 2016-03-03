package com.labor.word;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.labor.util.Db_Util;
import com.labor.util.WordUtil;
import com.lowagie.text.DocumentException;

public class CreateGroup {
	public static void main(String[] args) throws ParseException, DocumentException  {

		
		List<Person> list = new ArrayList<Person>();
		
		int approveperson = 0;


		
		
		
		
		
		
//		,"2016-04-30"
//		,"2016-11-30"
//      ,"2","19","19"
		
		approveperson = 3;
//		approveperson = 2;
//		approveperson = 1;
//		approveperson = 4;

//		ȫ	4444
		

///////////////////////////////////////////////////////////////////////////////////////////////////////

		
//6666

//		approveperson = 1;
//		approveperson = 2;
//		approveperson = 4;

		
//      ,"2","19","19"		
//		,"2015-01-30"

		
		
		

		

		
		
		Iterator<Person> it = list.iterator();
		
		
		CreateGroupWord gWord = new CreateGroupWord(); 
		
		Db_Util db = Db_Util.getInstance();
		
		WordUtil wUtil = WordUtil.getInstance();
		wUtil.wordOpen();
		
		boolean isHaveWorng = false;
		
		while(it.hasNext() && isHaveWorng == false) {
			Person person = it.next();
			
			if(approveperson != 0){
				person.setApproveperson(approveperson);
			}
			
			if (Util.check(person)) {
				db.addOnePerson(person);
				gWord.createDocContext(wUtil, person,it.hasNext());
			} else {
				isHaveWorng = true;
			}
		}
		
		if (isHaveWorng == false) {
			db.commit();
		}
		
		wUtil.wordClose();
		db.shutdown();
		
		
	
//		Calendar bron = Calendar.getInstance();
//		Calendar join = Calendar.getInstance();
//		Calendar shen = Calendar.getInstance();
//
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
//		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
//
//		Person person = new Person();
//
//		
//		
//		person.setId("0912210158860024             ");//���
//		person.setName("������");//����
//
//		person.setComp("�ڻ�����");//��˾
//		
//		person.setKesh(1);//���� 1-ҵ��һ�ƣ�2-ҵ����ƣ�3-ҵ�����ƣ�4-ֱ��
//
//
//		person.setSex(1);//�Ա� 1-�У�2-Ů
//		
//		
//		bron.setTime(df.parse("1949-12"));//��������
//		join.setTime(df.parse("1969-10"));//�μӹ���ʱ��
//		
//		
//		person.setType(1);//��� 1-���ˣ�2-�ɲ�
//		
//		person.setShenfen(1);//���� 1-������2-���ˣ�3-���⹤�֣�4-��ְ�� 5-�Ʋ�
//
//		
//
//		shen.setTime(df1.parse("2009-11-30"));//����ʱ��
//		
//		if(person.getShenfen() == 2) {
//		
//			person.setBingNum(111);//���˺�
//			
//		}
//
//		
//		person.setBorn(bron);
//		person.setJoin(join);
//		
//		person.setShen(shen);
//		
//		
//		
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
//		
		
	}
}