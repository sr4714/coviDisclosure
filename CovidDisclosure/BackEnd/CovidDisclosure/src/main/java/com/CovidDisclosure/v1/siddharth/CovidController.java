package com.CovidDisclosure.v1.siddharth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Api(value = "CovidController", description = "Operations relating to the covid entity by Siddharth")
@RestController
public class CovidController {
	
	
		@Autowired
		UserDatabase db;
		
		@Autowired
		CovidService covidService;
		
		@Autowired
		CovidDatabase dbc;
		
		@ApiOperation(value = "Get test date of a user", response = String.class)
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Suceess"),
	            @ApiResponse(code = 401, message = "not authorized"), 
	            @ApiResponse(code = 403, message = "forbidden"),
	            @ApiResponse(code = 404, message = "not found") })
		@GetMapping("/user/{id}/covidtest/date")
		String getTestDate(@PathVariable Integer id) {
			if(db.findOne(id).getCovid().isTested())
			{
				int[] testDate = db.findOne(id).getCovid().getTestDate();
				String date = "Tested on"+Integer.toString(testDate[0])+"/"+Integer.toString(testDate[1])+"/"+Integer.toString(testDate[2]);
				return date;
			}
			else return "Not Tested";
		}
		
		@ApiOperation(value = "Get days remaining in quarantine for a user", response = String.class)
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Suceess"),
	            @ApiResponse(code = 401, message = "not authorized"), 
	            @ApiResponse(code = 403, message = "forbidden"),
	            @ApiResponse(code = 404, message = "not found") })
		@GetMapping("/user/{id}/covidtest/days_remaining")
		String getDaysRemaining(@PathVariable Integer id) {
			
			if(db.findOne(id).getCovid().isTested() && db.findOne(id).getCovid().isResult()) {
			return Long.toString(covidService.getDays(db.findOne(id).getCovid().getTestDate()))+"days remaining";
			}
			else return "Not Tested or Result not given";
		}
		
		
		
		@ApiOperation(value = "Get covid result of a user", response = String.class)
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Suceess"),
	            @ApiResponse(code = 401, message = "not authorized"), 
	            @ApiResponse(code = 403, message = "forbidden"),
	            @ApiResponse(code = 404, message = "not found") })
		@GetMapping("/user/{id}/covidtest/result")
		String getResultStatus(@PathVariable Integer id) {
			if (db.findOne(id).getCovid().isResult()) {
				return "Positive";
			}
			else return "Negative";
		}
		
		
		@ApiOperation(value = "Update covid status of a user", response = Covid.class)
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Suceess"),
	            @ApiResponse(code = 401, message = "not authorized"), 
	            @ApiResponse(code = 403, message = "forbidden"),
	            @ApiResponse(code = 404, message = "not found") })
		@PutMapping("/user/{id}/covidtest/update")
		Covid updateCovidStatus(@RequestBody Covid c, @PathVariable Integer id) {
			User user = db.findOne(id);
			
			
			user.setCovid(c);
			db.save(user);
			return c;
		}
		
		@ApiOperation(value = "Get all covid properties of all users", response = Iterable.class)
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Suceess"),
	            @ApiResponse(code = 401, message = "not authorized"), 
	            @ApiResponse(code = 403, message = "forbidden"),
	            @ApiResponse(code = 404, message = "not found") })
		@GetMapping("user/covid")
		 public List<Covid> getAll(){
	        return dbc.findAll();
	    }
		

}