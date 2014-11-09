package com.epam.bookshop.home.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.bookshop.home.view.model.HomepageModel;
import com.epam.bookshop.home.view.model.LanguageUrlMapping;
import com.epam.bookshop.home.view.support.LocalizationUrlBuilder;
import com.epam.bookshop.i18n.service.LocalizationService;

@Controller
public class HomeController {
	public static final String REQUEST_MAPPING = "/";
	private LocalizationService localizationService;
	private LocalizationUrlBuilder localizationUrlBuilder;

	@Autowired
	public HomeController(LocalizationService localizationService, LocalizationUrlBuilder localizationUrlBuilder) {
		super();
		this.localizationService = localizationService;
		this.localizationUrlBuilder = localizationUrlBuilder;
	}

	@ModelAttribute("homepageModel")
	public HomepageModel homepageModel() {
		HomepageModel result = new HomepageModel();
		result.setBookshopName("Bookshop");
		result.setLanguageSelectors(getLanguageSelectors());
		return result;
	}

	private List<LanguageUrlMapping> getLanguageSelectors() {
		return localizationUrlBuilder.buildAccessibleLanguageSelectors(localizationService.getAccessibleLanguages());
	}

	@RequestMapping(REQUEST_MAPPING)
	public String homepage() {
		return "homepage";
	}
}
