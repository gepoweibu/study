package study201901_07;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {

	/**
	 * 时间日期计算测试
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		String startStr="2015-04-01";
		String endStr="2019-03-16";
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		Date start = sf.parse(startStr);
		Date end = sf.parse(endStr);
		System.out.println("开始日期星期："+getWeek(start));
		System.out.println("结束日期星期："+getWeek(end));
		
		long millions = getMillions(startStr, endStr);
		System.out.println("相差毫秒数："+millions);
		System.out.println("相差天数："+getDays(millions));
		System.out.println("星期下标："+getWeekIndex(getDays(millions), getWeek(start)));
		
	}
	/**
	 * 获取两个日期之间的毫秒数
	 * @param str1 1999-02-11
	 * @param str2 2016-08-17
	 * @return
	 * @throws ParseException 
	 */
	public static long getMillions(String startStr,String endStr) throws ParseException {
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		Date start = sf.parse(startStr);
		System.out.println("开始日期:"+sf.format(start));
		Date end = sf.parse(endStr);
		System.out.println("结束日期:"+sf.format(end));
		return end.getTime()-start.getTime();
	}
	public static long getDays(long millions) {
		 return millions/(24*60*60*1000);
	}
	public static String getWeek(Date date){ 
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
		String week = sdf.format(date);
		return week;
	}
	public static long getWeekIndex(long days,String begeinWeek) {
		String[] week= {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		int begeinWeekIndex=-1;
		for (int i = 0; i < week.length; i++) {
			if(week[i].equals(begeinWeek.trim())) {
				begeinWeekIndex=i;
			}
		}
		long endWeekIndex=(days+begeinWeekIndex)%7;
		return endWeekIndex;
	}

}
