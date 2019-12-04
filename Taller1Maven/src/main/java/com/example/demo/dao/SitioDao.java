package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Tmio1Sitio;

@Repository
@Scope("singleton")
public class SitioDao implements ITSitioDao {

	@PersistenceContext
	private EntityManager manager;
	@Transactional
	@Override
	public void save(Tmio1Sitio ruta) {
		manager.persist(ruta);
	}
	@Transactional
	@Override
	public Tmio1Sitio findById(Long id) {
		return manager.find(Tmio1Sitio.class, id);
	}
	@Transactional
	@Override
	public void delete(Tmio1Sitio ruta) {
		manager.remove(ruta);
	}
	@Transactional
	@Override
	public List<Tmio1Sitio> findAll() {
		String jpql = "Select a FROM Tmio1Sitio a";
		return manager.createQuery(jpql).getResultList();

	}

	@Transactional
	@Override
	public Tmio1Sitio update(Tmio1Sitio entity) {
		return manager.merge(entity);
	}

}
