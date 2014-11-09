package com.epam.bookshop.home.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	public static final String REQUEST_MAPPING = "/";

	@ModelAttribute("bookshopName")
	public String bookshopName() {
		return "Bookshop";
	}

	@RequestMapping(REQUEST_MAPPING)
	public String homepage() {
		return "homepage";
	}
}
