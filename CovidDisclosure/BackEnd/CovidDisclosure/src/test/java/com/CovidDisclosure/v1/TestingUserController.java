package com.CovidDisclosure.v1;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.CovidDisclosure.v1.siddharth.User;
import com.CovidDisclosure.v1.siddharth.UserController;
import com.CovidDisclosure.v1.siddharth.UserDatabase;
import com.CovidDisclosure.v1.siddharth.UserService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import org.springframework.http.MediaType;

// import mockito related
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class TestingUserController {

	@Autowired
	private MockMvc controller;
	
	@MockBean
	private UserDatabase repo;
	
	
	
	@MockBean
    private UserService userService;
	
	@Test
	public void testUser() throws Exception {
		User u = new User();
		u.setEmail("xxxx@xxxx.com"); u.setFirstName("sid"); u.setLastName("rana"); u.setPassword("rootpw");
		List<User> list = new ArrayList<User>();
		list.add(u); 
		
		when(repo.findAll()).thenReturn(list);
		when(userService.getAllUsers()).thenReturn(list);
		
		controller.perform(get("/users")).andExpect(status().isOk());
		
	}

	
}
