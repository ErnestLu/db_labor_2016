package com.labor.word;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class ImportExcel1 {

	POIFSFileSystem fs;
	HSSFWorkbook wb;
	HSSFSheet sheet;
	HSSFRow row;
	HSSFCell cell;

	public static void main(String[] args) throws IOException {

		try {
			// 对读取Excel表格标题测试
			InputStream is = new FileInputStream("E:/abc/sh.xls");
//			
//			InputStream is = new FileInputStream("E:/单位应用/个人手提档案（退职）申请受理通知书1.xls");
//			
//			InputStream is = new FileInputStream("E:/单位应用/改编版本2014（特殊工种）申请受理通知书1.xls");
//			
//			InputStream is = new FileInputStream("E:/单位应用/2014年档案（买断）申请受理通知书1.xls");
			
			
			
			ImportExcel improtexcelExcel = new ImportExcel();

			improtexcelExcel.importExcelIntoDatabase(is);
			

		} catch (FileNotFoundException e) {
			System.out.println("未找到指定路径的文件!");
			e.printStackTrace();
		}
	}

	public void importExcelIntoDatabase(InputStream is) {


		Person_Temp person_temp = new Person_Temp();

		try {
			fs = new POIFSFileSystem(is);
			wb = new HSSFWorkbook(fs);

		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = wb.getSheetAt(0);

		int rowNum = sheet.getLastRowNum();

		Db_Util db = Db_Util.getInstance();

		boolean isHaveWorng = false;


		for (int i = 1; i <= rowNum; i++) {

			row = sheet.getRow(i);

			person_temp.setAcceptNo(getCellFormatValue(row.getCell(1)).trim());

			person_temp.setCompany(getCellFormatValue(row.getCell(2)).trim());

			person_temp.setIdNo(getCellFormatValue(row.getCell(5)).trim());

			person_temp.setName(getCellFormatValue(row.getCell(3)).trim());

			person_temp.setTelephone(getCellFormatValue(row.getCell(6)).trim());

			int office = 0;
			int sex = 0;

			String office_str = getCellFormatValue(row.getCell(8)).trim();

			String sex_str = getCellFormatValue(row.getCell(4)).trim();

			if ("业务一科".equals(office_str)) {
				office = 1;
			} else if ("业务二科".equals(office_str)) {
				office = 2;
			} else if ("业务三科".equals(office_str)) {
				office = 3;
			} else if ("直属科".equals(office_str)) {
				office = 4;
			} else {
				office = 0;
			}

			if ("男".equals(sex_str)) {
				sex = 1;
			} else if ("女".equals(sex_str)) {
				sex = 2;
			}

			person_temp.setOffice(office);

			person_temp.setSex(sex);

			cell = row.getCell(7);
					
			

			Calendar date1 = HSSFDateUtil.getJavaCalendar(
					cell.getNumericCellValue(), false);
		
			
			person_temp.setAccepttime(date1);

			if (Util.checkTempPerson(person_temp)) {

				db.addPersonTemp(person_temp);
			} else {
				isHaveWorng = true;
			}

		}

		if (isHaveWorng == false) {

			db.commit();
		}

	}
	
	
	
	/**
	 * 根据HSSFCell类型设置数据
	 * 
	 * @param cell
	 * @return
	 */
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

	/**
	 * 获取单元格数据内容为字符串类型的数据
	 * 
	 * @param cell
	 *            Excel单元格
	 * @return String 单元格数据内容
	 */
//	private String getStringCellValue(HSSFCell cell) {
//		String strCell = "";
//		switch (cell.getCellType()) {
//		case HSSFCell.CELL_TYPE_STRING:
//			strCell = cell.getStringCellValue();
//			break;
//		case HSSFCell.CELL_TYPE_NUMERIC:
//			strCell = String.valueOf(cell.getNumericCellValue());
//			break;
//		case HSSFCell.CELL_TYPE_BOOLEAN:
//			strCell = String.valueOf(cell.getBooleanCellValue());
//			break;
//		case HSSFCell.CELL_TYPE_BLANK:
//			strCell = "";
//			break;
//		default:
//			strCell = "";
//			break;
//		}
//		if (strCell.equals("") || strCell == null) {
//			return "";
//		}
//		if (cell == null) {
//			return "";
//		}
//		return strCell;
//	}

	/**
	 * 获取单元格数据内容为日期类型的数据
	 * 
	 * @param cell
	 *            Excel单元格
	 * @return String 单元格数据内容
	 */
//	private String getDateCellValue(HSSFCell cell) {
//		String result = "";
//		try {
//			int cellType = cell.getCellType();
//			if (cellType == HSSFCell.CELL_TYPE_NUMERIC) {
//				Date date = cell.getDateCellValue();
//				result = (date.getYear() + 1900) + "-" + (date.getMonth() + 1)
//						+ "-" + date.getDate();
//			} else if (cellType == HSSFCell.CELL_TYPE_STRING) {
//				String date = getStringCellValue(cell);
//				result = date.replaceAll("[年月]", "-").replace("日", "").trim();
//			} else if (cellType == HSSFCell.CELL_TYPE_BLANK) {
//				result = "";
//			}
//		} catch (Exception e) {
//			System.out.println("日期格式不正确!");
//			e.printStackTrace();
//		}
//		return result;
//	}

	

}
