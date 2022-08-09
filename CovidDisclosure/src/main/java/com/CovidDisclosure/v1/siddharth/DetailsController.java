package com.CovidDisclosure.v1.siddharth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "DetailsController", description = "Operations relating to the details entity by Siddharth")
@RestController
public class DetailsController {
	
		@Autowired 
		UserDatabase db;
	
		@Autowired
		DetailsDatabase dbd;

		@ApiOperation(value = "Get details of a user with particular id", response = Details.class)
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Suceess"),
	            @ApiResponse(code = 401, message = "not authorized"), 
	            @ApiResponse(code = 403, message = "forbidden"),
	            @ApiResponse(code = 404, message = "not found") })
		@GetMapping("/user/{id}/details")
		Details getDetails(@PathVariable Integer id) {
			return db.findOne(id).getDetails();
		}
		
		@ApiOperation(value = "update details of a user", response = Details.class)
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Suceess"),
	            @ApiResponse(code = 401, message = "not authorized"), 
	            @ApiResponse(code = 403, message = "forbidden"),
	            @ApiResponse(code = 404, message = "not found") })
		@PutMapping("/user/{id}/details/new")
		Details updateDetails(@RequestBody Details d, @PathVariable Integer id) {
			
			User user = db.findOne(id);
			
			
			user.setDetails(d);
			db.save(user);
			return d;
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
		
		
		

}
