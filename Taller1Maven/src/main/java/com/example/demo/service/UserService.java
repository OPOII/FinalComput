package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserApp;
import com.example.demo.model.UserType;
import com.example.demo.repository.UserRepository;
@Service
public class UserService implements UserServiceImpl {

	private UserRepository userRepository;
	@Autowired
	public UserService(UserRepository repos) {
		userRepository=repos;
	}

	@Override
	public void save(UserApp user) {
		userRepository.save(user);
	}

	@Override
	public Optional<UserApp> findById(long id) {
		return userRepository.findById(id);
	}

	@Override
	public Iterable<UserApp> findAll() {
		
		return userRepository.findAll();
	}


	@Override
	public void delete(UserApp user) {
		userRepository.delete(user);
	}

	@Override
	public Iterable<UserApp> findallBuses() {
		return userRepository.findByType(UserType.buses);
	}

	@Override
	public Iterable<UserApp> findAllConductores() {
		return userRepository.findByType(UserType.conductor);
	}

	@Override
	public Iterable<UserApp> findAllRutas() {
		return userRepository.findByType(UserType.rutas);
	}
}
