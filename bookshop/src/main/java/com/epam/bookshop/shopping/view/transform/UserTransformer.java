package com.epam.bookshop.shopping.view.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.epam.bookshop.shopping.view.model.UserSummaryView;
import com.epam.bookshop.user.domain.User;

@Component
public class UserTransformer {
	public List<UserSummaryView> transformUsers(List<User> users) {
		List<UserSummaryView> result = new ArrayList<UserSummaryView>();
		for (User user : users) {
			result.add(transformUser(user));
		}
		return result;
	}

	private UserSummaryView transformUser(User user) {
		UserSummaryView result = new UserSummaryView();
		result.setName(user.getName());
		result.setEmail(user.getEmail());
		result.setPassword(user.getPassword());
		return result;
	}
}