package com.epam.bookshop.stock.view.controller;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.bookshop.shopping.view.controller.ClearShoppingCartController;
import com.epam.bookshop.shopping.view.model.ListUsersModel;
import com.epam.bookshop.stock.view.model.AddUserRequest;
import com.epam.bookshop.stock.view.transform.AddUserRequestTransformer;
import com.epam.bookshop.user.repository.dao.UserDao;
import com.epam.bookshop.user.service.UserWriteService;

public class AddUserPostControllerTest {
	
	private AddUserPostController underTest;

	@Mock
    private UserWriteService userWriteService;
	
	@Mock
	private AddUserRequestTransformer addUserRequestTransformer;

	
	@BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
		underTest = new AddUserPostController(userWriteService, addUserRequestTransformer);
    }
	
	private AddUserRequest addUserRequest;
	
	@Mock
	private ListUsersModel listUsersModel;
	
	@Mock
	RedirectAttributes redirectAttributes;
	
	@Mock
	private UserDao userDao;
	
	
	@Test
	public void testCreateUser() {
		
		/*
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setRequestURI("/addUserPost.html");
		request.setMethod("POST");
		request.setParameter("name", "name1");
		*/
		
		
		
		addUserRequest = new AddUserRequest();
		if (redirectAttributes == null) {
			System.out.println("null");
		}
		System.out.println("null2");
		String result = underTest.createUser(addUserRequest, redirectAttributes);
		
		System.out.println("result: " + result);
		Assert.assertEquals(result, "redirect:addUserForm.html");
		
		
		
		
	}
	
	

}
