package com.epam.bookshop.user.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.bookshop.book.domain.Book;
import com.epam.bookshop.book.repository.domain.BookEntity;
import com.epam.bookshop.user.domain.User;
import com.epam.bookshop.user.repository.dao.UserDao;
import com.epam.bookshop.user.repository.domain.UserEntity;
import com.epam.bookshop.user.service.transform.UserEntityTransformer;

@Service
public class UserSearchService {

	private UserDao userDao;
	private UserEntityTransformer userEntityTransformer;

	@Autowired
	public UserSearchService(UserDao userDao, UserEntityTransformer userEntityTransformer) {
		super();
		this.userDao = userDao;
		this.userEntityTransformer = userEntityTransformer;
	}
	
	public List<User> listUsers(String name, String email) {
		return transformUserEntities(findUserEntities(formatQuery(name), formatQuery(email)));
	}
	
	private UserEntity doFindUser(Long userId) {
		return userDao.findOne(userId);
	}

	private Iterable<UserEntity> findUserEntities() {
		return userDao.findAll();
	}
	
	private String formatQuery(String name) {
		String result;
		if (name == null) {
			result = "%";
		} else {
			result = "%" + name + "%";  //String.format("%%%s%%", title);
		}
		return result;
	}
	
	public User findUser(Long userId) {
		return transformUserEntity(doFindUser(userId));
	}
	
	private User transformUserEntity(UserEntity user) {
		return userEntityTransformer.transformUserEntity(user);
	}
	
	private List<User> transformUserEntities(Iterable<UserEntity> users) {
		return userEntityTransformer.transformUserEntities(users);
	}
	
	private Iterable<UserEntity> findUserEntities(String name, String email) {
		//return userDao.findByNameIgnoreCaseLike(name);
		return userDao.findByNameIgnoreCaseLikeAndEmailIgnoreCaseLike(name, email);
	}
	
}
