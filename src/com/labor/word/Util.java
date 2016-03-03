package com.labor.word;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import com.labor.util.Db_Util;


public class Util {
	
	private static SimpleDateFormat dfY = new SimpleDateFormat("yyyy");
	private static SimpleDateFormat dfYM = new SimpleDateFormat("yyyy-MM");
	private static SimpleDateFormat dfYMD = new SimpleDateFormat("yyyy-MM-dd");
	
	
	
	private static List<String> monthsList = new ArrayList<String>();
	private static List<String> carwheelList = new ArrayList<String>();
	
	private static Iterator<String> iter;
	
	private static String months[] = { "-01-30", "-02-28", "-03-30", "-04-30", "-05-30",
			"-06-30", "-07-30", "-08-30", "-09-30", "-10-30", "-11-30",
			"-12-30" };
	
	private static String carwheel[] = { "������","������","��ѫ","��־��","�����","����"
		,"������","������","�ſ�ͩ","�⽨��","����ŷ","�ƿ�ʵ"
		,"����˨","��ΰ","����","������","����"
		,"������","����","������","����־","���ຣ","��ʤ��"
		,"������","��־��","����","������","�ھý�","������"
		,"����","������","������","������"
		
	};
	
	
	private Util() {
		int i = 0;
		while (i != months.length) {
			monthsList.add(months[i++]);
		}
		i = 0;
		while (i != carwheel.length) {
			carwheelList.add(carwheel[i++]);
		}

	}
	
	private static Util util = new Util();
	


	public static String getSex(int sex) {

		switch (sex) {
		case 1:
			return "  ��  ";
		case 2:
			return "  Ů  ";
		default:
			return " ";
		}
	}

	public static String getKeshi(int num) {

		switch (num) {

		case 1:
			return "  ҵ��һ��  ";
		case 2:
			return "  ҵ�����  ";
		case 3:
			return "  ҵ������  ";
		case 4:
			return "  ֱ����  ";
		default:
			return " ";
		}

	}

	public static String getType(int type) {

		switch (type) {
		case 1:
			return "  ����  ";
		case 2:
			return "  �ɲ�  ";
		default:
			return " ";
		}

	}

	public static int getYear(Person person) {
		int age = getMonthNum(person.getJoin(), person.getApproveTime());
		
		int cut = 0;
		
		if (person.getIfaddorcut() != null ) {
			cut = getMonthNum(person.getAddorcutbegin(), person.getAddorcutend());	
		}
		
		
		//TODO ������ӹ��� �����Ƿ���ȷ
		
		if("1".equals(person.getIfaddorcut())) {
			age += cut;
		}
		if("2".equals(person.getIfaddorcut())) {
			age -= cut;
		}
		
		return age / 12;
	}
	
//	public static int getYear(Calendar c1, Calendar c2) {
//		int year = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
//		int month = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH) + 1;
//		
//		if(month == 12) {
//			year++;
//		}
//
//		return month >= 0 ? year : year - 1;
//	}

	public static int getMonth(Person person) {
		
		int age = getMonthNum(person.getJoin(), person.getApproveTime());
		
		int cut = 0;
		
		if (person.getIfaddorcut() != null || !"".equals(person.getIfaddorcut())) {
			cut = getMonthNum(person.getAddorcutbegin(), person.getAddorcutend());	
		}
		
		
		if("1".equals(person.getIfaddorcut())) {
			age += cut;
		}
		if("2".equals(person.getIfaddorcut())) {
			age -= cut;
		}
		
		return age % 12;
				
	}
	
//	public static int getMonth(Calendar c1, Calendar c2) {
//		int month = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH) + 1;
//		
//		if(month == 12) {
//			month = month - 12;
//		}
//
//		return month >= 0 ? month : month + 12;
//	}
	
	public static boolean isCut(Person person) {
		
		int cut = getMonthNum(person.getAddorcutbegin(), person.getAddorcutend());
		
		if(cut == 1) {
			return false;
		}
		
		return true;
	}
	
	public static int getMonthNum(Calendar c1, Calendar c2) {
		
		int year = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
		int month = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH) + 1;
		
