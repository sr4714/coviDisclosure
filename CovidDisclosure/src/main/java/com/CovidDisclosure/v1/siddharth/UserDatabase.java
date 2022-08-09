package com.CovidDisclosure.v1.siddharth;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;





@Repository
public interface UserDatabase extends JpaRepository<User, Integer> {
	
	User findByEmailAndPassword(String email, String password);
    public List<User> findByEmail(String email);  
    User findTopByOrderByIdDesc();
}
