package com.epam.bookshop.stock.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SiteIntegrationTest extends AbstractTestNGSpringContextTests {

	@Autowired 
	private WebApplicationContext wac; 
	private MockMvc mockMvc;
	
	@BeforeMethod 
	public void setup() { 
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build(); 
	} 
	
	@Test
	public void testIndex() throws Exception { 
		ResultActions ra = this.mockMvc.perform(MockMvcRequestBuilders.get("/"));
		ra.andExpect(MockMvcResultMatchers.status().isOk());
		ra.andExpect(MockMvcResultMatchers.view().name("shopping_cart"));
		
		
	
		
	}
	
	
}

