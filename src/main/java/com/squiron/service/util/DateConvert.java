package com.squiron.service.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvert {
	
	public static Date covertFromStr(String date, String dateFormat) {
		
		String strDateFormat = "";
		
		if (dateFormat == null || dateFormat == "") {
		
			strDateFormat = "yyyy-MM-dd";
					
		}else {
			
			strDateFormat = dateFormat;
			
		}
		
	    try {
	    	
			return new SimpleDateFormat(strDateFormat).parse(date);
		} catch (ParseException e) {
			
			return null;
		}  
	    
	}
}
