package com.labor.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.labor.word.Person;
import com.labor.word.Person_Temp;


public class Db_Util {

	
//	private static String dbURL = "jdbc:derby://localhost:1527/db_labor;user=lufengming;password=yang1111";
//	private static String dbURL = "jdbc:mysql://localhost:3306/db_labor_2012?user=root&password=sande";
//	private static String dbURL = "jdbc:mysql://localhost:3306/db_labor_2013?user=root&password=sande";
//	private static String dbURL = "jdbc:mysql://localhost:3306/db_labor_2014?user=root&password=sande";
//	private static String dbURL = "jdbc:mysql://localhost:3306/db_labor_backup?user=root&password=sande";//测试服
//	private static String dbURL = "jdbc:mysql://localhost:3306/db_labor?user=root&password=sande";
	private static String dbURL = "jdbc:mysql://localhost:3306/db_labor_2016?user=root&password=sande";

	
	private static String t_person = "t_person";

	private static Connection conn = null;
	private static Statement stmt = null;
	PreparedStatement ps = null;
	
	
	SimpleDateFormat dfYM = new SimpleDateFormat("yyyy-MM");
	SimpleDateFormat dfYMD = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat dfYMDHM = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	SimpleDateFormat dfYMDHMS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	private static Db_Util db = new Db_Util();
	

