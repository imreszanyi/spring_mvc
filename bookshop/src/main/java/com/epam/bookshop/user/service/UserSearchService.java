package com.epam.bookshop.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epam.bookshop.user.domain.User;
import com.epam.bookshop.user.repository.dao.UserDao;
import com.epam.bookshop.user.repository.domain.UserEntity;
import com.epam.bookshop.user.service.transform.UserEntityTransformer;

@Service
public class UserSearchService {

	private UserDao userDao;
	private UserEntityTransformer userEntityTransformer;

	public UserSearchService(UserDao userDao, UserEntityTransformer userEntityTransformer) {
		super();
		this.userDao = userDao;
		this.userEntityTransformer = userEntityTransformer;
	}
	
	public List<User> listBooks() {
		return transformUserEntities(findUserEntities());
	}

	private List<User> transformUserEntities(Iterable<UserEntity> users) {
		return userEntityTransformer.transformBookEntities(users);
	}

	private Iterable<UserEntity> findUserEntities() {
		return userDao.findAll();
	}
	
	
}
