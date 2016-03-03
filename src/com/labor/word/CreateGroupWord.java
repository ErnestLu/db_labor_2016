package com.labor.word;

import java.io.IOException;

import com.labor.util.WordUtil;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;

public class CreateGroupWord {

	/**
	 * @param file
	 * @param person
	 * @throws DocumentException 
	 * @throws DocumentException
	 * @throws IOException
	 */
	public void createDocContext(WordUtil wUtil, Person person,Boolean hasNewPage) throws DocumentException {
		
		
//		WordUtil wUtil = WordUtil.getInstance();
//		
//		wUtil.wordOpen();
		
		wUtil.addTian("退休（退职）人员审批单", WordUtil.fHei22, Element.ALIGN_CENTER, 2, 2);
		
		
		wUtil.addTian(" ", WordUtil.fHei22, Element.ALIGN_LEFT, 4, 4);
		
		
		wUtil.addPhrase("编号", WordUtil.fFang);
//TODO  编号
//		wUtil.addPhrase(": " + person.getAcceptNo() + person.getRemark() + "—"+person.getNumber()+"    ", WordUtil.fTimes);
		wUtil.addPhrase(": " + person.getAcceptNo() + person.getApproveperson() + "—"+person.getNumber()+"       ", WordUtil.fTimes);
		wUtil.addPhrase(Util.getKeshi(person.getOffice()), WordUtil.fUnderLine);
		
		
		wUtil.addTian(" ", WordUtil.fTian1, Element.ALIGN_LEFT, 1, 21);
		wUtil.addPhrase(" \n", WordUtil.fTian3);
		
		if (person.getType() ==1 && person.getCompany().matches("个体")){
			wUtil.addGeTiZhenWen(person);
		} else {
			wUtil.addZhenWen(person);
		}
		
		
		
		wUtil.addTian("	", WordUtil.fFang, Element.ALIGN_LEFT, 5, 0);
//TODO	添加修改备注
		
//		if (!("".equals(person.getRemark()) || person.getRemark() == null)) {
//			wUtil.addTian("    " + person.getRemark(), WordUtil.fFang, Element.ALIGN_LEFT, 0, 0);
//		}
		if(wUtil.isCut(person)) {
			wUtil.addCut(person);
		}
		
		if("" != person.getExtra1()){
			wUtil.addTian(person.getExtra1(), WordUtil.fFang, Element.ALIGN_LEFT, 0, 0);
		} 
//		if("" != person.getExtra2()){
			wUtil.addTian(person.getExtra2(), WordUtil.fFang, Element.ALIGN_LEFT, 0, 0);
//		} 
		
		wUtil.addTian("	", WordUtil.fFang, Element.ALIGN_LEFT, 0, 10);
		
		wUtil.addTian("	", WordUtil.fFang, Element.ALIGN_LEFT, 10, 10);
		
		
		wUtil.addTian("审核人签字:                        盖   章：", WordUtil.fFang, Element.ALIGN_LEFT, 20, 20);
		
		//TODO 固定审批时间
		wUtil.addTime(person);
//		wUtil.addTime1(person);
		
		
		wUtil.addTian("", WordUtil.fFang, Element.ALIGN_LEFT, 40, 40);
		
		
		wUtil.addTian("注: 本审批单一式四份，人力资源和社会保障局养老保险科、人力资源和社会保障局审批办、本人档案、社会保险经办机构各留存一份。", WordUtil.fFang12, Element.ALIGN_LEFT, 2, 2);
		
		
		wUtil.addTian("", WordUtil.fFang, Element.ALIGN_LEFT, 0, 0);
		
//		wUtil.addTian("", WordUtil.fFang, Element.ALIGN_LEFT, 0, 0);
		
		
		if(hasNewPage) {
			wUtil.newPage();	
		}
		
//		wUtil.wordClose();

	}

}
