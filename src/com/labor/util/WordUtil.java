package com.labor.util;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.labor.word.Person;
import com.labor.word.Util;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.rtf.RtfWriter2;
import com.lowagie.text.rtf.style.RtfFont;

public class WordUtil {

	private static WordUtil word ;

	/**
	 * Word�ĵ�
	 */
//	private Document document = new Document(PageSize.A4, 2540, 2540, 3180, 3180);
	private Document document = new Document(PageSize.A4, 3700, 3700, 2800, 2800);
	
	/**
	 * �ļ����·��
	 */
	private static String word_name = "e:/demo1.doc";

	private WordUtil() throws FileNotFoundException {
		RtfWriter2.getInstance(document, new FileOutputStream(word_name));
		
	}
	
	/**
	 * ���ʵ��
	 * @return
	 */
	public static WordUtil getInstance()  {
		if (word == null)
			try {
				word = new WordUtil();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		return word;
	}
	
	/**
	 * ���ĵ�
	 * @return
	 */
	public boolean wordOpen() {
		document.open();
		return document.isOpen();
	}
	
	/**
	 * �ر��ĵ�
	 */
	public void wordClose() {
		document.close();
	}

//	private WordUtil(String file)  {
//		
//		try {
//			RtfWriter2.getInstance(document, new FileOutputStream(word_name));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//
//		document.open();
//		
//	}
	
//	public void addTitle() throws DocumentException {
//		Paragraph title = new Paragraph("���ݣ���ְ����Ա������");
//		// ���ñ����ʽ���뷽ʽ
//		title.setAlignment(Element.ALIGN_CENTER);
//		title.setFont(fHei22);
//		title.setSpacingBefore(2);
//		title.setSpacingAfter(2);
//		document.add(title);
//	}
	
	public void addTian(String text, RtfFont font, int alig, int before,
			int after) throws DocumentException {
		if ("".equals(text) || text == null) {
			text = "";
		}
		Paragraph tianchang1 = new Paragraph(text, font);
		tianchang1.setAlignment(alig);
		if (before > 1) {
			tianchang1.setSpacingBefore(before);
		}

		if (after > 1) {
			tianchang1.setSpacingAfter(after);
		}

		document.add(tianchang1);
	}
	
	public void addPhrase(String text, RtfFont font) throws DocumentException {
		Phrase bianhao = new Phrase(text, font);
		document.add(bianhao);
	}
	
	
	/**
	 * 	��������
	 * @param person
	 * @throws DocumentException
	 */
	public void addGeTiZhenWen(Person person) throws DocumentException {
		// ��������
		Phrase Context01 = new Phrase();

		List<Phrase> list = new ArrayList<Phrase>();
		list.add(new Phrase("    ����˸�������ҵ��Ա", fFang));
		list.add(new Phrase("  " + person.getName() + "  ", fUnderLine));
		list.add(new Phrase("ͬ־���Ա�", fFang));
		list.add(new Phrase(Util.getSex(person.getSex()), fUnderLine));
		list.add(new Phrase("������", fFang));
		list.add(new Phrase(Util.getNation(person.getNation()), fUnderLine));
		list.add(new Phrase("��", fFang));
		list.add(new Phrase("  " + person.getBorn().get(Calendar.YEAR) + "  ", fUnderLineNum));
		list.add(new Phrase("��", fFang));
		list.add(new Phrase("  " + (person.getBorn().get(Calendar.MONTH) + 1) + "  ", fUnderLineNum));
		list.add(new Phrase("�³�������ͬ־��", fFang));
		list.add(new Phrase("  " + person.getJoin().get(Calendar.YEAR) + "  ", fUnderLineNum));
		list.add(new Phrase("��", fFang));
		list.add(new Phrase("  " + (person.getJoin().get(Calendar.MONTH) + 1) + "  ", fUnderLineNum));
//		list.add(new Phrase("�²μӹ������ɷ�����Ϊ", fFang));
		list.add(new Phrase("�²μ����ϱ��ա���׼�����ݡ�", fFang));
		

		Context01.addAll(list);

		Paragraph Context = new Paragraph(Context01);

		Context.setLeading(31);
		Context.setExtraParagraphSpace(20);
		// Context.setSpacingBefore(20);
		// Context.setSpacingAfter(20);
		document.add(Context);
	}
	
	
	/**
	 * 	����
	 * @param person
	 * @throws DocumentException
	 */
	public void addZhenWen(Person person) throws DocumentException {
		// ����
		Phrase Context01 = new Phrase();

		List<Phrase> list = new ArrayList<Phrase>();
		list.add(new Phrase("    ����ˣ�", fFang));
		list.add(new Phrase("  " + person.getCompany() + "  ", fUnderLine));
		list.add(new Phrase("��λ��", fFang));
		list.add(new Phrase("  " + person.getName() + "  ", fUnderLine));
		list.add(new Phrase("ͬ־���Ա�", fFang));
		list.add(new Phrase(Util.getSex(person.getSex()), fUnderLine));
		list.add(new Phrase("������", fFang));
		list.add(new Phrase(Util.getNation(person.getNation()), fUnderLine));
		list.add(new Phrase("����������", fFang));
		list.add(new Phrase("  " + person.getBorn().get(Calendar.YEAR) + "  ", fUnderLineNum));
		list.add(new Phrase("��", fFang));
		list.add(new Phrase("  " + (person.getBorn().get(Calendar.MONTH) + 1) + "  ", fUnderLineNum));
		list.add(new Phrase("�³�����", fFang));
		list.add(new Phrase(Util.getType(person.getIdentity()), fUnderLineNum));
		list.add(new Phrase("��ݡ���ͬ־��", fFang));
		list.add(new Phrase("  " + person.getJoin().get(Calendar.YEAR) + "  ", fUnderLineNum));
		list.add(new Phrase("��", fFang));
		list.add(new Phrase("  " + (person.getJoin().get(Calendar.MONTH) + 1) + "  ", fUnderLineNum));
//		list.add(new Phrase("�²μӹ������ɷ�����Ϊ", fFang));
		list.add(new Phrase("�²μӹ��������ݡ�����Ժ���ڹ���������ְ�����а취��������", fFang));
		list.add(new Phrase("[1978]104", fTimes));
		list.add(new Phrase("�ţ���", fFang));
		

		
//		if(person.getApproveTime() != null) {
//			list.add(new Phrase("  " + person.getApproveTime().get(Calendar.YEAR) + "  ",fUnderLineNum));
//			list.add(new Phrase("��", fFang));
////			int temp = Util.getMonth(person);
//			list.add(new Phrase("  " + (person.getApproveTime().get(Calendar.MONTH) + 1) + "  ", fUnderLineNum));
//			list.add(new Phrase("�´ﵽ�������䣬", fFang));
//		}
		
		
		
//		if(person.getApproveTime() == null && person.getType() == 1) {
//			list.add(new Phrase("  " + Util.getRetireYear(person) + "  ",fUnderLineNum));
//			list.add(new Phrase("��", fFang));
////			int temp = Util.getMonth(person);
//			list.add(new Phrase("  " + (person.getBorn().get(Calendar.MONTH) + 1) + "  ", fUnderLineNum));
//			list.add(new Phrase("�´ﵽ�������䣬", fFang));
//		}
		
		
		
		if (person.getType() == 2) {
			
//			list.add(new Phrase("  " + person.getApproveTime().get(Calendar.YEAR) + "  ",fUnderLineNum));
//			list.add(new Phrase("��", fFang));
////			int temp = Util.getMonth(person);
//			list.add(new Phrase("  " + (person.getApproveTime().get(Calendar.MONTH) + 1) + "  ", fUnderLineNum));
//			list.add(new Phrase("��", fFang));
			
			list.add(new Phrase("����", fFang));
			list.add(new Phrase(Util.getShenfen(person.getType()), fUnderLine));
			list.add(new Phrase("��ǰ����", fFang));
			if (person.getType() == 2) {
				list.add(new Phrase("�����ͼ��ǹ���", fFang));
				list.add(new Phrase(person.getBingNum().substring(0, 4), fTimes));
				list.add(new Phrase("����", fFang));
//				list.add(new Phrase("0", fTimes));
				list.add(new Phrase(person.getBingNum().substring(5, 8) + "", fTimes));
				list.add(new Phrase("�ţ�", fFang));
			}
			list.add(new Phrase("����׼�����ݡ�", fFang));

		} else if (person.getType() == 4) {
			
//			list.add(new Phrase("  " + person.getApproveTime().get(Calendar.YEAR) + "  ",fUnderLineNum));
//			list.add(new Phrase("��", fFang));
////			int temp = Util.getMonth(person);
//			list.add(new Phrase("  " + (person.getApproveTime().get(Calendar.MONTH) + 1) + "  ", fUnderLineNum));
//			list.add(new Phrase("��", fFang));

			list.add(new Phrase("����", fFang));
			list.add(new Phrase(Util.getShenfen(person.getType()), fUnderLine));
			list.add(new Phrase("��ǰ��ְ", fFang));
			if (person.getType() == 4) {
				list.add(new Phrase("�����ͼ��ǹ���", fFang));
				list.add(new Phrase(person.getBingNum().substring(0, 4), fTimes));
				list.add(new Phrase("����", fFang));
//				list.add(new Phrase("0", fTimes));
				list.add(new Phrase(person.getBingNum().substring(5, 8) + "", fTimes));
				list.add(new Phrase("�ţ�", fFang));
			}
			list.add(new Phrase("����׼����ְ��", fFang));

		} else if (person.getType() == 3 || person.getType() == 5) {
			
//			list.add(new Phrase("  " + person.getApproveTime().get(Calendar.YEAR) + "  ",fUnderLineNum));
//			list.add(new Phrase("��", fFang));
////			int temp = Util.getMonth(person);
//			list.add(new Phrase("  " + (person.getApproveTime().get(Calendar.MONTH) + 1) + "  ", fUnderLineNum));
//			list.add(new Phrase("��", fFang));
			
			list.add(new Phrase("����", fFang));
			list.add(new Phrase(Util.getShenfen(person.getType()), fUnderLine));
			list.add(new Phrase("��ǰ����", fFang));
			list.add(new Phrase("����׼�����ݡ�", fFang));
			
		} if (person.getType() == 6) {
			
//			list.add(new Phrase("  " + person.getApproveTime().get(Calendar.YEAR) + "  ",fUnderLineNum));
//			list.add(new Phrase("��", fFang));
////			int temp = Util.getMonth(person);
//			list.add(new Phrase("  " + (person.getApproveTime().get(Calendar.MONTH) + 1) + "  ", fUnderLineNum));
//			list.add(new Phrase("��", fFang));
			
			list.add(new Phrase("����", fFang));
			list.add(new Phrase(Util.getShenfen(person.getType()), fUnderLine));
			list.add(new Phrase("��ǰ����", fFang));
			list.add(new Phrase("����׼�����ݡ�", fFang));
			
		} else if (person.getType() == 1) {
			
//			������ʱ��
//			list.add(new Phrase("  " + person.getApproveTime().get(Calendar.YEAR) + "  ",fUnderLineNum));
//			list.add(new Phrase("��", fFang));
//			list.add(new Phrase("  " + (person.getApproveTime().get(Calendar.MONTH) + 1) + "  ", fUnderLineNum));
//			list.add(new Phrase("��", fFang));
			
			
			list.add(new Phrase("����", fFang));
			list.add(new Phrase(Util.getShenfen(person.getType()), fUnderLine));
			list.add(new Phrase("����", fFang));
			list.add(new Phrase("����׼�����ݡ�", fFang));

		}
		
		
		

		Context01.addAll(list);

		Paragraph Context = new Paragraph(Context01);

		Context.setLeading(31);
		Context.setExtraParagraphSpace(20);
		// Context.setSpacingBefore(20);
		// Context.setSpacingAfter(20);
		document.add(Context);
	}
	
	public void addTime(Person person) throws DocumentException {

//TODO	���Ĵ�ӡʱ�� / ��������ʱ��
//		Calendar c3 = person.getApproveTime();
		Calendar c3 = Calendar.getInstance();
//		Calendar c3 = person.getAddTime();

//		if (person.getType() == 2 || person.getType() == 3) {
//			c3 = person.getApproveTime();
//		}
		
//		if (person.getType() ==1 && person.getCompany().matches("����")) {
//			c3 = person.getApproveTime();
//		}
		
//TODO �޸� ��ӡ������������ʱ��
//		Calendar c3 = Calendar.getInstance();	//��ӡʱ��
//		c3 = person.getApproveTime();			//����ʱ��
		c3 = person.getAccepttime();    		//����ʱ��
		

		List<Phrase> list1 = new ArrayList<Phrase>();
		list1.add(new Phrase("                              ", fFang));
		list1.add(new Phrase("" + (c3.get(Calendar.YEAR)), fTimes));
		list1.add(new Phrase(" �� ", fFang));
		list1.add(new Phrase("" + (c3.get(Calendar.MONTH) + 1), fTimes));
		list1.add(new Phrase(" �� ", fFang));
		list1.add(new Phrase("" + (c3.get(Calendar.DAY_OF_MONTH)), fTimes));
		list1.add(new Phrase(" �� ", fFang));

		Phrase p1 = new Phrase();
		p1.addAll(list1);

		Paragraph Con4 = new Paragraph(p1);

		Con4.setSpacingBefore(2);
		Con4.setSpacingAfter(2);
		document.add(Con4);
	}
	
	
public void addTime1(Person person) throws DocumentException {
		
//		Calendar c3 = person.getApproveTime();
	
	
//		Calendar c3 = Calendar.getInstance();
//		if (person.getType() == 2 || person.getType() == 3) {
//			c3 = person.getApproveTime();
//		}

		List<Phrase> list1 = new ArrayList<Phrase>();
		list1.add(new Phrase("                              ", fFang));
		list1.add(new Phrase("2014", fTimes));
		list1.add(new Phrase(" �� ", fFang));
		list1.add(new Phrase("12", fTimes));
		list1.add(new Phrase(" �� ", fFang));
		list1.add(new Phrase("31", fTimes));
		list1.add(new Phrase(" �� ", fFang));

		Phrase p1 = new Phrase();
		p1.addAll(list1);

		Paragraph Con4 = new Paragraph(p1);

		Con4.setSpacingBefore(2);
		Con4.setSpacingAfter(2);
		document.add(Con4);
	}
	
	public void newPage() {
		document.newPage();
	}
	
	public boolean isCut(Person person) {
		
		int cut = 0;
		
		if (person.getIfaddorcut() != null) {
			cut = Util.getMonthNum(person.getAddorcutbegin(), person.getAddorcutend());
		}
		
		
		if(cut == 0) {
			return false;
		}
		
		return true;
	}
	
	public void addCut(Person person) throws DocumentException {
		// �˼���Ϣ
		Phrase Context01 = new Phrase();
		List<Phrase> list = new ArrayList<Phrase>();
		if (person.getIfaddorcut() == "1") {
			list.add(new Phrase("    ", fFang));
			list.add(new Phrase("" + person.getAddorcutbegin().get(Calendar.YEAR), fTimes));
			list.add(new Phrase("��", fFang));
			list.add(new Phrase("" + (person.getAddorcutbegin().get(Calendar.MONTH) + 1), fTimes));
			list.add(new Phrase("�¡�", fFang));
			list.add(new Phrase("" + person.getAddorcutend().get(Calendar.YEAR), fTimes));
			list.add(new Phrase("��", fFang));
			list.add(new Phrase("" + (person.getAddorcutend().get(Calendar.MONTH) + 1), fTimes));
			list.add(new Phrase("�¼��㹤��", fFang));
		} else if (person.getIfaddorcut() == "2") {
			list.add(new Phrase("    �˼�", fFang));
			list.add(new Phrase("" + person.getAddorcutbegin().get(Calendar.YEAR), fTimes));
			list.add(new Phrase("��", fFang));
			list.add(new Phrase("" + (person.getAddorcutbegin().get(Calendar.MONTH) + 1), fTimes));
			list.add(new Phrase("�¡�", fFang));
			list.add(new Phrase("" + person.getAddorcutend().get(Calendar.YEAR), fTimes));
			list.add(new Phrase("��", fFang));
			list.add(new Phrase("" + (person.getAddorcutend().get(Calendar.MONTH) + 1), fTimes));
			list.add(new Phrase("�¹���", fFang));
		}
		
		

		Context01.addAll(list);

		Paragraph Context = new Paragraph(Context01);

		document.add(Context);
	}
	
	
	
	public static String song = "�� ��";
	
	/**
	 * ������������
	 */
	public static RtfFont fHei22 = new RtfFont("�� ��", 22, Font.NORMAL, Color.BLACK);

	/**
	 * ���
	 */
	public static RtfFont fTian1 = new RtfFont("�� ��", 1, Font.NORMAL, Color.BLACK);

	/**
	 * ���
	 */
	public static RtfFont fTian2 = new RtfFont("�� ��", 7, Font.NORMAL, Color.BLACK);

	/**
	 * ���
	 */
//	public static RtfFont fTian3 = new RtfFont("�� �� _GB2312", 10, Font.NORMAL, Color.BLACK);
	public static RtfFont fTian3 = new RtfFont(song, 10, Font.NORMAL, Color.BLACK);

	/**
	 * ����
	 */
	public static RtfFont fFang = new RtfFont(song, 16, Font.NORMAL, Color.BLACK);
//	public static RtfFont fFang = new RtfFont("�� �� _GB2312", 16, Font.NORMAL, Color.BLACK);

	/**
	 * ����С��
	 */
	public static RtfFont fFang12 = new RtfFont(song, 12, Font.NORMAL,Color.BLACK);
//	public static RtfFont fFang12 = new RtfFont("�� �� _GB2312", 12, Font.NORMAL,Color.BLACK);

	/**
	 * Times New Roman
	 */
	public static RtfFont fTimes = new RtfFont("Times New Roman", 16, Font.NORMAL, Color.BLACK);

	/**
	 * �»���
	 */
	public static RtfFont fUnderLine = new RtfFont(song, 16, Font.UNDERLINE, Color.BLACK);
//	public static RtfFont fUnderLine = new RtfFont("�� �� _GB2312", 16, Font.UNDERLINE, Color.BLACK);

	/**
	 * �»�������
	 */
	public static RtfFont fUnderLineNum = new RtfFont("Times New Roman", 16, Font.UNDERLINE, Color.BLACK);

}
