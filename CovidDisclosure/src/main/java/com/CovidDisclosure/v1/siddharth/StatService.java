package com.CovidDisclosure.v1.siddharth;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author siddharth rana
 *
 */
@Service
public class StatService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	StatisticsRepository sr;
	
	@Autowired
	GlobalRepository gr;
	
	@Autowired
	CountriesRepository cr;
	
	/*
	public Statistics getTotalStats() {
		
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      ResponseEntity<Statistics> response = restTemplate.exchange("https://api.covid19api.com/world/total", HttpMethod.GET, entity, Statistics.class);//.getBody();
	     
	    	  System.out.println(response.getBody().TotalRecovered);
	      
	      return response.getBody();
	      86400000
	}
	*/
	
	@Scheduled(fixedRate = 21600000, initialDelay = 1000)
	public Statistics getAllStats() {
		
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      ResponseEntity<Statistics> response = restTemplate.exchange("https://api.covid19api.com/summary", HttpMethod.GET, entity, Statistics.class);//.getBody();
	      System.out.println(response.getBody().global.newConfirmed);
	      gr.save(response.getBody().global);
	      cr.save(response.getBody().countries);
	      //sr.save(response.getBody());
	      return response.getBody();
	}

	

}
