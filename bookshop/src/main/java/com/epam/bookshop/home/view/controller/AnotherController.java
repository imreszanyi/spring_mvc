package com.epam.bookshop.home.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AnotherController {
	
	@ModelAttribute("bookshopName")
	public String bookshopName() {
		return "BooookShop";
	}
	
	@RequestMapping("/")
	public String second(Model model) {
		model.addAttribute("alma", "rohadt");
		return "homepage";
		//return "forward:/shopping";
	}
}
