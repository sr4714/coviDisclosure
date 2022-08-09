package com.CovidDisclosure.v1.siddharth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "SymptomsController", description = "Operations relating to the symptoms entity by Siddharth")
@RestController
public class SymptomsController {
	
		@Autowired 
		UserDatabase db;
	
		@Autowired 
		SymptomsDatabase dbs;

		@ApiOperation(value = "Get symptoms of a particular user", response = Symptoms.class)
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Suceess"),
	            @ApiResponse(code = 401, message = "not authorized"), 
	            @ApiResponse(code = 403, message = "forbidden"),
	            @ApiResponse(code = 404, message = "not found") })
		@GetMapping("/user/{id}/symptoms")
		Symptoms getSymptoms(@PathVariable Integer id) {
			return db.findOne(id).getSymptoms();
		}
		
		@ApiOperation(value = "Make changes to symptoms of a particular user", response = Symptoms.class)
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Suceess"),
	            @ApiResponse(code = 401, message = "not authorized"), 
	            @ApiResponse(code = 403, message = "forbidden"),
	            @ApiResponse(code = 404, message = "not found") })
		@PutMapping("/user/{id}/symptoms/new")
		Symptoms updateSymptoms(@RequestBody Symptoms s, @PathVariable Integer id) {
			
			User user = db.findOne(id);
			
			
			user.setSymptoms(s);
			db.save(user);
			return s;
		}
		
		/*
		@PutMapping("/user/{id}/symptoms/update")
		Symptoms updateSymptoms(@RequestBody Symptoms s, @PathVariable Integer id) {
			Symptoms old_s = dbs.findOne(id);
			old_s=s;
			dbs.save(old_s);
			return old_s;
		}
		*/
		
		@ApiOperation(value = "Get all symptoms of all users", response = Iterable.class)
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Suceess"),
	            @ApiResponse(code = 401, message = "not authorized"), 
	            @ApiResponse(code = 403, message = "forbidden"),
	            @ApiResponse(code = 404, message = "not found") })
		@GetMapping("/user/symptoms")
		public List<Symptoms> getSymptoms() {
			return dbs.findAll();
		}
		

}
