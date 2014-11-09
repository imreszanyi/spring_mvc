package com.epam.bookshop.stock.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.bookshop.stock.view.model.AddBookRequest;

@Controller
public class AddBookFormController {

	@ModelAttribute("addBookRequest")
	public AddBookRequest createListBooksModel(@ModelAttribute AddBookRequest addBookRequest) {
		return new AddBookRequest();
	}

	@RequestMapping(value = "/addBookForm.html", method = RequestMethod.GET)
	private String createBook() {
		return "add_book";
	}

}
