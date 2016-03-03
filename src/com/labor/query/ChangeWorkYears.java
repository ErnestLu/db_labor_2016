package com.labor.query;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.labor.util.Db_Util;
import com.labor.word.Person;
import com.labor.word.Util;





public class ChangeWorkYears {
	
	
	public static void main(String[] args) throws IOException {
		
		POIFSFileSystem fs;
		HSSFWorkbook wb;
		HSSFSheet sheet;
		HSSFRow row = null;
		HSSFCell cell;
		
		ChangeWorkYears cl = new ChangeWorkYears();
		
		InputStream is = new FileInputStream("E:/����/2014����/���Ĺ�����Ա�б�.xls");
		
		fs = new POIFSFileSystem(is);
		wb = new HSSFWorkbook(fs);
		sheet = wb.getSheet("Sheet1");
		
		
		int rowNum = sheet.getLastRowNum();
		
		String idNo = "";
		
		
		Db_Util db = Db_Util.getInstance();
		
		
		for (int i = 1; i <= rowNum; i++) {

			row = sheet.getRow(i);
			
			idNo = cl.getCellFormatValue(row.getCell(0)).trim();
			
			Person person = new Person();
			Person rpersn = new Person();
			
			person = db.queryIDNo(idNo);
			
            cell = row.getCell(1);
					
			

			Calendar date1 = HSSFDateUtil.getJavaCalendar(
					cell.getNumericCellValue(), false);
		
			
			rpersn.setBorn(person.getBorn());
			rpersn.setJoin(date1);
			
//			rpersn.setCutbegin(cutbejin);
//			rpersn.setCutend(cutend);
			
			rpersn.setApproveTime(person.getApproveTime());
			
			Calendar c = Calendar.getInstance();
			c.setTime(person.getJoin().getTime());
			c.add(Calendar.MONTH, -1);
			
			
			String str = "";
			
			str += person.getName() + " ";
			
			str += Util.getSex(person.getSex()) + " ";
			
			str += Util.getNation(person.getNation()) + " ";
			
			str += person.getBorn().get(Calendar.YEAR) + "��" + (person.getBorn().get(Calendar.MONTH)+1) + "��" + " ";
			
			str += person.getApproveTime().get(Calendar.YEAR) + "��" + (person.getApproveTime().get(Calendar.MONTH)+1) + "��" + " ";
			
			str += person.getJoin().get(Calendar.YEAR) + "��" + (person.getJoin().get(Calendar.MONTH)+1) + "��" + " ";
			
			if (Util.getMonth(person) == 0) {
				str += Util.getYear(person) + "��" + " ";
			} else {
				str += Util.getYear(person) + "��" + Util.getMonth(person) + "��" + " ";
			}
			
			str += (Util.getYear(person)*12  + Util.getMonth(person)) + "��" + " ";
			
			str += rpersn.getJoin().get(Calendar.YEAR) + "��" + (rpersn.getJoin().get(Calendar.MONTH)+1) + "��" + " ";
			
			if (Util.getMonth(rpersn) == 0) {
				
				str += Util.getYear(rpersn) + "��" + " ";
				
			} else {
				
				str += Util.getYear(rpersn) + "��" + Util.getMonth(rpersn) + "��" + " ";
				
			}
			
			str += (Util.getYear(rpersn)*12  + Util.getMonth(rpersn)) + "��" + " ";
			
			str += rpersn.getJoin().get(Calendar.YEAR) + "��" + (rpersn.getJoin().get(Calendar.MONTH)+1) + "��" + " ";
			
			str += c.get(Calendar.YEAR) + "��" + (c.get(Calendar.MONTH)+1) + "��" + " ";
			
			str += Util.getKeshi(person.getOffice()) + " ";
			
			str += person.getIdNo();
			
			
//			System.out.println(person.getName() + " " + 
//			        Util.getSex(person.getSex()) + " " + 
//					Util.getNation(person.getNation()) + " " + 
//					person.getBorn().get(Calendar.YEAR) + "��" + (person.getBorn().get(Calendar.MONTH)+1) + "��" + " " + 
//					person.getApproveTime().get(Calendar.YEAR) + "��" + (person.getApproveTime().get(Calendar.MONTH)+1) + "��" + " " +
//					person.getJoin().get(Calendar.YEAR) + "��" + (person.getJoin().get(Calendar.MONTH)+1) + "��" + " " + 
//					Util.getYear(person) + "��" + Util.getMonth(person) + "��" + " " +
//			        (Util.getYear(person)*12  + Util.getMonth(person)) + "��" + " " +
//			        rpersn.getJoin().get(Calendar.YEAR) + "��" + (rpersn.getJoin().get(Calendar.MONTH)+1) + "��" + " " +
//			        Util.getYear(rpersn) + "��" + Util.getMonth(rpersn) + "��" + " " +
//			        (Util.getYear(rpersn)*12  + Util.getMonth(rpersn)) + "��" + " " + 
//			        rpersn.getJoin().get(Calendar.YEAR) + "��" + (rpersn.getJoin().get(Calendar.MONTH)+1) + "��" + " " +
//			        c.get(Calendar.YEAR) + "��" + (c.get(Calendar.MONTH)+1) + "��" + " " +
//					Util.getKeshi(person.getOffice())
//					);
			
			wb.close();
			fs.close();
			
			System.out.println(str);
			
		}
		
	}
	
	
	private String getCellFormatValue(HSSFCell cell) {
		String cellvalue = "";
		if (cell != null) {
			// �жϵ�ǰCell��Type
			switch (cell.getCellType()) {
			// �����ǰCell��TypeΪNUMERIC
			case HSSFCell.CELL_TYPE_NUMERIC:
			case HSSFCell.CELL_TYPE_FORMULA: {
				// �жϵ�ǰ��cell�Ƿ�ΪDate
				
				
				
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					// �����Date������ת��ΪData��ʽ

					// ����1�������ӵ�data��ʽ�Ǵ�ʱ����ģ�2011-10-12 0:00:00
					// cellvalue = cell.getDateCellValue().toLocaleString();

					// ����2�������ӵ�data��ʽ�ǲ�����ʱ����ģ�2011-10-12
					Date date = cell.getDateCellValue();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					cellvalue = sdf.format(date);

				}
				// ����Ǵ�����
				else {
					// ȡ�õ�ǰCell����ֵ
					cellvalue = String.valueOf(cell.getNumericCellValue());
					
					DecimalFormat df = new DecimalFormat("0");  
					  
					cellvalue = df.format(cell.getNumericCellValue());
				}
				break;
			}
			// �����ǰCell��TypeΪSTRIN
			case HSSFCell.CELL_TYPE_STRING:
				// ȡ�õ�ǰ��Cell�ַ���
				cellvalue = cell.getRichStringCellValue().getString();
				break;
			// Ĭ�ϵ�Cellֵ
			default:
				cellvalue = " ";
			}
		} else {
			cellvalue = "";
		}
		return cellvalue;

	}
}
