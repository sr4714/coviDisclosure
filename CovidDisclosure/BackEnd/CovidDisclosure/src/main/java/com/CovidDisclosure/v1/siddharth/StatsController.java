package com.CovidDisclosure.v1.siddharth;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StatsController {
	
	
	
	@Autowired
	private StatService statService;
	
	@Autowired
	StatisticsRepository sr;
	
	@Autowired
	GlobalRepository gr;
	
	@Autowired
	CountriesRepository cr;
	
	/*
	@GetMapping("/stats/total")
	public ResponseEntity<Statistics> getTotalStats() {
		
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      ResponseEntity<Statistics> response = restTemplate.exchange("https://api.covid19api.com/world/total", HttpMethod.GET, entity, Statistics.class);//.getBody();
	     
	    	  System.out.println(response.getBody().TotalRecovered);
	      
	      return response; 
	}
	
	@GetMapping("/stats/all")
	public ResponseEntity<String> getAllStats() {
		
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      ResponseEntity<String> response = restTemplate.exchange("https://api.covid19api.com/summary", HttpMethod.GET, entity, String.class);//.getBody();
	      return response;
	}
	*/
	
	/*
	@GetMapping("/stats/total")
	public Statistics showTotalStats() {
		
		return statService.getTotalStats();
	}
	*/
	
	@GetMapping("stats/all")
	public Statistics showAllStats() {
		
		return statService.getAllStats();
	}

	@GetMapping("stats/global")
	public Global showGlobalStats() {
		
		return gr.findTopByOrderByIdDesc();
	}
	
	@GetMapping("stats/{country}")
	public List<Countries> showCountryStat(@PathVariable String country)
	{
		return cr.findByCountry(country);
		
	}
	
	@GetMapping("stats/country")
	public List<Countries> showAllCountry()
	{
		return cr.findAll();
		
	}
}
