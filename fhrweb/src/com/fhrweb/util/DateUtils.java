package com.fhrweb.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {
	
	/**
     * getNowTimestamp
     * @return Timestamp
     */
    public static Timestamp getNowTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
    
    /**
     * getNowDate
     * @return Date
     */
    public static Date getNowDate() {
        return new Date(System.currentTimeMillis());
    }

    /**
     * getDate
     * @param s Date String
     * @return Date
     */
    public static Date getDate(String s) {
        return Date.valueOf(s);
    }

    /**
     * getNow Date format is yyyy-MM-dd HH:mm:ss
     * @return String
     */
    public static String getNow() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date dateTime = new java.util.Date();
        return formatter.format(dateTime);
    }

    /**
     * getToday date format is yyyy-MM-dd
     * @return String
     */
    public static String getToday() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dateTime = new java.util.Date();
        return formatter.format(dateTime);
    }

    /**
     * getFormatToday
     * @param format str like yyyy-MM-dd HH:mm:ss
     * @return String
     */
    public static String getFormatToday(String format) {
        java.util.Date d = new java.util.Date();
        SimpleDateFormat fmt = new SimpleDateFormat(format);
        return fmt.format(d);
    }

    /**
     * getDateByStr 
     * @param str yyyy-MM-dd
     * @return Date
     */
    public static final java.util.Date getDateByStr(String str){
    	try{
    		String strFormat = "yyyy-MM-dd";
    		SimpleDateFormat format = new SimpleDateFormat(strFormat);
    		if(str==null || str.equals("")){
    			return null;
    		}else{
    			return format.parse(str);
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
		return null;
    }
    
    /**
     * getDatetimeByStr 
     * @param str yyyy-MM-dd HH:mm:ss
     * @return Date
     */
    public static final java.util.Date getDatetimeByStr(String str){
    	try{
    		String strFormat = "yyyy-MM-dd HH:mm:ss";
    		SimpleDateFormat format = new SimpleDateFormat(strFormat);
    		if(str==null || str.equals("")){
    			return null;
    		}else{
    			return format.parse(str);
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
		return null;
    }
    
    /**
     * getStrByDatetime 
     * @param date 
     * @return String yyyy-MM-dd HH:mm:ss
     */
    public static final String getStrByDatetime(java.util.Date date){
    	try{
    		String strFormat = "yyyy-MM-dd HH:mm:ss";
    		SimpleDateFormat format = new SimpleDateFormat(strFormat);
    		if(date==null || date.equals("")){
    			return null;
    		}else{
    			return format.format(date);
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
		return null;
    }
    
    /**
     * getStrByDate 
     * @param date 
     * @return String yyyy-MM-dd
     */
    public static final String getStrByDate(java.util.Date date){
    	try{
    		String strFormat = "yyyy-MM-dd";
    		SimpleDateFormat format = new SimpleDateFormat(strFormat);
    		if(date==null || date.equals("")){
    			return null;
    		}else{
    			return format.format(date);
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
		return null;
    }
    
    /**
     * getFormatStr 
     * @param date java.util.Date
     * @param strFormat like yyyy-MM-dd HH:mm:ss
     * @return String 
     */
    public static final String getFormatStr(java.util.Date date, String strFormat){
    	try{
    		SimpleDateFormat format = new SimpleDateFormat(strFormat);
    		if(date==null || date.toString().equals("")){
    			return null;
    		}else{
    			return format.format(date);
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
		return null;
    }
    
    /**
     * getFormatDate 
     * @param str string
     * @param strFormat like yyyy-MM-dd HH:mm:ss
     * @return Date 
     */
    public static final java.util.Date getFormatDate(String str, String strFormat){
    	try{
    		SimpleDateFormat format = new SimpleDateFormat(strFormat);
    		if(str==null || str.equals("")){
    			return null;
    		}else{
    			return format.parse(str);
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
		return null;
    }
    
    public static java.util.Date[] getMondayAndNextMonday(java.util.Date date){
    	if(date==null)return null;
    	java.util.Date fromDate = null,endDate = null;
    	try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int a = cal.get(Calendar.DAY_OF_WEEK);
			//如果是星期天
			if(a==1){
				//加一天，时间变成下周�?
				cal.add(Calendar.DAY_OF_MONTH, 1);
				endDate = cal.getTime();
				//减一�?,时间变成上周�?
				cal.add(Calendar.WEEK_OF_YEAR, -1);
				fromDate = cal.getTime();
			}else{
				//如果不是星期�?,下面�?句则是改成本周一
				cal.add(Calendar.DAY_OF_MONTH, -a+2);
				fromDate = cal.getTime();
				//加一周，时间变成下周�?
				cal.add(Calendar.WEEK_OF_YEAR, 1);
				endDate = cal.getTime();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return new java.util.Date[]{fromDate,endDate};
    }

    
}
