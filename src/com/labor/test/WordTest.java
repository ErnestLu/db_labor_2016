package com.labor.test;


import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.rtf.RtfWriter2;

/**
 * 
 * @author wangyanjun
 * @email bd_wyj@sina.com
 * @createDate Jun 12, 2008
 */

class Person {

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComp() {
		return comp;
	}

	public void setComp(String comp) {
		this.comp = comp;
	}

	public int getKesh() {
		return kesh;
	}

	public void setKesh(int kesh) {
		this.kesh = kesh;
	}

	public Calendar getBorn() {
		return born;
	}

	public void setBorn(Calendar born) {
		this.born = born;
	}

	public Calendar getJoin() {
		return join;
	}

	public void setJoin(Calendar join) {
		this.join = join;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	private String id;
	private String name;
	private int kesh;
	private String comp;

	private Calendar born;
	private Calendar join;
	private int type;
	private int shenfen;
	private int sex;

	private Date born1;
	private Date join1;
	private Date shen;

	public int getShenfen() {
		return shenfen;
	}

	public Date getShen() {
		return shen;
	}

	public void setShen(Date shen) {
		this.shen = shen;
	}

	public void setShenfen(int shenfen) {
		this.shenfen = shenfen;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public Date getBorn1() {
		return born1;
	}

	public void setBorn1(Date born1) {
		this.born1 = born1;
	}

	public Date getJoin1() {
		return join1;
	}

	public void setJoin1(Date join1) {
		this.join1 = join1;
	}
}

public class WordTest {

	public void createDocContext(String file, Person person)
			throws DocumentException, IOException {
		// ����ֽ�Ŵ�С
		Document document = new Document(PageSize.A4);
		// ����һ����д��(Writer)��document���������ͨ����д��(Writer)���Խ��ĵ�д�뵽������
		RtfWriter2.getInstance(document, new FileOutputStream(file,true));
		document.open();
		// ������������
		BaseFont bfChinese = BaseFont.createFont("STSongStd-Light",
				"UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);

		// ����������
		Font titleFont = new Font(bfChinese, 20, Font.BOLD);
		// ����������
		Font contextFont = new Font(bfChinese, 12, Font.NORMAL);
		
		Font contextFont1 = new Font(bfChinese, 12, Font.UNDERLINE);
		
		
		
		Paragraph title = new Paragraph("���ݣ���ְ����Ա������");
		// ���ñ����ʽ���뷽ʽ
		title.setAlignment(Element.ALIGN_CENTER);
		title.setFont(titleFont);
		document.add(title);

		String contextString1 = "���:"+person.getId()+"                                 ";
		Paragraph context1 = new Paragraph(contextString1);
		context1.setAlignment(Element.ALIGN_LEFT);
		context1.setFont(contextFont);
		context1.setSpacingBefore(5);
		context1.setFirstLineIndent(0);
		
		String contextString2 = "���:"+person.getId()+"                                 ";
		Paragraph context2 = new Paragraph(contextString1);
		context2.setAlignment(Element.ALIGN_LEFT);
		context2.setFont(contextFont);
		context2.setSpacingBefore(5);
		context2.setFirstLineIndent(0);
		
		
		document.add(context1);
		
		Paragraph underline1 = new Paragraph("  "+person.getKesh()+"  ", FontFactory.getFont(
				FontFactory.HELVETICA_BOLDOBLIQUE, 18, Font.UNDERLINE,
				new Color(0, 0, 255)));
		document.add(underline1);
		
		String contextString = "���:"+person.getId()+"         "
				+ " \n"// ����
				+ "iText��java�������ЩҪ���������ı���"
				+ "���ͼ�ε�ֻ���ĵ��Ǻ����õġ��������������java Servlet�кܺõĸ��ϡ�"
				+ "ʹ��iText��PDF�ܹ�ʹ����ȷ�Ŀ���Servlet�������";
		Paragraph context = new Paragraph(contextString);
		// ���ĸ�ʽ�����
		context.setAlignment(Element.ALIGN_LEFT);
		context.setFont(contextFont);
		// ����һ���䣨���⣩�յ�����
		context.setSpacingBefore(5);
		// ���õ�һ�пյ�����
		context.setFirstLineIndent(20);
		document.add(context);
		
		
		

		// ������FontFactory���Font��Color�������ø��ָ���������ʽ
		/**
		 * Font.UNDERLINE �»��ߣ�Font.BOLD ����
		 */
		Paragraph underline = new Paragraph("�»��ߵ�ʵ��", FontFactory.getFont(
				FontFactory.HELVETICA_BOLDOBLIQUE, 18, Font.UNDERLINE,
				new Color(0, 0, 255)));
		document.add(underline);

		// ���� Table ���
		Table aTable = new Table(3);
		int width[] = { 25, 25, 50 };
		aTable.setWidths(width);// ����ÿ����ռ����
		aTable.setWidth(90); // ռҳ���� 90%

		aTable.setAlignment(Element.ALIGN_CENTER);// ������ʾ
		aTable.setAlignment(Element.ALIGN_MIDDLE);// ���������ʾ
		aTable.setAutoFillEmptyCells(true); // �Զ�����
		aTable.setBorderWidth(1); // �߿���
		aTable.setBorderColor(new Color(0, 125, 255)); // �߿���ɫ
		aTable.setPadding(2);// �ľ࣬��Ч����֪��ʲô��˼��
		aTable.setSpacing(3);// ����Ԫ��֮��ļ��
		aTable.setBorder(2);// �߿�

		// ���ñ�ͷ
		/**
		 * cell.setHeader(true);�ǽ��õ�Ԫ����Ϊ��ͷ��Ϣ��ʾ�� cell.setColspan(3);ָ���˸õ�Ԫ��ռ3�У�
		 * Ϊ�����ӱ�ͷ��Ϣʱ��Ҫע�����һ����ͷ��Ϣ�������֮�� ������� endHeaders()���������򵱱���ҳ�󣬱�ͷ��Ϣ��������ʾ
		 */
		Cell haderCell = new Cell("����ͷ");
		haderCell.setHeader(true);
		haderCell.setColspan(3);
		aTable.addCell(haderCell);
		aTable.endHeaders();

		Font fontChinese = new Font(bfChinese, 12, Font.NORMAL, Color.GREEN);
		Cell cell = new Cell(new Phrase("����һ�����Ե� 3*3 Table ����", fontChinese));
		cell.setVerticalAlignment(Element.ALIGN_TOP);
		cell.setBorderColor(new Color(255, 0, 0));
		cell.setRowspan(2);
		aTable.addCell(cell);

		aTable.addCell(new Cell("#1"));
		aTable.addCell(new Cell("#2"));
		aTable.addCell(new Cell("#3"));
		aTable.addCell(new Cell("#4"));
		Cell cell3 = new Cell(new Phrase("һ����������", fontChinese));
		cell3.setColspan(3);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		aTable.addCell(cell3);

		document.add(aTable);
		document.add(new Paragraph("\n"));
		

		document.close();
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Person person = new Person();

		person.setId("0910200158860055");
		person.setName("����ɽ");
		
		person.setKesh(3);
		person.setComp("ԭ����ʳƷ�ܹ�˾");
		
		person.setSex(1);
		
		person.setBorn1(new Date(19491001));
		person.setJoin1(new Date(19680801));
		
		person.setShen(new Date(20091021));
		


		WordTest word = new WordTest();
		String file = "d:/aaaaaaaaaa.doc";
		String file1 = "d:/bbbbbbbbb.doc";
		
		try {
			word.createDocContext(file, person);
			word.createDocContext(file1, person);
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}