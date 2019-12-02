package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserApp;
import com.example.demo.model.UserType;


public interface UserRepository extends CrudRepository<UserApp, Long> {

//	List<UserApp> findByName(String name);
	
	List<UserApp> findByUsername(String username);
	
	List<UserApp> findByType(UserType patient);

}
