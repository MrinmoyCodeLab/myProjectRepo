package com.store.common.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import com.store.common.constant.CommonConstant;

public  class CommonUtil {

	
	public static boolean assertNotNullObject(Object obj) {
		if(obj!=null) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public static boolean assertNotNullList(List arry) {
		if(arry!= null && arry.size() > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public static boolean assertNotEmptyString(String str) {
		if(str!= null && str.trim().length() > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public static LocalDateTime getDateFromString(String date) {
		
		LocalDate dateTime = null ;
		LocalDateTime localDateTime = null;
		try {
			DateTimeFormatter simpleDateFormat = DateTimeFormatter.ofPattern(CommonConstant.DATE_FORMAT);
			dateTime = LocalDate.parse(date, simpleDateFormat );
			localDateTime  = dateTime.atStartOfDay();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return localDateTime;
		
	}
	
	public static String getDateFromString(Timestamp date) {
		
		String dateString ="" ;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(CommonConstant.DATE_FORMAT);
			dateString = simpleDateFormat.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateString;
		
	}
	
	public static LocalDateTime getCurrentSystemDate() {
		
		LocalDateTime dateTime = null ;
		String currentdate = "" ;
		try {
			Date date = new  Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(CommonConstant.DATE_FORMAT);
			currentdate = simpleDateFormat.format(date);
			dateTime = getDateFromString(currentdate);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateTime;
		
	}
	
	
	
	
}
