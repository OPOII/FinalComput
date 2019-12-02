package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.modelo.Tmio1Bus;

public interface BusRepositorio extends CrudRepository<Tmio1Bus, Integer> {
//EmployDao repositorio
//	<S extends Tmio1Bus> S save(S entity);
//	void delete(Tmio1Bus entity);
	
}
