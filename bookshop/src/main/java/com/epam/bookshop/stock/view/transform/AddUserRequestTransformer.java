package com.epam.bookshop.stock.view.transform;

import org.springframework.stereotype.Component;

import com.epam.bookshop.stock.view.model.AddUserRequest;
import com.epam.bookshop.user.domain.User;

@Component
public class AddUserRequestTransformer {
	public User transformAddUserRequestToUser(AddUserRequest addUserRequest) {
		User result = new User();
		result.setName(addUserRequest.getName());
		result.setEmail(addUserRequest.getEmail());
		result.setPassword(addUserRequest.getPassword());
		return result;
	}
}
