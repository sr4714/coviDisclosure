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

import com.CovidDisclosure.v1.siddharth.Covid;
import com.CovidDisclosure.v1.siddharth.CovidController;
import com.CovidDisclosure.v1.siddharth.CovidDatabase;
import com.CovidDisclosure.v1.siddharth.CovidService;
import com.CovidDisclosure.v1.siddharth.UserDatabase;

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
@WebMvcTest(CovidController.class)
public class TestingCovidController {

	@Autowired
	private MockMvc controller;

	@MockBean // note that this service is needed in my controller
	private CovidService cService;

	@MockBean // note that this repo is also needed in controller
	private UserDatabase repo;
	
	@MockBean
	private CovidDatabase repoc;

	@Test
	public void testCovidService() throws Exception {
		int[] testDate = {10,20,2020};
		Covid c1 = new Covid();
		c1.setId(1); c1.setResult(false); c1.setTestDate(testDate); c1.setTested(false);
		
		Covid c2 = new Covid();
		c2.setId(2); c2.setResult(true); c2.setTestDate(testDate); c2.setTested(true);
		List<Covid> list = new ArrayList<Covid>();
		list.add(c1); list.add(c2);
		
		when(repoc.findAll()).thenReturn(list);
		

		
		
				
		 controller.perform(get("/user/covid")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(2)));
		
		 //controller.perform(get("/user/covid")).andExpect(status().isOk());
	}
}
