package com.CovidDisclosure.v1.siddharth;

import java.util.Arrays;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

 
@ServerEndpoint(value="/hello")
@Component  
public class WebSocket {
	
	@Autowired
	private StatService statService;
	
	@Autowired
    UserDatabase db;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@OnMessage
	public long hello(String message) {
		System.out.println("Received : "+ message);
		/*
		//Long temp = statService.getTotalStats().TotalConfirmed;
		String temp ="test";
		System.out.println(temp);
		temp = db.findOne(1).getFirstName();
		System.out.println(temp);
		return temp;
		//return 1111111;
		 */
		
	    	 // System.out.println(response.getBody().TotalRecovered);
	      
	     // return response.getBody().TotalConfirmed; 
	      return 11;
	}
	@OnOpen
	public void myOnOpen(Session session) {
		System.out.println("WebSocket opened: " + session.getId());
	}
	
	@OnClose
	public void myOnClose(CloseReason reason) {
		System.out.println("Closing a due to " + reason.getReasonPhrase());
	}

    @OnError
    public void error(Throwable t) {      
    	
    }

}
	