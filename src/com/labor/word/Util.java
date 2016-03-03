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
	
	private static String carwheel[] = { "王初二","吴连君","奇勋","胡志军","马国庆","王金"
		,"刘锡和","刘和宁","张克桐","吴建军","董海欧","云克实"
		,"赵兰栓","周伟","杨润","连永祥","王华"
		,"刘登运","顾向东","吕建琴","孙忠志","杜青海","毕胜利"
		,"郭恩俊","王志敏","白杨","范建华","于久江","赵正军"
		,"韩星","李卫军","王晓凤","陈彦蕊"
		
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
			return "  男  ";
		case 2:
			return "  女  ";
		default:
			return " ";
		}
	}

	public static String getKeshi(int num) {

		switch (num) {

		case 1:
			return "  业务一科  ";
		case 2:
			return "  业务二科  ";
		case 3:
			return "  业务三科  ";
		case 4:
			return "  直属科  ";
		default:
			return " ";
		}

	}

	public static String getType(int type) {

		switch (type) {
		case 1:
			return "  工人  ";
		case 2:
			return "  干部  ";
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
		
		
		//TODO 增加添加工龄 看看是否正确
		
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
			return "  正常  ";
		case 2:
			return "  因病  ";
		case 3:
			return "  特殊工种  ";
		case 4:
			return "  因病  ";
		case 5:
			return "  破产  ";
		case 6:
			return "  转制企业  ";
		default:
			return " ";
		}
	}
	
	
	public static String getNation(int nation) {
		switch (nation) {
		case 1:
			return "  汉  ";
		case 2:
			return "  回  ";
		case 3:
			return "  蒙  ";
		case 4:
			return "  满  ";
		case 5:
			return "  朝鲜  ";
		case 6:
			return "  壮  ";
		case 7:
			return "  达斡尔  ";
		case 8:
			return "  鄂温克  ";
		case 9:
			return "  俄罗斯  ";
		case 10:
			return "  侗  ";
		case 11:
			return "  维吾尔  ";
		case 12:
			return "  瑶  ";
		case 13:
			return "  苗  ";
		default:
			return " ";
		}
	}
	
	
	
	
	
	public static int getRetireYear(Person person) {
		// int year = person.getBorn().get;

		int year = -1;

		if (person.getSex() == 1) {
			if (person.getType() == 1) {// 男正常
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
	 * 	校验
	 */
	public static boolean check(Person person) {
		
		
		
		Calendar shen = person.getApproveTime();
//		Calendar now = Calendar.getInstance();
		Calendar born = person.getBorn();

		boolean is = true;

		int year = 0;
		int month = 0;

//		if (person.getId().length() !=p 16) {
//			System.err.println("受理编号 位数不对。");
//			is = false;
//		}
		
		if (person.getSex() != 1 && person.getSex() != 2) {
			System.err.println(person.getName() + "：性别不对");
			is = false;
		}
		
		Db_Util db = Db_Util.getInstance();
		
		if (db.ifJiTi(person) == false) {
			is = false;
			System.err.println(person.getName() + "(" +person.getIdNo() + ")"+ ":办过集体工。");
		}
		

		if (person.getType() == 2 || person.getType() == 4) {
			
			String tempNum = person.getBingNum();
			
			if (person.getBingNum()== null || person.getBingNum() == "") {
				System.err.println(person.getName() + "：病退编号没填写");
				is = false;
			} else if (tempNum.length() != 8) {
				System.err.println(person.getName() + "：病退编号位数不对");
				is = false;
			} else {
				String temp = "\\d{4}-\\d{3}";
				if (person.getBingNum().matches(temp) == false) {
					System.err.println(person.getName() + "：病退编号格式不对");
					is = false;
				}
			}

		}
		
		
		iter = carwheelList.iterator();
		
		while (iter.hasNext()) {
			if (person.getName().matches(iter.next())) {
				System.err.println("检查 " + person.getName() + " 是否是内蒙古汽车齿轮厂职工，该名字在除名名单内");
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
				System.err.println(person.getName() + "：审批日期不对");
				is = false;
			}
		}
		
		
		int year1 = getYear(person);
		if ((year1 < 15 && !person.getCompany().matches("个体"))|| year1 > 46) {
			System.err.println(person.getName() + "：缴费年限不对");
			is = false;
		}
		
		Calendar cal = Calendar.getInstance(); 
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DATE, 1);
		cal.add(Calendar.DATE, -1);
	
		if (person.getApproveTime().after(cal)) {
			
			System.err.println(person.getName() + ":不到法定退休年龄。");
			is = false;
		}
		
		
		year = shen.get(Calendar.YEAR) - born.get(Calendar.YEAR);
		month = shen.get(Calendar.MONTH) - born.get(Calendar.MONTH);
		int temp = month >= 0 ? year : year - 1;

		if (person.getSex() == 1) {
			if (person.getType() == 1) {// 男正常
				if (temp < 60) {
					System.err.println(person.getName() + ":" + temp + " 男 正常退休没到60岁！！！");
					is = false;
				} else if ((temp > 60) || ((temp == 60) && (month != 0))) {
					System.out.println(person.getName() +"： 不是当月办理退休，注意审批日期！！！");
				}
			}
			if (person.getType() == 2) {
				if (temp < 50) {
					System.err.println(person.getName() + ":" + temp + " 男 病退退休没到50岁！！！");
					is = false;
				} else if ((temp >= 60) ) {
					System.err.println(person.getName() + ":" + temp + " 男 病退退休超过60岁！！！");
					is = false;
				}
			}
			if (person.getType() == 3) {
				if (temp < 55) {
					System.err.println(person.getName() + ":" + temp + " 男 特殊工种退休没到55岁！！！");
					is = false;
				} else if ((temp >= 60) ) {
					System.err.println(person.getName() + ":" + temp + " 男 特殊工种退休超过60岁！！！");
					is = false;
				}
			}
		} else if (person.getSex() == 2) {
			if (person.getType() == 1) {// 女正常

				if (person.getIdentity() == 1) {
					if (temp < 50) {
						System.err.println(person.getName() + ":" + temp + " 女工人 正常退休没到50岁！！！");
						is = false;
					} else if ((temp > 50) || ((temp == 50) && (month != 0))) {
						System.out.println(person.getName() +"：不是当月办理退休，注意审批日期！！！");
					}
				}
				if (person.getIdentity() == 2) {
					if (temp < 55) {
						System.err.println(person.getName() + ":" + temp + " 女 干部正常退休没到55岁！！！");
						is = false;
					} else if ((temp > 55) || ((temp == 55) && (month != 0))) {
						System.out.println(person.getName() + "不是当月办理退休，注意审批日期！！！");
					}
				}
			}
			if ((person.getType() == 2) || (person.getType() == 3)) {
				if (temp < 45) {
					System.err.println(person.getName() + ":" + temp + " 女病退或特殊工种退休没到45岁！！！");
					is = false;
				}
				if (temp >= 50) {
					System.err.println(person.getName() + ":" + temp + " 女病退或特殊工种退休超过50岁！！！");
					is = false;
				}
			}
//			if (person.getShenfen() == 5) {// 女正常
//
//				if (person.getType() == 1) {
//					if (temp < 45) {
//						System.err.println(temp + " 女工人 破产退休没到45岁！！！");
//						is = false;
//					} else if ((temp > 45) || ((temp == 45) && (month != 0))) {
//						System.err.println("不是当月办理退休，注意审批日期！！！");
//					}
//				}
//				if (person.getType() == 2) {
//					if (temp < 50) {
//						System.err.println(temp + " 女 干部破产退休没到50岁！！！");
//						is = false;
//					} else if ((temp > 50) || ((temp == 50) && (month != 0))) {
//						System.err.println("不是当月办理退休，注意审批日期！！！");
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
			System.err.println(person.getName() + "：科室不对");
			is = false;
		} 
		
		if (sex != 1&& sex != 2) {
			System.err.println(person.getName() + "：性别不对");
			is = false;
		}
		
		if (id.length() != 18) {
			System.err.println(person.getName() + "身份证位数不对");
			is = false;
		} else if (id.length() == 18) {
			if (Integer.parseInt(id.substring(16, 17))%2 != sex%2) {
				System.err.println(person.getName() + "身份证性别和录入性别不符");
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