		return year * 12 + month;
		
//		if(month == 12) {
//			year++;
//		}

//		return month >= 0 ? year : year - 1;
		
	}

	public static String getShenfen(int type) {
		switch (type) {
		case 1:
			return "  ����  ";
		case 2:
			return "  ��  ";
		case 3:
			return "  ���⹤��  ";
		case 4:
			return "  ��  ";
		case 5:
			return "  �Ʋ�  ";
		case 6:
			return "  ת����ҵ  ";
		default:
			return " ";
		}
	}
	
	
	public static String getNation(int nation) {
		switch (nation) {
		case 1:
			return "  ��  ";
		case 2:
			return "  ��  ";
		case 3:
			return "  ��  ";
		case 4:
			return "  ��  ";
		case 5:
			return "  ����  ";
		case 6:
			return "  ׳  ";
		case 7:
			return "  ���Ӷ�  ";
		case 8:
			return "  ���¿�  ";
		case 9:
			return "  ����˹  ";
		case 10:
			return "  ��  ";
		case 11:
			return "  ά���  ";
		case 12:
			return "  ��  ";
		case 13:
			return "  ��  ";
		default:
			return " ";
		}
	}
	
	
	
	
	
	public static int getRetireYear(Person person) {
		// int year = person.getBorn().get;

		int year = -1;

		if (person.getSex() == 1) {
			if (person.getType() == 1) {// ������
				year = 60;
			}
			if (person.getType() == 2) {
				year = 50;
			}
			if (person.getType() == 3) {
				year = 55;
			}
			// if (person.getType() == 4) {
			// year =55;
			// }
			if (person.getType() == 5) {
				year = 55;
			}

		} else if (person.getSex() == 2 && person.getIdentity() == 1) {

			if (person.getType() == 1) {
				year = 50;
			}
			if (person.getType() == 2) {
				year = 45;
			}
			if (person.getType() == 3) {
				year = 45;
			}
			// if (person.getType() == 4) {
			// year =55;
			// }
			if (person.getType() == 5) {
				year = 45;
			}

		} else if (person.getSex() == 2 && person.getIdentity() == 2) {
			if (person.getType() == 1) {
				year = 55;
			}
			if (person.getType() == 2) {
				year = 50;
			}
			if (person.getType() == 3) {
				year = 50;
			}
			// if (person.getType() == 4) {
			// year =55;
			// }
			if (person.getType() == 5) {
				year = 50;
			}

		}

		if (year != -1) {
			year += Integer.parseInt(dfY.format(person.getBorn().getTime()));
		}

		return year;
	}
	
	
	

	/**
	 * 	У��
	 */
	public static boolean check(Person person) {
		
		
		
		Calendar shen = person.getApproveTime();
//		Calendar now = Calendar.getInstance();
		Calendar born = person.getBorn();

		boolean is = true;

		int year = 0;
		int month = 0;

//		if (person.getId().length() !=p 16) {
//			System.err.println("������ λ�����ԡ�");
//			is = false;
//		}
		
		if (person.getSex() != 1 && person.getSex() != 2) {
			System.err.println(person.getName() + "���Ա𲻶�");
			is = false;
		}
		
		Db_Util db = Db_Util.getInstance();
		
		if (db.ifJiTi(person) == false) {
			is = false;
			System.err.println(person.getName() + "(" +person.getIdNo() + ")"+ ":������幤��");
		}
		

		if (person.getType() == 2 || person.getType() == 4) {
			
			String tempNum = person.getBingNum();
			
			if (person.getBingNum()== null || person.getBingNum() == "") {
				System.err.println(person.getName() + "�����˱��û��д");
				is = false;
			} else if (tempNum.length() != 8) {
				System.err.println(person.getName() + "�����˱��λ������");
				is = false;
			} else {
				String temp = "\\d{4}-\\d{3}";
				if (person.getBingNum().matches(temp) == false) {
					System.err.println(person.getName() + "�����˱�Ÿ�ʽ����");
					is = false;
				}
			}

		}
		
		
		iter = carwheelList.iterator();
		
		while (iter.hasNext()) {
			if (person.getName().matches(iter.next())) {
				System.err.println("��� " + person.getName() + " �Ƿ������ɹ��������ֳ�ְ�����������ڳ���������");
			}
		}
		
		
		String time = dfYMD.format(person.getApproveTime().getTime());
		time = time.substring(4);

		if (person.getType() == 3 || person.getType() == 2) {
			boolean isMonth = false;
			iter = monthsList.iterator();
			while (iter.hasNext() && isMonth == false) {
				isMonth = time.matches(iter.next());
			}
			if (isMonth == false) {
				System.err.println(person.getName() + "���������ڲ���");
				is = false;
			}
		}
		
		
		int year1 = getYear(person);
		if ((year1 < 15 && !person.getCompany().matches("����"))|| year1 > 46) {
			System.err.println(person.getName() + "���ɷ����޲���");
			is = false;
		}
		
		Calendar cal = Calendar.getInstance(); 
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DATE, 1);
		cal.add(Calendar.DATE, -1);
	
		if (person.getApproveTime().after(cal)) {
			
			System.err.println(person.getName() + ":���������������䡣");
			is = false;
		}
		
		
		year = shen.get(Calendar.YEAR) - born.get(Calendar.YEAR);
		month = shen.get(Calendar.MONTH) - born.get(Calendar.MONTH);
		int temp = month >= 0 ? year : year - 1;

		if (person.getSex() == 1) {
			if (person.getType() == 1) {// ������
				if (temp < 60) {
					System.err.println(person.getName() + ":" + temp + " �� ��������û��60�꣡����");
					is = false;
				} else if ((temp > 60) || ((temp == 60) && (month != 0))) {
					System.out.println(person.getName() +"�� ���ǵ��°������ݣ�ע���������ڣ�����");
				}
			}
			if (person.getType() == 2) {
				if (temp < 50) {
					System.err.println(person.getName() + ":" + temp + " �� ��������û��50�꣡����");
					is = false;
				} else if ((temp >= 60) ) {
					System.err.println(person.getName() + ":" + temp + " �� �������ݳ���60�꣡����");
					is = false;
				}
			}
			if (person.getType() == 3) {
				if (temp < 55) {
					System.err.println(person.getName() + ":" + temp + " �� ���⹤������û��55�꣡����");
					is = false;
				} else if ((temp >= 60) ) {
					System.err.println(person.getName() + ":" + temp + " �� ���⹤�����ݳ���60�꣡����");
					is = false;
				}
			}
		} else if (person.getSex() == 2) {
			if (person.getType() == 1) {// Ů����

				if (person.getIdentity() == 1) {
					if (temp < 50) {
						System.err.println(person.getName() + ":" + temp + " Ů���� ��������û��50�꣡����");
						is = false;
					} else if ((temp > 50) || ((temp == 50) && (month != 0))) {
						System.out.println(person.getName() +"�����ǵ��°������ݣ�ע���������ڣ�����");
					}
				}
				if (person.getIdentity() == 2) {
					if (temp < 55) {
						System.err.println(person.getName() + ":" + temp + " Ů �ɲ���������û��55�꣡����");
						is = false;
					} else if ((temp > 55) || ((temp == 55) && (month != 0))) {
						System.out.println(person.getName() + "���ǵ��°������ݣ�ע���������ڣ�����");
					}
				}
			}
			if ((person.getType() == 2) || (person.getType() == 3)) {
				if (temp < 45) {
					System.err.println(person.getName() + ":" + temp + " Ů���˻����⹤������û��45�꣡����");
					is = false;
				}
				if (temp >= 50) {
					System.err.println(person.getName() + ":" + temp + " Ů���˻����⹤�����ݳ���50�꣡����");
					is = false;
				}
			}
//			if (person.getShenfen() == 5) {// Ů����
//
//				if (person.getType() == 1) {
//					if (temp < 45) {
//						System.err.println(temp + " Ů���� �Ʋ�����û��45�꣡����");
//						is = false;
//					} else if ((temp > 45) || ((temp == 45) && (month != 0))) {
//						System.err.println("���ǵ��°������ݣ�ע���������ڣ�����");
//					}
//				}
//				if (person.getType() == 2) {
//					if (temp < 50) {
//						System.err.println(temp + " Ů �ɲ��Ʋ�����û��50�꣡����");
//						is = false;
//					} else if ((temp > 50) || ((temp == 50) && (month != 0))) {
//						System.err.println("���ǵ��°������ݣ�ע���������ڣ�����");
//					}
//				}
//			}
		}

		return is;
	}
	
	
	
	public static boolean checkTempPerson(Person_Temp person) {
		boolean is = true;
		
		int office = person.getOffice();
		int sex = person.getSex();
		String id = person.getIdNo();
		
		if (office != 1&& office != 2 && office != 3 && office != 4 && office != 0) {
			System.err.println(person.getName() + "�����Ҳ���");
			is = false;
		} 
		
		if (sex != 1&& sex != 2) {
			System.err.println(person.getName() + "���Ա𲻶�");
			is = false;
		}
		
		if (id.length() != 18) {
			System.err.println(person.getName() + "���֤λ������");
			is = false;
		} else if (id.length() == 18) {
			if (Integer.parseInt(id.substring(16, 17))%2 != sex%2) {
				System.err.println(person.getName() + "���֤�Ա��¼���Ա𲻷�");
				is = false;
			}
			
		}
		
		
		
		return is;
	}

	public static Util getUtil() {
		return util;
	}

	public static void setUtil(Util util) {
		Util.util = util;
	}
	
	
	
}