	/**
	 * 私有构造函数
	 */
	private Db_Util() {
		createConnection();
	}
	
	
	/**
	 * 获得类实例
	 * @return
	 */
	public static Db_Util getInstance() {
		if (db == null)
			db = new Db_Util();
		return db;
	}

	
	/**
	 * 创建链接
	 */
	private static void createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// Get a connection
			conn = DriverManager.getConnection(dbURL);
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
		} catch (Exception except) {
			except.printStackTrace();
		}
	}
	
	/**
	 * 数据库提交
	 */
	public void commit() {
		try {
			conn.commit();
		} catch (SQLException e) {
			System.err.println("数据库提交错误");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 关闭数据库
	 */
	public void shutdown() {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
//				DriverManager.getConnection(dbURL + ";shutdown=true");
				
				conn.close();
			}
		} catch (SQLException sqlExcept) {

		}
	}

	/**
	 * 添加一个人
	 * @param person
	 */
	public synchronized void addOnePerson(Person person) {

		

		try {
			String sel = "select * from " + t_person + " where idNo = '" + person.getIdNo() + "' and ifuse = '1'";

			ResultSet rs = stmt.executeQuery(sel);

			
			Person tempPerson = new Person();
			
//			String num = "";
//			String temp = "";
//			String id = "";
			
			while (rs.next()) {
				
				person.setSerialNo(rs.getString("serialNo"));
				person.setNumber(rs.getString("number"));
				tempPerson.setOffice(rs.getInt("office"));
				tempPerson.setType(rs.getInt("type"));
//				num += rs.getString("serialNo");
//				id = rs.getString("number");
			}
			rs.close();
			
			String serialNo = person.getSerialNo();
//			String number = person.getNumber();
			
			String tempSql = "";

			if(serialNo == null || serialNo == "") {

				this.generateNumber(person);
				
			} else {
				
				tempSql = "update  " + t_person + " set " +
					"ifuse='0' " +
					"where serialNo='"+person.getSerialNo()+"'"
					;
				executeUpdate(tempSql);
				
				if (person.getOffice() != tempPerson.getOffice()) {
					this.generateNumber(person);
				} else if ((person.getOffice() == tempPerson.getOffice()) && (person.getType() != tempPerson.getType())) {
					this.changeNumber(person);
				}
				
			}
			
			person.setSerialNo(this.generateSerialNO());
			insertStatement(person);
			
			tempSql = "update t_person_temp set " +
					"ifprint='1' where " +
					" idNo='" + person.getIdNo() + "' and "
					+ "acceptNo = '" + person.getAcceptNo() + "' and " 
					+ "ifuse = '1' ; ";
			executeUpdate(tempSql);
			

		} catch (SQLException e) {
			e.printStackTrace();
		} 

	}
	
	private int insertStatement(Person person) {
		
		//TODO 修改备注信息 处理增加核减工龄信息  如果没有取消录入
		
		
		int if_Succeed = 0;
		
		String tempSql = "insert into " + t_person + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(tempSql);
			ps.setString(1, person.getSerialNo());
			ps.setString(2, person.getNumber());
			ps.setString(3, person.getName());
			ps.setInt(4, person.getSex());
			ps.setString(5, person.getNation() + "");
			ps.setString(6, person.getIdNo());
			ps.setInt(7, person.getIdentity());
			ps.setString(8, dfYM.format(person.getBorn().getTime()));
			ps.setString(9, dfYM.format(person.getJoin().getTime()));
			ps.setInt(10, person.getType());
			ps.setString(11, dfYMD.format(person.getApproveTime().getTime()));
			ps.setInt(12, person.getOffice());
			ps.setString(13, person.getAcceptNo());
			ps.setString(14, dfYMD.format(person.getAccepttime().getTime()));
			ps.setString(15, person.getPhonenumber());
			ps.setString(16, person.getRemark());
			ps.setInt(17, person.getApproveperson());
			ps.setString(18, person.getBingNum() + "");
			ps.setString(19, person.getCompany());
			ps.setString(20, person.getIfaddorcut());
			if (person.getIfaddorcut() != null) {
				ps.setString(21, dfYMD.format(person.getAddorcutbegin().getTime()));
				ps.setString(22, dfYMD.format(person.getAddorcutend().getTime()));
			} else {
				ps.setString(21, "");
				ps.setString(22, "");
			}
			ps.setString(23, dfYMDHMS.format(Calendar.getInstance().getTime()));
			ps.setString(24, "1");
			ps.setString(25, "0");
			
			if_Succeed = ps.executeUpdate();
//			conn.commit();
			ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return if_Succeed;
	}
	
	
	
	
	/**
	 * 执行更新
	 * @param sql
	 * @return
	 */
	public int executeUpdate(String sql) {
		int state = 0;
		try {
			state = stmt.executeUpdate(sql);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}
	
	/**
	 * 执行查询
	 * @param sql
	 */
	public ResultSet executeQuery(String sql) {
		ResultSet set = null;
		try {
			set = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return set;
	}
	
	
	/**
	 * 获得流水号（数据库主键）
	 * @return
	 */
	private String generateSerialNO() {

		Calendar cal = Calendar.getInstance();

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);

		String sql = "select number from index_num";
		int num = 0;

		try {

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				num = rs.getInt("number");
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
//		String number = ((("" + year) + (month+1)) + lpad(""+num,10,"0")) ;
	    String number = ((("" + year) + lpad(""+(month+1),2,"0") + lpad(""+(day),2,"0") + lpad(""+num,7,"0")));
		
		//修改编号
		num+=1;
		String sql1 = "update index_num set number = " + num;
		
		executeUpdate(sql1);

		return number;
	}
	
	
	/**
	 * 获得流水号（数据库主键）
	 * @return
	 */
	private String generateTempSerialNO() {

		Calendar cal = Calendar.getInstance();

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);

		String sql = "select shoulinum from index_num";
		int num = 0;

		try {

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				num = rs.getInt("shoulinum");
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
//		String number = ((("" + year) + (month+1)) + lpad(""+num,10,"0")) ;
	    String number = ((("" + year) + lpad(""+(month+1),2,"0") + lpad(""+(day),2,"0") + lpad(""+num,6,"0")));
		
		//修改编号
		num+=1;
		String sql1 = "update index_num set shoulinum = " + num;
		
		executeUpdate(sql1);

		return number;
	}
	
	
	
	
	/**
	 * 获得编号
	 * @return
	 */
	private String generateNumber(Person person) {

		String sql = "select * from index_num";
//		String normal = "";
//		String disease = "";
//		String special = "";

		
		int temp = 0;

		String str = "";
		String biao = "";
		switch (person.getOffice()) {
		case 1:
			str = "one";
			biao = "1";
			break;
		case 2:
			str = "two";
			biao = "2";
			break;
		case 3:
			str = "three";
			biao = "3";
			break;
		case 4:
			str = "zhi";
			biao = "4";
			break;
		default:
			break;
		}
		
		
		String leixing = "";
		switch (person.getType()) {
		case 1:
			leixing = "Z";
			break;
		case 2:
			leixing = "B";
			break;
		case 3:
			leixing = "T";
			break;
		case 4:// 退职
			leixing = "R";
			break;
		case 5:// 破产
			leixing = "P";
			break;
		default:
			break;
		}

		try {

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				temp = rs.getInt(str);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		temp += 1;

		String sql1 = "update index_num set " + str + " = " + temp;

		executeUpdate(sql1);
		
//TODO  修改 系统年份常量
		String sNum = "16" + leixing + biao + lpad("" + temp, 5, "0");
		
		person.setNumber(sNum);

		return sNum;
	}
	
	
	
	/**
	 * 获得编号
	 * @return
	 */
	private String changeNumber(Person person) {
		
		String temp = person.getNumber();
		
		String leixing = "";
		switch (person.getType()) {
		case 1:
			leixing = "Z";
			break;
		case 2:
			leixing = "B";
			break;
		case 3:
			leixing = "T";
			break;
		case 4:// 退职
			leixing = "R";
			break;
		case 5:// 破产
			leixing = "P";
			break;
		default:
			break;
		}
		temp = temp.substring(0, 2) + leixing + temp.substring(3, 9);
		
		person.setNumber(temp);
		
		return temp;
		
	}
	

	
	/**
	 * 左填充
	 * @param str		目标字符串
	 * @param len		长度	
	 * @param padstr	填充字符
	 * @return			填充完的字符
	 */
	private String lpad(String str, int len, String padstr) {
		if (str.getBytes().length > len)
			return null;
		if (str.getBytes().length == len)
			return str;
		while (str.getBytes().length < len) {
			str = padstr + str;
		}
		return str;
	}
	
	
	
	
	
	
	/**
	 * 添加一个人
	 * @param person
	 */
	public void addPersonTemp(Person_Temp person) {
		
		String tempSql = "";
		
		try {
			
			String sel = "select * from t_person_temp where "
					+ "acceptNo = '" + person.getAcceptNo() + "' and "
					+ "idNo = '" + person.getIdNo() + "' and "
					+ "name = '" + person.getName() + "' and "
					+ "company = '" + person.getCompany() + "' and "
					+ "office = '" + person.getOffice() + "' and "
					+ "sex = '" + person.getSex() + "' and "
					+ "accepttime = '" + dfYMD.format(person.getAccepttime().getTime()) + "' and "
					+ "phonenumber = '" + person.getTelephone() + "'";
			
			
			ResultSet rs = stmt.executeQuery(sel);
			

			if (rs.next() == false) {
				
				db.ifTempHas(person);

				tempSql = "update t_person_temp set " +
						"ifuse='0' " +
						"where idNo='" + person.getIdNo() + "'";
				executeUpdate(tempSql);
				
				person.setSerialNo(generateTempSerialNO());
				insertTempStatement(person);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

	}
	
	
	private int insertTempStatement(Person_Temp person) {
		
		int if_Succeed = 0;
		
		
		String tempSql = "insert into t_person_temp values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(tempSql);
			ps.setString(1, person.getSerialNo());
			ps.setString(2, person.getAcceptNo());
			ps.setString(3, person.getIdNo());
			ps.setString(4, person.getName());
			ps.setString(5, person.getCompany());
			ps.setInt(6, person.getOffice());
			ps.setInt(7, person.getSex());
			ps.setString(8, dfYMD.format(person.getAccepttime().getTime()));
			ps.setString(9, person.getTelephone());
			ps.setString(10, dfYMDHMS.format(Calendar.getInstance().getTime()));
			ps.setString(11, "1");
			ps.setString(12, "0");
			ps.setString(13, person.getIfSpecial());
			

			
			if_Succeed = ps.executeUpdate();
//			conn.commit();
			ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return if_Succeed;
	}
	
	
	
	public Person getPersonTempById(String id, Person person) {

		
		String sel = "select * from t_person_temp where "
				+ "idNo = '" + id + "' order by serialNo";

		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		Calendar shen1 = Calendar.getInstance();
		
		ResultSet rs;
		try {
			rs = stmt.executeQuery(sel);
			
			if (rs.last() == true) {
				
//				Calendar cal = Calendar.getInstance();
//				cal.setTime(dfYMD.parse(rs.getString("")));
//TODO 受理表中信息导入正式表
				person.setAcceptNo(rs.getString("acceptNo"));
				person.setIdNo(rs.getString("idNo"));
				person.setName(rs.getString("name"));
				person.setCompany(rs.getString("company"));
				person.setOffice(rs.getInt("office"));
				person.setSex(rs.getInt("sex"));
				person.setPhonenumber(rs.getString("phonenumber"));
				
				shen1.setTime(df1.parse(rs.getString("accepttime")));
				person.setAccepttime(shen1);
			}
		} catch (SQLException e) {
			System.err.println("在受理表中查询已受理信息时出错。");
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		

		
		return person;
	}
	
	
	
	
	public List<Person_Temp> getPersonTempList() {
		List<Person_Temp> list = new ArrayList<Person_Temp>();
		
		
		
		String sel = "select * from t_person_temp t where 1=1 and t.ifuse = 1 and t.ifprint = 0 and t.addtime > '2015-05-07' order by acceptNo";
		
//		sel += "acceptNo > " + "";
//		
//		sel += " and acceptNo < " + "";
		
		
		
		ResultSet rs;
		try {
			rs = stmt.executeQuery(sel);
			
			
			
			
			while (rs.next()) {
				Person_Temp person = new Person_Temp();
				person.setAcceptNo(rs.getString("acceptNo"));
				person.setIdNo(rs.getString("idNo"));
				person.setName(rs.getString("name"));
				person.setCompany(rs.getString("company"));
				person.setOffice(rs.getInt("office"));
				person.setSex(rs.getInt("sex"));
				person.setIfprint(rs.getString("ifprint"));
				person.setIfuse(rs.getString("ifuse"));
				person.setIfSpecial(rs.getString("ifSpecial"));
				
				
				list.add(person);
				
			}
		} catch (SQLException e) {
			System.err.println("查询受理表时出错。");
			e.printStackTrace();
		}
		
		
		
		
		return list;
	}
	
	
	public List<Person> getPersonList() {

		List<Person> list = new ArrayList<Person>();

		String sel = "select * from t_person t where 1=1 and t.ifuse = 1  and t.addtime > '2015-05-13' order by t.acceptNo";

		// sel += "acceptNo > " + "";
		//
		// sel += " and acceptNo < " + "";

		ResultSet rs;
		try {
			rs = stmt.executeQuery(sel);

			while (rs.next()) {
				Person person = new Person();
				
				person.setAcceptNo(rs.getString("acceptNo"));
				person.setIdNo(rs.getString("idNo"));
				person.setName(rs.getString("name"));
				person.setCompany(rs.getString("company"));
				person.setOffice(rs.getInt("office"));
				person.setSex(rs.getInt("sex"));

				
//				ps.setString(1, person.getSerialNo());
				person.setSerialNo(rs.getString("serialNo"));
//				ps.setString(2, person.getNumber());
				person.setNumber(rs.getString("number"));
//				ps.setString(3, person.getName());
				person.setName(rs.getString("name"));
//				ps.setInt(4, person.getSex());
				person.setSex(rs.getInt("sex"));
//				ps.setString(5, person.getNation() + "");
				person.setNation(Integer.parseInt(rs.getString("nation")));
//				ps.setString(6, person.getIdNo());
				person.setIdNo(rs.getString("idNo"));
//				ps.setInt(7, person.getIdentity());
				person.setIdentity(Integer.parseInt(rs.getString("identity")));
//				ps.setString(8, dfYM.format(person.getBorn().getTime()));
				person.getBorn().setTime(dfYM.parse(rs.getString("borntime")));
//				ps.setString(9, dfYM.format(person.getJoin().getTime()));
				person.getJoin().setTime(dfYM.parse(rs.getString("jointime")));
//				ps.setInt(10, person.getType());
				person.setType(Integer.parseInt(rs.getString("type")));
//				ps.setString(11, dfYMD.format(person.getApproveTime().getTime()));
				person.getApproveTime().setTime(dfYMD.parse(rs.getString("approvetime")));
//				ps.setInt(12, person.getOffice());
				person.setOffice(Integer.parseInt(rs.getString("office")));
//				ps.setString(13, person.getAcceptNo());
				person.setAcceptNo(rs.getString("acceptNo"));
//				ps.setString(14, dfYMD.format(person.getAccepttime().getTime()));
				person.getAccepttime().setTime(dfYMD.parse(rs.getString("acceptTime")));
//				ps.setString(15, person.getPhonenumber());
				person.setPhonenumber(rs.getString("phonenumber"));
//				ps.setString(16, person.getRemark());
				person.setRemark(rs.getString("remark"));
//				ps.setInt(17, person.getApproveperson());
				person.setApproveperson(rs.getInt("approveperson"));
//				ps.setString(18, person.getBingNum() + "");
				person.setBingNum(rs.getString("etirenum"));
//				ps.setString(19, person.getCompany());
				person.setCompany(rs.getString("company"));
//				ps.setString(20, person.getIfaddorcut());
				person.setIfaddorcut(rs.getString("ifaddorcut"));
//				if (person.getIfaddorcut() != null) {
//					ps.setString(21, dfYMD.format(person.getAddorcutbegin().getTime()));
//					ps.setString(22, dfYMD.format(person.getAddorcutend().getTime()));
//				} else {
//					ps.setString(21, "");
//					ps.setString(22, "");
//				}
				if (person.getIfaddorcut() != null) {
					person.getAddorcutbegin().setTime(dfYM.parse(rs.getString("addorcutbegin")));
					person.getAddorcutend().setTime(dfYM.parse(rs.getString("addorcutend")));
				}
				
//				ps.setString(23, dfYMDHMS.format(Calendar.getInstance().getTime()));
				
				person.getAddTime().setTime(dfYMD.parse(rs.getString("addtime")));
//				ps.setString(24, "1");
//				ps.setString(25, "0");

				list.add(person);

			}
		} catch (SQLException e) {
			System.err.println("查询受理表时出错。");
			e.printStackTrace();
		} catch (ParseException e) {
			System.err.println("日期转换出错。");
			e.printStackTrace();
		}

		return list;

	}
	
	
	
	
	public boolean ifJiTi(Person person) {
		
		String sel = "select * from jiti where idNo = '" + person.getIdNo() + "'";
		
		boolean is = true;
		
		
		ResultSet rs;
		try {
			rs = stmt.executeQuery(sel);
			
			if (rs.next() == true) {
				
				is = false;
				
			}
			
		} catch (SQLException e) {
			System.err.println("查询受理表时出错。");
			e.printStackTrace();
		}
		
		return is;
	}
	
	
	public void ifTempHas(Person_Temp person) {

		String sel = "select * from t_person_temp where ifuse = '1' and idNo = '" + person.getIdNo() + "'";
		
		
		ResultSet rs;
		try {
			rs = stmt.executeQuery(sel);
			
			if (rs.next() == true) {
				
				System.err.println(person.getName() + ": 身份证号已有，已经受理过。");
				
			}
			
		} catch (SQLException e) {
			System.err.println("查询受理表时出错。");
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	public Person queryIDNo(String idNo) {
		
		String sql = "select * from t_person t where t.idNO = '" + idNo + "' and t.ifuse = 1";
		
		
		Person person = new Person();
		
		
		Calendar born = Calendar.getInstance();
		Calendar join = Calendar.getInstance();
		Calendar shen = Calendar.getInstance();
		
		
		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				
				
				
				person.setName(rs.getString("name"));
				person.setIdNo(rs.getString("idNo"));
				person.setSex(rs.getInt("sex"));
				person.setNation(rs.getInt("nation"));
				person.setOffice(rs.getInt("office"));
				
				
			
				born.setTime(dfYM.parse(rs.getString("borntime")));
				join.setTime(dfYM.parse(rs.getString("jointime")));
				shen.setTime(dfYM.parse(rs.getString("approvetime")));
				
				
				
				
				
				person.setBorn(born);
				person.setJoin(join);
				person.setApproveTime(shen);
//				System.out.println("1." +person.getJoin().get(Calendar.YEAR) + "年" + (person.getJoin().get(Calendar.MONTH)+1) + "月");
				
			}
			
//			rs.getString("name")
//			rs.getInt("name")
			
			
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		

		
		
		
		return person;
	}
	
	
	
	
	
	
	
//	/**
//	 * 插入一条记录
//	 * @deprecated
//	 * @param person
//	 */
//	public void insertStatement_old(Person person) {
//
//
//
//		try {
//			String sel = "select * from " + t_person + " where acceptNo = '" + person.getAcceptNo() + "'";
//
//			ResultSet rs = stmt.executeQuery(sel);
//
//			String num = "";
//			String temp = "";
//			String id = "";
//			
//			while (rs.next()) {
//				num += rs.getString("serialNo");
//				id = rs.getString("number");
//			}
//			rs.close();
//
//			if(num == null || num == "") {
////				 String del = "delete from " + t_person +" where acceptNum = '" + person.getId() + "'";
////				 stmt.executeUpdate(del);
//				
//				temp = "insert into " + t_person + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//				ps = conn.prepareStatement(temp);
//				ps.setString(1, generateSerialNO());
//				ps.setString(2, generateNumber(person));
//				ps.setString(3, person.getAcceptNo());
//				ps.setString(4, person.getName());
//				ps.setString(5, person.getCompany());
//				ps.setInt(6, person.getOffice());
//				ps.setInt(7, person.getSex());
//				ps.setString(8, dfYM.format(person.getBorn().getTime()));
//				ps.setString(9, dfYM.format(person.getJoin().getTime()));
//				ps.setInt(10, person.getIdentity());
//				ps.setInt(11, person.getType());
//				ps.setString(12, dfYMD.format(person.getApproveTime().getTime()));
//				ps.setString(13, person.getNation() + "");
//				ps.setString(14, person.getBingNum() + "");
//				ps.setString(15, dfYMD.format(Calendar.getInstance().getTime()));
//				ps.setString(16, "");
//				ps.setString(17, person.getRemark());
//				
//				ps.executeUpdate();
//				conn.commit();
//				ps.close();
//			} else {
//				temp = "update  " + t_person + " set " +
//					"name = '" + person.getName() + "', " +
//					"company ='"+person.getCompany()+"', " +
//					"office="+person.getOffice()+", " +
//					"sex = "+person.getSex()+", " +
//					"borntime='"+dfYM.format(person.getBorn().getTime())+"', " +
//					"jointime='"+dfYM.format(person.getJoin().getTime())+"',"+
//					"identity="+person.getIdentity()+","+
//					"type="+person.getType()+","+
//					"approvetime='"+dfYMD.format(person.getApproveTime().getTime())+"',"+
//					"etirenum='"+person.getBingNum()+"', " +
//					"modtime='"+dfYMD.format(Calendar.getInstance().getTime())+"' " +
//					"where acceptNo='"+person.getAcceptNo()+"'"
//					;
//				
//				executeUpdate(temp);
//				
//
//				person.setNumber(id);
//
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} 
//
//	}
	
	
	
	
//	/**
//	 * 获得流水号
//	 * @deprecated
//	 * @return
//	 */
//	private String getSerialNumber_old(Person person) {
//
//		String sql = "select * from sequence";
////		String normal = "";
////		String disease = "";
////		String special = "";
//
//		int temp = 0;
//
//		String str = "";
//		String biao = "";
//		switch (person.getType()) {
//		case 1:
//			str = "normal";
//			biao = "Z";
//			break;
//		case 2:
//			str = "disease";
//			biao = "B";
//			break;
//		case 3:
//			str = "special";
//			biao = "T";
//			break;
//		case 4:// 退职
//			str = "retirement";
//			biao = "R";
//			break;
//		case 5:// 破产
//			str = "collapse";
//			biao = "P";
//			break;
//		default:
//			break;
//		}
//
//		try {
//
//			ResultSet rs = stmt.executeQuery(sql);
//
//			while (rs.next()) {
//				temp = rs.getInt(str);
//			}
//			rs.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		temp += 1;
//
//		String sql1 = "update sequence set " + str + " = " + temp;
//
//		executeUpdate(sql1);
//		
//		
//		String sNum = biao + lpad("" + temp, 5, "0");
//		
//		person.setNumber(sNum);
//
//		return sNum;
//	}
}
