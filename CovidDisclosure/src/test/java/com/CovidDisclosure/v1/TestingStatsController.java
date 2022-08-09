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

import com.CovidDisclosure.v1.siddharth.CountriesRepository;
import com.CovidDisclosure.v1.siddharth.Global;
import com.CovidDisclosure.v1.siddharth.GlobalRepository;
import com.CovidDisclosure.v1.siddharth.StatService;
import com.CovidDisclosure.v1.siddharth.StatisticsRepository;
import com.CovidDisclosure.v1.siddharth.StatsController;
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
@WebMvcTest(StatsController.class)
public class TestingStatsController {

	@Autowired
	private MockMvc controller;
	
	
	@MockBean
	private StatService statService;
	
	@MockBean
	StatisticsRepository sr;
	
	@MockBean
	GlobalRepository gr;
	
	@MockBean
	CountriesRepository cr;
	
	@Test
	public void testStat() throws Exception {
		Global g = new Global();
		g.setTotalConfirmed((long) 20);g.setTotalRecovered((long) 10); g.setTotalDeaths((long) 10);
		g.setNewConfirmed((long)5); g.setNewDeaths((long)2); g.setNewRecovered((long)3);
		List<Global> list = new ArrayList<Global>();
		list.add(g); 
		
		when(gr.findAll()).thenReturn(list);
		
		controller.perform(get("/stats/global")).andExpect(status().isOk());
		
	}

	
}
