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

//		全	4444
		

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
//		person.setId("0912210158860024             ");//编号
//		person.setName("李文庆");//姓名
//
//		person.setComp("众环集团");//公司
//		
//		person.setKesh(1);//科室 1-业务一科，2-业务二科，3-业务三科，4-直属
//
//
//		person.setSex(1);//性别 1-男，2-女
//		
//		
//		bron.setTime(df.parse("1949-12"));//出生年月
//		join.setTime(df.parse("1969-10"));//参加工作时间
//		
//		
//		person.setType(1);//身份 1-工人，2-干部
//		
//		person.setShenfen(1);//类型 1-正常，2-病退，3-特殊工种，4-退职， 5-破产
//
//		
//
//		shen.setTime(df1.parse("2009-11-30"));//受理时间
//		
//		if(person.getShenfen() == 2) {
//		
//			person.setBingNum(111);//病退号
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