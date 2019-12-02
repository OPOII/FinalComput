package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.UserApp;

public interface UserServiceImpl {
	public void save(UserApp user);

	public Optional<UserApp> findById(long id);

	public Iterable<UserApp> findAll();

	public Iterable<UserApp> findallBuses();

	public Iterable<UserApp> findAllConductores();

	public Iterable<UserApp> findAllRutas();
	public void delete(UserApp user);


}
