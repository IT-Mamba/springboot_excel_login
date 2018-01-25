package com.yht.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilDate {
	
    public static final String dtLong                  = "yyyyMMddHHmmss";
    
    public static final String simple                  = "yyyy-MM-dd HH:mm:ss";
    
    public static final String dtShort                 = "yyyyMMdd";
	
    
    /**
     * 返回系统当前时间(精确到毫秒),作为一个唯一的文件编号
     *      以yyyyMMddHHmmss为格式的当前系统时间
     */
	public  static String getFileNum(){
		Date date=new Date();
		DateFormat df=new SimpleDateFormat(dtLong);
		return df.format(date);
	}
	
	/**
	 * 获取系统当前日期(精确到毫秒)，格式：yyyy-MM-dd HH:mm:ss
	 */
	public  static String getDateFormatter(){
		Date date=new Date();
		DateFormat df=new SimpleDateFormat(simple);
		return df.format(date);
	}
	
	/**
	 * 获取系统当期年月日(精确到天)，格式：yyyyMMdd
	 */
	public static String getDate(){
		Date date=new Date();
		DateFormat df=new SimpleDateFormat(dtShort);
		return df.format(date);
	}
	
}
