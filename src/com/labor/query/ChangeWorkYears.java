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
		
		InputStream is = new FileInputStream("E:/工龄/2014工龄/更改工龄人员列表.xls");
		
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
			
			str += person.getBorn().get(Calendar.YEAR) + "年" + (person.getBorn().get(Calendar.MONTH)+1) + "月" + " ";
			
			str += person.getApproveTime().get(Calendar.YEAR) + "年" + (person.getApproveTime().get(Calendar.MONTH)+1) + "月" + " ";
			
			str += person.getJoin().get(Calendar.YEAR) + "年" + (person.getJoin().get(Calendar.MONTH)+1) + "月" + " ";
			
			if (Util.getMonth(person) == 0) {
				str += Util.getYear(person) + "年" + " ";
			} else {
				str += Util.getYear(person) + "年" + Util.getMonth(person) + "月" + " ";
			}
			
			str += (Util.getYear(person)*12  + Util.getMonth(person)) + "月" + " ";
			
			str += rpersn.getJoin().get(Calendar.YEAR) + "年" + (rpersn.getJoin().get(Calendar.MONTH)+1) + "月" + " ";
			
			if (Util.getMonth(rpersn) == 0) {
				
				str += Util.getYear(rpersn) + "年" + " ";
				
			} else {
				
				str += Util.getYear(rpersn) + "年" + Util.getMonth(rpersn) + "月" + " ";
				
			}
			
			str += (Util.getYear(rpersn)*12  + Util.getMonth(rpersn)) + "月" + " ";
			
			str += rpersn.getJoin().get(Calendar.YEAR) + "年" + (rpersn.getJoin().get(Calendar.MONTH)+1) + "月" + " ";
			
			str += c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH)+1) + "月" + " ";
			
			str += Util.getKeshi(person.getOffice()) + " ";
			
			str += person.getIdNo();
			
			
//			System.out.println(person.getName() + " " + 
//			        Util.getSex(person.getSex()) + " " + 
//					Util.getNation(person.getNation()) + " " + 
//					person.getBorn().get(Calendar.YEAR) + "年" + (person.getBorn().get(Calendar.MONTH)+1) + "月" + " " + 
//					person.getApproveTime().get(Calendar.YEAR) + "年" + (person.getApproveTime().get(Calendar.MONTH)+1) + "月" + " " +
//					person.getJoin().get(Calendar.YEAR) + "年" + (person.getJoin().get(Calendar.MONTH)+1) + "月" + " " + 
//					Util.getYear(person) + "年" + Util.getMonth(person) + "月" + " " +
//			        (Util.getYear(person)*12  + Util.getMonth(person)) + "月" + " " +
//			        rpersn.getJoin().get(Calendar.YEAR) + "年" + (rpersn.getJoin().get(Calendar.MONTH)+1) + "月" + " " +
//			        Util.getYear(rpersn) + "年" + Util.getMonth(rpersn) + "月" + " " +
//			        (Util.getYear(rpersn)*12  + Util.getMonth(rpersn)) + "月" + " " + 
//			        rpersn.getJoin().get(Calendar.YEAR) + "年" + (rpersn.getJoin().get(Calendar.MONTH)+1) + "月" + " " +
//			        c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH)+1) + "月" + " " +
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
			// 判断当前Cell的Type
			switch (cell.getCellType()) {
			// 如果当前Cell的Type为NUMERIC
			case HSSFCell.CELL_TYPE_NUMERIC:
			case HSSFCell.CELL_TYPE_FORMULA: {
				// 判断当前的cell是否为Date
				
				
				
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					// 如果是Date类型则，转化为Data格式

					// 方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
					// cellvalue = cell.getDateCellValue().toLocaleString();

					// 方法2：这样子的data格式是不带带时分秒的：2011-10-12
					Date date = cell.getDateCellValue();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					cellvalue = sdf.format(date);

				}
				// 如果是纯数字
				else {
					// 取得当前Cell的数值
					cellvalue = String.valueOf(cell.getNumericCellValue());
					
					DecimalFormat df = new DecimalFormat("0");  
					  
					cellvalue = df.format(cell.getNumericCellValue());
				}
				break;
			}
			// 如果当前Cell的Type为STRIN
			case HSSFCell.CELL_TYPE_STRING:
				// 取得当前的Cell字符串
				cellvalue = cell.getRichStringCellValue().getString();
				break;
			// 默认的Cell值
			default:
				cellvalue = " ";
			}
		} else {
			cellvalue = "";
		}
		return cellvalue;

	}
}
