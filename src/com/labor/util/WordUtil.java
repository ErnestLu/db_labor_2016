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
	 * Word文档
	 */
//	private Document document = new Document(PageSize.A4, 2540, 2540, 3180, 3180);
	private Document document = new Document(PageSize.A4, 3700, 3700, 2800, 2800);
	
	/**
	 * 文件输出路径
	 */
	private static String word_name = "e:/demo1.doc";

	private WordUtil() throws FileNotFoundException {
		RtfWriter2.getInstance(document, new FileOutputStream(word_name));
		
	}
	
	/**
	 * 获得实例
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
	 * 打开文档
	 * @return
	 */
	public boolean wordOpen() {
		document.open();
		return document.isOpen();
	}
	
	/**
	 * 关闭文档
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
//		Paragraph title = new Paragraph("退休（退职）人员审批单");
//		// 设置标题格式对齐方式
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
	 * 	个体正文
	 * @param person
	 * @throws DocumentException
	 */
	public void addGeTiZhenWen(Person person) throws DocumentException {
		// 个体正文
		Phrase Context01 = new Phrase();

		List<Phrase> list = new ArrayList<Phrase>();
		list.add(new Phrase("    经审核个体灵活就业人员", fFang));
		list.add(new Phrase("  " + person.getName() + "  ", fUnderLine));
		list.add(new Phrase("同志，性别", fFang));
		list.add(new Phrase(Util.getSex(person.getSex()), fUnderLine));
		list.add(new Phrase("，民族", fFang));
		list.add(new Phrase(Util.getNation(person.getNation()), fUnderLine));
		list.add(new Phrase("，", fFang));
		list.add(new Phrase("  " + person.getBorn().get(Calendar.YEAR) + "  ", fUnderLineNum));
		list.add(new Phrase("年", fFang));
		list.add(new Phrase("  " + (person.getBorn().get(Calendar.MONTH) + 1) + "  ", fUnderLineNum));
		list.add(new Phrase("月出生。该同志于", fFang));
		list.add(new Phrase("  " + person.getJoin().get(Calendar.YEAR) + "  ", fUnderLineNum));
		list.add(new Phrase("年", fFang));
		list.add(new Phrase("  " + (person.getJoin().get(Calendar.MONTH) + 1) + "  ", fUnderLineNum));
//		list.add(new Phrase("月参加工作，缴费年限为", fFang));
		list.add(new Phrase("月参加养老保险。现准予退休。", fFang));
		

		Context01.addAll(list);

		Paragraph Context = new Paragraph(Context01);

		Context.setLeading(31);
		Context.setExtraParagraphSpace(20);
		// Context.setSpacingBefore(20);
		// Context.setSpacingAfter(20);
		document.add(Context);
	}
	
	
	/**
	 * 	正文
	 * @param person
	 * @throws DocumentException
	 */
	public void addZhenWen(Person person) throws DocumentException {
		// 正文
		Phrase Context01 = new Phrase();

		List<Phrase> list = new ArrayList<Phrase>();
		list.add(new Phrase("    经审核，", fFang));
		list.add(new Phrase("  " + person.getCompany() + "  ", fUnderLine));
		list.add(new Phrase("单位，", fFang));
		list.add(new Phrase("  " + person.getName() + "  ", fUnderLine));
		list.add(new Phrase("同志，性别", fFang));
		list.add(new Phrase(Util.getSex(person.getSex()), fUnderLine));
		list.add(new Phrase("，民族", fFang));
		list.add(new Phrase(Util.getNation(person.getNation()), fUnderLine));
		list.add(new Phrase("，档案记载", fFang));
		list.add(new Phrase("  " + person.getBorn().get(Calendar.YEAR) + "  ", fUnderLineNum));
		list.add(new Phrase("年", fFang));
		list.add(new Phrase("  " + (person.getBorn().get(Calendar.MONTH) + 1) + "  ", fUnderLineNum));
		list.add(new Phrase("月出生，", fFang));
		list.add(new Phrase(Util.getType(person.getIdentity()), fUnderLineNum));
		list.add(new Phrase("身份。该同志于", fFang));
		list.add(new Phrase("  " + person.getJoin().get(Calendar.YEAR) + "  ", fUnderLineNum));
		list.add(new Phrase("年", fFang));
		list.add(new Phrase("  " + (person.getJoin().get(Calendar.MONTH) + 1) + "  ", fUnderLineNum));
//		list.add(new Phrase("月参加工作，缴费年限为", fFang));
		list.add(new Phrase("月参加工作。根据《国务院关于工人退休退职的暂行办法》（国发", fFang));
		list.add(new Phrase("[1978]104", fTimes));
		list.add(new Phrase("号），", fFang));
		

		
//		if(person.getApproveTime() != null) {
//			list.add(new Phrase("  " + person.getApproveTime().get(Calendar.YEAR) + "  ",fUnderLineNum));
//			list.add(new Phrase("年", fFang));
////			int temp = Util.getMonth(person);
//			list.add(new Phrase("  " + (person.getApproveTime().get(Calendar.MONTH) + 1) + "  ", fUnderLineNum));
//			list.add(new Phrase("月达到退休年龄，", fFang));
//		}
		
		
		
//		if(person.getApproveTime() == null && person.getType() == 1) {
//			list.add(new Phrase("  " + Util.getRetireYear(person) + "  ",fUnderLineNum));
//			list.add(new Phrase("年", fFang));
////			int temp = Util.getMonth(person);
//			list.add(new Phrase("  " + (person.getBorn().get(Calendar.MONTH) + 1) + "  ", fUnderLineNum));
//			list.add(new Phrase("月达到退休年龄，", fFang));
//		}
		
		
		
		if (person.getType() == 2) {
			
//			list.add(new Phrase("  " + person.getApproveTime().get(Calendar.YEAR) + "  ",fUnderLineNum));
//			list.add(new Phrase("年", fFang));
////			int temp = Util.getMonth(person);
//			list.add(new Phrase("  " + (person.getApproveTime().get(Calendar.MONTH) + 1) + "  ", fUnderLineNum));
//			list.add(new Phrase("月", fFang));
			
			list.add(new Phrase("办理", fFang));
			list.add(new Phrase(Util.getShenfen(person.getType()), fUnderLine));
			list.add(new Phrase("提前退休", fFang));
			if (person.getType() == 2) {
				list.add(new Phrase("（呼劳鉴非工（", fFang));
				list.add(new Phrase(person.getBingNum().substring(0, 4), fTimes));
				list.add(new Phrase("）第", fFang));
//				list.add(new Phrase("0", fTimes));
				list.add(new Phrase(person.getBingNum().substring(5, 8) + "", fTimes));
				list.add(new Phrase("号）", fFang));
			}
			list.add(new Phrase("。现准予退休。", fFang));

		} else if (person.getType() == 4) {
			
//			list.add(new Phrase("  " + person.getApproveTime().get(Calendar.YEAR) + "  ",fUnderLineNum));
//			list.add(new Phrase("年", fFang));
////			int temp = Util.getMonth(person);
//			list.add(new Phrase("  " + (person.getApproveTime().get(Calendar.MONTH) + 1) + "  ", fUnderLineNum));
//			list.add(new Phrase("月", fFang));

			list.add(new Phrase("办理", fFang));
			list.add(new Phrase(Util.getShenfen(person.getType()), fUnderLine));
			list.add(new Phrase("提前退职", fFang));
			if (person.getType() == 4) {
				list.add(new Phrase("（呼劳鉴非工（", fFang));
				list.add(new Phrase(person.getBingNum().substring(0, 4), fTimes));
				list.add(new Phrase("）第", fFang));
//				list.add(new Phrase("0", fTimes));
				list.add(new Phrase(person.getBingNum().substring(5, 8) + "", fTimes));
				list.add(new Phrase("号）", fFang));
			}
			list.add(new Phrase("。现准予退职。", fFang));

		} else if (person.getType() == 3 || person.getType() == 5) {
			
//			list.add(new Phrase("  " + person.getApproveTime().get(Calendar.YEAR) + "  ",fUnderLineNum));
//			list.add(new Phrase("年", fFang));
////			int temp = Util.getMonth(person);
//			list.add(new Phrase("  " + (person.getApproveTime().get(Calendar.MONTH) + 1) + "  ", fUnderLineNum));
//			list.add(new Phrase("月", fFang));
			
			list.add(new Phrase("办理", fFang));
			list.add(new Phrase(Util.getShenfen(person.getType()), fUnderLine));
			list.add(new Phrase("提前退休", fFang));
			list.add(new Phrase("。现准予退休。", fFang));
			
		} if (person.getType() == 6) {
			
//			list.add(new Phrase("  " + person.getApproveTime().get(Calendar.YEAR) + "  ",fUnderLineNum));
//			list.add(new Phrase("年", fFang));
////			int temp = Util.getMonth(person);
//			list.add(new Phrase("  " + (person.getApproveTime().get(Calendar.MONTH) + 1) + "  ", fUnderLineNum));
//			list.add(new Phrase("月", fFang));
			
			list.add(new Phrase("办理", fFang));
			list.add(new Phrase(Util.getShenfen(person.getType()), fUnderLine));
			list.add(new Phrase("提前退休", fFang));
			list.add(new Phrase("。现准予退休。", fFang));
			
		} else if (person.getType() == 1) {
			
//			加退休时间
//			list.add(new Phrase("  " + person.getApproveTime().get(Calendar.YEAR) + "  ",fUnderLineNum));
//			list.add(new Phrase("年", fFang));
//			list.add(new Phrase("  " + (person.getApproveTime().get(Calendar.MONTH) + 1) + "  ", fUnderLineNum));
//			list.add(new Phrase("月", fFang));
			
			
			list.add(new Phrase("办理", fFang));
			list.add(new Phrase(Util.getShenfen(person.getType()), fUnderLine));
			list.add(new Phrase("退休", fFang));
			list.add(new Phrase("。现准予退休。", fFang));

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

//TODO	更改打印时间 / 审批审批时间
//		Calendar c3 = person.getApproveTime();
		Calendar c3 = Calendar.getInstance();
//		Calendar c3 = person.getAddTime();

//		if (person.getType() == 2 || person.getType() == 3) {
//			c3 = person.getApproveTime();
//		}
		
//		if (person.getType() ==1 && person.getCompany().matches("个体")) {
//			c3 = person.getApproveTime();
//		}
		
//TODO 修改 打印、审批、受理时间
//		Calendar c3 = Calendar.getInstance();	//打印时间
//		c3 = person.getApproveTime();			//审批时间
		c3 = person.getAccepttime();    		//受理时间
		

		List<Phrase> list1 = new ArrayList<Phrase>();
		list1.add(new Phrase("                              ", fFang));
		list1.add(new Phrase("" + (c3.get(Calendar.YEAR)), fTimes));
		list1.add(new Phrase(" 年 ", fFang));
		list1.add(new Phrase("" + (c3.get(Calendar.MONTH) + 1), fTimes));
		list1.add(new Phrase(" 月 ", fFang));
		list1.add(new Phrase("" + (c3.get(Calendar.DAY_OF_MONTH)), fTimes));
		list1.add(new Phrase(" 日 ", fFang));

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
		list1.add(new Phrase(" 年 ", fFang));
		list1.add(new Phrase("12", fTimes));
		list1.add(new Phrase(" 月 ", fFang));
		list1.add(new Phrase("31", fTimes));
		list1.add(new Phrase(" 日 ", fFang));

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
		// 核减信息
		Phrase Context01 = new Phrase();
		List<Phrase> list = new ArrayList<Phrase>();
		if (person.getIfaddorcut() == "1") {
			list.add(new Phrase("    ", fFang));
			list.add(new Phrase("" + person.getAddorcutbegin().get(Calendar.YEAR), fTimes));
			list.add(new Phrase("年", fFang));
			list.add(new Phrase("" + (person.getAddorcutbegin().get(Calendar.MONTH) + 1), fTimes));
			list.add(new Phrase("月—", fFang));
			list.add(new Phrase("" + person.getAddorcutend().get(Calendar.YEAR), fTimes));
			list.add(new Phrase("年", fFang));
			list.add(new Phrase("" + (person.getAddorcutend().get(Calendar.MONTH) + 1), fTimes));
			list.add(new Phrase("月计算工龄", fFang));
		} else if (person.getIfaddorcut() == "2") {
			list.add(new Phrase("    核减", fFang));
			list.add(new Phrase("" + person.getAddorcutbegin().get(Calendar.YEAR), fTimes));
			list.add(new Phrase("年", fFang));
			list.add(new Phrase("" + (person.getAddorcutbegin().get(Calendar.MONTH) + 1), fTimes));
			list.add(new Phrase("月—", fFang));
			list.add(new Phrase("" + person.getAddorcutend().get(Calendar.YEAR), fTimes));
			list.add(new Phrase("年", fFang));
			list.add(new Phrase("" + (person.getAddorcutend().get(Calendar.MONTH) + 1), fTimes));
			list.add(new Phrase("月工龄", fFang));
		}
		
		

		Context01.addAll(list);

		Paragraph Context = new Paragraph(Context01);

		document.add(Context);
	}
	
	
	
	public static String song = "仿 宋";
	
	/**
	 * 黑体正常二号
	 */
	public static RtfFont fHei22 = new RtfFont("黑 体", 22, Font.NORMAL, Color.BLACK);

	/**
	 * 填充
	 */
	public static RtfFont fTian1 = new RtfFont("黑 体", 1, Font.NORMAL, Color.BLACK);

	/**
	 * 填充
	 */
	public static RtfFont fTian2 = new RtfFont("黑 体", 7, Font.NORMAL, Color.BLACK);

	/**
	 * 填充
	 */
//	public static RtfFont fTian3 = new RtfFont("仿 宋 _GB2312", 10, Font.NORMAL, Color.BLACK);
	public static RtfFont fTian3 = new RtfFont(song, 10, Font.NORMAL, Color.BLACK);

	/**
	 * 仿宋
	 */
	public static RtfFont fFang = new RtfFont(song, 16, Font.NORMAL, Color.BLACK);
//	public static RtfFont fFang = new RtfFont("仿 宋 _GB2312", 16, Font.NORMAL, Color.BLACK);

	/**
	 * 仿宋小四
	 */
	public static RtfFont fFang12 = new RtfFont(song, 12, Font.NORMAL,Color.BLACK);
//	public static RtfFont fFang12 = new RtfFont("仿 宋 _GB2312", 12, Font.NORMAL,Color.BLACK);

	/**
	 * Times New Roman
	 */
	public static RtfFont fTimes = new RtfFont("Times New Roman", 16, Font.NORMAL, Color.BLACK);

	/**
	 * 下划线
	 */
	public static RtfFont fUnderLine = new RtfFont(song, 16, Font.UNDERLINE, Color.BLACK);
//	public static RtfFont fUnderLine = new RtfFont("仿 宋 _GB2312", 16, Font.UNDERLINE, Color.BLACK);

	/**
	 * 下划线数字
	 */
	public static RtfFont fUnderLineNum = new RtfFont("Times New Roman", 16, Font.UNDERLINE, Color.BLACK);

}
