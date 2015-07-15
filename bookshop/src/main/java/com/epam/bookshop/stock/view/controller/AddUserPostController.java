package com.epam.bookshop.stock.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.epam.bookshop.book.service.BookWriteService;
import com.epam.bookshop.stock.view.model.AddBookRequest;
import com.epam.bookshop.stock.view.model.AddUserRequest;
import com.epam.bookshop.stock.view.transform.AddBookRequestTransformer;
import com.epam.bookshop.stock.view.transform.AddUserRequestTransformer;
import com.epam.bookshop.user.service.UserWriteService;

@Controller
public class AddUserPostController {
	private UserWriteService userWriteService;
    private AddUserRequestTransformer addUserRequestTransformer;
    
    @Autowired
    public AddUserPostController(UserWriteService userWriteService, AddUserRequestTransformer addUserRequestTransformer) {
        super();
        this.userWriteService = userWriteService;
        this.addUserRequestTransformer = addUserRequestTransformer;
    }
    
    @ModelAttribute("addUserRequest")
    public AddUserRequest createListUsersModel(AddUserRequest addUserRequest) {
        return new AddUserRequest();
    }
    
    @RequestMapping(value = "/addUserPost.html", method = RequestMethod.POST)
    public String createUser(AddUserRequest addUserRequest, RedirectAttributes redirectAttributes) {
    	
    	if (addUserRequest.getName().isEmpty()) {
    		redirectAttributes.addFlashAttribute("message", "enter name");
    	} else if  (addUserRequest.getEmail().isEmpty()) {
    		redirectAttributes.addFlashAttribute("message", "enter email");
    	} else if (addUserRequest.getPassword().equals(addUserRequest.getPasswordConfirm())) {
	        userWriteService.saveUser(addUserRequestTransformer.transformAddUserRequestToUser(addUserRequest));
	        redirectAttributes.addFlashAttribute("message", String.format("User '%s' of '%s' saved!", addUserRequest.getName(), addUserRequest.getEmail(), addUserRequest.getPassword()));
	   	} else {
	   		//redirectAttributes.addFlashAttribute("message", 
	   		redirectAttributes.addFlashAttribute("message", "passwords don't not match");
	   		
	   	}
	   	
	   	return "redirect:addUserForm.html";

    }
	
}
