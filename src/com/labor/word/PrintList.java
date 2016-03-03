package com.labor.word;

import java.util.Iterator;
import java.util.List;

import com.labor.util.Db_Util;
import com.labor.util.WordUtil;
import com.lowagie.text.DocumentException;

public class PrintList {
	
	public static void main(String[] args) throws DocumentException {
		Db_Util db = Db_Util.getInstance();
		
		List<Person> list = db.getPersonList();
		
		Iterator<Person> it = list.iterator();
		
		
		
		CreateGroupWord gWord = new CreateGroupWord(); 
		
//		Db_Util db = Db_Util.getInstance();
		
		WordUtil wUtil = WordUtil.getInstance();
		wUtil.wordOpen();
		
		boolean isHaveWorng = false;
		
		while(it.hasNext() && isHaveWorng == false) {
			Person person = it.next();
			
//			if(approveperson != 0){
//				person.setApproveperson(approveperson);
//			}
			
			if (Util.check(person)) {
//				db.addOnePerson(person);
				gWord.createDocContext(wUtil, person,it.hasNext());
			} else {
				isHaveWorng = true;
			}
		}
		
//		if (isHaveWorng == false) {
//			db.commit();
//		}
		
		wUtil.wordClose();
		db.shutdown();
		
//		while (it.hasNext() == true) {
//
//			Person person = it.next();
//			
//			System.out.print(person.getAcceptNo() + " ");
//			
//			System.out.print(person.getName() + " ");
//			
////			System.out.print("");
////			
////			System.out.print("");
//			
//			System.out.println("");
//			
//
//			
//
//		}
	}
	
}
