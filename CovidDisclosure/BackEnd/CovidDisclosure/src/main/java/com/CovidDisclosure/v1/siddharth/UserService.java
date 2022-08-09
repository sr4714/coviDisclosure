package com.CovidDisclosure.v1.siddharth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * @author siddharth rana
 *
 */
@Service
public class UserService {

    @Autowired
    UserDatabase db;
    
    /**
     * service method for registering a new user
     * @param a new user
     * @return newly created user
     */
    User registerUser(User user){
    	Symptoms symptoms = new Symptoms(false, false, false, false, false, false, false, false, false, false, false, false);
		Covid covid = new Covid(false,false,new int[] {0,0,0} );
		Details details = new Details(false, false, false, false, false, false);
		/*
		dbs.save(symptoms);
		p.setSymptoms(symptoms);
		symptoms.setUser(p);
		
		Covid covid = new Covid();
		dbc.save(covid);
		p.setCovid(covid);
		covid.setUser(p);*/
		user.setSymptoms(symptoms);
		user.setCovid(covid);
		user.setDetails(details);
		
		//p.setSymptomsId(symptoms.getId());
		
		
		db.save(user);
        return user;
    }

    /**
     * service method for validating user credentials
     * @param login information
     * @return user with matching credentials
     */
    public User validateUser(Login login){
        return db.findByEmailAndPassword(login.getEmail(), login.getPassword());
    }

    /**
     * service method for getting all users
     * @return list of all users
     */
    public List<User> getAllUsers(){
        return db.findAll();
    }
    
    /**
     * service method for getting a user by email
     * @param email of user
     * @return user with that email as a list
     */
    public List<User> getByEmail(String email) {
    	return db.findByEmail(email);
    }
}
