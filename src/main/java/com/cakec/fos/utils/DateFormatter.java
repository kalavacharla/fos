package com.cakec.fos.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class DateFormatter {
	
	private static final Logger logger = Logger.getLogger(DateFormatter.class);
	
	public Date convertStringtoDate(String dateInString) throws ParseException{
		logger.info("Converting string dob to Date");
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
		Date date = formatter.parse(dateInString);
		System.out.println(date);
		System.out.println(formatter.format(date));
		return date;

	}
}
