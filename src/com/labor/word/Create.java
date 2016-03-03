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

		
		person.setAcceptNo("1105260158860269 ");//编号
		person.setName("秦树根");//姓名

		person.setCompany("原呼市印刷厂");//公司
		
		person.setOffice(3);//科室 1-业务一科，2-业务二科，3-业务三科，4-直属


		person.setSex(1);//性别 1-男，2-女
		
		person.setNation(1);//民族
		
		
		bron.setTime(df.parse("1964-02"));//出生年月
		join.setTime(df.parse("1986-04"));//参加工作时间
		
		
		person.setIdentity(1);//身份 1-工人，2-干部
		
		person.setType(4);//类型 1-正常，2-病退，3-特殊工种，4-退职， 5-破产

		
		shen.setTime(df1.parse("2011-02-30"));//受理时间
//		shen.setTime(df1.parse("2009-11-30"));//受理时间
		
		if(person.getType() == 2 || person.getType() == 4) {
		
			person.setBingNum("2012-163");//病退号
		}

		
		
		cutbejin.setTime(df.parse("1977-06"));//核减开始时间
		cutend.setTime(df.parse("1978-07"));  //核减结束时间
		
		
//		addbejin.setTime(df.parse(""))

//		person.setExtra1("    补费故超月");//额外信息
//		person.setExtra2("    申请已写");

	
		
		
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
