package com.Picloud.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class DateUtil {

	/**
	 * 获取年月日字符串
	 * @return
	 */
	public  static String getDateNum() {
		Calendar c = Calendar.getInstance();
		String year = Integer.toString(c.get(Calendar.YEAR));
		String month = Integer.toString(c.get(Calendar.MONTH));
		String date = Integer.toString(c.get(Calendar.DATE));
		return year+month+date;
	}
	
	/**
	 * 获取年月日时分秒字符串
	 * @return
	 */
	public  static String getSecNum() {
		Calendar c = Calendar.getInstance();
		String year = Integer.toString(c.get(Calendar.YEAR));
		String month = Integer.toString(c.get(Calendar.MONTH));
		String date = Integer.toString(c.get(Calendar.DATE));
		String hour = Integer.toString(c.get(Calendar.HOUR));
		String minute = Integer.toString(c.get(Calendar.MINUTE));
		String second = Integer.toString(c.get(Calendar.SECOND));
		return year+month+date+hour+minute+second;
	}
	
	/**
	 * 将时间按照格式进行转换
	 * @param date 时间
	 * @param format 时间格式
	 * @return
	 */
	public static String formatDate(Date date, String format) {
		String result = "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		if (date != null) {
			result = sdf.format(date);
		}
		return result;
	}

	/**
	 * 将String时间转换成某时间格式
	 * @param str 时间
	 * @param format 格式
	 * @return
	 * @throws Exception
	 */
	public static Date formatString(String str, String format) throws Exception {
		if ((str == null)||(str.equals(""))){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(str);
	}

	/**
	 * 获取当前日期时间，24小时制
	 * @return String类型的时间
	 * @throws Exception
	 */
	public static String getCurrentDateStr() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(date);
	}
	
	public static String getCurrentDateMS() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sdf.format(date);
	}
	
	/**
	 * 获取当前时间的前一天
	 * @return
	 */
	public static String getPereviousDayMS() {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sdf.format(date);
	}
	
	/**
	 * 获取距离今日的时间统计
	 */
	public static String getLastTime(String lastTime){
		Long lastTimeL = Long.parseLong(lastTime);
		Long nowTime = new Date().getTime();
		Long range = nowTime - lastTimeL;
		int days = (int) (range/3600/1000/24);
		if(days < 1){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = sdf.format(new Date(lastTimeL));
			return date;
		} else if(days < 30){
			return days + "天前";
		} else {
			return "很久以前";
		}
	}
	
	public static String getStrTime(String strTime){
		String year = strTime.substring(0, 4);
		String month = strTime.substring(4,6);
		String day = strTime.substring(6,8);
		String hour = strTime.substring(8,10);
		String minute = strTime.substring(10,12);
		String second = strTime.substring(12,14);
		return year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
	}

}


