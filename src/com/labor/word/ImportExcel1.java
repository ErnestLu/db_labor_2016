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
			// �Զ�ȡExcel���������
			InputStream is = new FileInputStream("E:/abc/sh.xls");
//			
//			InputStream is = new FileInputStream("E:/��λӦ��/�������ᵵ������ְ����������֪ͨ��1.xls");
//			
//			InputStream is = new FileInputStream("E:/��λӦ��/�ı�汾2014�����⹤�֣���������֪ͨ��1.xls");
//			
//			InputStream is = new FileInputStream("E:/��λӦ��/2014�굵������ϣ���������֪ͨ��1.xls");
			
			
			
			ImportExcel improtexcelExcel = new ImportExcel();

			improtexcelExcel.importExcelIntoDatabase(is);
			

		} catch (FileNotFoundException e) {
			System.out.println("δ�ҵ�ָ��·�����ļ�!");
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

			if ("ҵ��һ��".equals(office_str)) {
				office = 1;
			} else if ("ҵ�����".equals(office_str)) {
				office = 2;
			} else if ("ҵ������".equals(office_str)) {
				office = 3;
			} else if ("ֱ����".equals(office_str)) {
				office = 4;
			} else {
				office = 0;
			}

			if ("��".equals(sex_str)) {
				sex = 1;
			} else if ("Ů".equals(sex_str)) {
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
	 * ����HSSFCell������������
	 * 
	 * @param cell
	 * @return
	 */
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

	/**
	 * ��ȡ��Ԫ����������Ϊ�ַ������͵�����
	 * 
	 * @param cell
	 *            Excel��Ԫ��
	 * @return String ��Ԫ����������
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
	 * ��ȡ��Ԫ����������Ϊ�������͵�����
	 * 
	 * @param cell
	 *            Excel��Ԫ��
	 * @return String ��Ԫ����������
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
//				result = date.replaceAll("[����]", "-").replace("��", "").trim();
//			} else if (cellType == HSSFCell.CELL_TYPE_BLANK) {
//				result = "";
//			}
//		} catch (Exception e) {
//			System.out.println("���ڸ�ʽ����ȷ!");
//			e.printStackTrace();
//		}
//		return result;
//	}

	

}
