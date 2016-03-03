package com.labor.word;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.labor.util.Db_Util;

public class Person {

	private SimpleDateFormat dfYM = new SimpleDateFormat("yyyy-MM");
	private SimpleDateFormat dfMD = new SimpleDateFormat("-MM-dd");
	private SimpleDateFormat dfYMD = new SimpleDateFormat("yyyy-MM-dd");

//	public static int myId;

	/**
	 * 1.��ˮ��
	 */
	private String serialNo;
	
	/**
	 * 2.���
	 */
	private String number;
	
	/**
	 * 3.����
	 */
	private String name;
	
	/**
	 * 4.�Ա�
	 */
	private int sex;

	/**
	 * 5.����
	 */
	private int nation;
	
	/**
	 * 6.���֤��
	 */
	private String idNo;
	
	/**
	 * 7.���
	 */
	private int identity;
	
	/**
	 * 8.��������
	 */
	private Calendar born = Calendar.getInstance();

	/**
	 * 9.�μӹ���ʱ��
	 */
	private Calendar join = Calendar.getInstance();
	
	/**
	 * 10.����
	 */
	private int type;
	
	/**
	 * 11.����ʱ��
	 */
	private Calendar approveTime = Calendar.getInstance();
	
	/**
	 * 12.����
	 */
	private int office;
		
	/**
	 * 13.������
	 */
	private String acceptNo;
	
	/**
	 * 14.����ʱ��
	 */
	private Calendar accepttime = Calendar.getInstance();
	
	/**
	 * 15.�绰
	 */
	private String phonenumber;
	
	/**
	 * 16.��ע
	 */
	private String remark = "";
	
	/**
	 * 17.�����Ա
	 */
	private int approveperson;
	
	/**
	 * 18.���˱��
	 */
	private String bingNum;

	/**
	 * 19.��˾
	 */
	private String company;


	/**
	 * 20.��� �Ƿ����Ӻ˼�����
	 */
	private String ifaddorcut;
	
	
	/**
	 * �˼���ʼʱ��
	 */
//	private Calendar addorcutbegin = Calendar.getInstance();
	private Calendar addorcutbegin = Calendar.getInstance();

	/**
	 * �˼�����ʱ��
	 */
//	private Calendar addorcutend = Calendar.getInstance();
	private Calendar addorcutend = Calendar.getInstance();
	
	
	private Calendar addTime = Calendar.getInstance();
	
	

	/**
	 * ������Ϣ1
	 */
	// private String extra1 = "    2009��12����ִ�й���";
	private String extra1 = "";

	/**
	 * ������Ϣ2
	 */
	private String extra2 = "    ������д";

	/**
	 * 1.��ˮ��
	 */
	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	/**
	 * 2.������
	 */
	public String getAcceptNo() {
		return acceptNo;
	}
	
