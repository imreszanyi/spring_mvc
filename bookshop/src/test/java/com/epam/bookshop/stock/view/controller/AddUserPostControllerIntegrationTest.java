package com.epam.bookshop.stock.view.controller;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@Test
@WebAppConfiguration
@ContextConfiguration
public class AddUserPostControllerIntegrationTest {

	@Autowired
    private WebApplicationContext webappContext;

    private MockMvc mockMvc;
    private MockHttpSession mockSession;

    @BeforeMethod
    public void setUp() {
        mockSession = new MockHttpSession();
        mockMvc = MockMvcBuilders.standaloneSetup(new AddUserFormController()).build();
    }
    
    @Test
    public void test() throws Exception {
    	 ResultActions performedRequest = mockMvc.perform(MockMvcRequestBuilders.get("/addUserForm.html").session(mockSession));
         // THEN
         performedRequest.andExpect(MockMvcResultMatchers.status().isOk());
         performedRequest.andExpect(MockMvcResultMatchers.view().name("add_user"));
         
         MatcherAssert.assertThat("a", Matchers.equalTo("a"));
    }

	
}
