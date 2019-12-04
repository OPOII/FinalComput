package com.example.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Tmio1Bus;
import com.example.demo.modelo.Tmio1Servicio;
import com.example.demo.modelo.Tmio1ServicioPK;

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

	@Override
	public Tmio1Servicio buscar(Tmio1ServicioPK id) {
		return manager.find(Tmio1Servicio.class, id);
	}

	@Override
	public Iterable<Tmio1Servicio> findAll() {
		String jpql="Select a FROM Tmio1Servicios a";
		return manager.createQuery(jpql).getResultList();
	
	}
}
