package com.epam.bookshop.shopping.view.model;

import java.util.List;

public class ListUsersModel {
	private List<UserSummaryView> users;

	public ListUsersModel(List<UserSummaryView> users) {
		super();
		this.users = users;
	}

	public List<UserSummaryView> getBooks() {
		return users;
	}
}
