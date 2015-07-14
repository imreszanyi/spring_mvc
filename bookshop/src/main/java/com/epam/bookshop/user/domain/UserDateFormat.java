package com.epam.bookshop.user.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.epam.bookshop.book.domain.BookFormat;

public class UserDateFormat {

	private static Date date;
	
	public String getDisplayName() {
		return date.toString();
	}

	public static UserDateFormat getByString(String dateString){
		UserDateFormat result  = null;
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
		Date date = null;
		try {
			date = format.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		result.date = date;
		return result;
	}
	
}