	public void setAcceptNo(String id) {
		this.acceptNo = id.trim();
	}
	
	
	/**
	 * 3.���֤��
	 */
	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}


	/**
	 * 4.���
	 */
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	

	/**
	 * 5.����
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.trim();
	}

	/**
	 * 6.��˾
	 */
	public String getCompany() {
		return company;
	}

	public void setCompany(String comp) {
		this.company = comp.trim();
	}

	/**
	 * 7.���� 1-ҵ��һ�ƣ�2-ҵ����ƣ�3-ҵ�����ƣ�4-ֱ��
	 */
	public int getOffice() {
		return office;
	}

	public void setOffice(int kesh) {
		this.office = kesh;
	}

	
	
	/**
	 * 8.�Ա� 1-�У�2-Ů
	 */
	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	/**
	 * 9.��������
	 */
	public Calendar getBorn() {
		return born;
	}

	public void setBorn(Calendar born) {
		this.born = born;
	}

	/**
	 * 10.�μӹ���ʱ��
	 */
	public Calendar getJoin() {
		return join;
	}

	public void setJoin(Calendar join) {
		this.join = join;
	}

	/**
	 * 11.��� 1-���ˣ�2-�ɲ�
	 */
	public int getIdentity() {
		return identity;
	}

	public void setIdentity(int identity) {
		this.identity = identity;
	}
	


	/**
	 * 12.���� 1-������2-���ˣ�3-���⹤��
	 *        4-��ְ��5-�Ʋ�
	 */
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	

	/**
	 * 13.����ʱ��
	 */
	public Calendar getApproveTime() {
		return approveTime;
	}

	public void setApproveTime(Calendar approveTime) {
		this.approveTime = approveTime;
	}


	/**
	 * 14.����
	 */
	public int getNation() {
		return nation;
	}

	public void setNation(int nation) {
		this.nation = nation;
	}

	/**
	 * 15.���˱��
	 */
	public String getBingNum() {
		return bingNum;
	}

	public void setBingNum(String bingNum) {
		this.bingNum = bingNum;
	}

	
	/**
	 * 18.�绰
	 */
	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	/**
	 * 19.��ע
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

	public String getExtra1() {
		return extra1;
	}

	public void setExtra1(String extra1) {
		this.extra1 = extra1;
	}

	public String getExtra2() {
		return extra2;
	}

	public void setExtra2(String extra2) {
		this.extra2 = extra2;
	}

		
	

	public String getIfaddorcut() {
		return ifaddorcut;
	}

	public void setIfaddorcut(String ifaddorcut) {
		this.ifaddorcut = ifaddorcut;
	}

	public Calendar getAddorcutbegin() {
		return addorcutbegin;
	}

	public void setAddorcutbegin(Calendar addorcutbegin) {
		this.addorcutbegin = addorcutbegin;
	}

	public Calendar getAddorcutend() {
		return addorcutend;
	}

	public void setAddorcutend(Calendar addorcutend) {
		this.addorcutend = addorcutend;
	}

	public Calendar getAccepttime() {
		return accepttime;
	}

	public void setAccepttime(Calendar accepttime) {
		this.accepttime = accepttime;
	}

	public int getApproveperson() {
		return approveperson;
	}

	public void setApproveperson(int approveperson) {
		this.approveperson = approveperson;
	}
	

	public Calendar getAddTime() {
		return addTime;
	}

	public void setAddTime(Calendar addTime) {
		this.addTime = addTime;
	}

	public Person() {
		
	}



	/**
	 * ���� û����ʱ��  1
	 * @param idNo
	 * @param born
	 * @param join
	 * @param identity
	 * @param type
	 * @param nation
	 * @param name
	 * @param comp
	 * @param kesh
	 * @param sex
	 * @throws ParseException 
	 */
	public Person(String idNo, String born, String join, int identity,
			int type, int nation, String name, String comp, int kesh, int sex) throws ParseException {

		Db_Util db = Db_Util.getInstance();

		db.getPersonTempById(idNo, this);
		
		
		Calendar shen2 = Calendar.getInstance();
		shen2.setTime(this.getAccepttime().getTime());
		
		
		setIdentity(identity);
		setType(type);
		setNation(nation);

		Calendar bron1 = Calendar.getInstance();
		Calendar join1 = Calendar.getInstance();
		Calendar shen1 = Calendar.getInstance();


		bron1.setTime(dfYM.parse(born));// ��������
		join1.setTime(dfYM.parse(join));// �μӹ���ʱ��


		setBorn(bron1);
		setJoin(join1);

		
		if (!"".equals(name)) {
			setName(name);
		}
		
		if (!"".equals(comp)) {
			setCompany(comp);
		}
		
		if (kesh != 0) {
			setOffice(kesh);
		}
		
		if (sex != 0) {
			setSex(sex);
		}
		
		
		shen1.setTime(dfYMD.parse(Util.getRetireYear(this) + dfMD.format(bron1.getTime())));
		setApproveTime(shen1);
		
		
		if (this.getType() ==1 && this.getCompany().matches("����")) {
			setApproveTime(shen2);
		}
		
	}
	
	
	/**
	 * ���� ������ʱ�� 1
	 * @param idNo
	 * @param born
	 * @param join
	 * @param identity
	 * @param type
	 * @param nation
	 * @param name
	 * @param comp
	 * @param kesh
	 * @param sex
	 * @throws ParseException 
	 */
	public Person(String idNo, String born, String join, int identity,
			int type, int nation, String name, String comp, int kesh, int sex, String shen) throws ParseException {

		Db_Util db = Db_Util.getInstance();

		db.getPersonTempById(idNo, this);
		
		
		
		setIdentity(identity);
		setType(type);
		setNation(nation);

		Calendar bron1 = Calendar.getInstance();
		Calendar join1 = Calendar.getInstance();
		Calendar shen1 = Calendar.getInstance();


		bron1.setTime(dfYM.parse(born));// ��������
		join1.setTime(dfYM.parse(join));// �μӹ���ʱ��


		setBorn(bron1);
		setJoin(join1);

//		shen1.setTime(dfYMD.parse(Util.getRetireYear(this) + dfMD.format(bron1.getTime())));
//		setApproveTime(shen1);
		
		if (!"".equals(name)) {
			setName(name);
		}
		
		if (!"".equals(comp)) {
			setCompany(comp);
		}
		
		if (kesh != 0) {
			setOffice(kesh);
		}
		
		if (sex != 0) {
			setSex(sex);
		}
		
		
//		shen1.setTime(dfYMD.parse(Util.getRetireYear(this) + dfMD.format(bron1.getTime())));
//		setApproveTime(shen1);
		
		
		if (!("".equals(shen) || shen == null)) {
			shen1.setTime(dfYMD.parse(shen));// ����ʱ��
		}


		setBorn(bron1);
		setJoin(join1);
		setApproveTime(shen1);
	}
	
	
	/**
	 * �Ӻ˼�  û�� ����ʱ�� 1
	 * @param idNo
	 * @param born
	 * @param join
	 * @param identity
	 * @param type
	 * @param nation
	 * @param name
	 * @param comp
	 * @param kesh
	 * @param sex
	 * @throws ParseException 
	 */
	public Person(String idNo, String born, String join, int identity,
			int type, int nation,String ifAddOrCut, String addOrCutBeing, String addOrCutEnd,String name, String comp, int kesh, int sex) throws ParseException {

		
		
		
		Db_Util db = Db_Util.getInstance();

		db.getPersonTempById(idNo, this);
		
		
		
		setIdentity(identity);
		setType(type);
		setNation(nation);

		Calendar bron1 = Calendar.getInstance();
		Calendar join1 = Calendar.getInstance();
		Calendar shen1 = Calendar.getInstance();


		bron1.setTime(dfYM.parse(born));// ��������
		join1.setTime(dfYM.parse(join));// �μӹ���ʱ��


		setBorn(bron1);
		setJoin(join1);

		shen1.setTime(dfYMD.parse(Util.getRetireYear(this) + dfMD.format(bron1.getTime())));
		setApproveTime(shen1);
		
		if (!"".equals(name)) {
			setName(name);
		}
		
		if (!"".equals(comp)) {
			setCompany(comp);
		}
		
		if (kesh != 0) {
			setOffice(kesh);
		}
		
		if (sex != 0) {
			setSex(sex);
		}
		
		
		Calendar cutbejin = Calendar.getInstance();
		Calendar cutend = Calendar.getInstance();
		
		cutbejin.setTime(dfYM.parse(addOrCutBeing));// �˼���ʼʱ��
		cutend.setTime(dfYM.parse(addOrCutEnd)); // �˼�����ʱ��
		
		setIfaddorcut(ifAddOrCut);
		
		setAddorcutbegin(cutbejin);
		setAddorcutend(cutend);
		
				
//		shen1.setTime(dfYMD.parse(Util.getRetireYear(this) + dfMD.format(bron1.getTime())));
//		setApproveTime(shen1);
		
		
	}
	
	
	
	/**
	 * �Ӻ˼�  �� ����ʱ�� 1
	 * @param idNo
	 * @param born
	 * @param join
	 * @param identity
	 * @param type
	 * @param nation
	 * @param name
	 * @param comp
	 * @param kesh
	 * @param sex
	 * @throws ParseException 
	 */
	public Person(String idNo, String born, String join, int identity,
			int type, int nation, String ifAddOrCut, String addOrCutBeing, String addOrCutEnd,String name, String comp, int kesh, int sex, String shen) throws ParseException {

		
		
		
		Db_Util db = Db_Util.getInstance();

		db.getPersonTempById(idNo, this);
		
		
		
		setIdentity(identity);
		setType(type);
		setNation(nation);

		Calendar bron1 = Calendar.getInstance();
		Calendar join1 = Calendar.getInstance();
		Calendar shen1 = Calendar.getInstance();


		bron1.setTime(dfYM.parse(born));// ��������
		join1.setTime(dfYM.parse(join));// �μӹ���ʱ��


		setBorn(bron1);
		setJoin(join1);

		shen1.setTime(dfYMD.parse(Util.getRetireYear(this) + dfMD.format(bron1.getTime())));
		setApproveTime(shen1);
		
		if (!"".equals(name)) {
			setName(name);
		}
		
		if (!"".equals(comp)) {
			setCompany(comp);
		}
		
		if (kesh != 0) {
			setOffice(kesh);
		}
		
		if (sex != 0) {
			setSex(sex);
		}
		
		
		Calendar cutbejin = Calendar.getInstance();
		Calendar cutend = Calendar.getInstance();
		
		cutbejin.setTime(dfYM.parse(addOrCutBeing));// �˼���ʼʱ��
		cutend.setTime(dfYM.parse(addOrCutEnd)); // �˼�����ʱ��
		
		setIfaddorcut(ifAddOrCut);
		
		setAddorcutbegin(cutbejin);
		setAddorcutend(cutend);
		
				
//		shen1.setTime(dfYMD.parse(Util.getRetireYear(this) + dfMD.format(bron1.getTime())));
//		setApproveTime(shen1);
		
		
		if (!("".equals(shen) || shen == null)) {
			shen1.setTime(dfYMD.parse(shen));// ����ʱ��
		}
		
	}
	
	
	/**
	 * �Ӳ��� �� ����ʱ�� 1
	 * @param idNo
	 * @param born
	 * @param join
	 * @param identity
	 * @param type
	 * @param nation
	 * @param name
	 * @param comp
	 * @param kesh
	 * @param sex
	 * @throws ParseException 
	 */
	public Person(String idNo, String born, String join, int identity,
			int type, String BingNum, int nation, String name, String comp, int kesh, int sex, String shen) throws ParseException {

		Db_Util db = Db_Util.getInstance();

		db.getPersonTempById(idNo, this);
		
		
		
		setIdentity(identity);
		setType(type);
		setNation(nation);
		
		setBingNum(BingNum);

		Calendar bron1 = Calendar.getInstance();
		Calendar join1 = Calendar.getInstance();
		Calendar shen1 = Calendar.getInstance();


		bron1.setTime(dfYM.parse(born));// ��������
		join1.setTime(dfYM.parse(join));// �μӹ���ʱ��


		setBorn(bron1);
		setJoin(join1);

		shen1.setTime(dfYMD.parse(Util.getRetireYear(this) + dfMD.format(bron1.getTime())));
		setApproveTime(shen1);
		
		if (!"".equals(name)) {
			setName(name);
		}
		
		if (!"".equals(comp)) {
			setCompany(comp);
		}
		
		if (kesh != 0) {
			setOffice(kesh);
		}
		
		if (sex != 0) {
			setSex(sex);
		}
		
		
		if (!("".equals(shen) || shen == null)) {
			shen1.setTime(dfYMD.parse(shen));// ����ʱ��
		}
//		shen1.setTime(dfYMD.parse(Util.getRetireYear(this) + dfMD.format(bron1.getTime())));
		setApproveTime(shen1);
	}
	
	
	
	
	/**
	 * �Ӳ��� �Ӻ˼� �� ����ʱ�� 1
	 * @param idNo
	 * @param born
	 * @param join
	 * @param identity
	 * @param type
	 * @param nation
	 * @param name
	 * @param comp
	 * @param kesh
	 * @param sex
	 * @throws ParseException 
	 */
	public Person(String idNo, String born, String join, int identity,
			int type, String BingNum, int nation, String ifAddOrCut, String addOrCutBeing, String addOrCutEnd,
			String name, String comp, int kesh, int sex, String shen) throws ParseException {

		Db_Util db = Db_Util.getInstance();

		db.getPersonTempById(idNo, this);
		
		
		
		setIdentity(identity);
		setType(type);
		setNation(nation);
		
		setBingNum(BingNum);

		Calendar bron1 = Calendar.getInstance();
		Calendar join1 = Calendar.getInstance();
		Calendar shen1 = Calendar.getInstance();


		bron1.setTime(dfYM.parse(born));// ��������
		join1.setTime(dfYM.parse(join));// �μӹ���ʱ��


		setBorn(bron1);
		setJoin(join1);

		shen1.setTime(dfYMD.parse(Util.getRetireYear(this) + dfMD.format(bron1.getTime())));
		setApproveTime(shen1);
		
		if (!"".equals(name)) {
			setName(name);
		}
		
		if (!"".equals(comp)) {
			setCompany(comp);
		}
		
		if (kesh != 0) {
			setOffice(kesh);
		}
		
		if (sex != 0) {
			setSex(sex);
		}
		
		Calendar cutbejin = Calendar.getInstance();
		Calendar cutend = Calendar.getInstance();
		
		cutbejin.setTime(dfYM.parse(addOrCutBeing));// �˼���ʼʱ��
		cutend.setTime(dfYM.parse(addOrCutEnd)); // �˼�����ʱ��
		
		setIfaddorcut(ifAddOrCut);
		
		setAddorcutbegin(cutbejin);
		setAddorcutend(cutend);
		if (!("".equals(shen) || shen == null)) {
			shen1.setTime(dfYMD.parse(shen));// ����ʱ��
		}
//		shen1.setTime(dfYMD.parse(Util.getRetireYear(this) + dfMD.format(bron1.getTime())));
		setApproveTime(shen1);
	}

	
	
	@Override
	public String toString() {
		
		
		SimpleDateFormat dfYMD = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dfYM = new SimpleDateFormat("yyyy-MM");
		
		System.out.println("");
		System.out.println("��ˮ�ţ�" + getSerialNo());
		
		System.out.println("�����ţ�" + getAcceptNo());
		
		System.out.println("���֤�ţ�" + getIdNo());
		
		System.out.println("������" + getName());
		
		
		
		System.out.println("��λ���ƣ�" + getCompany());
		
		System.out.println("���ң�" + getOffice());
		
		System.out.println("�Ա�" + getSex());
		
		System.out.println("����ʱ�䣺" + dfYMD.format(getApproveTime().getTime()));
		
		System.out.println("�绰��" + getPhonenumber());
		
		
		String born = dfYM.format(getBorn());
		
		String join = dfYM.format(getJoin());
		
		System.out.println("�������£�" + born);
		
		System.out.println("�μӹ���ʱ�䣺" + join);
		
		
		return "";
	}
	
}
