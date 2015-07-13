package com.epam.bookshop.shopping.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.bookshop.shopping.view.model.ListUsersModel;
import com.epam.bookshop.shopping.view.model.UserSummaryView;
import com.epam.bookshop.shopping.view.transform.UserTransformer;
import com.epam.bookshop.user.domain.User;
import com.epam.bookshop.user.service.UserSearchService;

@Controller
public class ListUserController {
	private UserSearchService userSearchService;
	private UserTransformer userTransformer;

	@Autowired
	public ListUserController(UserSearchService userSearchService, UserTransformer userTransformer) {
		this.userSearchService = userSearchService;
		this.userTransformer = userTransformer;
	}

	@ModelAttribute("listUsersModel")
	public ListUsersModel createListUsersModel() {
		List<User> users = listUsers();
		List<UserSummaryView> userViews = transformUsers(users);
		return initListUsersModel(userViews);
	}

	@RequestMapping("/users.html")
	public String showUsers() {
		return "users";
	}

	private List<UserSummaryView> transformUsers(List<User> users) {
		return userTransformer.transformUsers(users);
	}

	private ListUsersModel initListUsersModel(List<UserSummaryView> userViews) {
		return new ListUsersModel(userViews);
	}

	private List<User> listUsers() {
		return userSearchService.listUsers();
	}

}
