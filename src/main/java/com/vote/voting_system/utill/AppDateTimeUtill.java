package com.vote.voting_system.utill;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;

public class AppDateTimeUtill {
	
	public static Date getCurrentDateTime(){
		Date date = new Date();
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdf.format(date);
		try {
			date = sdf.parse(dateStr);
		} catch (Exception e) {
			date = null;
		}
		return date;
	}
	
	public static String getCurrentDateTimeInString(){
		Date date = new Date();
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.format(date);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static Date formatDateTime(String str) {
		Date date = new Date();
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = sdf.parse(str);
		} catch (Exception e) {
			date = null;
		}
		return date;
	}
	
	public static Date formatDate(String str) {
		Date date = new Date();
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse(str);
		} catch (Exception e) {
			date = null;
		}
		return date;
	}
	
	public static String getStringDateTimeFromDate(Date date) {
		// convert a time into simple date format

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
		String formatted = format.format(date);

		return formatted;
	}
	
	
	public static JSONObject dateDifferent(Date dateobjOne,Date dateobjTwo) {
		JSONObject jsonObject = new JSONObject();
		long diffDays = 0;
		long diffHours = 0;
		
		try {
			
			SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			Date day1 = myFormat.parse(getStringDateTimeFromDate(dateobjOne));
			Date day2 = myFormat.parse(getStringDateTimeFromDate(dateobjTwo));

			//in milliseconds
			long diff = day2.getTime() - day1.getTime();

			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			diffHours = diff / (60 * 60 * 1000) % 24;
			diffDays = diff / (24 * 60 * 60 * 1000);

			System.out.print(diffDays + " days, ");
			System.out.print(diffHours + " hours, ");
			System.out.print(diffMinutes + " minutes, ");
			System.out.print(diffSeconds + " seconds.");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		jsonObject.put("days", diffDays);
		jsonObject.put("hours", diffHours);
		
		return jsonObject;
		
	} 
	

}
