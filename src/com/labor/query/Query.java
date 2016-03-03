package com.labor.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import com.labor.util.Db_Util;

public class Query {

	public static void main(String[] args) {
		Query query = new Query();

		// query.getMonthNums(2009, 12);

		String begin = "2015-05-13";
		String end = "2016-01-30";

		String str[][] = { { "", "" }, { "", "" }, { "", "" }, { "", "" },
				{ "", "" }, { "", "" }, { "", "" }  };

		str = query.queryNums(begin, end);

		str[0][0] = "ȫ��";
		str[1][0] = "����";
		str[2][0] = "����";
		str[3][0] = "���⹤��";
		str[4][0] = "��ְ";
		str[5][0] = "�Ʋ�";
		str[6][0] = "ת����ҵ";

		query.print(str);

		String str1[][] = { { "", "" }, { "", "" }, { "", "" }, { "", "" },
				{ "", "" }, { "", "" } };

		str1 = query.queryoff(begin, end);

		str1[0][0] = "һ��";
		str1[1][0] = "����";
		str1[2][0] = "����";
		str1[3][0] = "ֱ��";
		str1[4][0] = "ȫ��";

		query.printoff(str1);

		// query.

		// System.out.println(query.getNums("2010-01-01", "2010-12-31"));

		// query.delrow("1003180158860002");

	}

	public void printoff(String[][] str1) {

		System.out.println();

		for (int i = 0; i != 5; i++) {
			System.out.println(str1[i][0] + "\t" + str1[i][1]);
		}

	}

