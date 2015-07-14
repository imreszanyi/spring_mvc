package com.epam.bookshop.user.view.formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.epam.bookshop.user.domain.UserDateFormat;

@Component
public class UserFormatFormatter implements Formatter<UserDateFormat> {

	@Override
	public String print(UserDateFormat userFormat, Locale locale) {
		return userFormat.getDisplayName();
	}

	@Override
	public UserDateFormat parse(String text, Locale locale) throws ParseException {
		return UserDateFormat.getByString(text);
	}

	
		
}
