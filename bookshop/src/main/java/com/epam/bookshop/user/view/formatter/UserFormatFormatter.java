package com.epam.bookshop.user.view.formatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;



@Component
public class UserFormatFormatter implements Formatter<Date> {

	@Override
	public String print(Date userFormat, Locale locale) {
		return userFormat.toString();
	}

	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd", locale);
		Date date = null;
		try {
			date = format.parse(text);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
		
}
