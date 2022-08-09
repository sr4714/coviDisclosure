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

import com.CovidDisclosure.v1.siddharth.Symptoms;
import com.CovidDisclosure.v1.siddharth.SymptomsController;
import com.CovidDisclosure.v1.siddharth.SymptomsDatabase;
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
@WebMvcTest(SymptomsController.class)
public class TestingSymptomsController {

	@Autowired
	private MockMvc controller;
	
	@MockBean // note that this repo is also needed in controller
	private UserDatabase repo;
	
	@MockBean // note that this repo is also needed in controller
	private SymptomsDatabase repos;
	
	@Test
	public void testSymptoms() throws Exception {

		Symptoms s1= new Symptoms();
		s1.setId(1); s1.setChest_pain(false); s1.setCough(false); s1.setDiarrhea(false); s1.setDifficult_breathing(false);
		s1.setFever(false); s1.setHeadache(false); s1.setLoss_of_senses(false); s1.setPains(false);
		s1.setRashes(false); s1.setShort_breath(false); s1.setSore_throat(false); s1.setTiredness(false);
		List<Symptoms> list = new ArrayList<Symptoms>();
		list.add(s1); 
		when(repos.findAll()).thenReturn(list);
		
		
		controller.perform(get("/user/symptoms")).andExpect(status().isOk());
	}	
}