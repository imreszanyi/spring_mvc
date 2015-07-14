package com.epam.bookshop.user.service.transform;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Component;

import com.epam.bookshop.user.domain.User;
import com.epam.bookshop.user.repository.domain.UserEntity;

@Component
public class UserEntityTransformer {
	public List<User> transformUserEntities(Iterable<UserEntity> users) {
		List<User> result = new ArrayList<User>();
		for (UserEntity user : users) {
			result.add(transformUserEntity(user));
		}
		return result;
	}

	public User transformUserEntity(UserEntity user) {
		User result = new User();
		result.setName(user.getName());
		result.setEmail(user.getEmail());
		result.setPassword(user.getPassword());
		
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		Date date = null;
		try {
			date = format.parse(user.getBirthdate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (date == null) date = new Date();
		result.setBirthdate(date);
		return result;
	}
	
	public UserEntity transformUserToUserEntity(User user) {
		UserEntity result = new UserEntity();
		result.setName(user.getName());
		result.setEmail(user.getEmail());
		result.setPassword(user.getPassword());
		result.setBirthdate(user.getBirthdate().toString());
		return result;
	}
	
}
