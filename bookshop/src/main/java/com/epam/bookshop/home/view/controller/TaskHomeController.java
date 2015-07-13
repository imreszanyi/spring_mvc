package com.epam.bookshop.home.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TaskHomeController {

	@RequestMapping("/second")
	public String homepage(Model model) {
		//model.addAttribute("bookshopName", "second bookshop");
		return "homepage";
	}
	
	@ModelAttribute("bookshopName")
	public String bookshopName() {
		return "2dnBookshop";
	}
	
}
