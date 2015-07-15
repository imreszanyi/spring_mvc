package com.epam.bookshop.shopping.view.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.epam.bookshop.shopping.view.model.UserSummaryView;
import com.epam.bookshop.shopping.view.transform.UserTransformer;
import com.epam.bookshop.user.service.UserSearchService;

@RestController
@RequestMapping("/rest-api")
public class ListUserRestController {
	
	private UserSearchService userSearchService;
    private UserTransformer userTransformer;

    @Autowired
    public ListUserRestController(UserSearchService userSearchService, UserTransformer userTransformer) {
        super();
        this.userSearchService = userSearchService;
        this.userTransformer = userTransformer;
    }

    @RequestMapping("/users")
    public List<UserSummaryView> clients() {
        return userTransformer.transformUsersToSummaries(userSearchService.listAllUsers());
    }

}