	public String[][] queryoff(String begin, String end) {

		String str[][] = { { "", "" }, { "", "" }, { "", "" }, { "", "" },
				{ "", "" } };

		String sql[] = {

				"select count(1) from T_PERSON t where ifuse = '1' and  addtime between ('"
						+ begin.trim() + "') and ('" + end.trim()
						+ "') and t.office = 1;",
				"select count(1) from T_PERSON t where ifuse = '1' and addtime between ('"
						+ begin.trim() + "') and ('" + end.trim()
						+ "') and t.office = 2;",
				"select count(1) from T_PERSON t where ifuse = '1' and addtime between ('"
						+ begin.trim() + "') and ('" + end.trim()
						+ "') and t.office = 3;",
				"select count(1) from T_PERSON t where ifuse = '1' and addtime between ('"
						+ begin.trim() + "') and ('" + end.trim()
						+ "') and t.office = 4;",
				"select count(0) ȫ�� from t_person t where ifuse = '1' and  t.addtime between ('"
						+ begin.trim() + "') and ('" + end.trim() + "')" };

		Db_Util db = Db_Util.getInstance();

		for (int i = 0; i != 5; i++) {

			// System.out.println(sql[i]);

			ResultSet rs = db.executeQuery(sql[i]);

			try {
				while (rs.next()) {

					str[i][1] = String.valueOf(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			// System.out.println(str[i][0] + "\t" + str[i][1]);

		}

		return str;

	}

	public void print(String[][] str) {

		for (int i = 0; i != 7; i++) {
			System.out.println(str[i][0] + "\t" + str[i][1]);
		}

	}

	public String[][] queryNums(String begin, String end) {

		String str[][] = { { "", "" }, { "", "" }, { "", "" }, { "", "" },
				{ "", "" }, { "", "" }, { "", "" } };

		String sql[] = {
				"select count(0) ȫ�� from t_person t where ifuse = '1' and t.addtime between ('"
						+ begin.trim() + "') and ('" + end.trim() + "')",
				"select count(0) ����  from t_person t where ifuse = '1' and t.addtime between ('"
						+ begin.trim() + "') and ('" + end.trim()
						+ "')  and t.type = 1",
				"select count(0) ���� from t_person t where ifuse = '1' and t.addtime between ('"
						+ begin.trim() + "') and ('" + end.trim()
						+ "')  and t.type = 2",
				"select count(0) ���⹤�� from t_person t where ifuse = '1' and t.addtime between ('"
						+ begin.trim() + "') and ('" + end.trim()
						+ "') and t.type = 3",
				"select count(0) ��ְ from t_person t where ifuse = '1' and t.addtime between ('"
						+ begin.trim() + "') and ('" + end.trim()
						+ "') and t.type = 4",
				"select count(0) �Ʋ� from t_person t where ifuse = '1' and t.addtime between ('"
						+ begin.trim() + "') and ('" + end.trim()
						+ "') and t.type = 5",
				"select count(0) ת����ҵ from t_person t where ifuse = '1' and t.addtime between ('"
						+ begin.trim() + "') and ('" + end.trim()
						+ "') and t.type = 6" };

		Db_Util db = Db_Util.getInstance();

		for (int i = 0; i != 7; i++) {

			// System.out.println(sql[i]);

			ResultSet rs = db.executeQuery(sql[i]);

			try {
				while (rs.next()) {

					str[i][1] = String.valueOf(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			// System.out.println(str[i][0] + "\t" + str[i][1]);

		}

		return str;

	}

	/**
	 * ĳ��ĳ�µ���������
	 * 
	 * @param year
	 *            ��
	 * @param month
	 *            ��
	 * @return
	 */
	public int getMonthNums(int year, int month) {

		GregorianCalendar cal = new GregorianCalendar();
		if (month == 2 && cal.isLeapYear(year) == true) {
			month = 13;
		}

		int temp = getNums((year + months[month - 1][0]),
				(year + months[month - 1][1]));

		if (temp != 0) {
			System.out.println("" + year + "��" + month + "����������Ϊ�� " + temp);
		} else {
			System.out.println();
		}

		return temp;
	}

	/**
	 * ��ѯʱ��ε���������
	 * 
	 * @param begin
	 * @param end
	 * @return
	 */
	public int getNums(String begin, String end) {

		String sql = "select count(0) abc from t_person where ifuse = '1' and servicetime between ('"
				+ begin.trim() + "') and ('" + end.trim() + "')";

		Db_Util db = Db_Util.getInstance();

		ResultSet rs = db.executeQuery(sql);

		int num = 0;

		try {
			while (rs.next()) {
				num = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		db.shutdown();

		return num;
	}

	/**
	 * ��ѯʱ��ε���������
	 * 
	 * @param begin
	 * @param end
	 * @return
	 */
	public int getTypeNums(String begin, String end, String type) {

		String sql = "select count(0) abc from t_person where servicetime between ('"
				+ begin.trim() + "') and ('" + end.trim() + "')";

		Db_Util db = Db_Util.getInstance();

		ResultSet rs = db.executeQuery(sql);

		int num = 0;

		try {
			while (rs.next()) {
				num = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		db.shutdown();

		return num;
	}

	/**
	 * ɾ��һ������
	 * 
	 * @param id
	 *            ������
	 * @return
	 */
	public int delrow(String id) {
		String sql = "delete from t_person where acceptNum = '" + id.trim()
				+ "'";

		Db_Util db = Db_Util.getInstance();

		int num = db.executeUpdate(sql);

		if (num == 1) {
			System.out.println("ɾ���ɹ�");
		} else {
			System.err.println("ɾ��ʧ��");
		}

		db.shutdown();

		return num;
	}

	/**
	 * �·���ֹ
	 */
	public String months[][] = { { "-01-01", "-01-31" },// 1
			{ "-02-01", "-02-28" },// 2
			{ "-03-01", "-03-31" },// 3
			{ "-04-01", "-04-30" },// 4
			{ "-05-01", "-05-31" },// 5
			{ "-06-01", "-06-30" },// 6
			{ "-07-01", "-07-31" },// 7
			{ "-08-01", "-08-31" },// 8
			{ "-09-01", "-09-30" },// 9
			{ "-10-01", "-10-31" },// 10
			{ "-11-01", "-11-30" },// 11
			{ "-12-01", "-12-31" },// 12
			{ "-02-01", "-02-29" },// 13
	};

}
