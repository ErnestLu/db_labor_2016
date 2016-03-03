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
		
		wUtil.addTian("���ݣ���ְ����Ա������", WordUtil.fHei22, Element.ALIGN_CENTER, 2, 2);
		
		
		wUtil.addTian(" ", WordUtil.fHei22, Element.ALIGN_LEFT, 4, 4);
		
		
		wUtil.addPhrase("���", WordUtil.fFang);
//TODO  ���
//		wUtil.addPhrase(": " + person.getAcceptNo() + person.getRemark() + "��"+person.getNumber()+"    ", WordUtil.fTimes);
		wUtil.addPhrase(": " + person.getAcceptNo() + person.getApproveperson() + "��"+person.getNumber()+"       ", WordUtil.fTimes);
		wUtil.addPhrase(Util.getKeshi(person.getOffice()), WordUtil.fUnderLine);
		
		
		wUtil.addTian(" ", WordUtil.fTian1, Element.ALIGN_LEFT, 1, 21);
		wUtil.addPhrase(" \n", WordUtil.fTian3);
		
		if (person.getType() ==1 && person.getCompany().matches("����")){
			wUtil.addGeTiZhenWen(person);
		} else {
			wUtil.addZhenWen(person);
		}
		
		
		
		wUtil.addTian("	", WordUtil.fFang, Element.ALIGN_LEFT, 5, 0);
//TODO	����޸ı�ע
		
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
		
		
		wUtil.addTian("�����ǩ��:                        ��   �£�", WordUtil.fFang, Element.ALIGN_LEFT, 20, 20);
		
		//TODO �̶�����ʱ��
		wUtil.addTime(person);
//		wUtil.addTime1(person);
		
		
		wUtil.addTian("", WordUtil.fFang, Element.ALIGN_LEFT, 40, 40);
		
		
		wUtil.addTian("ע: ��������һʽ�ķݣ�������Դ����ᱣ�Ͼ����ϱ��տơ�������Դ����ᱣ�Ͼ������졢���˵�������ᱣ�վ������������һ�ݡ�", WordUtil.fFang12, Element.ALIGN_LEFT, 2, 2);
		
		
		wUtil.addTian("", WordUtil.fFang, Element.ALIGN_LEFT, 0, 0);
		
//		wUtil.addTian("", WordUtil.fFang, Element.ALIGN_LEFT, 0, 0);
		
		
		if(hasNewPage) {
			wUtil.newPage();	
		}
		
//		wUtil.wordClose();

	}

}
