package com.example.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Tmio1Servicio;

@Repository
@Scope("singleton")
public class ServiciosDao implements ITServiciosDao {
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void save(Tmio1Servicio servicio) {
		manager.persist(servicio);
	}

	@Override
	public void delete(Tmio1Servicio servicio) {
		manager.remove(servicio);
	}

	@Override
	public void update(Tmio1Servicio servicio) {
		manager.merge(servicio);
	}
}
