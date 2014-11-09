package com.epam.bookshop.home.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@ModelAttribute("bookshopName")
	public String bookshopName() {
		return "Bookshop";
	}

	@RequestMapping("/")
	public String homepage() {
		return "homepage";
	}
}
