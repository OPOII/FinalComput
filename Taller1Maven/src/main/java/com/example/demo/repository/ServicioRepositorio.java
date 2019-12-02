package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.modelo.Tmio1Servicio;
import com.example.demo.modelo.Tmio1ServicioPK;

public interface ServicioRepositorio extends CrudRepository<Tmio1Servicio, Tmio1ServicioPK> {
	
}
