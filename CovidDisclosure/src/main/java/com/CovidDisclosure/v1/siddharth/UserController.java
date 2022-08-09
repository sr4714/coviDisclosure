package com.CovidDisclosure.v1.siddharth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.JsonNode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;



@Api(value = "UserController", description = "Operations relating to the user entity by Siddharth")
@RestController
public class UserController {
	

	@Autowired
	UserDatabase db;
	
	
	
	@Autowired
    UserService userService;
	
	//@Autowired
	//CovidDatabase dbc;

	@ApiOperation(value = "Get user with the particular id ", response = User.class)
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Suceess"),
            @ApiResponse(code = 401, message = "not authorized"), 
            @ApiResponse(code = 403, message = "forbidden"),
            @ApiResponse(code = 404, message = "not found") })
	@GetMapping("/user/{id}")
	User getUser(@PathVariable Integer id) {
		User user = db.findOne(id);
		
		return user;
	}
	
	
	@ApiOperation(value = "Get a list of all the users", response = Iterable.class)
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Suceess"),
            @ApiResponse(code = 401, message = "not authorized"), 
            @ApiResponse(code = 403, message = "forbidden"),
            @ApiResponse(code = 404, message = "not found") })
	@GetMapping(value = "/userinfo", produces = "application/json")
	List<User> showAll() {
		
		return userService.getAllUsers();
	}


	@ApiOperation(value = "Create a new user", response = User.class)
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Suceess"),
            @ApiResponse(code = 401, message = "not authorized"), 
            @ApiResponse(code = 403, message = "forbidden"),
            @ApiResponse(code = 404, message = "not found") })
	@PostMapping("/user/new")
	User createId(@RequestBody User p) {
		// create new objects
		
		
		return userService.registerUser(p);
		//User str = JsonNode.stringify(p, null, 2);
	}


	@ApiOperation(value = "Add changes to an existing user", response = User.class)
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Suceess"),
            @ApiResponse(code = 401, message = "not authorized"), 
            @ApiResponse(code = 403, message = "forbidden"),
            @ApiResponse(code = 404, message = "not found") })
	@PutMapping("/user/update/{id}")
	User updateUser(@RequestBody User p, @PathVariable Integer id) {
		User old_p = db.findOne(id);
		old_p.setPassword(p.password);
		db.save(old_p);
		return old_p;

	}

	@ApiOperation(value = "Delete a user", response = String.class)
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Suceess"),
            @ApiResponse(code = 401, message = "not authorized"), 
            @ApiResponse(code = 403, message = "forbidden"),
            @ApiResponse(code = 404, message = "not found") })
	@DeleteMapping("/user/delete/{id}")
	String deleteUser(@PathVariable Integer id) {
        User user = db.findOne(id);
        String usern=user.getEmail();
        db.delete(id);
        
		return "deleted " + id + usern;
	}
	
	@ApiOperation(value = "Get a list of all the users", response = Iterable.class)
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Suceess"),
            @ApiResponse(code = 401, message = "not authorized"), 
            @ApiResponse(code = 403, message = "forbidden"),
            @ApiResponse(code = 404, message = "not found") })
	@GetMapping("/users")
	List<User> getAll() {
		
		return userService.getAllUsers();
	}
	
	
	@ApiOperation(value = "Validates credentials of a user", response = User.class)
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Suceess"),
            @ApiResponse(code = 401, message = "not authorized"), 
            @ApiResponse(code = 403, message = "forbidden"),
            @ApiResponse(code = 404, message = "not found") })
	 @PostMapping("user/validate")
	    public @ResponseBody User validateUser(@RequestBody Login login){
		 return userService.validateUser(login);
	    }
	 
	@ApiOperation(value = "Get a particular user by email", response = Iterable.class)
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Suceess"),
            @ApiResponse(code = 401, message = "not authorized"), 
            @ApiResponse(code = 403, message = "forbidden"),
            @ApiResponse(code = 404, message = "not found") })
	 @GetMapping("/user/id/{email}")
		List<User> getId(@PathVariable String email) {
			//User user = userService.getByEmail(email);
			
			return userService.getByEmail(email);
		}
	
	@GetMapping("/user/last")
	User getLastUser() {
		User user = db.findTopByOrderByIdDesc();
		
		return user;
	} 
	 
}